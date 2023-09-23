
    /*
 CASE STUDY
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

 */

public class validateAgeForVoting {

    // Base exception class for AgeException
    public static class AgeException extends Exception {
        public AgeException(String message) {
            super(message);
        }
    }

    // Custom exception for invalid ages (negative or zero)
    public static class InvalidAgeException extends AgeException {
        public InvalidAgeException(String string) {
            super("Age cannot be negative or zero.");
        }
    }

    // Custom exception for negative age
    public static class NegativeAgeException extends InvalidAgeException {
        public NegativeAgeException() {
            super("Age cannot be negative.");
        }
    }

    // Custom exception for zero age
    public static class ZeroAgeException extends InvalidAgeException {
        public ZeroAgeException() {
            super("Age cannot be zero.");
        }
    }

    // Custom exception for age ceiling issues
    public static class AgeCeilingException extends AgeException {
        public AgeCeilingException(String message) {
            super(message);
        }
    }

    // Custom exception for ages below 18
    public static class TooYoungAgeException extends AgeCeilingException {
        public TooYoungAgeException() {
            super("Citizens below 18 are not allowed to vote.");
        }
    }

    // Custom exception for ages above 80
    public static class TooOldAgeException extends AgeCeilingException {
        public TooOldAgeException() {
            super("Citizens above 80 are not allowed to vote.");
        }
    }

    // Function to check if a person can vote based on age
    public static void checkVoterEligibility(int age) throws AgeException {
        if (age < 0) {
            throw new NegativeAgeException();
        } else if (age == 0) {
            throw new ZeroAgeException();
        } else if (age < 18) {
            throw new TooYoungAgeException();
        } else if (age > 80) {
            throw new TooOldAgeException();
        } else {
            System.out.println("Age: "+age+" - You are eligible to vote.");
        }
    }

    public static void main(String[] args) {
        int[] ages = {24, 35, 15, 54, 11, 71, 88, 0, 63, 19, -33, 45, 28, 91, -31, 75};

        for (int age : ages) {
            try {
                checkVoterEligibility(age);
            } catch (AgeException e) {
                System.out.println("Age: " + age + " - " + e.getMessage());
            }
        }
    }
}



