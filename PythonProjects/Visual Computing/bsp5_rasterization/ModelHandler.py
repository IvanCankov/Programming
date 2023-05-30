# Copyright TU Wien (2022) - EVC: Task5
# Institute of Computer Graphics and Algorithms.
import importlib

import rasterize
import Framebuffer
import plyReader


class Model:

    def __init__(self, model_path : str):
        """Initializes the model given by the path"""

        self.mesh = plyReader.load_transformed_model(model_path, 1)
        self.faces = self.mesh.num_faces
        self.vertices = self.mesh.num_vertices
        self.model_name = model_path.split("data")[-1].strip(".ply").strip("/").strip("\\")

    def rasterize(self, rasterization_mode : str):
        """Rasterizes the mesh by the given mode:
                mode='line' -> line rasterization
                mode='fill' -> fill rasterization"""

        importlib.reload(rasterize)

        framebuffer  = Framebuffer.Framebuffer(600, 600)
        rasterize.rasterize(self.mesh, framebuffer, mode=rasterization_mode)       
        self.image = framebuffer.image