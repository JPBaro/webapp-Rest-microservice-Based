<h3>Provisional README file</h3>

Note README is on the way, this is a provisional on JP

*Microservice* developed by using:
**Java SE-1.8** && **Spring Boot** 2.2.4 - **MAVEN** 4.0.0 &&  **JPA**+**Hibernate**(Postgresql dialect)

Depending on PostgreSQL DB (coming soon...)
 <blockquote> provisional fixed set up for postgresql--> see '/DisplayControl/src/main/resources/application.properties' </blockquote>
Tested funcionallity using POSTMAN app
<hr>
Microservice DisplayControl does :

* Listen request from API client on _'host':8080_  (_http_ - GET, POST, DELETE).
* Process request (not secured yet!).
* SELECT/INSERT/DELETE data on/from '_DB/table_'(_username_ + _password_).
* Send Response to API client as '.json'.

         
      
            GET 'localhost':8080/items    --> get all items present the DB/table
            GET 'localhost':8080/items/{id}    --> get item with matched id in the DB/table (see primaryKey)
            POST 'localhost':8080/items/{id}   --> insert/update given id item in DB/table (see atributes/column of 'Item' see primaryKey)
            DELETE 'localhost':8080/items/{id}  --> idem POST but to drop given id item.
<hr>       
<h5>JSON schedule </h5> 
<html>
<body>
<pre>
<code>
{ 
"manufacturer_id": string,
"idItemInStore": string,
"nickname": string,
"description": string,
"price": number,
"units": number
}
</code>
</pre>
</body>
</html>

<blockquote> selfnote --there are many fancy .println stuff to check some info in the workflow, will be removed once fully developed </blockquote>
      
