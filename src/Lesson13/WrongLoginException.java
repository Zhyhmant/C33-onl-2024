package Lesson13;

// Пользовательские исключения
class WrongLoginException extends Exception {
    public WrongLoginException() {
        super("Invalid login");
    }

    public WrongLoginException(String message) {
        super(message);
    }
}

class WrongPasswordException extends Exception {
    public WrongPasswordException() {
        super("Invalid password");
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}

class UserValidation {

    public static boolean validate(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {
        // Проверка логина
        if (login.length() >= 20 || login.contains(" ")) {
            throw new WrongLoginException("Login must be less than 20 characters and not contain spaces.");
        }

        // Проверка пароля
        if (password.length() >= 20 || password.contains(" ") || !password.matches(".*\\d.*")) {
            throw new WrongPasswordException("Password must be less than 20 characters, not contain spaces, and have at least one digit.");
        }

        // Проверка совпадения паролей
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Password and confirm password must match.");
        }

        return true;
    }

    public static void main(String[] args) {
        try {
            boolean result = validate("ValidLogin", "Pass123", "Pass123");
            System.out.println("Validation successful: " + result);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Validation error: " + e.getMessage());
        } finally {
            // Создадим ситуацию, чтобы блок finally не вызвался
            if (true) {
                System.exit(0);
            }
        }

        System.out.println("This will never print because finally is skipped.");
    }
}
