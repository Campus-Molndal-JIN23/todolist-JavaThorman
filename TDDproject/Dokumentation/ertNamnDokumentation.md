# Ditt namn
    Jonas Torjman
## Egna reflektioner
    Detta projektet var en utmaning. Man tänker nog inte på hur mycket som man glömmer under kort tid
    när man hela tiden sysslar med nya grejer. En reflektion som jag tänkt på är att man måste hålla 
    uppe programmeringen under lovet för att inte tappa allt för mycket. Kanske hitta på något eget
    projekt som man brinner för.
## Projektet
    Databas-baserad Todolist där man har tillgång till databasen enligt CRUD operationer.
### Beskrivning av projektet
    Projektet är skapat i Java.
    Jag har använt mig utav MongoDB och det valet tog jag mest för att jag inte hållt på så mycket med
    MongoDB utan de flesta uppgifter vi gjort så har jag hållt mig till SQLite för att det har kännts 
    säkrare för min del. 
    Projektet är gjort med Maven.
### Vad du har gjort
    Jadu, vad har jag inte gjort?
    Har nog gjort alla fel som man bara kan göra och hur jobbigt det än varit så har det gynnat mig
    för man lär sig aldrig så mycket som när ens kunskap hela tiden testas.
## Planering
    Min planering bestod utav ett text-dokument där jag skrev ned alla krav som projektet skulle utgå 
    ifrån. Det kändes viktigt att börja med då det var en del krav och jag tror att jag lyckats följa det
    till punkt och pricka. 
    Efter att jag skapat krav-specen så påbörjade jag med Github backlog. Jag visste vilka klasser som
    skulle behövas då vi skapat liknande project tidigare. 
    Jag visste att jag skulle behöva en Scanner class för att kunna återavnända en och samma scanner
    lite vart som. 
    Jag förstod också tidigt att jag behövde en Databas klass, en DBFacade klass, 
    Todo klassen(självklart) och även en Application klass (i mitt fall namngav jag den Program).
### Lösningsförslag innan uppgiften påbörjas
    - ![Backlog](Dokumenation/backlogtodo.png) (Backlog bild finns i Dokumenation foldern)


#### Hur du tänker försöka lösa uppgiften.(exempelvis)
    Jag har försökt lösa uppgiften genom att ha i åtanke att programmet skall följa OOP principer.
    Så det har ju gjort att man måste tänka till innan man gör metoder, eller liknande.
    Jag hade ett problem med databasen. I SQLite så har de ju en inbyggd autoincrement, där man kan få nya
    ID på varje dokument, medans i MongoDB så har de inte direkt det. Efter lite research så förstod jag
    att man kunde skapa ett sekvensdokument för att hålla koll på det senaste ID't vilket lät som en 
    jättebra ide, men det var svårare än jag trodde och fick det inte riktigt att fungera. Därav
    skapade jag en metod i databasen istället där vi kollar efter det högsta värdet på kolumnen "ID", och
    lade helt enkelt +1 på det för kommande todo.


## Arbetet och dess genomförande

### Vad som varit svårt
    Mycket har varit svårt. Det jag tycker är absolut svårast är att använda Mockito. Där har jag 
    fått bra med hjälp av Johan och ChatGPT.
### Beskriv lite olika lösningar du gjort
    Exempelvis när jag gjorde DBFacade testerna så var problemet att jag försökte Mocka med en anslutning
    till databasen, därav fick jag flera gånger röda tester. 

### Beskriv något som var besvärligt att få till
    Något som var extremt besvärligt var att felsöka i slutet. När alla klasser är skapta och det mesta
    har någon slags relation till varandra så blir minsta lilla ändring livsfarlig. Och det fick jag
    lära mig den hårda vägen :).
### Beskriv om du fått byta lösning och varför i sådana fall
    Hade jag kunnat ändra på något så hade det nog varit relationern mellan klasserna. Känner att 
    det hade kunnat göras mycket bättre och på ett mer förståeligt sätt. Dels för att kunna underhålla
    men även för felsökningens skull. Det gör det otroligt mycket enklare om allt är organiserat.
## Reflektion & Slutsatser
    I helhet tycker jag att det har ändå gått bra. Jag har ett program som gör det jag vill, som kan hantera
    felaktiga inmatningar och det lär nog vara jävligt svårt att krascha programmet.
    Jag tycker att jag har jobbat konscist sedan det att vi fick uppgiften och det har självklart gynnat mig.
    Jag har lärt mig av mina misstag att göra saker i sista sekund, och tänkte att det skulle vara skönt
    för mitt sinne att ha det färdigt när det faktiskt skall vara färdigt.
    

### Vad har du lärt dig
    Jag har lärt mig en del om testning, MongoDB och hur man använder sig utav det och nog det viktigaste
    av allt: Var inte blyg att fråga om hjälp. Alla i klassen finns för en om man behöver hjälp och det
    syns väldigt tydligt.

### Vad hade ni gjort annorlunda om ni gjort om projektet
    Hade tänkt mer på strukturen, försökt klura ut vilka klasser som faktiskt är beroende av varandra
    innan istället för att liksom "lösa det på vägen". Det hade nog underlättat enormt.
    Även tänka på vilka olika lösningar som finns, och inte bara köra på det man VET fungerar utan att man
    istället kanske vågar pröva sig fram.
### Vilka möjligheter ser du med de kunskaper du fått under kursen.
    Tycker att detta är superbra att kunna. Allt vi lärt oss känner jag kommer gynna mig någon gång i livet.
    Även om det kanske inte är användbart här och nu direkt (även om det är det) så är det skitbra
    att ha grunden för programmering och olika koncept för det kommer man långt med.