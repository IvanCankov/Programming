

#1. feladat; adatok beolvasasa
atkelesek = []

with open('/home/ivan/Programming/PythonProjects/tarsalgo_2018_maj/ajto.txt', 'r', encoding = "UTF-8") as file:
    for line in file:
        line = line.strip().split(' ')
        atkeles = {
            'ora' : line[0],
            'perc' : line[1],
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

print(f'5. feladat\n{atkelesek[legtobben_index]["ora"]}:{atkelesek[legtobben_index]["perc"]}-kor voltak a legtöbben a társalgóban.')