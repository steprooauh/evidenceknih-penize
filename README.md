# Evidence knih

```
Evidence knih je v src/EvidenceKnih.form a zároveň s ní je i Kniha.java a soubor kniha.txt ve složce DobryDen/
```

Obsahuje to supr věci, jako procházení souborem s knihama nebo přidání své vlastní knihy.

# Peníze

```
Peníze je v src/Penize.form a zároveň penize.txt ve složce DobryDen/ a zároveň s src/Pracovnici.java
```

Obsahuje to bomba věci jako načtení prací ze souboru, jejich mzdu na hodinu a počet pracovníků vykonávájící tuto práci. Také je možné editovat soubor přímo v aplikaci Poznámkový blok, který se otevře přímo z aplikace, restartovat aplikaci pomocí jedneho tlačítka nebo vypnutí s loučící hláškou.

## Zadání k penězům:

Máte v textovém souboru informace o vypsaných úkolech:
textový popis úkolu
vypsanou odměnu (finanční částku, zvolte tak, aby se dalo částky bezpečně sčítat,...)
počet pracovníků (celé číslo)
Oddělovačem záznamů je středník (;)

Načtěte data ze souboru a vypište jednotlivé úkoly očíslované v pořadí, jak jsou v souboru - číselné hodnoty převeďte před výstupem na číslo.

Vstupní soubor například:
zamést před firmou;500.40;1
naprogramovat rezervační systém;200000;2
Výstup například:
1) zamést před firmou: 1 osob (500.40 Kč)
2) naprogramovat rezervační systém: 20 osob (200000 Kč)
