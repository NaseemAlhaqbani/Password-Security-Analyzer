package password.strength.checker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        PasswordAnalyzer analyzer = new PasswordAnalyzer();

        if (analyzer.isLengthValid(password)) {
            System.out.println("Length Check: PASS");
        } else {
            System.out.println("Length Check: FAIL");
        }

        PasswordReport report = analyzer.analyzePassword(password);
        System.out.println("Has Uppercase: "
                + analyzer.hasUpperCase(password));
        System.out.println("Has Lowercase: "
                + analyzer.hasLowerCase(password));
        System.out.println("Has Digit: "
                + analyzer.hasDigit(password));
        System.out.println("Has Symbol: "
                + analyzer.hasSpecialCharacter(password));
        System.out.println("Contains Common Password: "
                + analyzer.containsCommonPassword(password));

        System.out.println("Score: "
                + report.getScore()
                + "/100");

        System.out.println("Strength Level: "
                + report.getStrength());
        
        System.out.println("\nFeedback:");
        System.out.println(report.getFeedback());
    }
}
