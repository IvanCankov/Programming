import os
import sys

absPath = os.path.abspath('./bsp3_camera')
sys.path.insert(1, absPath)
import matplotlib as mpl
import matplotlib.pyplot as plt
import numpy as np
from evc_gamma_correction import *
from matplotlib.backends.backend_qtagg import FigureCanvas
from matplotlib.backends.backend_qtagg import \
    NavigationToolbar2QT as NavigationToolbar
from matplotlib.backends.qt_compat import QtWidgets
from matplotlib.figure import Figure
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QFont, QIcon, QPixmap
from PyQt6.QtWidgets import (QCheckBox, QDoubleSpinBox, QLabel, QPushButton,
                             QSizePolicy, QSlider, QTabWidget, QWidget, QHBoxLayout, QVBoxLayout)
from GUI.gui_shared import ClickableImageLabel

#mpl.use('Qt5Agg')


def gui_gamma_correction(img):
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

    return app.img_corrected


class ApplicationWindow(QtWidgets.QMainWindow):
    def __init__(self, img, parent=None):
        super(ApplicationWindow, self).__init__(parent)

        self.img = img
        self.img_corrected = img

        self.color_balance = False
        self.slider_used = False
        self.spin_used = False

        self.title = 'White Balance'
        self.icon = ".\cvl_icon.ico"
        width = 1500
        height = 1500

        self.setWindowTitle(self.title)
        icon = QIcon()
        icon.addPixmap(QPixmap(self.icon))#, QIcon.Normal, QIcon.Off)
        self.setWindowIcon(icon)

        self.resize(width, height)

        self.mainWidget = QWidget()
        self.layout_content = QVBoxLayout(self.mainWidget)
        self.layout_main_row_1 = QHBoxLayout()
        self.layout_main_row_2 = QHBoxLayout()
        self.layout_main_row_3 = QHBoxLayout()
        self.layout_main_row_4 = QHBoxLayout()
        self.layout_main_row_5 = QHBoxLayout()
        self.setCentralWidget(self.mainWidget)

        # Left image
        # self._canvas_1 = FigureCanvas(Figure(figsize=(5, 3), tight_layout=True))
        # self.layout_main_row_1.addWidget(NavigationToolbar(self._canvas_1, self))

        # self._canvas_1.mpl_connect('button_press_event', self.on_click)
        # #self._canvas_1.mpl_connect('button_release_event', self.on_release)
        # #self._canvas_1.mpl_connect('motion_notify_event', self.on_drag)
        # self.layout_main_row_2.addWidget(self._canvas_1)

        # self._axis_1 = self._canvas_1.figure.subplots()
        # self._axis_1.imshow(self.img)

        # Right image
        self._img = ClickableImageLabel()
        self.layout_main_row_2.addWidget(self._img)

        # LUT
        self._canvas_lut = FigureCanvas(Figure(figsize=(5, 2), tight_layout=True))
        self._canvas_lut.setSizePolicy(QSizePolicy.Policy.Preferred, QSizePolicy.Policy.Maximum)
        self.layout_main_row_3.addWidget(self._canvas_lut)
        self._axis_lut = self._canvas_lut.figure.subplots()

        self.on_gamma_changed()

        # self._axis_lut.imshow(self.img)

        # calculate mean value from RGB channels and flatten to 1D array
        #vals = self.img.mean(axis=2).flatten()
        # calculate histogram
        #counts, bins = np.histogram(vals, range(257))

        # plt.bar(bins[:-1] - 0.5, counts, width=1, color= 'b', edgecolor='black', alpha=0.35)
        # plt.xlim([-0.5, 255.5])

        self.gamma_label = QLabel("Gamma")
        self.gamma_label.setStyleSheet("font-weight: bold")
        self.layout_main_row_4.addWidget(self.gamma_label)
        self.layout_main_row_4.addSpacing(5)

        # Slider
        self.slider = QSlider()
        # self.slider.setGeometry(0, 00, 20, 30)
        self.slider.setOrientation(Qt.Orientation.Horizontal)
        self.slider.setTickPosition(QSlider.TickPosition.TicksBelow)
        self.slider.setSingleStep(1)
        self.slider.setTickInterval(1)

        self.slider.setMinimum(0)
        self.slider.setMaximum(50)
        # self.slider.setMaximum(100)
        self.slider.setValue(10)
        self.slider.valueChanged.connect(self.change_gamma_slider)
        self.layout_main_row_4.addWidget(self.slider)
        self.layout_main_row_4.addSpacing(20)

        # Double Spinbox
        self.gamma_spin = QDoubleSpinBox(self)
        self.gamma_spin.setSingleStep(0.1)
        self.gamma_spin.setMinimum(0.0)
        self.gamma_spin.setValue(1)
        self.layout_main_row_4.addWidget(self.gamma_spin)
        self.gamma_spin.valueChanged.connect(self.change_gamma_input)
        self.layout_main_row_4.addSpacing(20)

        # Checkbox
        self.color_checkbox = QCheckBox("Keep color balance")
        self.color_checkbox.stateChanged.connect(
            lambda: self.keep_color_balance_clicked(self.color_checkbox))
        self.layout_main_row_4.addWidget(self.color_checkbox)

        self.layout_main_row_4.setContentsMargins(0, 0, 0, 30)

        # Buttons
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

        self.gamma_spin.setValue(2.2)

    def refresh_img(self):
        self._img.set_image(np.clip(self.img_corrected*255,0,255).astype(np.uint8))

    def on_gamma_changed(self):
        self.refresh_img()

        self._axis_lut.clear()
        vals = self.img_corrected.mean(axis=2).flatten()
        counts, bins = np.histogram(vals, bins=255)
        self._axis_lut.stairs(counts, bins, fill=True)
        self._axis_lut.set_xlim([0, 1])
        self._axis_lut.set_ylim([0, 100000])
        self._canvas_lut.draw()

    def change_gamma_slider(self, value):
        """Refresh image with changed gamma value"""
        if value > 0 and value <= 50:
            self.slider_used = True
            gamma = float(value) / 10
            if not self.spin_used:
                self.gamma_spin.setValue(gamma)
            else:
                self.slider_used = False
                self.spin_used = False

            self.compute_gamma_corrected_image(self.img, gamma)
            self.on_gamma_changed()

    def change_gamma_input(self, gamma):
        """Refresh image with changed gamma value"""
        self.spin_used = True
        if not self.slider_used:
            value = round(gamma * 10)
            self.slider.setValue(value)
        else:
            self.slider_used = False
            self.spin_used = False

    def keep_color_balance_clicked(self, button):
        """Change color balance mode"""
        self.color_balance = button.isChecked()
        self.compute_gamma_corrected_image(self.img, self.gamma_spin.value())
        self.refresh_img()

    def reset(self):
        """Resets the selected white value"""
        self.slider.setValue(10)
        self.img_corrected = evc_gamma_correct(self.img, 1)
        self.refresh_img()

    def confirm_and_close(self):
        """Returns the white balanced image values"""
        self.close()

    def compute_gamma_corrected_image(self, img, gamma):
        if self.color_balance:
            brightness = evc_compute_brightness(img)
            chromaticity = evc_compute_chromaticity(img, brightness)
            brightness_corrected = evc_gamma_correct(brightness, gamma)
            self.img_corrected = evc_reconstruct(brightness_corrected,
                                                 chromaticity)
        else:
            self.img_corrected = evc_gamma_correct(self.img, gamma)


if __name__ == "__main__":
    # img = np.random.rand(1000, 1000)
    from PIL import Image
    img = np.array(
        Image.open(".\\bsp3_camera\\GUI\\weiss.jpg")).astype('float') / 255
    img_corrected = gui_gamma_correction(img)