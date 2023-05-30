# Copyright TU Wien (2022) - EVC: Task5
# Institute of Computer Graphics and Algorithms.

from typing import List
import numpy as np

class ClippingPlane:

    def __init__(self, plane : np.ndarray):
        """ plane     ... plane stored in Hessian normal form as a 1x4 vector"""
        self.plane = plane
    
    def inside(self, pos : np.ndarray) -> bool:
        """Checks if a given point lies behind the plane (opposite direction
        of normal vector). Points lying on the plane are considered to be
        inside.
        position  ... homogeneous position with 4 components
        return res... logical value which indicates if the point is
                      inside or not """

        ### STUDENT CODE
        # TODO 2: Implement this function.
        # HINT:   You can access the plane property via self.plane.
        # NOTE:   The following lines can be removed. They prevent the framework
        #         from crashing.

        res = 0

        ### END STUDENT CODE


        return res

    def intersect(self, pos1 : np.ndarray, pos2 : np.ndarray) -> float:
        """ Intersects the plane with a line between pos1 and pos2.
        pos1      ... homogeneous position with 4 components
        pos2      ... homogeneous position with 4 components
        return t  ... normalized intersection value t in [0, 1]"""

        ### STUDENT CODE
        # TODO 2: Implement this function.
        # HINT:   You can access the plane property via self.plane.
        # NOTE:   The following lines can be removed. They prevent the framework
        #         from crashing.

        t = 0

        ### END STUDENT CODE


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

