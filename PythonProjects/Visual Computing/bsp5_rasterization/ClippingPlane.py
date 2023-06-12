# Copyright TU Wien (2022) - EVC: Task5
# Institute of Computer Graphics and Algorithms.

from typing import List
import numpy as np

class ClippingPlane:

    def __init__(self, plane : np.ndarray):
        """ plane     ... plane stored in Hessian normal form as a 1x4 vector"""
        self.plane = plane
    
    def inside(self, pos : np.ndarray) -> bool:

        # Calculate the dot product between the normal vector and the position vector
        dot_product = np.dot(self.plane, pos)

        # Check if the dot product is less than or equal to 0
        # Points lying on the plane will have a dot product of 0
        # Points behind the plane will have a negative dot product
        inside_plane = dot_product <= 0

        return inside_plane

    def intersect(self, pos1 : np.ndarray, pos2 : np.ndarray) -> float:
        # Calculate the direction vector of the line
        direction = pos2 - pos1

        # Calculate the dot product between the normal vector of the plane and the direction vector
        dot_product = np.dot(self.plane, direction)

        # Check if the line is parallel to the plane (dot product is close to 0)
        if np.abs(dot_product) < 1e-6:
            # Line is parallel to the plane, so there is no intersection
            return None

        # Calculate the intersection parameter t
        t = -np.dot(self.plane, pos1) / dot_product

        # Check if the intersection is within the line segment
        if t < 0 or t > 1:
            # Intersection is outside the line segment
            return None

        return t
    
    @staticmethod
    def get_clipping_planes() -> List:
        """creates and returns a list of the six Clipping planes defined in the task description."""

        ### STUDENT CODE
        # TODO 2: Define the correct clip planes.
        # NOTE:   The following lines can be removed. They prevent the framework
        #         from crashing.

        res = [
            ClippingPlane(np.array([0, 0, 0, 0])),
            ClippingPlane(np.array([0, 0, 0, 0])),
            ClippingPlane(np.array([0, 0, 0, 0])),
            ClippingPlane(np.array([0, 0, 0, 0])),
            ClippingPlane(np.array([0, 0, 0, 0])),
            ClippingPlane(np.array([0, 0, 0, 0]))
        ]

        ### END STUDENT CODE

        
        return res

