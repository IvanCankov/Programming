import os, argparse
from pathlib import Path
from PIL import Image

import numpy as np

from ModelHandler import Model

# argument parser
parser = argparse.ArgumentParser()
parser.add_argument('--model', default='data/star.ply', help='path to the .ply file')
parser.add_argument('--rasterization_mode', default='line', help='line or fill rasterization')
parser.add_argument('--save_dir', default='data/', help='save directory')

args = parser.parse_args()

# check if out dir exists
if not os.path.exists(args.save_dir):
    print(f'Target directory {args.save_dir} not found!')
    exit()

# get rasterization mode
rasterization_mode = args.rasterization_mode if args.rasterization_mode in ['line', 'fill'] else 'line'

# load model
model = Model(args.model)

# rasterize model
model.rasterize(rasterization_mode = rasterization_mode)

# save image
image = np.uint8(model.image*255)
Image.fromarray(image).save(os.path.join(args.save_dir, f'{Path(args.model).stem}.png'))
