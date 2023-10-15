from typing import List


class Property:
    def __init__(self, ssnr: str, street_name: str, number: str, category: str, area: int):
        self.ssnr: int = int(ssnr)
        self.street_name: str = street_name
        self.number: str = number
        self.category: str = category
        self.area: int = int(area)


    def get_ssnr(self) -> int: return self.ssnr


    def get_street_name(self) -> str: return self.street_name


    def get_number(self) -> str: return self.number


    def get_category(self) -> str: return self.category


    def get_area(self) -> int: return self.area


class Solution:
    def __init__(self, input_file: str, output_file: str):
        self.categories: dict[int] = {}
        self.properties: List[Property] = []
        self.output_file = output_file

        with open(input_file) as file:
            for index, line in enumerate(file):
                line = line.strip().split(" ")
                if index > 0:
                    self.properties.append(Property(line[0], line[1], line[2], line[3], line[4]))
                else:
                    self.categories = {"A": line[0], "B": line[1], "C": line[2]}


    def count_of_properties(self) -> None:
        print(f"2. feladat. A mintában {len(self.properties)} telek szerepel.")


    def properties_belonging_to(self) -> None:
        ssnr: int = int(input("3. feladat. Egy tulajdonos adószáma: "))
        properties: set = set()
        for property in self.properties:
            if property.get_ssnr() == ssnr:
                print(f"{property.get_street_name()} utca {property.get_number()}")


    def tax(self, category: str, area: int) -> int:
        tax: int = int(self.categories.get(category)) * area
        return tax if tax >= 10000 else 0


    def total_tax_and_number(self) -> None:
        taxes: dict[dict[int]] = {"A": {"buildings": 0, "tax": 0}, "B": {"buildings": 0, "tax": 0}, "C": {"buildings": 0, "tax": 0}}
        for property in self.properties:
            taxes[property.get_category()]["buildings"] += 1
            taxes[property.get_category()]["tax"] += self.tax(property.get_category(), property.get_area())
        for key, value in taxes.items():
            print(f"{key} sávba {value['buildings']} telek esik, az adó {value['tax']} Ft.")


    def owed_by_individuals(self) -> None:
        individuals: dict = {}
        for property in self.properties:
            if not individuals.get(property.get_ssnr()):
                individuals[property.get_ssnr()] = self.tax(property.get_category(), property.get_area())
            else:
                individuals[property.get_ssnr()] += self.tax(property.get_category(), property.get_area())

        with open(self.output_file, "w", encoding="UTF-8") as file:        
            for individual, owed in sorted(individuals.items(), key=lambda x: x[0]):        # NOTE: change between 0 and 1 to sort according to
                print(f"{individual} {owed}", file=file)                                    # ssnr or amount owed


    def belongs_to_multiple(self):
        streets: set(str) = set()
        for i in range(1, len(self.properties)):
            if  self.properties[i].get_street_name() == self.properties[i - 1].get_street_name() and \
                not self.properties[i].get_category() == self.properties[i - 1].get_category():
                streets.add(self.properties[i].get_street_name())
        for street in sorted(streets):
            print(street)


if __name__ == "__main__":
    INPUT_FILE: str = "utca.txt"
    OUTPUT_FILE: str = "fizetendo.txt"
    sol = Solution(INPUT_FILE, OUTPUT_FILE)
    sol.count_of_properties()
    sol.properties_belonging_to()
    sol.total_tax_and_number()
    sol.owed_by_individuals()
    sol.belongs_to_multiple()
