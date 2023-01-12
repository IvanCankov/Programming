#1. feladat adatok beolvasasa
godrok = []

with open('/home/ivan/Programming/PythonProjects/godrok_2021_majus/melyseg.txt', 'r', encoding = 'UTF-8') as file:
    for line in file:
        godrok.append(int(line.strip()))

print(f'1. feladat\nA fájl adatainak száma: {len(godrok)}\n')

try:
    tavolsag = int(input('2. feladat\nAdjon meg egy távolságértéket! ')) - 1
    print(f'Ezen a helyen a felszín {godrok[tavolsag]} méter mélyen van.\n')
except ValueError:
    print('helytelen ertek')

print(f'3. feladat\nAz érintetlen terület aránya {(len([godor for godor in godrok if godor == 0]) / len(godrok)) * 100:.2f}%.\n')

#4. feladat godrok fajbairasa
godor_szam = 0
with open('/home/ivan/Programming/PythonProjects/godrok_2021_majus/godrok.txt', 'w') as file:
    for index, godor in enumerate(godrok):
        if godor != 0:
            print(godor, end = ' ', file = file)  
        elif godor == 0 and godrok[index - 1] != 0:
            print(file = file)
            godor_szam += 1

print(f'5. feladat\nA gödrök száma: {godor_szam}\n')

if godrok[tavolsag] != 0:
    folyamatosan_melyul = True
    max_melyseg = 0
    terfogat = 0
    viz_terfogat = 0
    while godrok[tavolsag] != 0:
        tavolsag -= 1
    kezdet = tavolsag + 2
    tavolsag += 1
    while godrok[tavolsag] != 0:
        if godrok[tavolsag] > godrok[tavolsag - 1]:
            folyamatosan_melyul = False
        max_melyseg = max(max_melyseg, godrok[tavolsag])
        terfogat += godrok[tavolsag] * 10
        viz_terfogat += (godrok[tavolsag] - 1) * 10
        tavolsag += 1

    print(f'6. feladat\na)\nA gödör kezdete: {kezdet} méter, a gödör vége: {tavolsag} méter.\nb)')
    print('Folyamatosan mélyül.') if folyamatosan_melyul else print('Nem mélyül folyamatosan .')
    print(f'c)\nA legnagyobb mélysége {max_melyseg} méter.')
    print(f'd)\nA térfogata {terfogat} m^3.\ne)\nA vízmennyiség {viz_terfogat} m^3.')
else:
    print('Az adott helyen nincs gödör.\n')