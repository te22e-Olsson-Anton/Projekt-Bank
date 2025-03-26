import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank();

        // Skapa några användare och en admin
        bank.addUser(new User(1, "Kund", "password123"));
        bank.addUser(new Admin(2, "Admin", "admin123"));

        Scanner scanner = new Scanner(System.in);

        boolean loggedIn = false; // Håller koll på inloggningsstatus

        while (!loggedIn) {
            System.out.print("Ange användarnamn (eller 'exit' för att avsluta): ");
            String name = scanner.nextLine();

            // Om användaren skriver "exit" → avsluta programmet
            if (name.equalsIgnoreCase("exit")) {
                System.out.println("Programmet avslutas...");
                break;
            }

            System.out.print("Ange lösenord: ");
            String password = scanner.nextLine();

            // Försök att logga in
            User loggedInUser = bank.login(name, password);

            if (loggedInUser != null) {
                System.out.println("Inloggning lyckades!");
                loggedIn = true; // Avsluta loopen eftersom inloggning lyckades

                if (loggedInUser instanceof Admin) {
                    System.out.println("Välkommen Admin: " + loggedInUser.getName());
                    ((Admin) loggedInUser).manageUsers(); // Kör admin-specifik kod
                } else {
                    System.out.println("Välkommen Användare: " + loggedInUser.getName());
                    // Kör vanlig användarkod här
                }
            } else {
                System.out.println("Fel användarnamn eller lösenord. Försök igen.\n");
            }
        }

        scanner.close();
    }
}
