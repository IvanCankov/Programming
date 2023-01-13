#1. feladat adatok beolvasasa
utasok = []

with open('/home/ivan/Programming/PythonProjects/eutazas_2019_okt/utasadat.txt', 'r', encoding = 'UTF-8') as file:
    for line in file:
        line = line.strip().split()
        utas = {
            'allomas' : int(line[0]),
            'datum' : int(line[1][:8]),
            'ido' : line[1][9:],
            'azonosito' : int(line[2]),
            'tipus' : line[3],
            'ervenyes' : int(line[4])
        }
        utasok.append(utas)

print(f'2. feladat\nA buszra {len(utasok)} utas akart felszállni.')

nem_szallhattak_fel = 0
egy_allomas = 0
legtobben = 0
megallo = 0
ingyenesen_utazok = 0
kedvezmenyesen_utazok = 0

for index, utas in enumerate(utasok):
    if utas['ervenyes'] > 0 and utas['tipus'] == 'JGY' or utas['datum'] < utas['ervenyes'] and utas['tipus'] != 'JGY':
        nem_szallhattak_fel += 1
        if utas['tipus'] == 'RVS' or utas['tipus'] == 'GYK' or utas['tipus'] == 'NYP':
            ingyenesen_utazok += 1
        if utas['tipus'] == 'TAB' or utas['tipus'] == 'NYB':
            kedvezmenyesen_utazok += 1

    if utas['allomas'] == utasok[index - 1]['allomas']:
        egy_allomas += 1
    else:
        egy_allomas += 1
        if egy_allomas > legtobben:
            legtobben = egy_allomas
            megallo = utasok[index - 1]['allomas']
        egy_allomas = 0

print(f'3. feladat\nA buszra {nem_szallhattak_fel} utas nem szállhatott fel.')
print(f'4. feladat\nA legtöbb utas ({legtobben} fő) a {megallo}. megállóban próbált felszállni.')
print(f'5. feladat\nIngyenesen utazók száma: {ingyenesen_utazok} fő\nA kedvezményesen utazók száma: {kedvezmenyesen_utazok} fő')

def naposzama(e1, h1, n1, e2, h2, n2):
    h1 = (h1 + 9) % 12
    e1 = e1 - h1 // 10
    d1 = 365 * e1 + e1 // 4 - e1 // 100 + e1 // 400 + (h1 * 306 + 5) // 10 + n1 - 1
    h2 = (h2 + 9) % 12
    e2 = e2 - h2 // 10
    d2 = 365 * e2 + e2 // 4 - e2 // 100 + e2 // 400 + (h2 * 306 + 5) // 10 + n2 - 1
    napokszama = d2 - d1
    return napokszama

with open('/home/ivan/Programming/PythonProjects/eutazas_2019_okt/figyelmeztetes.txt', 'w', encoding = 'UTF-8') as file:
    for utas in utasok:
        if utas['ervenyes'] - utas['datum'] == 3:
            print(f'{utas["azonosito"]} {utas["ervenyes"]}-{utas["ervenyes"]}-{utas["ervenyes"]}', file = file)
