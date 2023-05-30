# Copyright TU Wien (2022) - EVC: Task5
# Institute of Computer Graphics and Algorithms.

import sys
import numpy as np
from PIL import Image

from ModelHandler import Model
from gui import *

class App(Ui_MainWindow):
    def __init__(self, window):
        self.setupUi(window)
        self.window = window

        self.rasterization_mode = "line"

        self.radioButton_line.clicked.connect(self.rasterization_mode_line)
        self.radioButton_fill.clicked.connect(self.rasterization_mode_fill)
        self.button_load_model.clicked.connect(self.load_model)
        self.button_rasterize.clicked.connect(self.rasterize)
        self.button_save_as.clicked.connect(self.save_image)
        self.button_close.clicked.connect(self.close_app)

    def rasterization_mode_line(self):
        print('Rasterization mode changed to "LINE"')
        self.rasterization_mode = "line"
        ui.button_save_as.setEnabled(False)

    def rasterization_mode_fill(self):
        print('Rasterization mode changed to "FILL"')
        self.rasterization_mode = "fill"
        ui.button_save_as.setEnabled(False)

    def load_model(self):
        print("load_model() called")
        
        # select ply file
        path = QtWidgets.QFileDialog.getOpenFileName(self.window,directory="./data/",filter="*.ply")[0]
        print(path)
        if path is None or path == "":
            return

        # compute model
        self.model = Model(path)

        # update information
        self.label_info_model.setText(self.model.model_name)
        self.label_info_vertices.setText(str(self.model.vertices))
        self.label_info_faces.setText(str(self.model.faces))

        ui.button_rasterize.setEnabled(True)
        ui.button_save_as.setEnabled(False)
        ui.label_image.setText("Please rasterize")
        
    def rasterize(self):
        print("rasterize() called")
        self.model.rasterize(self.rasterization_mode)

        # show image
        self.img = np.uint8(self.model.image*255) 

        height, width, channel = self.img.shape
        bytesPerLine = 3 * width
        qImg = QtGui.QImage(self.img, width, height, bytesPerLine, QtGui.QImage.Format.Format_RGB888)
        ui.label_image.setPixmap(QtGui.QPixmap(qImg))

        ui.button_save_as.setEnabled(True)

    def save_image(self):
        print("save_image() called")
        path = path = QtWidgets.QFileDialog.getSaveFileName(self.window,directory=f"./saved_images/{self.model.model_name}_{self.rasterization_mode}.png",filter="*.png")[0]
        if path is None or path == "":
            return
        if (path.split(".")[-1] != "png"):
            path = path+".png"
        Image.fromarray(self.img).save(path)

    def close_app(self):
        print("close_app() called")
        app.quit()

if __name__ == "__main__":
    app = QtWidgets.QApplication(sys.argv)
    MainWindow = QtWidgets.QMainWindow()

    ui = App(MainWindow)
    MainWindow.show()
    app.exec()
