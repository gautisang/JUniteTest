import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class AssertException_4 {

    Calculator calculator;

    @BeforeAll
    static void setup()
    {
        System.out.println("Executing @BeforeAll");
    }

    @BeforeEach
    void BeforeEachTestMethod()
    {
        System.out.println("Executing @BeforeEach");
        calculator = new Calculator();
    }

    @AfterAll
    static void cleanup()
    {
        System.out.println("Executing @AfterAll");
    }

    @AfterEach
    void AfterEachTestMethod()
    {
        System.out.println("Executing @AfterEach");
    }

    @Test
    @DisplayName("Test 4/2 = 2")
    void testIntegerDivision_WhenFourDividedByTwo_ShouldReturnTwo() {

        // AAA

        // Arrange (Given) :  Prepare and Analyze all the needed variables and objects

        // We wil initialize this is BeforeEach
        // Calculator calculator = new Calculator();
        System.out.println("Test 4/2 = 2");

        int dividend=4;
        int divisor=2;
        int expectedResult=2;

        // Act (When) : Actual invoke the method which we need to test

        int actualResult =  calculator.integerDivision(dividend, divisor);

        // Assert (Then) : Validate the return value received from method under test

        assertEquals(expectedResult, actualResult, "4/2 did not produce 2");
    }

    //@Disabled("Need to work")
    @DisplayName("Divided By Zero")
    @Test
    void testIntegerDivision_WhenrDividedZero_ShouldThrowArithmaticException() {

        System.out.println("Divided By Zero");
        //Arrange
        int dividend=4;
        int divisor=0;
        String expectedExceptionMessage="/ by zero";

        //Act && Assert
      ArithmeticException actualExceptionMessage=  assertThrows(ArithmeticException.class,()->{
            calculator.integerDivision(dividend, divisor);
        },"Division by zero should have thrown Arithmatic Exception");

        // Aseert
        assertEquals(expectedExceptionMessage,actualExceptionMessage.getMessage(),"Unexpected exception");

    }

    @DisplayName("Test 33-1=32")
    @Test
    void integerSubtraction() {
        System.out.println("Test 33-1=32");
        int minuend=33;

        int sub=1;
        int expectedResult=32;


        int actualResult =  calculator.integerSubtraction(minuend,
                sub);

        // The problem with these optional message is that
        //it can slow down the process as it will get compute
        //everytime whether even if it doesn't get use.
        // For optimization of this, we can use
        // Lambda expression as follows:

        assertEquals(expectedResult, actualResult,()->minuend+"-"+
                sub + " did not produce "+expectedResult);


    }

}
