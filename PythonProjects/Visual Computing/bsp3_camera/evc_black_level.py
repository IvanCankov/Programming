# Copyright TU Wien (2022) - EVC: Task3
# Computer Vision Lab
# Institute of Computer Graphics and Algorithms

from typing import Tuple

import numpy as np
from PIL import Image
from PIL.TiffTags import TAGS


def evc_read_file_info(filename: str) -> Tuple[int, Tuple]:

    # open the image
    img_pil = Image.open(filename)

    # get all tags in a dict
    meta_dict = {TAGS[ key ] : img_pil.tag [ key ] for key in img_pil.tag_v2 }

    # get blacklevel
    blackLevel = meta_dict['BlackLevel'][0]

    # get whatever this is
    asShotNeutral = meta_dict['AsShotNeutral']
    ### END STUDENT CODE
    
    #return the 2 values
    return blackLevel, asShotNeutral


    
def evc_transform_colors(input_image: np.ndarray, blackLevel: float) -> np.ndarray:
    
    # copy the image
    output_image = input_image.copy().astype(float)

    # creates a boolean mask where each element of the mask is True if the corresponding element of the output_image is less than or equal to blackLevel
    mask = output_image <= blackLevel

    ### Yes, there is a reason for subtracting the blackLevel value from every pixel value in the output_image.
    # The blackLevel value represents the level below which the image sensor produces no signal,
    # resulting in a pure black image. However, due to the inherent noise in the image sensor, 
    # even when no signal is present, some small fluctuations in the signal can still be detected.
    # These fluctuations can cause a small offset or bias in the pixel values, resulting in a "dark current" 
    # that can manifest as a small amount of noise or a slightly elevated baseline level in the image.
    # Subtracting the blackLevel value from the pixel values effectively removes this bias,
    # bringing the true black level of the image down to zero. This can improve the contrast and overall quality
    # of the image by reducing the amount of noise and increasing the dynamic range.
    output_image = output_image - blackLevel

    # sets to zero any pixel value in the output_image that corresponds to a True value in the mask 
    output_image[mask] = 0         

    # rescales the pixel values to the range between 0 and 1
    output_image = output_image / (65535 - blackLevel)
    
    ### END STUDENT CODE
    
    # return the processed image
    return output_image
