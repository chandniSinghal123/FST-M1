
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void setup(){
        calculator = new Calculator();
    }

    @Test
    public void testMultiply(){

        assertEquals(20, calculator.multiplication(5,4));
    }
    @Test
    public void testAdd(){
        assertEquals(10, calculator.add(5,5));
    }
}
