class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}

class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) {
        super(message);
    }
}

public class UserService {

    public void registerUser(String username) throws UserAlreadyExistsException {
        if (checkUserExistence(username)) {
            throw new UserAlreadyExistsException("User already exists: " + username);
        }
        System.out.println("User " + username + " registered successfully.");
    }

    public boolean checkUserExistence(String username) throws UserNotFoundException {
        if ("existingUser".equals(username)) {
            return true; 
        } else {
            throw new UserNotFoundException("User not found: " + username);
        }
    }

    public static void main(String[] args) {
        UserService userService = new UserService();

        try {
            userService.registerUser("existingUser");
        } catch (UserAlreadyExistsException e) {
            System.out.println("Registration Error: " + e.getMessage());
        }

        try {
            userService.checkUserExistence("nonExistingUser");
        } catch (UserNotFoundException e) {
            System.out.println("Check Error: " + e.getMessage());
        }
    }
}
