import numpy as np

from PyQt6 import QtCore, QtGui, QtWidgets

class ClickableImageLabel(QtWidgets.QLabel):
    def __init__(self,*args,**kwargs):
        super().__init__(*args,**kwargs)
        self.setSizePolicy(QtWidgets.QSizePolicy.Policy.Ignored, QtWidgets.QSizePolicy.Policy.Ignored)
        self.setAlignment(QtCore.Qt.AlignmentFlag.AlignVCenter | QtCore.Qt.AlignmentFlag.AlignHCenter)
        self.setStyleSheet("background-color:#ffffff;")
        self.qpix = None
        self.clickHandler = None
    
    def set_image(self,img):
        w,h,c = img.shape
        qimg = QtGui.QImage(img.data,h,w, 3*h,QtGui.QImage.Format.Format_RGB888)
        self.qpix = QtGui.QPixmap.fromImage(qimg)
        self.refresh_image()

    def refresh_image(self):
        if self.qpix:
            self.setPixmap(self.qpix.scaled(self.width(),self.height(),QtCore.Qt.AspectRatioMode.KeepAspectRatio))

    #Qt Override
    def resizeEvent(self, event: QtGui.QResizeEvent):
        self.refresh_image()
    
    #Qt Override
    def mousePressEvent(self, event: QtGui.QMouseEvent) -> None:
        pixRect = self.pixmap().rect()
        pixRect.moveCenter(self.rect().center())

        x = (event.position().x()-pixRect.x())/pixRect.width()
        y = (event.position().y()-pixRect.y())/pixRect.height()

        if self.clickHandler:
            self.clickHandler(x,y)