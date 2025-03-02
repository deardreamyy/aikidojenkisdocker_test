import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class AikidoTrackerTest {
    Scanner scanner = new Scanner(System.in);

    @Test
    void addPracticeSession() {
        AikidoTracker tracker = new AikidoTracker();
        tracker.addPracticeSession("2025-02-28", 60);

        assertEquals(1, tracker.getSessions().size());
    }

    @Test
    void viewTotalPracticeTime() {
        AikidoTracker tracker = new AikidoTracker();
        tracker.addPracticeSession("2025-02-28", 60);
        tracker.addPracticeSession("2025-03-01", 90);

        assertEquals(150, tracker.getTotalPracticeTime());
    }

    @Test
    void checkGraduationEligibility() {
        AikidoTracker tracker = new AikidoTracker();
        tracker.addPracticeSession("2025-02-28", 60);
        tracker.addPracticeSession("2025-03-01", 90);
        assertFalse(tracker.checkGraduationEligibility());

        tracker.addPracticeSession("2025-09-02", 90);
        assertTrue(tracker.checkGraduationEligibility());
    }
}