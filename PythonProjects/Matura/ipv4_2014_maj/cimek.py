def main(): 

    #1. feladat adatok beolvasasa
    cimek = []

    with open('/home/ivan/Programming/PythonProjects/ipv4_2014_maj/ip.txt', 'r', encoding = 'UTF-8') as file:
        for cim in file:
            cim = cim.strip()
            cimek.append(cim)

    print(f'2. feladat:\nAz állományban {len(cimek)} darab adatsor van.')

    print(f'3. feladat:\nA legalacsonyabb tárolt IP-cím: {sorted(cimek)[0]}')

    dokumentacios = len([cim for cim in cimek if cim[:9] == '2001:0db8'])
    globalis = len([cim for cim in cimek if cim[:7] == '2001:0e'])
    helyi = len([cim for cim in cimek if cim[:2] == 'fc' or cim[:2] == 'fd'])
    print(f'4. feladat:\nDokumentációs cím: {dokumentacios} darab\nGlobális egyedi cím: {globalis} darab\nHelyi egyedi cím: {helyi} darab')

    #5. feladat kigyujtes
    with open('/home/ivan/Programming/PythonProjects/ipv4_2014_maj/sok.txt', 'w') as file:
        for cim in cimek:
            if cim.count('0') >= 18:
                print(cim, file = file)

    try:
        sorszam = int(input('6. feladat:\nKérek egy sorszámot: '))

        print(f'{cimek[sorszam]}')
        roviditett = cimek[sorszam].split(":")

        for index, substring in enumerate(roviditett):
            if substring[0] == '0':
                roviditett[index] = substring[1:]

        for index, substring in enumerate(roviditett):
            if substring == '000':
                roviditett[index] = '0'
            
        roviditett = ':'.join(roviditett)
        print(roviditett)

        for i in range(8):
            replace = '0:' * (8 - i)
            if replace in roviditett:
                rovidebb = roviditett.replace(replace, '::')
                break

        print(f'7. feladat:\n{rovidebb}')

    except ValueError:
        print("Helytelen ertek")

    




if __name__ == '__main__':
    main()