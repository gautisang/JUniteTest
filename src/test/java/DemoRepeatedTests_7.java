import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DemoRepeatedTests_7 {
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


    //@Disabled("Need to work")
    @DisplayName("Divided By Zero")
    @RepeatedTest(value=3,name="{displayName}. Repetition {currentRepetition} of {totalRepetitions}")
    void testIntegerDivision_WhenrDividedZero_ShouldThrowArithmaticException(
            RepetitionInfo repetitionInfo,
            TestInfo testInfo

    ) {

        System.out.println("Running : "+testInfo.getTestMethod().get().getName());
        System.out.println("Repetition # : "+repetitionInfo.getCurrentRepetition() +" of " +repetitionInfo.getTotalRepetitions());

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
}
