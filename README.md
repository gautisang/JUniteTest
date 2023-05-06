# JUniteTest

1. Sections to write test class logics. \n
    a. Arrange (Given) :  Prepare and Analyze all the needed variables and objects
    b. Act (When) : Actual invoke the method which we need to test
    c. Assert (Then) : Validate the return value received from method under test
   2. Life cycle for test class
       ![img.png](img.png)

      The complete lifecycle of a test case can be seen in three phases with the help of annotations.

       **Setup**: This phase puts the the test infrastructure in place. JUnit provides class level setup (@BeforeAll) and method level setup (@BeforeEach). Generally, heavy objects like databse comnections are created in class level setup while lightweight objects like test objects are reset in the method level setup.
       **Test** Execution: In this phase, the test execution and assertion happen. The execution result will signify a success or failure.
       **Cleanup**: This phase is used to cleanup the test infrastructure setup in the first phase. Just like setup, teardown also happen at class level (@AfterAll) and method level (@AfterEach).
