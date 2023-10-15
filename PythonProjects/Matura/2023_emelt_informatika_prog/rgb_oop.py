from typing import List


class Pixel:
    def __init__(self, red: str, green: str, blue: str):
        self.red: int = int(red)
        self.green: int = int(green)
        self.blue: int = int(blue)


    def get_red(self):
        return self.red


    def get_green(self):
        return self.green


    def get_blue(self):
        return self.blue


class Picture:
    def __init__(self, input_file: str, output_file: str) -> None:
        self.picture: List[List[Pixel]] = []
        self.count_bright: int = 0
        self.darkest_pixel: List[Pixel] = []
        self.darkest_sum: int = 3 * 255

        with open(input_file) as file:
            lines = file.readlines()

        for line in lines:
            pixels: List[Pixel] = []
            line = line.strip().split()

            for i in range(0, len(line), 3):
                r, g, b = map(int, line[i:i+3])
                if self.is_bright(r, g, b):                         # counts all the bright pixels (pixel > 600)
                    self.count_bright += 1
                if self.sum_equals(self.darkest_sum, r, g, b):      # collects all the pixels equal to the darkest point
                    self.darkest_pixel.append(Pixel(r, g, b))
                if self.is_darker(self.darkest_sum, r, g, b):       # checks for a darker pixel than the current darkest
                    self.darkest_pixel.clear()
                    self.darkest_pixel.append(Pixel(r, g, b))
                    self.darkest_sum = r + g + b
                pixels.append(Pixel(r, g, b))
            self.picture.append(pixels)


    def is_bright(self, r: int, g: int, b: int) -> bool:
        return r + g + b > 600


    def get_pixel(self, x:int, y:int) -> Pixel:     # numbering starts at one
        return self.picture[x - 1][y - 1]


    def get_darkest_sum(self) -> None:
        print(f"4. feladat:\nA legsötétebb pont RGB összege: {self.darkest_sum}")


    def get_darkest_pixel(self) -> None:
        print("A legsötétebb pixelek színe: ")
        for pixel in self.darkest_pixel:
            print(f"RGB{pixel.get_red(), pixel.get_green(), pixel.get_blue()}")


    def is_darker(self, target: int, r: int, g: int, b: int) -> bool:
        return r + g + b < target


    def sum_equals(self, target: int, r: int, g: int, b: int) -> bool:
        return target == r + g + b


    def colors_at(self) -> None:
        x = int(input("2. feladat:\nKérem egy képpont adatait!\nSor: "))
        y = int(input("Oszlop:"))
        pixel = self.get_pixel(x, y)
        print(f"A képpont színe RGB{pixel.get_red(), pixel.get_green(), pixel.get_blue()}")


    def get_count_of_bright(self) -> None:
        print(f"3. feladat:\nA világos képpontok száma: {self.count_bright}")

    # NOTE: the functions below aren't accurate -> refer to exercises 5 and 6
    def border(self, row: int, blue1: int, blue2: int) -> bool:
        return abs(blue1 - blue2) >= 10


    def object_start_and_end(self):
        start, end = -1, -1         #int, int
        for i in range(len(self.picture)):
            for j in range(1, i):
                if self.border(i, self.picture[i][j].get_blue(), self.picture[i][j - 1].get_blue()):
                    end = i
                if self.border(i, self.picture[i][j].get_blue(), self.picture[i][j - 1].get_blue()) and start == -1:
                    start = i
        print(f"6. feladat:\nA felhő legfelső sora: {start}\nA felhő legalsó sora: {end}")


if __name__ == "__main__":
    INPUT_FILE: str = "kep.txt"
    OUTPUT_FILE: str = ""
    pic = Picture(INPUT_FILE, OUTPUT_FILE)
    pic.colors_at()
    pic.get_count_of_bright()
    pic.get_darkest_sum()
    pic.get_darkest_pixel()
    pic.object_start_and_end()
