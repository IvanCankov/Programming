from typing import Tuple
import numpy as np
    
def define_structures() -> Tuple[np.ndarray, np.ndarray, np.ndarray]:
    """
        Defines the two vectors v1 and v2 as well as the matrix M determined by your matriculation number.
    """

    ### STUDENT CODE
    # TODO: Implement this function.
    v1 = np.array([1, 1, 2])
    v2 = np.array([4, 2, 9])
	
    M = np.array([
        [1, 2, 2],
        [2, 0, 1],
        [9, 0, 4]
        ])
    
    ### END STUDENT CODE

    return v1, v2, M

def sequence(M : np.ndarray) -> np.ndarray:
    """
        Defines a vector given by the minimum and maximum digit of your matriculation number. Step size = 0.25.
    """
    ### STUDENT CODE
    # TODO: Implement this function.

    minimum = np.min(M)
    maximum = np.max(M) + 0.1
    result = np.arange(minimum, maximum, 0.25, dtype='float32')
    print(result)
    ### END STUDENT CODE

    return result

def matrix(M : np.ndarray) -> np.ndarray:
    """
        Defines the 15x9 block matrix as described in the task description.
    """
    ### STUDENT CODE
    # TODO: Implement this function.

	# NOTE: The following lines can be removed. They prevent the framework
    #       from crashing.
    matrikel_matrix = M
    zero_matrix = np.zeros_like(matrikel_matrix)
    vertical_row_1 = np.vstack((matrikel_matrix, zero_matrix, matrikel_matrix, zero_matrix, matrikel_matrix))
    vertical_row_2 = np.vstack((zero_matrix, matrikel_matrix, zero_matrix, matrikel_matrix, zero_matrix))
    r = np.hstack((vertical_row_1, vertical_row_2, vertical_row_1))
    ### END STUDENT CODE

    return r

def dot_product(v1:np.ndarray, v2:np.ndarray) -> float:
    """
        Dot product of v1 and v2.
    """
    ### STUDENT CODE
    # TODO: Implement this function.

	# NOTE: The following lines can be removed. They prevent the framework
    #       from crashing.
    r = sum([i*j for (i, j) in zip(v1, v2)])
    ### END STUDENT CODE
    return r

def cross_product(v1:np.ndarray, v2:np.ndarray) -> np.ndarray:
    """
        Cross product of v1 and v2.
    """
    ### STUDENT CODE
    # TODO: Implement this function.

	# NOTE: The following lines can be removed. They prevent the framework
    #       from crashing.
    # (a1, a2, a3) X (b1, b2, b3) = (a2*b3-a3*b2, a3*b1-a1*b3, a1*b2-a2*b1)

    r = np.array([v1*v2 - v1*v2,
                  v1*v2 - v1*v2,
                  v1*v2 - v1*v2])

    ### END STUDENT CODE

    return r

def vector_X_matrix(v:np.ndarray, M:np.ndarray) -> np.ndarray:
    """
        Defines the vector-matrix multiplication v*M.
    """
    ### STUDENT CODE
    # TODO: Implement this function.
    r = []
    for column in range(3):
        temp = 0
        for row in range(3):
            temp += M[row][column] * v[row]
        r.append(temp)
    r = np.array(r)
    ### END STUDENT CODE
    return r

def matrix_X_vector(M:np.ndarray, v:np.ndarray) -> np.ndarray:
    """
        Defines the matrix-vector multiplication M*v.
    """
    ### STUDENT CODE
    # TODO: Implement this function.

	# NOTE: The following lines can be removed. They prevent the framework
    #       from crashing.
    r = []
    for  column in M:
        temp = 0
        for index, row in enumerate(column):
            temp += row * v[index]
        r.append(temp)
    r = np.array(r)
    ### END STUDENT CODE

    return r

def matrix_X_matrix(M1:np.ndarray, M2:np.ndarray) -> np.ndarray:
    """
        Defines the matrix multiplication M1*M2.
    """
    ### STUDENT CODE
    # TODO: Implement this function.

	# NOTE: The following lines can be removed. They prevent the framework
    #       from crashing.
    
    r = []
    matrix_rows = []

    for mat1_row in range(3):
        r = []
        for col in range(3):
            temp = 0
            for row in range(3):
                temp += M1[mat1_row][row] * M2[row][col]
            r.append(temp)
        matrix_rows.append(r)
    matrix_rows = np.array(matrix_rows)
    ### END STUDENT CODE
    return matrix_rows

matrix_X_matrix(define_structures(), define_structures())

def matrix_Xc_matrix(M1:np.ndarray, M2:np.ndarray) -> np.ndarray:
    """
        Defines the element-wise matrix multiplication M1*M2 (Hadamard Product).
    """
    ### STUDENT CODE
    # TODO: Implement this function.

	# NOTE: The following lines can be removed. They prevent the framework
    #       from crashing.

    r = []
    for col in range(3):
            matrix_rows = []
            for row in range(3):
                matrix_rows.append(M1[col][row] * M2[col][row])
            r.append(matrix_rows)
    ### END STUDENT CODE
    
    return r