from typing import List, Tuple

import numpy as np
import math

def define_triangle() -> Tuple[np.ndarray, np.ndarray, np.ndarray]:
    ### STUDENT CODE
    # TODO: Implement this function.

	# NOTE: The following lines can be removed. They prevent the framework
    #       from crashing.
    P1 = np.array([(1 + 2), -(1 + 1), -(1 + 9)])
    P2 = np.array([-(0 + 2), -(2 + 1), (2 + 9)])
    P3 = np.array([-(1 + 1), (1 + 4), -(1 + 2)])
    ### END STUDENT CODE

    return P1, P2, P3

def define_triangle_vertices(P1:np.ndarray, P2:np.ndarray, P3:np.ndarray) -> Tuple[np.ndarray, np.ndarray, np.ndarray]:
    ### STUDENT CODE
    # TODO: Implement this function.
    # NOTE: vertex == Punkt; edge == Seite
	# NOTE: The following lines can be removed. They prevent the framework
    #       from crashing. 
    P1P2 = P2 - P1
    P2P3 = P3 - P2
    P3P1 = P1 - P3
    ### END STUDENT CODE

    return P1P2, P2P3, P3P1


def compute_lengths(P1P2:np.ndarray, P2P3:np.ndarray, P3P1:np.ndarray) -> List[float]:
    ### STUDENT CODE
    # TODO: Implement this function.

	# NOTE: The following lines can be removed. They prevent the framework
    #       from crashing.

    distance_P1P2 = math.sqrt(sum(pow(P1P2, 2)))
    distance_P2P3 = math.sqrt(sum(pow(P2P3, 2)))
    distance_P3P1 = math.sqrt(sum(pow(P3P1, 2)))
    norms = np.array([distance_P1P2, distance_P2P3, distance_P3P1])
    ### END STUDENT CODE

    return norms

def compute_normal_vector(P1P2:np.ndarray, P2P3:np.ndarray, P3P1:np.ndarray) -> Tuple[np.ndarray, np.ndarray]:
    ### STUDENT CODE
    # TODO: Implement this function.

	# NOTE: The following lines can be removed. They prevent the framework
    #       from crashing.

    n = np.cross(P1P2, P3P1)
    lenght_n = math.sqrt(sum(pow(n, 2)))
    n_normalized = n / lenght_n
    ### END STUDENT CODE

    return n, n_normalized

def compute_triangle_area(n:np.ndarray) -> float:
    ### STUDENT CODE
    # TODO: Implement this function.

	# NOTE: The following lines can be removed. They prevent the framework
    #       from crashing.

    area = 0.5 * math.sqrt(sum(pow(n ,2)))
    ### END STUDENT CODE

    return area

def compute_angles(P1P2:np.ndarray,P2P3:np.ndarray,P3P1:np.ndarray) -> Tuple[float, float, float]:
    ### STUDENT CODE
    # TODO: Implement this function.

	# NOTE: The following lines can be removed. They prevent the framework
    #       from crashing.

    alpha, beta, gamma = 0., 0., 0.
    ### END STUDENT CODE

    return alpha, beta, gamma
