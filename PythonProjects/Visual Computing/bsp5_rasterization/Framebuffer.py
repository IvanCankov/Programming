# Copyright TU Wien (2022) - EVC: Task5
# Institute of Computer Graphics and Algorithms.
 
import copy
import numpy as np

class Framebuffer:

    def __init__(self, height : int, width : int):
        """Initializes a framebuffer of size (height width 3) and a zbuffer to save the depth values."""

        self.width = width
        self.height = height
        self.channels = 3
        self.image = np.zeros((height, width, self.channels))
        self.zbuffer = np.ones((height, width))

    def copy(self):
        "returns a copy of the framebuffer and returns it."
        
        fb = copy.copy(self)
        fb.image = self.image
        fb.zbuffer = self.zbuffer
        return fb
    
    def set_pixel(self, x : np.ndarray, y : np.ndarray, depth: np.ndarray, color : np.ndarray):
        """Sets the corresponding pixels at location (x,y) to the color values and the zbuffer."""

        x = np.array(x, dtype=int)
        y = np.array(y, dtype=int)

        coords = np.array(list(zip(x,y)))
        delete = np.argwhere(self.zbuffer[coords[:, 1], coords[:, 0]] < depth)

        new_coords = np.delete(coords, delete, axis=0)
        depth = np.delete(depth, delete, axis=0)
        color = np.delete(color, delete, axis=0)

        self.zbuffer[new_coords[:, 1], new_coords[:, 0]] = depth
        self.image[new_coords[:, 1], new_coords[:, 0]] = color


    def get_pixel(self, x : int, y : int):
        """Get the value of the frame buffer at position (x,y)."""

        if x < 0 or y < 0 or x > (self.width - 1) or y > (self.height - 1):
            raise

        res = self.image[y,x]
        return res

    def clear(self):
        """Clear the framebuffer"""

        self.image = np.zeros((self.height, self.width, self.channels))
        self.zbuffer = np.ones((self.height, self.width))

