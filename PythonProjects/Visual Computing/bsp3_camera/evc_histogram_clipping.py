# Copyright TU Wien (2022) - EVC: Task3
# Computer Vision Lab
# Institute of Computer Graphics and Algorithms

from typing import Tuple

import numpy as np

def evc_prepare_histogram_range(input_image: np.ndarray, low: float, high: float) -> Tuple[float, float]:

    # get the maximum intensity in the image
    max_intensity = np.max(input_image)

    # calculate new values for lower and upper bounds
    new_low = max(0, low)
    new_high = min(max_intensity, high)

    ### END STUDENT CODE

    # return the new values
    return new_low, new_high


def evc_transform_histogram(input_image: np.ndarray, new_low: float, new_high: float) -> np.ndarray:

    # get the maximum intensity in the image again
    max_intensity = np.max(input_image)

    # normalize the bounds to [0,1]
    new_low /= max_intensity
    new_high /= max_intensity

    # create a copy of the input image to avoid modifying the original
    output_image = input_image.copy()

    # scale the pixel values to the desired range [0,new_high]
    output_image = output_image / new_high

    # create a mask where pixel values are below the lower bound new_low
    mask = output_image <= new_low

    # set the masked pixel values to zero
    output_image[mask] = 0.0

    ### END STUDENT CODE

    # return the processed image
    return output_image

def evc_clip_histogram(input_image: np.ndarray) -> np.ndarray:

    # Set all values < 0 to 0
    input_image[input_image < 0] = 0

    # Set all values > 1 to 1
    input_image[input_image > 1] = 1

    ### END STUDENT CODE

    # returns the clipped image
    return input_image