+------------+
| 14-09-2023 |
+------------+
    =   In the top of the program after creating an object of the JFrame class, we have
        called the setLayout() method with reference to the JFrame object.

        Example:
            JFrame frm = new JFrame("Login");
            frm.setLayout(null);

    =   The setLayout method is asking for a LayoutManager object. LayoutManager is an
        interface, so give the object of the class that has implemented the LayoutManager
        interface.

            public class SpecialLayout implements LayoutManager {

            }

    =   There are already 5 classes that have implemented the LayoutManager interface:
        1)  FlowLyout
            The components that are added to the container are arranged like the words
            are arranged in a wordprocessor. The components are wrapped to the next line.
            +----------------------------------------+
            | Quick Brown Fox Jumps Over The Lazy    |
            | Dog. Quick Brown Fox Jumps Over The    |
            | Lazy Dog.                              |
            |                                        |
            |                                        |
            |                                        |
            |                                        |
            |                                        |
            +----------------------------------------+

        2)  BorderLayout
            The border layout provides 5 cells. These cells are arranged in the following
            ways:
            +----------------------------------------+
            |                 NORTH                  |
            +-----+----------------------------+-----+
            |  W  |                            |  E  |
            |  E  |           CENTER           |  A  |
            |  S  |                            |  S  |
            |  T  |                            |  T  |
            +-----+----------------------------+-----+
            |                 SOUTH                  |
            +----------------------------------------+

        3)  GridLayout
            A simple layout manager. It divides the container into number of rows
            and columns provided in the constructor.

            new GridLayout(6,7);
            +-----+-----+-----+-----+-----+-----+-----+
            |     |     |     |     |     |     |     |
            +-----+-----+-----+-----+-----+-----+-----+
            |     |     |     |     |     |     |     |
            +-----+-----+-----+-----+-----+-----+-----+
            |     |     |     |     |     |     |     |
            +-----+-----+-----+-----+-----+-----+-----+
            |     |     |     |     |     |     |     |
            +-----+-----+-----+-----+-----+-----+-----+
            |     |     |     |     |     |     |     |
            +-----+-----+-----+-----+-----+-----+-----+
            |     |     |     |     |     |     |     |
            +-----+-----+-----+-----+-----+-----+-----+

        4)  CardLayout
        5)  GridBagLayout

