from typing import List

import numpy as np
import matplotlib.pyplot as plt

def define_transformations() -> List[np.ndarray]:
    """
        Returns the four transformations t_1, .., t_4 to transform the square. 
        The transformations are determined by using mscale, mrotate and mtranslate.
    """
    ### STUDENT CODE
    # TODO: Implement this function.

	# NOTE: The following lines can be removed. They prevent the framework
    #       from crashing.

    t1 = transform_vertices(mrotate(55), mtranslate(-3, 0))
    t2 = transform_vertices(mscale(3, 2), transform_vertices(mrotate(70), mtranslate(3, 1)))

    t3, t4 =  mtranslate(3, 3), np.zeros((3,3))

    ### END STUDENT CODE

    return [t1, t2, t3, t4]

def mscale(sx : float, sy : float) -> np.ndarray:
    """
        Defines a scale matrix. The scales are determined by s_x in x and s_y in y dimension.
    """
    ### STUDENT CODE
    # TODO: Implement this function.

    m = np.array([
            [sx, 0 , 0],
            [0, sy, 0],
            [0, 0, 1.]
        ])

	# NOTE: The following lines can be removed. They prevent the framework
    #       from crashing.


    ### END STUDENT CODE

    return m

def mrotate(angle : float) -> np.ndarray:
    """
        Defines a rotation matrix (z-axis) determined by the angle in degree (!).
    """
    ### STUDENT CODE
    # TODO: Implement this function.

	# NOTE: The following lines can be removed. They prevent the framework
    #       from crashing.

    angle = angle * (np.pi/180) #deg to rad

    m = np.array([
            [np.cos(angle), -np.sin(angle), 0.],
            [np.sin(angle), np.cos(angle), 0.],
            [0., 0., 1.]
        ])

    ### END STUDENT CODE

    return m
    
def mtranslate(tx : float, ty : float) -> np.ndarray:
    """
        Defines a translation matrix. t_x in x, t_y in y direction.
    """
    ### STUDENT CODE
    # TODO: Implement this function.

	# NOTE: The following lines can be removed. They prevent the framework
    #       from crashing.

    m = np.array([
            [1., 0. , tx],
            [0., 1., ty],
            [0., 0., 1.]
        ])

    ### END STUDENT CODE

    return m

def transform_vertices(v : np.ndarray, m : np.ndarray) -> np.ndarray:
    """
        transform the (3xN) vertices given by v with the (3x3) transformation matrix determined by m.
    """
    out = m @ v

    ### END STUDENT CODE

    return out

def display_vertices(v : np.ndarray, title : str) -> None:
    """
        Plot the vertices in a matplotlib figure.
    """
    # create the figure and set the title
    plt.figure()
    plt.axis('square')

    plt.title(title)

    # x and y limits
    plt.xlim((-6,6))
    plt.ylim((-6,6))
    plt.xticks(range(-6,6))
    plt.yticks(range(-6,6))

    # plot coordinate axis
    plt.axvline(color='black')
    plt.axhline(color='black')
    plt.grid()
    
    # we just add the last element, so plot can do our job :)
    v_ = np.concatenate((v, v[:, 0].reshape(3,-1)), axis=1)

    plt.plot(v_[0, :], v_[1, :], linewidth=3)
    plt.show()
