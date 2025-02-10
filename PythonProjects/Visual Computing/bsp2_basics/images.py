import numpy as np
import scipy.ndimage
from PIL import Image

import utils


def read_img(inp:str) -> Image.Image:
    """
        Returns a PIL Image given by its input path.
    """
    img =  Image.open(inp)
    return img

def convert(img:Image.Image) -> np.ndarray:
    """
        Converts a PIL image [0,255] to a numpy array [0,1].
    """
    ### STUDENT CODE
    # TODO: Implement this function.

	# NOTE: The following lines can be removed. They prevent the framework
    #       from crashing.
    out = np.array(img, dtype='f')
    converter_rows = 255.0 * np.ones(len(out))
    converter = np.vstack(converter_rows)
    out = np.divide(out, converter) 
    ### END STUDENT CODE
    return out

def switch_channels(img:np.ndarray) -> np.ndarray:
    """
        Swaps the red and green channel of an RGB iamge given by a numpy array.
    """
    ### STUDENT CODE
    # TODO: Implement this function.

	# NOTE: The following lines can be removed. They prevent the framework
    #       from crashing.
    
    out = img[:, :, [1, 0, 2]]
    #python array slicing magic :hearteyes:

    ### END STUDENT CODE

    return out

def image_mark_green(img:np.ndarray) -> np.ndarray:
    """
        returns a numpy-array (HxW) with 1 where the green channel of the input image is greater or equal than 0.7, otherwise zero.
    """
    ### STUDENT CODE
    # TODO: Implement this function.

	# NOTE: The following lines can be removed. They prevent the framework
    #       from crashing.
    mask = (img[:, :, [1]] >= 0.7).astype(int)
    ### END STUDENT CODE

    return mask


def image_masked(img:np.ndarray, mask:np.ndarray) -> np.ndarray:
    """
        sets the pixels of the input image to zero where the mask is 1.
    """
    ### STUDENT CODE
    # TODO: Implement this function.

	# NOTE: The following lines can be removed. They prevent the framework
    #       from crashing.

    out = img
    out = out[:, :, [0, 1, 2]] * (1 - mask)

    ### END STUDENT CODE

    return out

def grayscale(img:np.ndarray) -> np.ndarray:
    """
        Returns a grayscale image of the input. Use utils.rgb2gray().
    """
    ### STUDENT CODE
    # TODO: Implement this function.

	# NOTE: The following lines can be removed. They prevent the framework
    #       from crashing.

    out = np.zeros(img.shape)
    out = utils.rgb2gray(img)

    ### END STUDENT CODE

    return out

def cut_and_reshape(img_gray:np.ndarray) -> np.ndarray:
    """
        Cuts the image in half (x-dim) and stacks it together in y-dim.
    """
    ### STUDENT CODE
    # TODO: Implement this function.

	# NOTE: The following lines can be removed. They prevent the framework
    #       from crashing.

    out = np.zeros(img_gray.shape)

    ### END STUDENT CODE

    return out

def filter_image(img:np.ndarray) -> np.ndarray:
    """
        filters the image with the gaussian kernel given below. 
    """
    gaussian = utils.gauss_filter(10, 10)  # 5x5 kernel, sigma=2

    if img.ndim == 2:  # Grayscale image
        return convolve(img, gaussian)
    elif img.ndim == 3:  # RGB image
        # Apply the Gaussian filter to each channel independently
        return np.stack([convolve(img[:, :, i], gaussian) for i in range(3)], axis=2)

def horizontal_edges(img:np.ndarray) -> np.ndarray:
    """
        Defines a sobel kernel to extract horizontal edges and convolves the image with it.
    """
    ### STUDENT CODE
    # TODO: Implement this function.

	# NOTE: The following lines can be removed. They prevent the framework
    #       from crashing.

    out = np.zeros(img.shape)

    ### END STUDENT CODE

    return out


import numpy as np
from scipy.ndimage import convolve

def edge_detection(img: np.ndarray) -> np.ndarray:
    """
    Applies Sobel edge detection to a grayscale image represented as a 2D numpy array.
    """
    # If the image is RGB (3D), convert it to grayscale by averaging the color channels
    if img.ndim == 3:
        img = img.mean(axis=2)

    # Define Sobel kernels for edge detection
    sobel_x = np.array([
        [-1, 0, 1],
        [-2, 0, 2],
        [-1, 0, 1]
    ])

    sobel_y = np.array([
        [-1, -2, -1],
        [ 0,  0,  0],
        [ 1,  2,  1]
    ])
    
    # Apply convolution with Sobel kernels
    # Gx = convolve(img, sobel_x)
    Gy = convolve(img, sobel_y)
    
    # Compute the edge magnitude
    edges = np.sqrt(Gy**2) # + Gy**2)
    
    # Normalize the output to fit in the range [0, 255] for visualization
    edges = (edges / edges.max()) * 255
    edges = edges.astype(np.uint8)
    
    return edges

