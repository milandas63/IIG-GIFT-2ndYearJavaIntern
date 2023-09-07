+------------+
| 07-09-2023 |
+------------+
    +-  package-1
    |   +-  class-01
    |   +-  class-02
    |   +-  class-03
    +-  package-2
    |   +-  class-04
    |   +-  class-05
    |   +-  class-06
    +-  package-3
    |   +-  class-07
    |   +-  class-08
    |   +-  class-03


    =   There are 4 access modifiers:
        >   public
            Other classes may access the public class from the same package or from
            other packages
        >   protected
            Other classes may access the protected class from same package by both,
            inheritance and object reference. To access the class from other packages
            only object reference is allowed. Inheritance is restricted.
        >   private
            Other classes can't access a private class.
        >   <undefined>
            Other classes may access the <undefined> class from same package by both,
            inheritance and object reference. To access the class from other packages,
            only inheritance is allowed. Object reference is restricted.

    =   How many modifiers are there?
        There are eight modifiers:
        1)  abstract
            example: public abstract class Input {}
        2)  final
            example: public final class Important {}
        3)  static
            example: 
        4)  native
        5)  synchronized
        6)  transient
        7)  strictfp
        8)  volatile

    =   APPLIED RULES
       --------------------------------------------------------------------------
                                                    OUTER   INNER   OUTER   INNER
        SL  MODIFIER        FIELD   METHOD  CONSTR  CLASS   CLASS  INTERF  INTERF
       --------------------------------------------------------------------------
        1.  public          yes     yes     yes     yes     yes     yes     yes
        2.  protected       yes     yes     yes     no      yes     no      yes
        3.  private         yes     yes     yes     no      yes     no      yes
        4.  <undefined>     yes     yes     yes     yes     no      yes     no
       --------------------------------------------------------------------------
        5.  abstract        no      yes     no      yes     yes     yes     yes
        6.  final           yes     yes     no      yes     yes     no      no
        7.  static          yes     yes     no      no      yes     no      yes
        8.  native          no      yes     no      no      no      no      no
        9.  synchronized    no      yes     no      no      no      no      no
       10.  transient       yes     no      no      no      no      no      no
       11.  volatile        yes     no      no      no      no      no      no
       12.  strictfp        no      yes     no      yes     yes     yes     yes
       --------------------------------------------------------------------------
    
    =   The final modifier:
        The final modifier may be used with a field, method and class.
        >   If the final modifier is used with a field, the value of the field becomes
            constant. The value can't be changed once the field is assigned with a
            value. In case the final field is not assigned with any value, you can
            assign the value from the constructor. Once assigned, it can't be changed.

        >   If a method is final, the same method can't be overrided.

        >   If a class is final, the same class can't be inherited.

    =   The static modifier:
        >   If a field is static, all instances of the class share a common location
            of the same field.
        >   If a method is static, the method should be called by class name reference.

    =   What is the syntax of creating a field?
        The public variables are known as fields. The fields are accessible to all other
        member of the class.

        Syntax:
            [access-modifiers] [modifiers] <type> <name-of-the-field> [= <value>];

            public final double PI = 3.141;
            public double PI = 3.141;
            double PI;

    =   What is a constructor?
        >   A constructor is an entity/a member of the class that is required to instantiate
            a class. Every class must have at least one constructor. If a constructor is not
            defined by the coder, it is implicitly created. This implicitly created constructor
            is class default constructor. The default constructor doesn't have any parameters-
            list.
        >   The constructor name must resemble with the class name. The constructor doesn't 
            have any return type.
        >   The constructors are normally used to initialize the values of a field.
    
    =   Syntax of a constructor:

            [access-modifier]
            [modifier]
            <name-of-the-constructor>([parameter-list]) 
            [throws <exception-list>] 
            {}

            example:
                public class Work {
                    public int count;
                    public String matter;

                    public Work() {
                        count = 0;
                        matter = null;
                    }

                    public Work(int p) {
                        count = p;
                        matter = null
                    }

                    public Work(String x) {
                        count = 0;
                        matter = x;
                    }

                    public Work(int p, String x) {
                        count = p;
                        matter = x;
                    }

                    public void Work() {
                    }
                }

    =   What is method?
        >   A function in other languages is similar to Java language.
        >   Small code that is repeatedly used in the program may be kept within a method
            so that the method can be called whenever required.
        >   A method may be called recursively from within the same method.
        >   There may be several methods that have the same name.
        >   A method must have a return-type or void if nothing is there to return.
        >   A method is different from a constructor because it has a return-type

    =   Syntax of a method:

        [access-modifier]
        [modifier]
        <return-type>|void
        <name-of-the-method>([parameter-list])
        [thorws <exception-list>]
        {}


