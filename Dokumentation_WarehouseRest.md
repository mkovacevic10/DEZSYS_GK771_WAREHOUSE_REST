****Maksym Kovacevic 4DHIT****

## **Dokumentation Warehouse REST**

##### Grundlagen

1. Klassen mit Code in IntelliJ pullen aus Repository.

2. Die Klassen in die richtige Packages einordnen und die notwendigen imports hinzufügen
   
   ![](C:\Users\makko\AppData\Roaming\marktext\images\2025-09-23-14-43-05-image.png)
   
   ![](C:\Users\makko\AppData\Roaming\marktext\images\2025-09-23-14-44-12-image.png)
   
   ![](C:\Users\makko\AppData\Roaming\marktext\images\2025-09-23-14-44-55-image.png)
   
   ![](C:\Users\makko\AppData\Roaming\marktext\images\2025-09-23-14-46-37-image.png)

3. ProductData Klasse erstellen mit notwendigen Attributen, Setter und Getter Methoden und to String Methode. Anschließend die Klassen, die ProductData nutzen, den import hinzufügen.
   
   ![](C:\Users\makko\AppData\Roaming\marktext\images\2025-09-23-14-48-21-image.png)

4. Das gleiche in Warehouse Data, ein List Attribut erstellen und setter und getter Methoden dazu geben. ![](C:\Users\makko\AppData\Roaming\marktext\images\2025-09-23-15-28-21-image.png)

5. In der `getData`-Methode wird ein neues `WarehouseData`-Objekt erstellt und alle Produktdaten (Name, Adresse etc.) gesetzt. Es werden Arrays für Obst, Saft sowie Einheiten (kg, l) angelegt, ein zufälliger Produktcount (1–4) generiert und Produkte mit zufälligen Eigenschaften (Name, Kategorie, Einheit, Menge, ID) erstellt und in einem Array gespeichert. Anschließend werden alle Produkte in eine `ArrayList` übertragen, im `WarehouseData`-Objekt gesetzt und zurückgegeben.
   
   ![](C:\Users\makko\AppData\Roaming\marktext\images\2025-09-30-14-49-38-Screenshot%202025-09-30%20144837.png)
   
   ![](C:\Users\makko\AppData\Roaming\marktext\images\2025-09-30-14-49-56-Screenshot%202025-09-30%20144900.png)

6. Als letztes einfach nicht nur als json Format anzeigen lassen, sondern auch als XML. Dazu hab ich einfach das HTML-Link-Element vom json(was schon vorgegeben war) kopiert, nochmal hinzugefügt und es von json auf xml geändert. Auch beim @RequestMapping habe ich es kopiert und auf XML umgeändert.
   
   ![](C:\Users\makko\AppData\Roaming\marktext\images\2025-09-23-15-35-10-image.png)

7. Website in JSON: http://localhost:8080/warehouse/001/json

8. Website in XML: http://localhost:8080/warehouse/001/xml

##### Erweitert

1. Ich hab einfach bei der Erweiterung der Aufgabe eine Website erstellt, wo die Daten per fetch geladen werden. Die Tabelle und das Aktualisieren der Daten werden per function selbst erstellt. Das gesamte wird per getElementById aufgerufen und ausgegeben.

```html
<!DOCTYPE html>
<html lang="de">
<script>
    var allData = [];
    var warehouseCity = '';

    function loadData() {
        fetch('/warehouse/001/json')
            .then(function(response) { return response.json(); })
            .then(function(data) {
                allData = data.productdata;
                warehouseCity = data.warehouseCity;
                renderTable(allData);
            });
    }

    function renderTable(products) {
        var tbody = document.getElementById('warehouseTable').querySelector('tbody');
        tbody.innerHTML = '';
        for (var i = 0; i < products.length; i++) {
            var p = products[i];
            var row = document.createElement('tr');
            row.innerHTML = '<td>' + p.productID + '</td>' +
                '<td>' + p.productName + '</td>' +
                '<td>' + p.productCategory + '</td>' +
                '<td>' + p.productQuantity + '</td>' +
                '<td>' + p.productUnit + '</td>';
            tbody.appendChild(row);
        }
    }

    function filterData() {
        var cityFilter = document.getElementById('cityFilter').value.trim().toLowerCase();
        var productFilter = document.getElementById('productFilter').value.trim().toLowerCase();

        var filtered = allData;

        if (cityFilter && warehouseCity.toLowerCase() !== cityFilter) filtered = [];
        if (productFilter) {
            filtered = filtered.filter(function(p) {
                return p.productName.toLowerCase().includes(productFilter);
            });
        }

        renderTable(filtered);
    }
</script>
</html>
```

2. Funktion loadData
- `fetch` fragt die JSON-Daten vom Server ab.

- `response.json()` wandelt die Antwort in ein nutzbares JavaScript-Objekt um.

- `allData` speichert alle Produkte, `warehouseCity` den Standort.

- `renderTable(allData)` aktualisiert die Tabelle mit den aktuellen Daten.
3. Funktion renderTable
- Es wird der Tabellenbereich `<tbody>` ausgewählt, in den die Produkte eingefügt werden.

- Vorhandene Zeilen werden gelöscht, damit keine alten Daten angezeigt werden.

- Eine Schleife geht durch jedes Produkt im übergebenen Array.

- Für jedes Produkt wird eine neue Zeile erstellt.

- Die Produktinformationen (ID, Name, Kategorie, Menge, Einheit) werden in die Zellen der Zeile geschrieben.

- Die fertige Zeile wird ans Ende der Tabelle angehängt.
4. Funktion filterData
- Die Funktion liest die Werte aus den Textfeldern für Stadt und Produktname ein und bereinigt sie (Leerzeichen entfernen, alles klein schreiben).

- Zunächst werden alle Produkte als Ausgangsbasis genommen.

- Prüft, ob ein Stadtfilter gesetzt ist:
  
  Wenn der Lagerstandort nicht mit dem Filter übereinstimmt, wird die Ergebnisliste geleert.

- Prüft, ob ein Produktname-Filter gesetzt ist:
  
  Filtert alle Produkte heraus, deren Name den Filtertext nicht enthält.

- Die gefilterten Produkte werden an die `renderTable`-Funktion übergeben, um die Tabelle auf der Webseite zu aktualisieren.

- Website mit Tabelle: http://localhost:8080/index.html
