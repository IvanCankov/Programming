# Copyright TU Wien (2022) - EVC: Task3
# Computer Vision Lab
# Institute of Computer Graphics and Algorithms

from typing import Tuple

import numpy as np
import numpy.matlib as matlib
import scipy.ndimage
from scipy import ndimage


def evc_demosaic_pattern(input_image: np.ndarray, pattern = 'RGGB') -> Tuple[np.ndarray, np.ndarray, np.ndarray]:
    """ evc_demosaic_pattern extracts the red, green and blue values of the
     'input' image. Results are stored in the R, G, B variables.
    
      INPUT
      input_image...      Bayer-Pattern image
      pattern             Bayer-Pattern
      OUTPUT
      R...                red channel of the image (without interpolation)
      G...                green channel of the image (without interpolation)
      B...                blue channel of the image (without interpolation)"""

    ### STUDENT CODE
    # TODO: Implement this function.
    # HINT: For this task the "start:end:step" array slicing might be useful.
    #       Find the correct Bayer-Pattern depending on your dataset.
    #       No interpolation needs to be performed here!

	# NOTE: The following three lines can be removed. They prevent the framework
    #       from crashing.

    R = np.zeros(input_image.shape)
    G = np.zeros(input_image.shape)
    B = np.zeros(input_image.shape)

    # Extract color channels without interpolation
    #for some reason it doesn't work when i add if-else statements for the pattern :/
    #this one is for RGGB

    #get every second element starting from 0 (row)
    #get every second element starting from 0 (column)
    R[0::2, 0::2] = input_image[0::2, 0::2]
    G[0::2, 1::2] = input_image[0::2, 1::2]
    G[1::2, 0::2] = input_image[1::2, 0::2]
    B[1::2, 1::2] = input_image[1::2, 1::2]


    
    ### END STUDENT CODE

    return  R,G,B

def evc_transform_neutral(R: np.ndarray, G: np.ndarray, B: np.ndarray, asShotNeutral: np.ndarray) -> Tuple[np.ndarray, np.ndarray, np.ndarray]:
    """evc_transform_neutral changes the red, green and blue channels depending
    on the neutral white value (asShotNeutral). Therefore every channel needs
    to be divided by the respective channel of the white value.
    
      INPUT
      R...                red channel of the image
      G...                green channel of the image
      B...                blue channel of the image
      asShotNeutral... 	neutral white value (RGB vector)
    
      OUTPUT
      R_trans...                red channel of the image (changed by neutral white value)
      G_trans...                green channel of the image (changed by neutral white value)
      B_trans...                blue channel of the image (changed by neutral white value)"""

    ### STUDENT CODE
    # TODO: Implement this function.
	# NOTE: The following three lines can be removed. They prevent the framework
    #       from crashing.
    #gotta do this since the asShotNeutral is a tuple

    R_trans = R / asShotNeutral[0]
    G_trans = G / asShotNeutral[1]
    B_trans = B / asShotNeutral[2]

    return R_trans, G_trans, B_trans
    
    
    ### END STUDENT CODE

def evc_interpolate(red : np.ndarray, green : np.ndarray, blue : np.ndarray) -> Tuple[np.ndarray, np.ndarray, np.ndarray]:
    """evc_interpolate interpolates the red, green and blue channels. In the
        final image, every pixel now has red, green and blue values.
        
        INPUT
        red...                red channel of the image
        green...                green channel of the image
        blue...                blue channel of the image
        
        OUTPUT
        R_inter...                red channel of the image (without missing values)
        G_inter...                green channel of the image (without missing values)
        B_inter...                blue channel of the image (without missing values)"""

    ### STUDENT CODE
    # TODO: Implement this function.
	# HINT: The function 'scipy.ndimage.correlate' might be useful.
	# NOTE: The following three lines can be removed. They prevent the framework
    #       from crashing.

    #silly lil filter
    filter = np.array([[0, 1, 0], [1, 4, 1], [0, 1, 0]]) / 4

    # Interpolate the red channel
    R_inter = ndimage.correlate(red, filter, mode='constant')

    # Interpolate the green channel
    G_inter = ndimage.correlate(green, filter, mode='constant')

    # Interpolate the blue channel
    B_inter = ndimage.correlate(blue, filter, mode='constant')

    ### ndimage.correlate() is a function from the SciPy library that performs correlation of multi-dimensional arrays.
    # It calculates the correlation of a given array with a filter (kernel) in a sliding-window fashion,
    # where the kernel is shifted over each element of the input array, calculating the inner product at each step.
    # basically the same that we did in EP2 AB2 when applying a filter to the raster

    ### END STUDENT CODE

    return R_inter, G_inter, B_inter

def evc_concat(R: np.ndarray, G: np.ndarray, B: np.ndarray) -> np.ndarray:
    """evc_concat combines the three individual red, green and blue channels to a
    single image.
    
      INPUT
      R...                red channel of the image
      G...                green channel of the image
      B...                blue channel of the image
    
      OUTPUT
      result...           resulting image"""

    ### STUDENT CODE
    # TODO: Implement this function.
    # HINT: The function 'np.stack' might be useful.
    # NOTE: The following line can be removed. It prevents the framework
    #       from crashing.

    result = np.dstack((R, G, B))

    ### END STUDENT CODE


    return result
