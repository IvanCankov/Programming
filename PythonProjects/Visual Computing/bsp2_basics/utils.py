import numpy as np

import matplotlib.pyplot as plt
from mpl_toolkits.mplot3d import Axes3D

def rgb2gray(rgb:np.ndarray) -> np.ndarray:
    return np.dot(rgb[...,:3], [0.2989, 0.5870, 0.1140])

def gauss_filter(size:int, sigma:float) -> np.ndarray:
    x, y = np.mgrid[-size//2 + 1:size//2 + 1, -size//2 + 1:size//2 + 1]
    g = np.exp(-((x**2 + y**2)/(2.0*sigma**2)))
    return g/g.sum()

def plot_triangle(p1:np.ndarray,p2:np.ndarray,p3:np.ndarray,v1:np.ndarray,v2:np.ndarray,v3:np.ndarray, normal:np.ndarray):
    mean = np.mean(np.stack([p1,p2,p3]), axis=0)
    x, y, z = zip(p1,p2,p3)
    fig = plt.figure()
    ax = fig.add_subplot(projection='3d')
    
    plt.title('Triangle')
    def plot_vec(p, v, **kwargs):
        ax.quiver(p[0], p[1], p[2], v[0], v[1], v[2], arrow_length_ratio=0.1, **kwargs)

    plot_vec(p1, v1)
    plot_vec(p2, v2)
    plot_vec(p3, v3)

    normal = normal / np.linalg.norm(normal) * 5
    plot_vec(mean, normal, color='red')
    ax.plot_trisurf(x, y, z, triangles=((1,2,3)), alpha=0.2)
    ax.scatter(x,y,z)
    ax.text(p1[0], p1[1], p1[2], "P1", None)
    ax.text(p2[0], p2[1], p2[2], "P2", None)
    ax.text(p3[0], p3[1], p3[2], "P3", None)
