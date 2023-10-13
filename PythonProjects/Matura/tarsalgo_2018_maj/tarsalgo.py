def main():
    #1. feladat; adatok beolvasasa
    atkelesek = []

    with open('/home/ivan/Programming/PythonProjects/tarsalgo_2018_maj/ajto.txt', 'r', encoding = "UTF-8") as file:
        for line in file:
            line = line.strip().split(' ')
            atkeles = {
                'ora' : int(line[0]),
                'perc' : int(line[1]),
                'azonosito' : int(line[2]),
                'be' : True if line[3] == 'be' else False
            }

            atkelesek.append(atkeles)

    for atkeles in reversed(atkelesek):
        if not atkeles['be']:
            utolso_kilepo = atkeles['azonosito']
            break
        
    print(f'2. feladat\nAz első belépő: {atkelesek[0]["azonosito"]}\nAz utolsó kilépő: {utolso_kilepo}')

    #3. feladat; athaladasok meghatarozasa
    athaladasok = {}
    with open('/home/ivan/Programming/PythonProjects/tarsalgo_2018_maj/athaladas.txt', 'w') as file:
        for atkeles in atkelesek:
            azonosito = atkeles['azonosito']
            if athaladasok.get(azonosito):
                athaladasok[azonosito] += 1
            else:
                athaladasok[azonosito] = 1

        for key, azonosito in sorted(athaladasok.items()):
            print(key, azonosito, file = file)

    legtobben = 0
    bent_maradtak = set()
    for index, atkeles in enumerate(atkelesek):
        if atkeles['be']:
            bent_maradtak.add(int(atkeles['azonosito']))
        else:
            bent_maradtak.remove(int(atkeles['azonosito']))
        if len(bent_maradtak) > legtobben:
            legtobben = len(bent_maradtak)
            legtobben_index = index

    print(f'4. feladat\nA végén a társalgóban voltak: ', end ='')
    for azonosito in bent_maradtak:
        print(azonosito, end = ' ')

    print(f'\n5. feladat\n{atkelesek[legtobben_index]["ora"]}:{atkelesek[legtobben_index]["perc"]}-kor voltak a legtöbben a társalgóban.')

    try:
        azonosito = int(input('6. feladat\nAdja meg a személy azonosítóját! '))

        print('7. feladat')
        osszesen_bent_toltott_perc = 0
        for atkeles in atkelesek:
            if atkeles['azonosito'] == azonosito and atkeles['be']:
                print(f'{atkeles["ora"]}:{atkeles["perc"]}', end = ' - ')
                kezdo_perc = (atkeles["ora"] * 60) + atkeles["perc"]

            elif atkeles['azonosito'] == azonosito and not atkeles['be']:
                print(f'{atkeles["ora"]}:{atkeles["perc"]}')
                vegzo_perc = (atkeles["ora"] * 60) + atkeles["perc"]
                osszesen_bent_toltott_perc += vegzo_perc - kezdo_perc
            
        if azonosito in bent_maradtak:
            osszesen_bent_toltott_perc += 900 - kezdo_perc

        print(f'\n8. feladat\nA(z) {azonosito}. személy összesen {osszesen_bent_toltott_perc} percet volt bent, a megfigyelés\nvégén a társalgóban volt.')
    except ValueError:
        print("Helytelen ertek")

    
if __name__ == '__main__':
    main()