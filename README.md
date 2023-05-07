# JUnitTest

1. #### Sections to write test class logics.<br>
    a. Arrange (Given) :  Prepare and Analyze all the needed variables and objects<br>
    b. Act (When) : Actual invoke the method which we need to test<br>
    c. Assert (Then) : Validate the return value received from method under test<br>

2. #### Life cycle for test class
    ![img.png](img.png)

      The complete lifecycle of a test case can be seen in three phases with the help of annotations.<br>
       **Setup**: This phase puts the the test infrastructure in place. 
                    JUnit provides class level setup (@BeforeAll) and method level setup (@BeforeEach). 
                    Generally, heavy objects like databse comnections are created in class level setup while lightweight objects like test objects are reset in the method level setup.<br>
       **Test Execution** : In this phase, the test execution and assertion happen. The execution result will signify a success or failure.<br>
       **Cleanup**: This phase is used to cleanup the test infrastructure setup in the first phase. Just like setup, teardown also happen at class level (@AfterAll) and method level (@AfterEach).<br>

**Note** :<br>  
```diff 
@@  1. By default, JUnit will create a `new Test class instance` for each test method. This provides a clean separation of state between tests.@@
+   2. @Disbaled("Message")  Annotation can be use to disable the test case to run but it will show in the test report.
```  

3. 
   a. We can pass parameters to the test method using **@ParameterizedTest** annotation.<br>
   b. To provide different variation for input parameters, use **@MethodSource** annotation.<br>
      Need to pass the name of the method that will provide the input parameters. Method needs to be static<br>
      **@MethodSource("integerSubtractionInputParameters")** : Return stream of arguments<br>
      If we don't pass the name in MethodSource, the it will search for the test class method name.<br>
      ### Example :<br>
       private static Stream<Arguments> integerSubtractionInputParameters(){
            return Stream.of(
                Arguments.of(33,1,32),
                Arguments.of(24,1,23),
                Arguments.of(54,1,53)
            );
       }
4. We can pass the Source as csv file as well using **@CsvFileSource(resources="Filepath")**
5. To pass a single parameter, we can use @**@ValueSource** annotation which take array of values as a Parameter:
      ### Example
        @ValueSource(strings={"A","B","C"})
6. **@RepeatedTest(3)** annoptation allows to repeat a test method multiple times.
    We can also pass RepetitionInfo repetitionInfo, TestInfo testInfo object in the methiod to get the information about the running test class.
      #### Example
        @DisplayName("Divided By Zero")
        @RepeatedTest(value=3,name="{displayName}. Repetition {currentRepetition} of {totalRepetitions}")
        void testIntegerDivision_WhenrDividedZero_ShouldThrowArithmaticException(
        RepetitionInfo repetitionInfo,
        TestInfo testInfo

        ) {

        System.out.println("Running : "+testInfo.getTestMethod().get().getName());
        System.out.println("Repetition # : "+repetitionInfo.getCurrentRepetition() +" of " +repetitionInfo.getTotalRepetitions());
