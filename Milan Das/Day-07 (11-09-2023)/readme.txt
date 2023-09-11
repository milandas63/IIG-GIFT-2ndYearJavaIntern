+------------+
| 11-09-2023 |
+------------+
    =   What is exception handling?
        >   The exception handling is used to make a Java program fault resistant.
        >   Exception handling is done with the help of a statement that "try" statement.
        >   The try statement has two clauses, catch and finally.
        >   When an exception occurs, an exception object is generated. All lines
            following the exception line will be ignored.
        >   The exception object tries to match with the exception variable that is
            provided in the catch clause. Whichever variable in the catch clause is
            matched, the object is stored in that variable and the corresponding 
            block is executed.
        >   When the finally clause is used, it is executed when there is an exception
            and when there is no exception.

    =   Exception is a class. An exception class is that class which inherits the
        Throwable class.
    =   There are two types of exceptions:
        1)  Checked exception
            It checks if there is any possibility of such exception being generated
            from the try block.
            OR
            An exception is generated from the try block but there is no catch clause
            for that exception.
        2)  Unchecked exception
            Any exception that inherit the Throwable class through RuntimeException
            is treated as unchecked exception.

    =   CASE STUDY
        In a certain country, the cizitens are provided with voter id cards.
        The rules are, citizens below the age of 18 and above the age of 80 are 
        restricted from excercising votes.

        Object
        +- Throwable
        |  +- Exception
        |  |  +- AgeExcepiton
        |  |  |  +- InvalidAgeException
        |  |  |  |  +- NegativeAgeException
        |  |  |  |  +- ZeroAgeException
        |  |  |  +- AgeCeilingException
        |  |  |  |  +- TooYoungAgeException
        |  |  |  |  +- TooOldAgeException

        int ages[] = {24,35,15,54,11,71,88,0,63,19,-33,45,28,91,-31,75};

