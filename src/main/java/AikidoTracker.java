import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AikidoTracker {
    private List<TrainingSession> sessions = new ArrayList<>();

    public List getSessions() {
        return sessions;
    }

    public void addPracticeSession(String date, int duration) {
        sessions.add(new TrainingSession(date, duration));
        System.out.println("Practice session added.");
        System.out.println();
    }

    public int getTotalPracticeTime() {
        return sessions.stream().mapToInt(TrainingSession::getDuration).sum();
    }

    public boolean checkGraduationEligibility() {
        if (sessions.size() >= 100) {
            System.out.println("Eligible for Kyu graduation. Congratulations!");
            System.out.println("You have completed at least 100 practice sessions.");
            System.out.println();
            return true;
        }

        if (!sessions.isEmpty()) {
            String startDate = sessions.get(0).getDate();
            String endDate = sessions.get(sessions.size() - 1).getDate();
            if (isSixMonthsApart(startDate, endDate)) {
                System.out.println("Eligible for Kyu graduation. Congratulations!");
                System.out.println("You have practiced for at least 6 months.");
                System.out.println();
                return true;
            }
        }

        System.out.println("Not eligible for Kyu graduation yet.");
        return false;
    }

    private boolean isSixMonthsApart(String startDate, String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate start = LocalDate.parse(startDate, formatter);
        LocalDate end = LocalDate.parse(endDate, formatter);
        return ChronoUnit.MONTHS.between(start, end) >= 6;
    }
}