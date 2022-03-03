import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tracker.text.Message;
import tracker.menu.Menu;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MenuTest {
    private Menu menu = new Menu();
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
    public void exitTest() {
        menu.printMenu("exit");
        Assertions.assertEquals(Message.EXIT_SUCCESS, outputStreamCaptor.toString().trim());
    }
}
