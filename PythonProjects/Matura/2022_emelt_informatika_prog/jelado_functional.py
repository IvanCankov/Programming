from typing import List
import sys
import math


def read_raw_data(file_name: str) -> List[dict]:
    entries: List[dict] = []

    with open(file_name) as file:
        for line in file:
            line = line.strip().split(" ")
            entry: dict = {
                "hour": int(line[0]),
                "minute": int(line[1]),
                "second": int(line[2]),
                "x_coord": int(line[3]),
                "y_coord": int(line[4])
            }
            entries.append(entry)
    return entries


def coords_of_entry(entries: List[dict]) -> None:
    number: int = int(input("2. feladat\nAdja meg a jel sorszámát! ")) - 1
    print(f"x={entries[number]['x_coord']} y={entries[number]['y_coord']}")


def elapsed_between(hour: int, minute: int, second: int) -> int:
    return hour * 3600 + minute * 60 + second


def formatted_time(seconds: int) -> dict:
    return {"hours": seconds // 3600, "minutes": seconds % 3600 // 60, "seconds": seconds % 3600 % 60}


def total_time_elapsed(entries: List[dict]) -> None:
    seconds: int = elapsed_between(entries[-1]['hour'], entries[-1]['minute'], entries[-1]['second']) \
                   - elapsed_between(entries[0]['hour'], entries[0]['minute'], entries[0]['second'])
    time: dict = formatted_time(seconds)
    print(f"4. feladat\nIdőtartam: {time['hours']}:{time['minutes']}:{time['seconds']}")


def max_square(entries: List[dict]) -> None:
    min_x, min_y = sys.maxsize, sys.maxsize
    max_x, max_y = -sys.maxsize - 1, -sys.maxsize - 1

    for entry in entries:
        min_x, min_y = min(entry['x_coord'], min_x), min(entry['y_coord'], min_y)
        max_x, max_y = max(entry['x_coord'], max_x), max(entry['y_coord'], max_y)
    print(f"5. feladat\nBal alsó: {min_x} {min_y}, jobb felső: {max_x} {max_y}")


def sum_of_dist(entries: List[dict]) -> None:
    sum: int = 0

    for i in range(len(entries) - 1):
        sum += math.sqrt((entries[i]['x_coord'] - entries[i + 1]['x_coord']) ** 2 \
                         + (entries[i]['y_coord'] - entries[i + 1]['y_coord'])**2)
    print(f"6. feladat\nElmozdulás: {sum:.3f} egység")
    

# TODO: implement this method!
def missed_entries(output_file: str, entries: List[dict]) -> None:
    with open(output_file, 'w', encoding='UTF-8') as file:
        for i in range(1, len(entries)):
            elapsed: int = elapsed_between(entries[i]['hour'], entries[i]['minute'], entries[i]['second']) \
                   - elapsed_between(entries[i - 1]['hour'], entries[i - 1]['minute'], entries[i - 1]['second'])
            if elapsed > 5 * 60:
                pass    # TODO implement branching
            if abs(entries[i]['x_coord'] - entries[i - 1]['x_coord']) > 10:
                pass    # TODO implement branching



if __name__ == "__main__":
    # Global Variables
    FILE_NAME: str = "jel.txt"
    OUTPUT_FILE: str = "kimaradt.txt"
    ENTRIES: List[dict] = read_raw_data(FILE_NAME)
    coords_of_entry(ENTRIES)
    total_time_elapsed(ENTRIES)
    max_square(ENTRIES)
    sum_of_dist(ENTRIES)
    missed_entries(OUTPUT_FILE, ENTRIES)
