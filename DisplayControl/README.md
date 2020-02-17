<h3>Provisional README file - no public</h3>

Note README is on the way, this is a provisional on JP

*Microservice* developed by using:
**Java SE-1.8** && **Spring Boot** 2.2.4 - **MAVEN** 4.0.0 &&  **JPA**+**Hibernate**(Postgresql dialect)

Depending on PostgreSQL DB (coming soon...)
  *with table linked to java class 'items' atributes--> see _/DisplayControl/src/main/resources/application.properties_.
Tested funcionallity using POSTMAN app

Microservice **DisplayControl** does :

* Listen request from API on _'host':8080_  (_http_ - GET, POST, DELETE).
* Process request (not secured yet!).
* SELECT/INSERT/DELETE data on/from '_DB/table_'(_username_ + _password_).
* Send Response to API as '.json'.

         
      
            GET 'localhost':8080/items    --> get all items present the DB/table
            GET 'localhost':8080/items/{id}    --> get item with matched id in the DB/table (see primaryKey)
            POST 'localhost':8080/items/{id}   --> insert/update given id item in DB/table (see atributes/column of 'Item' see primaryKey)
            DELETE 'localhost':8080/items/{id}  --> idem POST but to drop given id item.
       
_ejemplo_ **JSON** 
{ "manufacturer_id": "DSP123",
  "idItemInStore": null,
"nickname": "Monitor YUYO",
"description": "Monitor de a marca YUYO",
"price": 69.99,
"units": 4
}

<h2>!! Working on JWT once other microservices are ON. Postgresql DB on the way to be deployed in independent Docker, as all other microservices.</h2>
* there are many fancy .println stuff to check some info in the workflow, will be removed once fully developed
      
