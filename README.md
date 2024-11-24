# HypotheekInzicht

Dit project is een Java-gebaseerde applicatie voor het beheren en berekenen van verschillende soorten hypotheken. Het biedt gebruikers de mogelijkheid om verschillende hypotheektypen te modelleren, waaronder lineaire, annuïteit- en spaarhypotheken. 

## Functionaliteiten

- Hypotheek inzicht: creëer een hypotheek en toont per jaar een overzicht van de restschuld/rente/aflossing.
- Lineaire-,Spaar- en Annuiteiten hypotheek: 3 type hypotheken met verschillende wijze van afbetaling.
- Uitzonderingen onderscheppen: er voor zorgen dat er geen negatieven getallen ingevult kunnen worden.

## Bestandsoverzicht

De applicatie bevat de volgende klassen:

1. `HypotheekInzicht.java`  
   De hoofdklasse van de applicatie die het programma uitvoert.

2. `Product.java`
   Beheert de funtionaliteiten om de gegevens op te roepen van de verschillende hypotheken.

3. `Hypotheek.java` 
   Beheert de basis gegevens van de hypotheek, zoals hypotheek som, rente en looptijd.

4. `LineaireHypotheek.java`
   creërt een lineaire hypotheek, kenmerk hiervan is dat de aflossing gelijk blijft.

5. `SpaarHypotheek.java` 
   creërt een Spaar hypotheek, kenmerk hiervan is dat er gespaard wordt gedurende de looptijd en de aflossing in één keer aan het einde.

6. `AnnuiteitenHypotheek.java`
    creërt een annuiteiten hypotheek, kenmerk van deze hypotheek is dat de maandlasten constant blijven gedurende de looptijd.

7. `NegativeValueException.java`
    Een class die uitzondering onderschept, namelijk het invullen van negatieve getallen bij het aanmaken van een hypotheek.

## Structuur

De projectbestanden bevinden zich in de map `src/HypotheekInzicht`. De klassen zijn georganiseerd om een duidelijke scheiding tussen verantwoordelijkheden te behouden.

## Vereisten

- Java SE 8 of hoger
- Een IDE zoals IntelliJ IDEA of Visual Studio Code wordt aanbevolen.

## Toekomstige uitbreidingen

- Nog niet alle gegevens staan in rechte rijtjes als het programma wordt uitgevoerd.
- Het hypotheek nummer automatisch laten genereren.

## Auteur

Dit project is gemaakt door GCleophas.

---

### Feedback of bijdragen?

Als je suggesties hebt of wilt bijdragen, stuur dan een pull request of neem contact op via mijn GitHub-profiel.
