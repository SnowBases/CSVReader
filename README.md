# CSVReader
CSVReader Java (WIP)

## Summary
- This CSVReader was created in java. 
- This program will convert the CSV file into MySQL database
- The program using JDBC without using the CSV to MySQL java library
- The program need some common library for input output

## To-Do
There are more upcoming feature in classDB

## CSV dataset
https://github.com/SnowBases/CSVReader/blob/master/C2ImportFamRelSample.csv

Dataset must be identical to this

    | Header | Header | Header | Header | Header |
    | Value | Value | Value | Value | Value |
    | Value | Value | Value | Value | Value |
    | Value | Value | Value | Value | Value |
    | Value | Value | Value | Value | Value |
	...



## How to use?
### Create Object to test the MySQL connection
    ClassDB mysql = new ClassDB("mysql");

### Create new Database based on open connection
    mysql.createDB("CSVReader");

### Set the Database
    ClassDB db = new ClassDB("CSVReader");

### Create new table name in the database
**Please note** : paramTableSQL(readCSVContent(0) means the first column of CSV file will be the HEADER

    db.createTables("TableName", paramTableSQL(readCSVContent(0) ) );

### Create new records 
    for(int n=1; n < getCSVLines() ; n++) db.insertRecords("CSVReader", paramRecordSQL(readCSVContent(n) , n));


Eclipse EE IDE 2018-9 

## Required

1. commons-io-2.6.jar
2. mysql-connector-java-8.0.13

## MySQL settings
Please ensure lower_case_table_names = 2 is set in my.ini

