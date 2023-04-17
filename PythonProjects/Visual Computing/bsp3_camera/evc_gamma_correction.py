# Copyright TU Wien (2022) - EVC: Task3
# Computer Vision Lab
# Institute of Computer Graphics and Algorithms

import numpy as np

def rgb2gray(rgb : np.ndarray):
    r, g, b = rgb[:,:,0], rgb[:,:,1], rgb[:,:,2]
    gray = 0.2989 * r + 0.5870 * g + 0.1140 * b
    return np.clip(gray, 0, 1)

def evc_compute_brightness(input_image: np.ndarray) -> np.ndarray:

    # Normalize the image by dividing it by the maximum value
    max_val = np.max(input_image)
    normalized = input_image / max_val
    
    # Convert the normalized image to grayscale
    grayscale = rgb2gray(normalized)
    
    # Multiply the grayscale image by the maximum value
    brightness = grayscale * max_val

    ### END STUDENT CODE
    
    # return the result
    return brightness


def evc_compute_chromaticity(input_image: np.ndarray, brightness: np.ndarray) -> np.ndarray:

    # divide each color channel of the input image by its corresponding brightness value
    chromaticity = input_image / np.dstack((brightness, brightness, brightness))
    
    ### END STUDENT CODE

    # return the result
    return chromaticity



def evc_gamma_correct(input_image: np.ndarray, gamma: float) -> np.ndarray:

    # Check if gamma is zero and set it to a small value to avoid division by zero
    if gamma == 0:
        gamma = 1e-6
    
    # Compute the gamma-corrected image
    corrected = np.power(input_image, 1.0 / gamma)

    ### The np.power function raises each element of input_image to the power of 1.0 / gamma.
    # This operation effectively adjusts the brightness of the image by compressing or expanding 
    # the brightness range of the image.
    
    ### END STUDENT CODE

    # Return the result
    return corrected


def evc_reconstruct(brightness_corrected: np.ndarray, chromaticity) -> np.ndarray:

    # Multiply the brightness values with the chromaticity
    result = np.multiply(brightness_corrected[..., np.newaxis], chromaticity)

    ### This new axis is added at the end of the array (since ... is shorthand for "all existing dimensions") 
    # and has a size of 1. This is done so that brightness_corrected has the same number of dimensions as chromaticity,
    # allowing NumPy to perform the element-wise multiplication.

    ### END STUDENT CODE
    
    # Return the result
    return result