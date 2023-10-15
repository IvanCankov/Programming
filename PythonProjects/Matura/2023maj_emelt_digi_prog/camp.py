from helpers import sorszam

class Camp:
    def __init__(self, start_month: str, start_day: str, end_month: str, end_day: str, student: str, type: str):
        self.start_month: int = int(start_month)
        self.start_day: int = int(start_day)
        self.end_month: int = int(end_month)
        self.end_day: int = int(end_day)
        self.student: str = student
        self.type: str = type

    def __str__(self) -> str:
        return f"{self.start_month}. {self.start_day}.-{self.end_month}. {self.end_day}. {self.type}"

    def __lt__(self, other) -> bool:
        return self.start_month < other.start_month and self.start_day< other.start_day

    def count_students(self) -> int:
        return len(self.student)

    def is_musical(self) -> bool:
        return self.type.__eq__("zenei")

    def being_held(self, month: int, day: int) -> bool:
        return sorszam(month, day) > sorszam(self.start_month, self.start_day) and \
                sorszam(month, day) < sorszam(self.end_month, self.end_day)

    def is_interested(self, student: str) -> bool:
        return self.student.find(student.upper()) != -1
