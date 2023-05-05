import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@DisplayName("Test Math Opearation")
public class DemoAnnotation {

    @Test
    @DisplayName("Test 4/2 = 2")
    void testIntegerDivision_WhenFourDividedByTwo_ShouldReturnTwo() {
        Calculator calculator = new Calculator();
        int result =  calculator.integerDivision(4, 2);
        assertEquals(2, result, "4/2 did not produce 2");
    }

    @DisplayName("Divided By Zero")
    @Test
    void testIntegerDivision_WhenrDividedZero_ShouldThrowArithmaticException() {
        fail("Not Implemented");
    }

    @DisplayName("Test 33-1=32")
    @Test
    void integerSubtraction() {
        Calculator calculator = new Calculator();
        int minuend=33;
        int sub=1;
        int expectedResult=32;


        int actualResult =  calculator.integerSubtraction(minuend,
                sub);

        assertEquals(expectedResult, actualResult,minuend+"-"+
                sub + "did not produce "+expectedResult);

        // The problem with these optional message is that
        //it can slow down the process as it will get compute
        //everytime whether even if it doesn't get use.
        // For optimization of this, we can use
        // Lambda expression as follows:

        assertEquals(expectedResult, actualResult,()->minuend+"-"+
                sub + " did not produce "+expectedResult);


    }
}
