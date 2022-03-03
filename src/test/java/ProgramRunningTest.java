import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tracker.text.Message;
import tracker.Tracker;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ProgramRunningTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void appRunningWithTitle() {
        Tracker.startTracker();
        Assertions.assertEquals(Message.APP_TITLE, outputStreamCaptor.toString().trim()); // trim removes the new line that System.out.println() adds!
    }
}
