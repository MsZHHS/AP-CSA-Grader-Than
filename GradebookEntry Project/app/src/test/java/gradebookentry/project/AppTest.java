/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package gradebookentry.project;

/*import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
*/
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AppTest {
    @Before
    public void setUp() {
        // Setup code here (if required)
    }

    @After
    public void tearDown() {
        // Teardown code here (if required)
    }

    @Test
    public void testConstructor() {
        // You may rename this method to better suit the purpose of your test case
        // Your test case logic here
        assertNotNull("Something is wrong with your class", new GradebookEntry("Z", 100, 100, 100));
    }

    @Test
    public void testValues() {
        // You may rename this method to better suit the purpose of your test case
        // Your test case logic here
        GradebookEntry t1 = new GradebookEntry("Z", 100, 90, 80);
        assertEquals(t1.getName(), "Z");
        assertEquals(t1.getScore1(), 100);
        assertEquals(t1.getScore2(), 90);
        assertEquals(t1.getScore3(), 80);
    }
}
