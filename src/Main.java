import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank();

        bank.addUser(new User(1, "Kund", "password123"));
        bank.addUser(new Admin(2, "Admin", "admin123"));

        Scanner scanner = new Scanner(System.in);

        boolean loggedIn = false;


        while (!loggedIn) {
            System.out.print("Ange användarnamn (eller 'exit' för att avsluta): ");
            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("exit")) {
                System.out.println("Programmet avslutas...");
                break;
            }

            System.out.print("Ange lösenord: ");
            String password = scanner.nextLine();

            User loggedInUser = bank.login(name, password);

            if (loggedInUser != null) {
                System.out.println("Inloggning lyckades!");
                loggedIn = true;

                if (loggedInUser instanceof Admin) {
                    System.out.println("Välkommen Admin: " + loggedInUser.getName());
                    ((Admin) loggedInUser).manageUsers();
                } else {
                    System.out.println("Välkommen Användare: " + loggedInUser.getName());
                }
            } else {
                System.out.println("Fel användarnamn eller lösenord. Försök igen.\n");
            }
        }

        scanner.close();
    }
}
