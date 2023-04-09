import os
import sys

absPath = os.path.abspath('./bsp3_camera')
sys.path.insert(1, absPath)
import matplotlib as mpl
import numpy as np
from evc_white_balance import evc_white_balance
from matplotlib.backends.backend_qtagg import FigureCanvas
from matplotlib.backends.backend_qtagg import \
    NavigationToolbar2QT as NavigationToolbar
from matplotlib.backends.qt_compat import QtWidgets
from matplotlib.figure import Figure
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QIcon, QPixmap, QImage, QResizeEvent, QMouseEvent
from PyQt6.QtWidgets import (QDoubleSpinBox, QLabel, QPushButton, QSizePolicy,
                             QSlider, QTabWidget, QWidget)
from GUI.gui_shared import ClickableImageLabel

#mpl.use('Qt5Agg')


def gui_white_balance(img):
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

    return app.img_balanced

class ApplicationWindow(QtWidgets.QMainWindow):
    def __init__(self, img, parent=None):
        super(ApplicationWindow, self).__init__(parent)

        self.img = img
        self.img_balanced = img

        self.title = 'White Balance'
        self.icon = ".\cvl_icon.ico"
        width = 2000
        height = 1000

        self.setWindowTitle(self.title)
        icon = QIcon()
        icon.addPixmap(QPixmap(self.icon)) #, QIcon.Normal, QIcon.Off)
        self.setWindowIcon(icon)

        self.resize(width, height)

        self.mainWidget = QWidget()
        self.layout_content = QtWidgets.QVBoxLayout(self.mainWidget)
        self.layout_main_row_1 = QtWidgets.QHBoxLayout()
        self.layout_main_row_2 = QtWidgets.QHBoxLayout()
        self.layout_main_row_3 = QtWidgets.QHBoxLayout()
        self.setCentralWidget(self.mainWidget)

        # Left image
        self._lbl_1 = QLabel("Original")
        self._lbl_1.setSizePolicy(QSizePolicy.Policy.Expanding,QSizePolicy.Policy.Maximum)
        self._lbl_1.setAlignment(Qt.AlignmentFlag.AlignHCenter)
        self.layout_main_row_1.addWidget(self._lbl_1)

        self._img_1 = ClickableImageLabel()
        self._img_1.clickHandler = self.on_click
        self.layout_main_row_2.addWidget(self._img_1)

        self._img_1.set_image(np.clip(self.img*255,0,255).astype(np.uint8))

        # Right image
        self._lbl_2 = QLabel("Balanced")
        self._lbl_2.setSizePolicy(QSizePolicy.Policy.Expanding,QSizePolicy.Policy.Maximum)
        self._lbl_2.setAlignment(Qt.AlignmentFlag.AlignHCenter)
        self.layout_main_row_1.addWidget(self._lbl_2)

        self._img_2 = ClickableImageLabel()
        self._img_2.clickHandler = self.on_click
        self.layout_main_row_2.addWidget(self._img_2)

        # Buttons
        self.btn_reset = QPushButton('Reset', self)
        self.layout_main_row_3.addWidget(self.btn_reset)
        self.btn_reset.clicked.connect(self.reset_white)

        self.btn_ok = QPushButton('OK', self)
        self.layout_main_row_3.addWidget(self.btn_ok)
        self.btn_ok.clicked.connect(self.confirm_and_close)

        self.layout_content.addLayout(self.layout_main_row_1)
        self.layout_content.addLayout(self.layout_main_row_2)
        self.layout_content.addLayout(self.layout_main_row_3)

        self.refresh_balanced_img()

    def on_click(self,x,y):
        if x >1 or x<0 or y>1 or y<0:
            return
        shape = self.img.shape
        px = x*shape[1]
        py = y*shape[0]

        self.img_balanced = evc_white_balance(self.img, self.img[int(py),int(px)])
        self.refresh_balanced_img()

    def refresh_balanced_img(self):
        self._img_2.set_image(np.clip(self.img_balanced*255,0,255).astype(np.uint8))

    def reset_white(self):
        """Resets the selected white value"""
        self.img_balanced = evc_white_balance(self.img, [1, 1, 1])
        self.refresh_balanced_img()

    def confirm_and_close(self):
        """Returns the white balanced image values"""
        self.close()

if __name__ == "__main__":
    # img = np.random.rand(1000, 1000)
    from PIL import Image
    img = np.array(
        Image.open(".\\bsp3_camera\\GUI\\weiss.jpg")).astype('float') / 255
    img_balanced = gui_white_balance(img)
    print(img_balanced)