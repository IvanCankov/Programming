from typing import List
import math
import sys


class Entry:
    def __init__(self, hour: str, minute: str, second: str, x_coord: str, y_coord: str):
        self.hour: int = int(hour)
        self.minute: int = int(minute)
        self.second: int = int(second)
        self.x_coord: int = int(x_coord)
        self.y_coord: int = int(y_coord)

    def get_hour(self):
        return self.hour

    def get_minute(self):
        return self.minute

    def get_second(self):
        return self.second

    def get_x(self):
        return self.x_coord

    def get_y(self):
        return self.y_coord


class Solution:
    def __init__(self, input_file: str, output_file: str):
        entries: List[Entry] = []
        with open(input_file) as file:
            for line in file:
                line = line.strip().split(" ")
                entries.append(Entry(line[0], line[1], line[2], line[3], line[4]))
        self.entries = entries
        self.output_file = output_file


    def elapsed_between(self, hour: int, minute: int, second: int) -> int:
        return hour * 3600 + minute * 60 + second


    def formatted_time(self, seconds: int) -> dict[int]:
        return {"hours": seconds // 3600, "minutes": seconds % 3600 // 60, "seconds": seconds % 3600 % 60}


    def coords_of_entry(self) -> None:
        number: int = int(input("2. feladat\nAdja meg a jel sorszámát! ")) - 1
        print(f"x={self.entries[number].get_x()} y={self.entries[number].get_y()}")


    def total_time_elapsed(self) -> None:
        seconds: int = self.elapsed_between(self.entries[-1].get_hour(), self.entries[-1].get_minute(), self.entries[-1].get_second()) \
                    - self.elapsed_between(self.entries[0].get_hour(), self.entries[0].get_minute(), self.entries[0].get_second())
        time: dict = self.formatted_time(seconds)
        print(f"4. feladat\nIdőtartam: {time['hours']}:{time['minutes']}:{time['seconds']}")


    def max_square(self) -> None:
        min_x, min_y = sys.maxsize, sys.maxsize                 # type: int, int
        max_x, max_y = -sys.maxsize - 1, -sys.maxsize - 1       # type: int, int

        for entry in self.entries:
            min_x, min_y = min(entry.get_x(), min_x), min(entry.get_y(), min_y)
            max_x, max_y = max(entry.get_x(), max_x), max(entry.get_y(), max_y)
        print(f"5. feladat\nBal alsó: {min_x} {min_y}, jobb felső: {max_x} {max_y}")
    

    def sum_of_dist(self) -> None:
        total_distance: float = 0.0

        for i in range(len(self.entries) - 1):
            distance: float = math.sqrt((self.entries[i].get_x() - self.entries[i + 1].get_x()) ** 2 \
                            + (self.entries[i].get_y() - self.entries[i + 1].get_y())**2)
            total_distance += distance
        print(f"6. feladat\nElmozdulás: {total_distance:.3f} egység")


    # TODO: implement this method!
    def missed_entries(self) -> None:
        with open(self.output_file, 'w', encoding='UTF-8') as file:
            for i in range(1, len(self.entries)):
                elapsed: int = self.elapsed_between(self.entries[i].get_hour(), self.entries[i].get_minute(), self.entries[i].get_second()) \
                    - self.elapsed_between(self.entries[i - 1].get_hour(), self.entries[i - 1].get_minute(), self.entries[i - 1].get_second())
                if elapsed > 5 * 60:
                    pass  # TODO implement branching
                if abs(self.entries[i].get_x() - self.entries[i - 1].get_x()) > 10:
                    pass  # TODO implement branching


if __name__ == "__main__":

    #Global Variables
    INPUT_FILE: str = "jel.txt"
    OUTPUT_FILE: str = "kimaradt.txt"
    sol = Solution(INPUT_FILE, OUTPUT_FILE)
    
    sol.coords_of_entry()
    sol.total_time_elapsed()
    sol.max_square()
    sol.sum_of_dist()
    sol.missed_entries()
    