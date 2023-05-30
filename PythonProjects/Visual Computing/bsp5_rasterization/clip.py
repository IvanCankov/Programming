# Copyright TU Wien (2022) - EVC: Task5
# Institute of Computer Graphics and Algorithms.

from copy import copy
from typing import List

import numpy as np

from Mesh import Mesh
from MeshVertex import MeshVertex
from ClippingPlane import ClippingPlane


def clip(mesh : Mesh, planes : List[ClippingPlane]) -> Mesh:
    """ clip the mesh with the given planes."""
    clipped_mesh = copy(mesh)
    clipped_mesh.clear()

    for f in range(mesh.faces.shape[0]):
        vertices = mesh.get_face(f).get_vertex(np.arange(mesh.faces[f]))

        positions = vertices.get_position()
        colors = vertices.get_color()
        vertex_count = 3

        for plane in planes:
            vertex_count, positions, colors = clip_plane(vertex_count, positions, colors, plane)

        if vertex_count != 0:
            clipped_mesh.add_face(vertex_count, positions, colors)

    return clipped_mesh

def clip_plane(vertex_count : int, positions : np.ndarray, colors : np.ndarray, plane : ClippingPlane) -> List[np.ndarray]:
    """ clips all vertices defined in positions against the clipping
             plane clipping_plane. Clipping is done by using the Sutherland
             Hodgman algorithm.

        Input Parameter
            vertex_count          ... number of vertices of the face that is clipped
            positions             ... n x 4 matrix with positions of n vertices
                                    one row corresponds to one vertex position
            colors                ... n x 3 matrix with colors of n vertices
                                    one row corresponds to one vertex color
            plane                 ... plane to clip against

        Returns:
            vertex_count_clipped  ... number of resulting vertices after clipping;
                                    this number depends on how the plane intersects
                                    with the face and therefore is not constant
            pos_clipped           ... n x 4 matrix with positions of n clipped vertices
                                    one row corresponds to one vertex position
            col_clipped           ... n x 3 matrix with colors of n clipped vertices
                                    one row corresponds to one vertex color"""
 
    # clear output
    pos_clipped = np.zeros((vertex_count + 1,  4))
    col_clipped = np.zeros((vertex_count + 1,  3))
    vertex_count_clipped = 0

    ### STUDENT CODE
    # TODO 2:   Implement this function.
    # HINT 1: 	Read the article about Sutherland Hodgman algorithm on Wikipedia.
    #           https://en.wikipedia.org/wiki/Sutherland%E2%80%93Hodgman_algorithm
    #           Take a look at the tutorial.ipynb file for further explanations!
    # HINT 2: 	There is an edge between every consecutive vertex in the positions
    #       	matrix. Note: also between the last and first entry!
	# NOTE:     The following lines can be removed. They prevent the framework
	#           from crashing.

    pos_clipped = positions
    col_clipped = colors
    vertex_count_clipped = vertex_count

    ### END STUDENT CODE


    return vertex_count_clipped, pos_clipped, col_clipped
