# Copyright TU Wien (2022) - EVC: Task5
# Institute of Computer Graphics and Algorithms.

import numpy as np
from numpy.matlib import repmat

from MeshVertex import MeshVertex
from Framebuffer import Framebuffer
from MeshVertex import MeshVertex

def fill_rasterization(mesh : MeshVertex, framebuffer : Framebuffer):
    """ applies the fill rasterization algorithm. Draws a mesh to the Framebuffer."""

    for i in range(mesh.faces.shape[0]):
        v1 = mesh.get_face(i).get_vertex(0)
        for j in range(mesh.faces[i][0]-1):
            i, j = np.array(i).reshape(np.asarray(i).size), np.array(j).reshape(np.asarray(j).size)

            v2 = mesh.get_face(i).get_vertex(j)
            v3 = mesh.get_face(i).get_vertex(j+1)
            draw_triangle(framebuffer, v1, v2, v3)


def line_eq(A : float, B : float, C : float, x : float, y : float) -> float:
    """defines the line equation described by the provided parameters and
        returns the distance of a point (x, y) to this line.
        A    ... line equation parameter 1
        B    ... line equation parameter 2
        C    ... line equation parameter 3
        x    ... x coordinate of point to test against the line
        y    ... y coordinate of point to test against the line
        res  ... distance of the point (x, y) to the line (A, B, C)."""

    ### STUDENT CODE
    res = abs(A * x + B * y + C) / (A ** 2 + B ** 2) ** 0.5
    ### END STUDENT CODE

    return res

def draw_triangle(framebuffer : Framebuffer, v1 : MeshVertex, v2 : MeshVertex, v3 : MeshVertex):
    """ draws a triangle defined by v1,v2,v3 to the given framebuffer"""
    
    x1, y1, depth1 = v1.get_screen_coordinates()
    x2, y2, depth2 = v2.get_screen_coordinates()
    x3, y3, depth3 = v3.get_screen_coordinates()

    col1 = v1.get_color()
    col2 = v2.get_color()
    col3 = v3.get_color()

    # calc triangle area * 2
    a = ((x3-x1)*(y2-y1) - (x2-x1)*(y3-y1))

    if not np.isclose(a, 0):
        # Swap order of clockwise triangle to make them counter-clockwise
        if a < 0:
            t = x2
            x2 = x3 
            x3 = t

            t = y2
            y2 = y3
            y3 = t

            t = depth2
            depth2 = depth3
            depth3 = t

            t = col2
            col2 = col3
            col3 = t

        ### STUDENT CODE
        x1 = x1[0]
        y1 = y1[0]
        x2 = x2[0]
        y2 = y2[0]
        x3 = x3[0]
        y3 = y3[0]
        min_x = int(min(x1, x2, x3))
        max_x = int(max(x1, x2, x3))
        min_y = int(min(y1, y2, y3))
        max_y = int(max(y1, y2, y3))
        a1, b1 = -(y3 - y2), x3 - x2
        a2, b2 = -(y1 - y3), x1 - x3
        a3, b3 = -(y2 - y1), x2 - x1
        c1 = -(a1 * x2 + b1 * y2)
        c2 = -(a2 * x3 + b2 * y3)
        c3 = -(a3 * x1 + b3 * y1)

        ov1 = a1 * x1 + b1 * y1 + c1
        ov2 = a2 * x2 + b2 * y2 + c2
        ov3 = a3 * x3 + b3 * y3 + c3
        for y in range(min_y, max_y + 1):
            for x in range(min_x, max_x + 1):
                o1 = a1 * x + b1 * y + c1
                o2 = a2 * x + b2 * y + c2
                o3 = a3 * x + b3 * y + c3
                if o1 <= 0 and o2 <= 0 and o3 <= 0:
                    alpha = o1 / ov1
                    beta = o2 / ov2
                    gamma = o3 / ov3
                    depth = MeshVertex.barycentric_mix(depth1, depth2, depth3, alpha, beta, gamma)
                    color = MeshVertex.barycentric_mix(col1, col2, col3, alpha, beta, gamma)
                    framebuffer.set_pixel(np.array([int(x)]), np.array([int(y)]), np.array([depth]), np.array(color))
        ### END STUDENT CODE
