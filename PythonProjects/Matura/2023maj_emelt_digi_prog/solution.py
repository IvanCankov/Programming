from typing import List
from camp import Camp


class Solution:
    def __init__(self, input_file: str, output_file: str) -> None:
        self.output_file = output_file
        self.camps: List[Camp] = []
        self.musical: List[Camp] = []
        with open(input_file) as file:
            for line in file:
                line = line.strip().split("\t")
                camp = Camp(line[0], line[1], line[2], line[3], line[4], line[5])
                self.camps.append(camp)
                if camp.is_musical():
                    self.musical.append(camp)


    def first_last_amount(self) -> None:
        print(f"2. feladat")
        print(f"Az adatsorok száma: {len(self.camps)}")
        print(f"Az először rögzített tábor témája: {self.camps[0].type}")
        print(f"Az utoljára rögzített tábor témája: {self.camps[-1].type}")


    def exists_musical(self) -> None:
        if not self.musical:
            print("Nemvolt zenei tábor.")
        else:
            for camp in self.musical:
                print(f"Zenei tábor kezdődik {camp.start_month}. hó {camp.start_day}. napján.")

            
    def most_popular(self) -> None:
        top_camp: List[Camp] = []
        for camp in self.camps:
            if not top_camp or camp.count_students() > top_camp[0].count_students():
                top_camp.clear()
                top_camp.append(camp)
        for camp in top_camp:        
            print(f"{camp.start_month} {camp.start_day} {camp.type}")


    def number_of_camps_being_held(self) -> None:
        print(f"6. feladat")
        month: int = int(input("hó: "))
        day: int = int(input("nap: "))
        print(f"Ekkor éppen {len([camp for camp in self.camps if camp.being_held(month, day)])} tábor tart.")


    def can_go(self) -> None:
        self.camps.sort()
        student: str = input("7. feladat\nAdja meg egy tanuló betűjelét: ")
        student_camps: List[Camp] = []
        can_go_to_all: bool = True

        for camp in self.camps:
            if not student_camps and camp.is_interested(student):
                student_camps.append(camp)
            elif camp.is_interested(student):
                can_go_to_all = can_go_to_all and not student_camps[-1].being_held(camp.start_month, camp.start_day)
                student_camps.append(camp)
                
        with open(self.output_file, "w") as file:
            for camp in student_camps:
                print(camp, file=file)
        print("Nem mehet el mindegyik táborba.") if not can_go_to_all else print("Mindegyik táborba elmehet")
