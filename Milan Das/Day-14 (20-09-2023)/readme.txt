+------------+
| 20-09-2023 |
+------------+
    =   To UPDATE data in a table use the following command:
            UPDATE students SET name='Some name', regd_no=3445544 WHERE slno=2;

    =   To remove all data from a table:
            TRUNCATE students;

    =   To insert new set of data in a table:
            INSERT INTO students(name,regd_no) VALUES
                ('Abhijit Sahu',2101298383),
                ('Aditya Das',2101298050),
                ('Aman Kumar',2101298054),
                ('Anwesha Mahapatra',2101298063);

    =   Stock Accounting MENU
        >Master   Transaction  Tool   Exit
         Manufacturer
         Product
         -------------
         Vendor
         Customer
         -------------
         Activities
         -------------

        >Master   Transaction  Tool   Exit
                   Stock Entry
                   --------------
                   Stock Reports
                   --------------
                   Stock Adjustment


    =   ASSIGNMENT:
        >   Create a user interface in Java Swing to enter data into the student's table.
            Column names:
            1)  slno
            2)  name
            3)  regd_no

        >   Create a button in the name "Submit". On clicking on the Submit button,
            the data is inserted into the db-table.

        >   There will be an Exit button, to come out of the application.

