
package password.strength.checker;

import java.security.SecureRandom;

public class PasswordGenerator {

    private static final String UPPER =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final String LOWER =
            "abcdefghijklmnopqrstuvwxyz";

    private static final String DIGITS =
            "0123456789";

    private static final String SYMBOLS =
            "!@#$%^&*()_+-=";

    private static final String ALL =
            UPPER + LOWER + DIGITS + SYMBOLS;

    private SecureRandom random = new SecureRandom();

    public String generatePassword(int length) {

        StringBuilder password = new StringBuilder();

        password.append(
                UPPER.charAt(random.nextInt(UPPER.length()))
        );

        password.append(
                LOWER.charAt(random.nextInt(LOWER.length()))
        );

        password.append(
                DIGITS.charAt(random.nextInt(DIGITS.length()))
        );

        password.append(
                SYMBOLS.charAt(random.nextInt(SYMBOLS.length()))
        );

        for (int i = 4; i < length; i++) {

            password.append(
                    ALL.charAt(random.nextInt(ALL.length()))
            );
        }

        return password.toString();
    }
}