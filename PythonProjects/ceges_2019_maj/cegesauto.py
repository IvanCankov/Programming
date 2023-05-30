from typing import List


def main():  # 1. Feladat: adatok beolvasasa
    FILE_NAME: str = "autok.txt"
    cars = read_data(FILE_NAME)
    last_out(cars)
    traffic(cars)
    is_outside(cars)
    kilometres_travelled(cars)
    paper(cars)


def read_data(file_name: str) -> List[dict]:
    cars: List[dict] = []
    with open(file_name) as file:
        for line in file:
            line = line.strip().split(" ")
            car = {
                'day': int(line[0]),
                'time': line[1],
                'licenseplate': line[2],
                'id': int(line[3]),
                'km': int(line[4]),
                'out': True if line[5] == '0' else False
            }
            cars.append(car)
    return cars


def last_out(cars: List[dict]) -> None:
    for car in reversed(cars):
        if car['out']:
            print(f'2. Feladat\n{car["day"]}. nap rendszám: {car["licenseplate"]}')
            break


def traffic(cars: List[dict]) -> None:
    print("3. feladat")
    try:
        day: int = int(input("Nap: "))
        print(f'Forgalom a(z) {day}. napon:')
        for car in cars:
            if car['day'] == day:
                print(f'{car["time"]} {car["licenseplate"]} {car["id"]} {"ki" if car["out"] else "be"}')
    except ValueError:
        print("Helytelen ertek")


def is_outside(cars: List[dict]) -> None:
    outside: set = set()
    for car in cars:
        if car['out']:
            outside.add(car['licenseplate'])
        else:
            outside.remove(car['licenseplate'])

    print(f'4. feladat\nA hónap végén {len(outside)} autót nem hoztak vissza.')


def kilometres_travelled(cars: List[dict]) -> None:
    travelled: dict = {}
    longest: int = 0

    for index, car in enumerate(cars):
        if not car['out']:
            licenseplate: str = car['licenseplate']
            back: int = index - 1
            while cars[back]["licenseplate"] != licenseplate and index != 0:
                back -= 1
            travelled_km: int = car['km'] - cars[back]["km"]
            if travelled_km > longest:
                longest: int = travelled_km
                person: int = car['id']
            if travelled.get(licenseplate):
                travelled[licenseplate] += travelled_km
            else:
                travelled[licenseplate] = travelled_km
    for key, value in sorted(travelled.items()):
        print(f'{key} {value} km')

    print(f'6. feladat\nLeghosszabb út: {longest} km, személy: {person}')


def paper(cars: List[dict]) -> None:
    licenseplate: str = input("7. feladat\nRendszám: ")
    with open(licenseplate + '_menetlevel.txt', 'w') as file:
        for car in cars:
            if car["licenseplate"] == licenseplate and car["out"]:
                print(f'{car["id"]}\t{car["time"]}\t{car["km"]} km', file=file, end='')
            if car["licenseplate"] == licenseplate and car["out"]:
                print(f'{car["time"]}\t{car["km"]} km', file=file)

    print('Menetlevél kész.')


if __name__ == '__main__':
    main()
