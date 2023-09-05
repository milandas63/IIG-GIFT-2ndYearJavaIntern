+------------+
| 05-09-2023 |
+------------+
    =   LIST OF RESERVE WORDS/KEY WORDS IN JAVA (53 words)
        abstract    continue    for         new         switch
        assert***   default     goto*       package     synchronized
        boolean     do          if          private     this
        break       double      implements  protected   throw
        byte        else        import      public      throws
        case        enum****    instanceof  return      transient
        catch       extends     int         short       try
        char        final       interface   static      void
        class       finally     long        strictfp**  volatile
        const*      float       native      super       while
        null        true        false

        *       not used
        **      added in 1.2
        ***     added in 1.4
        ****    added in 5.0

	=	What is a class?
		A Java program is written a class. A class is a wrapper of the program.


	 2 x  1 =  2   3 x  1 =  3   4 x  1 =  4   5 x  1 =  5   6 x  1 =  6
	 2 x  2 =  4   3 x  2 =  6   4 x  2 =  8   5 x  2 = 10   6 x  2 = 12
	 2 x  3 =  6   3 x  3 =  9   4 x  3 = 12   5 x  3 = 15   6 x  3 = 18
	 2 x  4 =  8   3 x  4 = 12   4 x  4 = 16   5 x  4 = 20   6 x  4 = 24
	 2 x  5 = 10   3 x  5 = 15   4 x  5 = 20   5 x  5 = 25   6 x  5 = 30
	 2 x  6 = 12   3 x  6 = 18   4 x  6 = 24   5 x  6 = 30   6 x  6 = 36
	 2 x  7 = 14   3 x  7 = 21   4 x  7 = 28   5 x  7 = 35   6 x  7 = 42
	 2 x  8 = 16   3 x  8 = 24   4 x  8 = 32   5 x  8 = 40   6 x  8 = 48
	 2 x  9 = 18   3 x  9 = 27   4 x  9 = 36   5 x  9 = 45   6 x  9 = 54
	 2 x 10 = 20   3 x 10 = 30   4 x 10 = 40   5 x 10 = 50   6 x 10 = 60

	=	The syntax/grammer for creating a class:
		[access-modifier] [modifier] class <class-name> [extends <parent-class>] [implements <parent-interface>] {}

		[access-modifier]
		[modifier]
		class <class-name>
		[extends <parent-class>]
		[implements <parent-interface>]
		{}

	=	Rules for creating the name of an identifiers (class, interface, field, constrator, method)

		class & interface should start with an uppercase alphabetic character (A-Z)
		                  It may also start with $ or _
		field & method    should start with a lowercase alphabetic character
		constrator	      the name resemble with the class name

        >   There is no restriction for the size of the name
        >   The identifiers may use (A-Z, a-z, 0-9, $, _) characters

    =   What is an access-modifier?
        >   The access-modifier gives permission to access the same class, field, method
            There are 4 access-modifiers:
            1)  public
                Other classes may access the public class from the same package or from
                other packages
            2)  protected
            3)  private
            4)  <undefined>

    =   What are the way to access a class?
        There are two ways to access a class:
        1)  By creating an object of the class and calling its members with the object
            reference
        2)  By inheriting the class and using the members



