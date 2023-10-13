from typing import List
from car import Car


class Solution:
    def __init__(self, input_file: str, output_file: str):
        self.cars: List[Car] = []
        with open(input_file) as file:
            for line in file:
                line = line.strip().split(" ")
                car = Car(line[0], line[1], line[2], line[3], line[4], line[5])
                self.cars.append(car)


    def last_out(self) -> None:
        for car in reversed(self.cars):
            if car.out:
                print(f'2. Feladat\n{car.day}. nap rendszám: {car.licenseplate}')
                break


    def traffic(self) -> None:
        print("3. feladat")
        day: int = int(input("Nap: "))
        print(f'Forgalom a(z) {day}. napon:')
        for car in self.cars:
            if car.day == day:
                print(f'{car.time} {car.licenseplate} {car.cid} {car.strout()}')



sol = Solution("autok.txt", "autok.txt")
sol.traffic()