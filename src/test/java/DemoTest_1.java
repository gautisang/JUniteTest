import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DemoTest_1 {

    // Test Name naming Convention
    // test<System Under Test>_<Condition or State Change>_<Expectred Result>

    @Test
    void testDemo(){
        System.out.println("Test Demo");
    }

    @Test
    void testIntegerDivision_WhenFourDividedByTwo_ShouldReturnTwo() {
        Calculator calculator = new Calculator();
        int result =  calculator.integerDivision(4, 2);
        assertEquals(2, result, "4/2 did not produce 2");
    }

    @Test
    void testIntegerDivision_WhenrDividedZero_ShouldThrowArithmaticException() {

    }


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
