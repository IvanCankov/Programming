# Copyright TU Wien (2022) - EVC: Task3
# Computer Vision Lab
# Institute of Computer Graphics and Algorithms

from typing import Tuple

import numpy as np

def evc_prepare_histogram_range(input_image: np.ndarray, low: float, high: float) -> Tuple[float, float]:
    """evc_prepare_histogram_range first calculates the new upper- and lower-
    bounds. During the normalization, those two values are then mapped to [0,1].
    If 'low' < 0, it should be set to 0.
    If 'high' > than the maximum intensity in the image, it should be set
    to the maximum intensity.

      INPUT
      input 		... image
      low   		... current black value
      high  		... current white value

      OUTPUT
      newLow      ... new black value
      newHigh     ... new white value"""

    ### STUDENT CODE
    # TODO:	Implement this function.
    # NOTE: The following two lines can be removed. They prevent the
    #       framework from crashing.

    newLow = low
    newHigh = high
    ### END STUDENT CODE
    
    
    return newLow, newHigh


def evc_transform_histogram(input_image: np.ndarray, newLow: float, newHigh: float) -> np.ndarray:
    """ evc_transform_histogram performs the 'histogram normalization' and
        maps the interval [newLow, newHigh] to [0, 1].

        INPUT
        input 		... image
        newLow   	... black value
        newHigh  	... white value

        OUTPUT
        result		... image after the histogram normalization"""

    ### STUDENT CODE
    # TODO:	Implement this function.
    # HINT: If the current white value is smaller than the maximum intensity
    #       of the image, this function will create values larger than 1.
	# NOTE: The following line can be removed. It prevents the framework
    #       from crashing.

    result = np.zeros(input_image.shape)
    ### END STUDENT CODE

    
    return result


def evc_clip_histogram(input_image: np.ndarray) -> np.ndarray:
    """ After the transformation of the histogram, evc_clip_histogram sets all
    values that are < 0 to 0 and values that are > 1 to 1.

      INPUT
      img 		... image after the histogram normalization

      OUTPUT
      result		... image after the clipping operation"""

    ### STUDENT CODE
    # TODO:	Implement this function.
	# NOTE: The following line can be removed. It prevents the framework
    #       from crashing.

    result = np.zeros(input_image.shape)
    ### END STUDENT CODE

    
    return result
