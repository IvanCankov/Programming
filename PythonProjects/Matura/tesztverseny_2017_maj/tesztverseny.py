def main():    
    print('1. feladat: Az adatok beolvasása\n')
    valaszok = []

    with open('/home/ivan/Programming/PythonProjects/tesztverseny_2017_maj/valaszok.txt') as file:
        for index, line in enumerate(file):
            if index != 0:
                line = line.strip().split(' ')
                valasz = {
                    'azonosito' : line[0],
                    'valaszok' : line[1]
                }
                valaszok.append(valasz)
            else:
                megoldasok = line.strip()

    print(f'2. feladat: A vetélkedőn {len(valaszok)} versenyző indult.\n')

    azonosito = input('3. feladat: A versenyző azonosítója = ')
    for valasz in valaszok:
        if valasz['azonosito'] == azonosito:
            versenyzo_valasza = valasz["valaszok"]
            print(f'{versenyzo_valasza}\t(a versenyző válasza)\n')
            break

    print(f'4. feladat:\n{megoldasok}\t(a helyes megoldás)')
    for index, valasz in enumerate(versenyzo_valasza):
        if valasz == megoldasok[index]:
            print('+', end = '')
        else:
            print(' ', end = '')
    print('\t(a versenyző helyes válaszai)\n')

    try:
        sorszam = int(input(('5. feladat: A feladat sorszáma = '))) - 1
        count = 0
        for valasz in valaszok:
            if valasz['valaszok'][sorszam] == megoldasok[sorszam]:
                count += 1
        print(f'A feladatra {count} fő, a versenyzők {100 * (count / len(valaszok)):.2f}%-a adott helyes\nválaszt.\n')

    except ValueError:
        print("Helytelen ertek")

    print('6. feladat: A versenyzők pontszámának meghatározása')
    helyes = {}
    for index, valasz in enumerate(valaszok):
        pass

if __name__ == "__main__":
    main()