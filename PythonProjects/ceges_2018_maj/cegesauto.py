

#1. Feladat: adatok beolvasasa
autok = []

with open('/home/ivan/Programming/PythonProjects/ceges_2018_maj/autok.txt') as file:
    for line in file:
        line = line.strip().split(" ")
        auto = {
            'nap' : int(line[0]),
            'oraperc' : line[1],
            'rendszam' : line[2],
            'azonosito' : int(line[3]),
            'km' : int(line[4]),
            'ki' : True if line[5] == '0' else False
        }
        autok.append(auto)


for auto in reversed(autok):
    if auto['ki']:
        print(f'2. Feladat\n{auto["nap"]}. nap rendszám: {auto["rendszam"]}')
        break


print("3. feladat")
try:
    nap = int(input("Nap: "))
except ValueError:
    print("Helytelen ertek")
    
print(f'Forgalom a(z) {nap}. napon:')

for auto in autok:
    if auto['nap'] == nap:
        print(f'{auto["oraperc"]} {auto["rendszam"]} {auto["azonosito"]} {"ki" if auto["ki"] else "be"}')


kint_van = set()
for auto in autok:
    if auto['ki']:
        kint_van.add(auto['rendszam'])
    else:
        kint_van.remove(auto['rendszam'])

print(f'4. feladat\nA hónap végén {len(kint_van)} autót nem hoztak vissza.')

megtett = {}
leghosszabb = 0

for index, auto in enumerate(autok):
    if not auto['ki']:
        rendszam = auto['rendszam']
        vissza = index - 1

        while autok[vissza]["rendszam"] != rendszam and index != 0:
            vissza -= 1

        megtett_km = auto['km'] - autok[vissza]["km"]
        if megtett_km > leghosszabb:
            leghosszabb = megtett_km
            szemely = auto['azonosito']

        if megtett.get(rendszam):
            megtett[rendszam] += megtett_km
        else:
            megtett[rendszam] = megtett_km


for key, value in sorted(megtett.items()):
    print(f'{key} {value} km')

print(f'6. feladat\nLeghosszabb út: {leghosszabb} km, személy: {szemely}')