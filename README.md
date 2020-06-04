# Connecting-JDBC-MySQL_DB-Persons

Simple project using connector JDBC to connect DB with MySQL to manage Persons DataBase.


In this project is using responsibilities separation to establish connection with database, i built class 'Person' representing records
from an existing DataBase kind Person.
I built class PersonJDBC working with basic operations to handle table 'Person' in DB from MySQL so we can use functions like 'Select' to
see our objects in DB, 'Insert' to add some registry on this one, 'Update' to change some parameters in one of our records and 'Delete' 
to delete records using with this the ID for registry.

Also we have class called ManagingPersons wich actually is the main class and here we got a Menu so we can test all the functions and start
to doing changes in the DB, all this changes we can see it in MySQL WorkBench instantly. 

All the classes has some notes to understand perfectly the entire software

On folder 'database' you will find the Database created in MySQL WorkBench, so if you wish it, you can test it by your own.



