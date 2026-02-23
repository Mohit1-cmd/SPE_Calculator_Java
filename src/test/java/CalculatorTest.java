import org.example.Calculator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    private static final double DELTA = 1e-4;

    @Before
    public void setUp() {
        // No state needed; Calculator uses static methods
    }

    // ---------------------- ADD ----------------------

    @Test
    public void testAddPositives() {
        assertEquals(15.0, Calculator.add(10, 5), DELTA);
    }

    @Test
    public void testAddNegatives() {
        assertEquals(-7.0, Calculator.add(-4, -3), DELTA);
    }

    @Test
    public void testAddMixedSign() {
        assertEquals(3.5, Calculator.add(7.5, -4.0), DELTA);
    }

    @Test
    public void testAddZero() {
        assertEquals(99.0, Calculator.add(99, 0), DELTA);
    }

    // ---------------------- SUBTRACT ----------------------

    @Test
    public void testSubtractBasic() {
        assertEquals(8.0, Calculator.subtract(13, 5), DELTA);
    }

    @Test
    public void testSubtractNegativeResult() {
        assertEquals(-5.0, Calculator.subtract(3, 8), DELTA);
    }

    @Test
    public void testSubtractDecimals() {
        assertEquals(1.1, Calculator.subtract(3.3, 2.2), DELTA);
    }

    // ---------------------- MULTIPLY ----------------------

    @Test
    public void testMultiplyPositives() {
        assertEquals(42.0, Calculator.multiply(6, 7), DELTA);
    }

    @Test
    public void testMultiplyByZero() {
        assertEquals(0.0, Calculator.multiply(100, 0), DELTA);
    }

    @Test
    public void testMultiplyNegativeByPositive() {
        assertEquals(-15.0, Calculator.multiply(-5, 3), DELTA);
    }

    @Test
    public void testMultiplyNegatives() {
        assertEquals(12.0, Calculator.multiply(-4, -3), DELTA);
    }

    // ---------------------- DIVIDE ----------------------

    @Test
    public void testDivideEven() {
        assertEquals(5.0, Calculator.divide(25, 5), DELTA);
    }

    @Test
    public void testDivideDecimalResult() {
        assertEquals(2.5, Calculator.divide(5, 2), DELTA);
    }

    @Test
    public void testDivideNegative() {
        assertEquals(-4.0, Calculator.divide(-20, 5), DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZeroThrows() {
        Calculator.divide(7, 0);
    }

    @Test
    public void testDivideByZeroMessage() {
        try {
            Calculator.divide(7, 0);
            fail("Expected ArithmeticException");
        } catch (ArithmeticException e) {
            assertEquals("Error! Division by zero.", e.getMessage());
        }
    }

    // ---------------------- POWER ----------------------

    @Test
    public void testPowerSquare() {
        assertEquals(49.0, Calculator.power(7, 2), DELTA);
    }

    @Test
    public void testPowerZeroExponent() {
        assertEquals(1.0, Calculator.power(100, 0), DELTA);
    }

    @Test
    public void testPowerFractionalExponent() {
        assertEquals(2.0, Calculator.power(8, 1.0 / 3.0), DELTA);
    }

    @Test
    public void testPowerNegativeExponent() {
        assertEquals(0.1, Calculator.power(10, -1), DELTA);
    }

    // ---------------------- SQUARE ROOT ----------------------

    @Test
    public void testSquareRootPerfectSquare() {
        assertEquals(9.0, Calculator.squareRoot(81), DELTA);
    }

    @Test
    public void testSquareRootOfOne() {
        assertEquals(1.0, Calculator.squareRoot(1), DELTA);
    }

    @Test
    public void testSquareRootOfZero() {
        assertEquals(0.0, Calculator.squareRoot(0), DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void testSquareRootNegativeThrows() {
        Calculator.squareRoot(-9);
    }

    @Test
    public void testSquareRootNegativeMessage() {
        try {
            Calculator.squareRoot(-4);
            fail("Expected ArithmeticException");
        } catch (ArithmeticException e) {
            assertEquals("Error! Square root of a negative number.", e.getMessage());
        }
    }

    // ---------------------- LOGARITHM ----------------------

    @Test
    public void testLogarithmOfE() {
        assertEquals(1.0, Calculator.logarithm(Math.E), DELTA);
    }

    @Test
    public void testLogarithmOfTen() {
        assertEquals(Math.log(10), Calculator.logarithm(10), DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void testLogarithmOfZeroThrows() {
        Calculator.logarithm(0);
    }

    @Test(expected = ArithmeticException.class)
    public void testLogarithmNegativeThrows() {
        Calculator.logarithm(-5);
    }

    @Test
    public void testLogarithmNegativeMessage() {
        try {
            Calculator.logarithm(-1);
            fail("Expected ArithmeticException");
        } catch (ArithmeticException e) {
            assertEquals("Error! Logarithm of zero or negative number.", e.getMessage());
        }
    }

    // ---------------------- FACTORIAL ----------------------

    @Test
    public void testFactorialOfFive() {
        assertEquals(120.0, Calculator.factorial(5), DELTA);
    }

    @Test
    public void testFactorialOfSeven() {
        assertEquals(5040.0, Calculator.factorial(7), DELTA);
    }

    @Test
    public void testFactorialOfZero() {
        assertEquals(1.0, Calculator.factorial(0), DELTA);
    }

    @Test
    public void testFactorialOfOne() {
        assertEquals(1.0, Calculator.factorial(1), DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void testFactorialNegativeThrows() {
        Calculator.factorial(-3);
    }

    @Test
    public void testFactorialNegativeMessage() {
        try {
            Calculator.factorial(-2);
            fail("Expected ArithmeticException");
        } catch (ArithmeticException e) {
            assertEquals("Error! Factorial of a negative number.", e.getMessage());
        }
    }
}
