epuletek: list[list] = []

with open("utca.txt") as file:
    for i, line in enumerate(file):
        if i != 0:
            line = line.strip().split(' ')
            epuletek.append(line)

print(f"2. feladat. A mintában {len(epuletek)} telek szerepel.")