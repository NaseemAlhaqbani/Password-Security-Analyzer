package password.strength.checker;

public class PasswordAnalyzer {

    //1
    public boolean isLengthValid(String password) {
        return password.length() >= 8;
    }

    public boolean hasUpperCase(String password) {

        for (int i = 0; i < password.length(); i++) {

            if (Character.isUpperCase(password.charAt(i))) {
                return true;
            }
        }

        return false;
    }

    //2
    public boolean hasLowerCase(String password) {

        for (int i = 0; i < password.length(); i++) {

            if (Character.isLowerCase(password.charAt(i))) {
                return true;
            }
        }

        return false;
    }

    //3
    public boolean hasDigit(String password) {

        for (int i = 0; i < password.length(); i++) {

            if (Character.isDigit(password.charAt(i))) {
                return true;
            }
        }

        return false;
    }

    //4
    public boolean hasSpecialCharacter(String password) {

        String symbols = "!@#$%^&*()-_=+";

        for (int i = 0; i < password.length(); i++) {

            if (symbols.contains(String.valueOf(password.charAt(i)))) {
                return true;
            }
        }

        return false;
    }

    //5
    public boolean containsCommonPassword(String password) {

        String[] commonPasswords = {"password", "admin", "welcome", "qwerty", "123456", "letmein"};

        String lowerPassword = password.toLowerCase();

        for (String common : commonPasswords) {

            if (lowerPassword.contains(common)) {
                return true;
            }
        }

        return false;
    }

    //6
    public boolean hasSequence(String password) {

        password = password.toLowerCase();

        for (int i = 0; i < password.length() - 2; i++) {

            char first = password.charAt(i);
            char second = password.charAt(i + 1);
            char third = password.charAt(i + 2);

            boolean ascending
                    = second == first + 1
                    && third == second + 1;

            boolean descending
                    = second == first - 1
                    && third == second - 1;

            if (ascending || descending) {
                return true;
            }
        }

        return false;
    }

    public int calculateScore(String password) {

        int score = 0;

        if (isLengthValid(password)) {
            score += 20;
        }

        if (hasUpperCase(password)) {
            score += 15;
        }

        if (hasLowerCase(password)) {
            score += 15;
        }

        if (hasDigit(password)) {
            score += 15;
        }

        if (hasSpecialCharacter(password)) {
            score += 15;
        }

        if (!containsCommonPassword(password)) {
            score += 10;
        }

        if (!hasSequence(password)) {
            score += 10;
        }

        return score;
    }

    public String getStrengthLevel(int score) {

        if (score >= 90) {
            return "Very Strong";
        }

        if (score >= 70) {
            return "Strong";
        }

        if (score >= 50) {
            return "Medium";
        }

        if (score >= 30) {
            return "Weak";
        }

        return "Very Weak";
    }

    public PasswordReport analyzePassword(String password) {

        int score = calculateScore(password);
        String strength = getStrengthLevel(score);
        String feedback = generateFeedback(password);

        return new PasswordReport(score, strength, feedback);
    }

    public String generateFeedback(String password) {

        String feedback = "";

        if (!isLengthValid(password)) {
            feedback += "- Password should be at least 8 characters.\n";
        }

        if (!hasUpperCase(password)) {
            feedback += "- Add at least one uppercase letter.\n";
        }

        if (!hasLowerCase(password)) {
            feedback += "- Add at least one lowercase letter.\n";
        }

        if (!hasDigit(password)) {
            feedback += "- Add at least one number.\n";
        }

        if (!hasSpecialCharacter(password)) {
            feedback += "- Add at least one special character.\n";
        }

        if (containsCommonPassword(password)) {
            feedback += "- Password contains a common or predictable word.\n";
        }

        if (hasSequence(password)) {
            feedback += "- Avoid sequential patterns such as abc or 123.\n";
        }

        if (feedback.isEmpty()) {
            feedback = "Excellent password.";
        }

        return feedback;
    }

}
