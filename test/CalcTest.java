import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CalcTest {
    MainFrame mainFrame;

    @BeforeEach
    public void initEach() {
        this.mainFrame = new MainFrame();
    }
    
    @Test
    public void testCalcBodyIndex() {
        double actual = this.mainFrame.calcBodyIndex(100, 1.8);
        double expected = 30.86;
        assertEquals(expected, actual, 0.1);
    }

    @Test
    public void testCalcBodyIndexSecond() {
        double actual = this.mainFrame.calcBodyIndex(130, 1.7);
        double expected = 44.98;
        assertEquals(expected, actual, 0.1);
    }
    @Test
    public void testCalcBodyIndexBottom() {
        double actual = this.mainFrame.calcBodyIndex(1, 1.7);
        double expected = 0.34;
        assertEquals(expected, actual, 0.1);
    }
    @Test
    public void testCalcBodyIndexTop() {
        double actual = this.mainFrame.calcBodyIndex(600, 2.5);
        double expected = 96.0;
        assertEquals(expected, actual, 0.1);
    }


}