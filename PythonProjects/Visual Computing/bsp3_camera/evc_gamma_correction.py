# Copyright TU Wien (2022) - EVC: Task3
# Computer Vision Lab
# Institute of Computer Graphics and Algorithms

import numpy as np

def rgb2gray(rgb : np.ndarray):
    r, g, b = rgb[:,:,0], rgb[:,:,1], rgb[:,:,2]
    gray = 0.2989 * r + 0.5870 * g + 0.1140 * b
    return np.clip(gray, 0, 1)

def evc_compute_brightness(input_image: np.ndarray) -> np.ndarray:
    """evc_compute_brightness calculates the brightness of the input image.
    First the image is normalized by multiplying it with the reciprocal of
    the maximum value of all three color channels. The brightness is then
    retrieved by computing a gray-scale image. Afterwards the result
    is multiplied by the maximum value.
    
      INPUT
      input_image...  image matrix of dimension: (n, m, 3)
    
      OUTPUT
      brightness...   brightness of the image, matrix of dimension (n, m)"""

    ### STUDENT CODE
    # TODO: Implement this function.
    # HINT: The function 'rgb2gray' might be useful.

    brightness = np.ones(input_image.shape)
    ### END STUDENT CODE


    return brightness

def evc_compute_chromaticity(input_image: np.ndarray, brightness: np.ndarray) -> np.ndarray:
    """ evc_compute_chromaticity calculates the chromaticity of the 'input' image
    using the 'brightness' values. Therefore the color channels of the input
    image are individually divided by the brightness values.
    
      INPUT
      input_image...      image, dimension (n, m, 3)
      brightness...       brightness values, dimension (n, m)
    
      OUTPUT
      chromaticity...     chromaticity of the image, dimension (n, m, 3)"""

    ### STUDENT CODE
    # TODO: Implement this function.
    # HINT: The function 'np.dstack' might be useful.
    # NOTE: The following line can be removed. It prevents the framework
    #       from crashing.

    chromaticity = np.zeros(input_image.shape)
    ### END STUDENT CODE


    return chromaticity

def evc_gamma_correct(input_image: np.ndarray, gamma: float) -> np.ndarray:
    """evc_gamma_correct performs gamma correction on the 'input_image' image.
    This is done by raising it to the power of the reciprocal value of gamma
    (gamma**(-1)).
    
      INPUT
      input_image...  image
      gamma...        gamma value
    
      OUTPUT
      corrected...    image after gamma correction"""

    ### STUDENT CODE
    # TODO: Implement this function.
    # HINT: Make sure the program does not crash because of a division by 0
    # NOTE: The following line can be removed. It prevents the framework
    #       from crashing.

    corrected = np.zeros(input_image.shape)
    ### END STUDENT CODE


    return corrected

def evc_reconstruct(brightness_corrected: np.ndarray, chromaticity) -> np.ndarray:
    """ evc_reconstruct reconstructs the color values by multiplying the corrected
    brightness with the chromaticity.
    
      INPUT
      brightness_corrected... gamma-corrected brightness values
      chromaticity...         chromaticity
    
      OUTPUT
      result...               reconstructed image"""

    ### STUDENT CODE
    # TODO: Implement this function.
    # NOTE:  The following line can be removed. It prevents the framework
    #       from crashing.

    result = np.zeros(brightness_corrected.shape)
    ### END STUDENT CODE


    return result
