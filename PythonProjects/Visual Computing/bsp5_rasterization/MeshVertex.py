# Copyright TU Wien (2022) - EVC: Task5
# Institute of Computer Graphics and Algorithms.

import numpy as np


class MeshVertex:

    def __init__(self, mesh, index):
        """initializes mesh vertex"""

        self.mesh = mesh
        self.index = np.array(index, dtype=int)

    def get_position(self):
        """returns position of the mesh vertex"""
        return self.mesh.V_position[self.index]

    def get_color(self):
        """returns color of the mesh vertex"""

        return self.mesh.V_color[self.index]

    def get_screen_coordinates(self):
        """returns screen position of the mesh vertex"""

        x = self.mesh.V_screen_position[self.index, 0]
        y = self.mesh.V_screen_position[self.index, 1]
        z = self.mesh.V_screen_position[self.index, 2]
        return x, y, z

    @staticmethod
    def mix(a : np.ndarray, b : np.ndarray, t : np.ndarray) -> np.ndarray:
        """Interpolates the line defined by a,b at position t and returns the result."""
        ### STUDENT CODE

        res = a

        ### END STUDENT CODE

        return res

    @staticmethod
    def barycentric_mix(a : np.ndarray, b : np.ndarray, c : np.ndarray, alpha : int, beta : int, gamma : int) -> np.ndarray:
        """Interpolates the triangle defined by a,b,c at barycentric coordinates alpha, beta, gamma and returns the result."""

        ### STUDENT CODE

        res = a

        ### END STUDENT CODE

        return res

