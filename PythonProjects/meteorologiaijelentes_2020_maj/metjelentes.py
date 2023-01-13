#1. feladat adatok beolvasasa

jelentesek = []
nem_volt_szelcsned = set()
with open('/home/ivan/Programming/PythonProjects/meteorologiaijelentes_2020_maj/tavirathu13.txt', 'r', encoding = 'UTF-8') as file:
    for line in file:
        line = line.strip().split()
        jelentes = {
            'varos' : line[0],
            'ora' : line[1][:2],
            'perc' : line[1][2:],
            'irany' : line[2][:3],
            'erosseg' : line[2][3:],
            'homerseklet' : int(line[3])
        }
        nem_volt_szelcsned.add(line[0])
        jelentesek.append(jelentes)

varoskod = input(f'2. feladat\nAdja meg egy település kódját! Település: ')
for jelentes in reversed(jelentesek):
    if jelentes['varos'] == varoskod:
        print(f'Az utolsó mérési adat a megadott településről {jelentes["ora"]}:{jelentes["perc"]}-kor érkezett.')
        break 

legalacsonyabb_index = 0
legmagasabb_index = 0

for index, jelentes in enumerate(jelentesek):
    if jelentes['homerseklet'] < jelentesek[legalacsonyabb_index]['homerseklet']:
        legalacsonyabb_index = index
    if jelentes['homerseklet'] > jelentesek[legmagasabb_index]['homerseklet']:
        legmagasabb_index = index

print(f'3. feladat\nA legalacsonyabb hőmérséklet: {jelentesek[legalacsonyabb_index]["varos"]} {jelentesek[legalacsonyabb_index]["ora"]}:{jelentesek[legalacsonyabb_index]["perc"]} {jelentesek[legalacsonyabb_index]["homerseklet"]} fok.\nA legmagasabb hőmérséklet: {jelentesek[legmagasabb_index]["varos"]} {jelentesek[legmagasabb_index]["ora"]}:{jelentesek[legmagasabb_index]["perc"]} {jelentesek[legmagasabb_index]["homerseklet"]} fok.\n4. feladat')
for index, jelentes in enumerate(jelentesek):
    if jelentes['irany'] == '000' and jelentes['erosseg'] == '00':
        print(f'{jelentes["varos"]} {jelentes["ora"]}:{jelentes["perc"]}')
        nem_volt_szelcsned.remove(jelentes['varos'])

