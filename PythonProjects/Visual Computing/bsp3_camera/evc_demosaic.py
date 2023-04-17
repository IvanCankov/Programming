# Copyright TU Wien (2022) - EVC: Task3
# Computer Vision Lab
# Institute of Computer Graphics and Algorithms

from typing import Tuple

import numpy as np
import numpy.matlib as matlib
import scipy.ndimage
from scipy import ndimage


def evc_demosaic_pattern(input_image: np.ndarray, pattern = 'RGGB') -> Tuple[np.ndarray, np.ndarray, np.ndarray]:

    # initialise R, G and B to numpy arrays with the sane dimensions as the image
    R = np.zeros(input_image.shape)
    G = np.zeros(input_image.shape)
    B = np.zeros(input_image.shape)

    # extract color channels without interpolation

    if pattern == 'RGGB':

    # get every second element starting from 0 (row)
    # get every second element starting from 0 (column)
        R[0::2, 0::2] = input_image[0::2, 0::2]
        G[0::2, 1::2] = input_image[0::2, 1::2]
        G[1::2, 0::2] = input_image[1::2, 0::2]
        B[1::2, 1::2] = input_image[1::2, 1::2]
    
    ### END STUDENT CODE

    # returns the arrays
    return  R,G,B

def evc_transform_neutral(R: np.ndarray, G: np.ndarray, B: np.ndarray, asShotNeutral: np.ndarray) -> Tuple[np.ndarray, np.ndarray, np.ndarray]:

    # tuple asShotNeutral (r, g, b)
    R_trans = R / asShotNeutral[0]
    G_trans = G / asShotNeutral[1]
    B_trans = B / asShotNeutral[2]

    ### END STUDENT CODE

    # returns (R, G, B) values divided by their respective asShotNeutral values
    return R_trans, G_trans, B_trans

def evc_interpolate(red : np.ndarray, green : np.ndarray, blue : np.ndarray) -> Tuple[np.ndarray, np.ndarray, np.ndarray]:

    #silly lil filters
    green_filter_kernel = np.array([[0, 0.25, 0], [0.25, 1, 0.25], [0, 0.25, 0]])
    blue_filter_kernel = np.array([[0.25, 0.5, 0.25], [0.5, 1, 0.5], [0.25, 0.5, 0.25]])
    red_filter_kernel = blue_filter_kernel

    G_inter = scipy.ndimage.correlate(green, green_filter_kernel, mode='constant')
    B_inter = scipy.ndimage.correlate(blue, blue_filter_kernel, mode='constant')
    R_inter = scipy.ndimage.correlate(red, red_filter_kernel, mode='constant')

    ### ndimage.correlate() is a function from the SciPy library that performs correlation of multi-dimensional arrays.
    # It calculates the correlation of a given array with a filter (kernel) in a sliding-window fashion,
    # where the kernel is shifted over each element of the input array, calculating the inner product at each step.
    # basically the same that we did in EP2 AB2 when applying a filter to the raster

    ### END STUDENT CODE

    # returns the correlated arrays
    return R_inter, G_inter, B_inter

def evc_concat(R: np.ndarray, G: np.ndarray, B: np.ndarray) -> np.ndarray:

    # combines the three individual red, green and blue channels to a single image
    result = np.dstack((R, G, B))

    ### END STUDENT CODE

    # returns the resulting coloured image
    return result
