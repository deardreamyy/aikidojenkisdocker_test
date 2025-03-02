import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AikidoTracker tracker = new AikidoTracker();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Aikido Practice Tracker");
            System.out.println("1. Add Practice Session");
            System.out.println("2. View Total Practice Time");
            System.out.println("3. Check Graduation Eligibility");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid option. Please try again.");
                scanner.nextLine(); // consume the invalid input
                continue;
            }
            int choice = scanner.nextInt();

            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter session date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter session duration (minutes): ");
                    int duration = scanner.nextInt();
                    tracker.addPracticeSession(date, duration);
                    break;
                case 2:
                    int totalMinutes = tracker.getTotalPracticeTime();
                    System.out.println("Total practice time: " + totalMinutes + " minutes.");
                    System.out.println();
                    break;
                case 3:
                    tracker.checkGraduationEligibility();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}