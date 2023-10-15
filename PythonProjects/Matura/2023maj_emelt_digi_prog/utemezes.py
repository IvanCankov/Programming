from solution import Solution
from helpers import sorszam


if __name__ == "__main__":
    INPUT_FILE: str = "taborok.txt"
    OUTPUT_FILE: str = "egytanulo.txt"
    sol = Solution(INPUT_FILE, OUTPUT_FILE)
    sol.first_last_amount()
    sol.exists_musical()
    sol.most_popular()
    sol.number_of_camps_being_held()
    sol.can_go()
    