import os
import sys

absPath = os.path.abspath('./bsp3_camera')
sys.path.insert(1, absPath)
import matplotlib as mpl
import matplotlib.pyplot as plt
import numpy as np

from evc_compute_binary import *
from evc_histogram_clipping import *

from matplotlib.backends.backend_qtagg import FigureCanvas
from matplotlib.backends.backend_qtagg import \
    NavigationToolbar2QT as NavigationToolbar
from matplotlib.backends.qt_compat import QtWidgets
from matplotlib.figure import Figure
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QFont, QIcon, QPixmap
from PyQt6.QtWidgets import (QCheckBox, QDoubleSpinBox, QLabel, QPushButton,
                             QSizePolicy, QSlider, QTabWidget, QWidget)
from GUI.gui_shared import ClickableImageLabel

#mpl.use('Qt5Agg')


def gui_gamma_histogram_clipping(img):
    # Check whether there is already a running QApplication (e.g., if running
    # from an IDE).
    qapp = QtWidgets.QApplication.instance()
    if not qapp:
        qapp = QtWidgets.QApplication(sys.argv)

    app = ApplicationWindow(img)
    #apply_stylesheet(app, theme='light_purple.xml')
    app.show()
    app.activateWindow()
    app.raise_()
    qapp.setQuitOnLastWindowClosed(True)
    qapp.exec()

    return app.low, app.high


class ApplicationWindow(QtWidgets.QMainWindow):
    def __init__(self, img, parent=None):
        super(ApplicationWindow, self).__init__(parent)

        self.low = 0
        self.high = 1

        self.img = img
        self.img_corrected = img
        self.img_low = evc_compute_binary(img, self.low, 0)
        self.img_high = evc_compute_binary(img, self.high, 1)
       
        self.title = 'Histogram Clipping'
        self.icon = ".\cvl_icon.ico"
        width = 1600
        height = 1600

        self.setWindowTitle(self.title)
        icon = QIcon()
        icon.addPixmap(QPixmap(self.icon))
        self.setWindowIcon(icon)

        self.resize(width, height)

        self.mainWidget = QWidget()
        self.layout_content = QtWidgets.QVBoxLayout(self.mainWidget)
        self.layout_main_row_1 = QtWidgets.QHBoxLayout()
        self.layout_main_row_2 = QtWidgets.QHBoxLayout()
        self.layout_main_row_3 = QtWidgets.QHBoxLayout()
        self.layout_main_row_4 = QtWidgets.QHBoxLayout()
        self.layout_main_row_5 = QtWidgets.QHBoxLayout()
        self.setCentralWidget(self.mainWidget)

        # low thres image
        self._lbl_low = QLabel("Lower Clipping")
        self._lbl_low.setSizePolicy(QSizePolicy.Policy.Expanding,QSizePolicy.Policy.Maximum)
        self._lbl_low.setAlignment(Qt.AlignmentFlag.AlignHCenter)
        self.layout_main_row_1.addWidget(self._lbl_low)

        self._img_label_low = ClickableImageLabel()
        self.layout_main_row_2.addWidget(self._img_label_low)
        self.refresh_img_low()

        # main image
        self._lbl_main = QLabel("Corrected")
        self._lbl_main.setSizePolicy(QSizePolicy.Policy.Expanding,QSizePolicy.Policy.Maximum)
        self._lbl_main.setAlignment(Qt.AlignmentFlag.AlignHCenter)
        self.layout_main_row_1.addWidget(self._lbl_main)

        self._img_label_main = ClickableImageLabel()
        self.layout_main_row_2.addWidget(self._img_label_main)
        self.refresh_img()

        # high thres image
        self._lbl_high = QLabel("Upper Clipping")
        self._lbl_high.setSizePolicy(QSizePolicy.Policy.Expanding,QSizePolicy.Policy.Maximum)
        self._lbl_high.setAlignment(Qt.AlignmentFlag.AlignHCenter)
        self.layout_main_row_1.addWidget(self._lbl_high)

        self._img_label_high = ClickableImageLabel()
        self.layout_main_row_2.addWidget(self._img_label_high)
        self.refresh_img_high()

        # Histogram
        self._hist_canvas = FigureCanvas(Figure(figsize=(5, 2), tight_layout=True))
        self._hist_canvas.setSizePolicy(QSizePolicy.Policy.Preferred, QSizePolicy.Policy.Maximum)

        self._hist_canvas.mpl_connect("motion_notify_event", self.histogram_hover_event)
        self._hist_canvas.mpl_connect("button_press_event", self.histogram_click_event)

        self.layout_main_row_3.addWidget(self._hist_canvas)
        self._axis_lut: plt.Axes = self._hist_canvas.figure.subplots()

        self.low_label = QLabel("Low")
        # self.gamma_label.setStyleSheet("font-weight: bold")
        self.layout_main_row_4.addWidget(self.low_label)
        
        # Double Spinbox low
        self.low_spin = QDoubleSpinBox(self)
        self.low_spin.setSingleStep(0.02)
        self.low_spin.setValue(self.low)
        self.layout_main_row_4.addWidget(self.low_spin)
        self.low_spin.valueChanged.connect(self.change_low_input)
        self.layout_main_row_4.addSpacing(20)

        self.high_label = QLabel("High")
        # self.gamma_label.setStyleSheet("font-weight: bold")
        self.layout_main_row_4.addWidget(self.high_label)

        # Double Spinbox high
        self.high_spin = QDoubleSpinBox(self)
        self.high_spin.setSingleStep(0.02)
        self.high_spin.setValue(self.high)
        self.layout_main_row_4.addWidget(self.high_spin)
        self.high_spin.valueChanged.connect(self.change_high_input)
        self.layout_main_row_4.addSpacing(20)

        # Buttons

        self.btn_new_selection = QPushButton('New Selection', self)
        self.layout_main_row_5.addWidget(self.btn_new_selection)
        self.btn_new_selection.clicked.connect(self.on_new_selection)

        self.btn_reset = QPushButton('Reset', self)
        self.layout_main_row_5.addWidget(self.btn_reset)
        self.btn_reset.clicked.connect(self.reset)

        self.btn_ok = QPushButton('OK', self)
        self.layout_main_row_5.addWidget(self.btn_ok)
        self.btn_ok.clicked.connect(self.confirm_and_close)

        self.layout_content.addLayout(self.layout_main_row_1)
        self.layout_content.addLayout(self.layout_main_row_2)
        self.layout_content.addLayout(self.layout_main_row_3)
        self.layout_content.addLayout(self.layout_main_row_4)
        self.layout_content.addLayout(self.layout_main_row_5)

        self.on_clipping_changed()

        self.hover_line = None
        self.new_selection_stage = 0
        self.selectionDisableList = (self.btn_new_selection,self.btn_ok,self.btn_reset,self.low_spin,self.high_spin)

    def histogram_hover_event(self,event):
        if self.hover_line:
            self.hover_line.remove()
            self.hover_line = None
        if event.inaxes:
            if self.new_selection_stage:
                self.hover_line = self._axis_lut.axvline(event.xdata)
            if self.new_selection_stage == 1:
                self.img_low = evc_compute_binary(self.img, event.xdata, 0)
                self.refresh_img_low()
            elif self.new_selection_stage == 2:
                self.img_high = evc_compute_binary(self.img, event.xdata, 1)
                self.refresh_img_high()
        self._hist_canvas.draw()
    
    def histogram_click_event(self,event):
        if event.inaxes:
            if self.new_selection_stage == 1:
                self._axis_lut.axvline(event.xdata)
                self.low_spin.setValue(event.xdata)
                self.new_selection_stage = 2
            elif self.new_selection_stage == 2:
                self.high_spin.setValue(event.xdata)
                self.finish_selection()

    def start_selection(self):
        self.new_selection_stage = 1

        self.refreshHistogram(self.img)

        for e in self.selectionDisableList:
            e.setEnabled(False)

    def finish_selection(self):
        self.new_selection_stage = 0

        self.on_clipping_changed()

        for e in self.selectionDisableList:
            e.setEnabled(True)

    def on_new_selection(self):
        if self.new_selection_stage == 0:
            self.start_selection()

    def refresh_img(self):
        self._img_label_main.set_image(np.clip(self.img_corrected*255,0,255).astype(np.uint8))

    def refresh_img_low(self):
        self._img_label_low.set_image(np.clip(self.img_low*255,0,255).astype(np.uint8))

    def refresh_img_high(self):
        self._img_label_high.set_image(np.clip(self.img_high*255,0,255).astype(np.uint8))

    def change_low_input(self, value):
        """Refresh low image"""
        self.low = value
        top = 0
        self.img_low = evc_compute_binary(self.img, self.low, top)
        self.refresh_img_low()
        if self.new_selection_stage == 0:
            self.on_clipping_changed()
    
    def change_high_input(self, value):
        """Refresh high image"""
        self.high = value
        top = 1
        self.img_high = evc_compute_binary(self.img, self.high, top)
        self.refresh_img_high()
        if self.new_selection_stage == 0:
            self.on_clipping_changed()
    
    def refreshHistogram(self,img):
        vals = img.mean(axis=2).flatten()
        counts, bins = np.histogram(vals, bins=255)
        self._axis_lut.clear()
        self._axis_lut.stairs(counts, bins, fill=True)
        self._axis_lut.set_xlim([0, 1])
        self._axis_lut.set_ylim([0, 100000])
        self._hist_canvas.draw()

    def on_clipping_changed(self):
        self.img_corrected = evc_transform_histogram(self.img,self.low_spin.value(), self.high_spin.value())
        self.img_corrected = evc_clip_histogram(self.img_corrected)
        self.refresh_img()

        self.refreshHistogram(self.img_corrected)        
    
    def reset(self):
        """Resets the selected white value"""
        self.low = 0
        self.high = 1
        self.new_selection_stage = -1 #avoid double update, not the nicest way, but it works
        self.low_spin.setValue(self.low)
        self.high_spin.setValue(self.high)
        self.new_selection_stage = 0
        self.on_clipping_changed()

    def confirm_and_close(self):
        """Returns the white balanced image values"""
        self.close()

if __name__ == "__main__":
    # img = np.random.rand(1000, 1000)
    from PIL import Image
    img = np.array(
        Image.open(".\\bsp3_camera\\GUI\\weiss.jpg")).astype('float') / 255
    low, high = gui_gamma_histogram_clipping(img)
    print(low, high)