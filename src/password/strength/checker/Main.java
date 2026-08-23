package password.strength.checker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\u001B[44m" + "========================================");
        System.out.println("\u001B[44m" + "      PASSWORD SECURITY ANALYZER        ");
        System.out.println("\u001B[44m" + "========================================");

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        PasswordAnalyzer analyzer = new PasswordAnalyzer();
        PasswordGenerator generator = new PasswordGenerator();
        PasswordReport report = analyzer.analyzePassword(password);

      

        System.out.println("\nPassword Score : "
                + report.getScore() + "/100");

        System.out.println("Strength Level : "
                + report.getStrength());

        System.out.println("\nSecurity Checks:-");
        System.out.println("----------------------------------------");

        System.out.println(
                analyzer.isLengthValid(password)
                ? "[PASS] Minimum Length"
                : "[FAIL] Minimum Length"
        );

        System.out.println(
                analyzer.hasUpperCase(password)
                ? "[PASS] Contains Uppercase Letter"
                : "[FAIL] Contains Uppercase Letter"
        );

        System.out.println(
                analyzer.hasLowerCase(password)
                ? "[PASS] Contains Lowercase Letter"
                : "[FAIL] Contains Lowercase Letter"
        );

        System.out.println(
                analyzer.hasDigit(password)
                ? "[PASS] Contains Number"
                : "[FAIL] Contains Number"
        );

        System.out.println(
                analyzer.hasSpecialCharacter(password)
                ? "[PASS] Contains Special Character"
                : "[FAIL] Contains Special Character"
        );

        System.out.println(
                !analyzer.containsCommonPassword(password)
                ? "[PASS] No Common Password"
                : "[FAIL] Common Password Detected"
        );

        System.out.println(
                !analyzer.hasSequence(password)
                ? "[PASS] No Sequential Pattern"
                : "[FAIL] Sequential Pattern Detected"
        );

        System.out.println(
                !analyzer.hasRepeatedCharacters(password)
                ? "[PASS] No Repeated Characters"
                : "[FAIL] Repeated Characters Detected"
        );

        System.out.println("\nFeedback");
        System.out.println("----------------------------------------");
        System.out.println(report.getFeedback());

        if (report.getScore() < 70) {
            System.out.println("\nSuggested Password:");
            System.out.println(
                    generator.generatePassword(12)
            );
        }

    }
}
