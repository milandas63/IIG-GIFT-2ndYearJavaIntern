+------------+
| 18-09-2023 |
+------------+
    =   RDBMS stands for Relational DataBase Management System
    =   We will install MySQL because MySQL is free (Open Source).
    =   There are two types of databases:
        1)  Proprietory
            a)  Oracle
            b)  MS-SQL Server
            c)  Informix
            d)  Sybase
            e)  Unify
            f)  Ingress
        2)  Open Source
            a)  MySQL
            b)  PostgreSQL
            c)  Berkeley
            d)  CloudScape

    =   Install MySQL in your machine by running the following:
            xampp-windows-x64-8.2.4-0-VS16-installer.exe
    =   One user is provided in the name "root". There is no password for this
        user. From the DOS prompt type "mysql -uroot". MySQL command will start.

        D:\IIG\Gift\2ndYearJavaIntern>mysql -uroot
        Welcome to the MariaDB monitor.  Commands end with ; or \g.
        Your MariaDB connection id is 8
        Server version: 10.4.28-MariaDB mariadb.org binary distribution

        Copyright (c) 2000, 2018, Oracle, MariaDB Corporation Ab and others.

        Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

        MariaDB [(none)]>

    =   MySQL can also run from other IDEs. Some of the most popular IDEs are
        1)  MySQL Workbench
        2)  TOAD

    =   How to create a database in MySQL?
            CREATE DATABASE [IF NOT EXISTS] <dbName>;
        Example:
            MariaDB [(none)]> create database gift_3;
            Query OK, 1 row affected (0.002 sec)
    
    =   To view the databases that already exists?
            SHOW DATABASES;
        Example:
            MariaDB [(none)]> show databases;
            +--------------------+
            | Database           |
            +--------------------+
            | certificate        |
            | church_cocbbsr     |
            | gift_3             |
            | information_schema |
            | mysql              |
            | performance_schema |
            | phpmyadmin         |
            | stock_accounting   |
            | test               |
            +--------------------+
            9 rows in set (0.001 sec)

    =   To use a particular database usable type the following:
            USE <dbName>;
        Example:
            USE gift_3;

    =   How to create a table in a database?
            CREATE TABLE IF NOT EXISTS students(
                slno            INT(6)          NOT NULL AUTO_INCREMENT,
                name            VARCHAR(50)     NOT NULL,
                regd_no         INT(12)         NOT NULL,
                PRIMARY KEY(slno)
            );

    =   To view the list of tables within a database type:
            SHOW TABLES;

    =   To view the columns that exists within a table, type:
            DESCRIBE <tbName>;
        Example:
            MariaDB [gift_3]> DESCRIBE students;
            +---------+-------------+------+-----+---------+----------------+
            | Field   | Type        | Null | Key | Default | Extra          |
            +---------+-------------+------+-----+---------+----------------+
            | slno    | int(6)      | NO   | PRI | NULL    | auto_increment |
            | name    | varchar(50) | NO   |     | NULL    |                |
            | regd_no | int(12)     | NO   |     | NULL    |                |
            +---------+-------------+------+-----+---------+----------------+
            3 rows in set (0.016 sec)

    =   How to insert rows into a table?
            INSERT INTO <tbName>[(column1, column2, ....)] VALUES(colData1, colDate2, ....);

    =   How to view the data within a table?
            SELECT <column1, column2, column3, ...> FROM <tbName>;
            SELECT * FROM <tbName>;
        Example:
            SELECT * FROM students;

    =   How to access the data within a RDBMS using Java program?
        There are 6 steps to access a database from Java program:
            Step-1: Load and register driver
            Step-2: Create a Connection object
            Step-3: Create a Statement object
            Step-4: Create a ResultSet object
            Step-5: Manipulate ResultSet
            Step-6: Close ResultSet, Statement, Connection
