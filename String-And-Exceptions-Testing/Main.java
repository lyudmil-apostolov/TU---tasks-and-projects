import java.util.Scanner;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<>();

        while (true) {
            System.out.println("Enter an option: ");
            System.out.println("1. Register");
            System.out.println("2. Login");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Консумиране на новия ред след въвеждането на числото

            if (choice == 1) {
                // Регистрация
                System.out.print("Enter an username: ");
                String username = scanner.nextLine();
                System.out.print("Enter a password: ");
                String password = scanner.nextLine();
                System.out.print("Enter phone number: ");
                String phoneNumber = scanner.nextLine();

                try {
                    // Проверка дали потребителят вече съществува
                    boolean exists = users.stream().anyMatch(u -> u.getUsername().equals(username));
                    if (exists) {
                        System.out.println("The username no longer exists.");
                    } else {
                        // Създаване на нов потребител
                        User newUser = new User(username, password, phoneNumber);
                        users.add(newUser);
                        System.out.println("The registration was successful.");
                    }
                } catch (WrongUserException | WrongPhoneNumberException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } else if (choice == 2) {
                // Вход
                System.out.print("Enter an username: ");
                String username = scanner.nextLine();
                System.out.print("Enter a password: ");
                String password = scanner.nextLine();

                boolean found = false;
                for (User user : users) {
                    if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                        System.out.println("Successful login.");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Invalid username or password.");
                }
            } else {
                System.out.println("Invalid choice.");
            }
        }





    }
}