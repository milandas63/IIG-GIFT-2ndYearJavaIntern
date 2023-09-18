class AgeException extends Exception {
    public AgeException(String message) {
        super(message);
    }
}

class InvalidAgeException extends AgeException {
    public InvalidAgeException(String message) {
        super(message);
    }
}

class NegativeAgeException extends InvalidAgeException {
    public NegativeAgeException() {
        super("Age cannot be negative.");
    }
}

class ZeroAgeException extends InvalidAgeException {
    public ZeroAgeException() {
        super("Age cannot be zero.");
    }
}

class AgeCeilingException extends AgeException {
    public AgeCeilingException(String message) {
        super(message);
    }
}

class TooYoungAgeException extends AgeCeilingException {
    public TooYoungAgeException() {
        super("Too young to vote.");
    }
}

class TooOldAgeException extends AgeCeilingException {
    public TooOldAgeException() {
        super("Too old to vote.");
    }
}

public class VoterIDValidator {
    public static void main(String[] args) {
        int ages[] = {24, 35, 15, 54, 11, 71, 88, 0, 63, 19, -33, 45, 28, 91, -31, 75};

        for (int age : ages) {
            try {
                validateAge(age);
                System.out.println("Age " + age + " is valid for voting.");
            } catch (AgeException e) {
                System.out.println("Age " + age + " is not valid for voting: " + e.getMessage());
            }
        }
    }

    public static void validateAge(int age) throws AgeException {
        if (age < 0) {
            throw new NegativeAgeException();
        } else if (age == 0) {
            throw new ZeroAgeException();
        } else if (age < 18) {
            throw new TooYoungAgeException();
        } else if (age > 80) {
            throw new TooOldAgeException();
        }
    }
}
