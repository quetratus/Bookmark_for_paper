package pt.ipp.isep.dei.examples.tdd.basic.domain;


import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
//import static jdk.nashorn.internal.objects.NativeMath.round;
public class CalculatorTest {

    @BeforeAll
    public static void classSetUp() {
        //HACK: for demonstration purposes only
        System.out.println(
                "This is a CalculatorTest class method and takes place before any @Test is executed");
    }

    @AfterAll
    public static void classTearDown() {
        //HACK: for demonstration purposes only
        System.out.println(
                "This is a CalculatorTest class method and takes place after all @Test are executed");
    }

    @BeforeEach
    public void setUp() {
        //HACK: for demonstration purposes only
        System.out.println(
                "\tThis call takes place before each @Test is executed");
    }

    @AfterEach
    public void tearDown() {
        //HACK: for demonstration purposes only
        System.out.println(
                "\tThis call takes place after each @Test is executed");
    }

    @Test
    @Disabled
    public void failingTest() {
        fail("a disabled failing test");
    }

    /**
     * Test to ensure two positive numbers are summed correctly.<p>
     * <p>
     * For demonstration purposes the Arrange/Act/Assert syntax is used:<p>
     * Arrange: one positive number (three) and another positive number (two).<p>
     * Act: sum both numbers (three and two).<p>
     * Assert: the result is five.
     */
    @Test
    public void ensureThreePlusTwoEqualsFive() {

        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int expectedResult = 5;
        int firsOperand = 3;
        int secondOperand = 2;
        int result = 3;

        // Act
        result = new Calculator().sum(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void sumFirstOperandZero() {
        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firsOperand = 0;
        int secondOperand = 10;
        int expectedResult = 10;
        int result = 10;

        // Act
        result = new Calculator().sum(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void sumSecondOperandZero() {
        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firsOperand = 10;
        int secondOperand = 0;
        int expectedResult = 10;
        int result = 10;

        // Act
        result = new Calculator().sum(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void sumBothOperandsZero() {
        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firsOperand = 0;
        int secondOperand = 0;
        int expectedResult = 0;
        int result = 0;

        // Act
        result = new Calculator().sum(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void sumWithLargeNumbers() {
        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firsOperand = 500000000;
        int secondOperand = 500000000;
        int expectedResult = 1000000000;
        int result = 1000000000;

        // Act
        result = new Calculator().sum(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void subtractFiveMinusFive() {
        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firsOperand = 5;
        int secondOperand = 5;
        int expectedResult = 0;
        int result = 0;

        // Act
        result = new Calculator().subtract(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }
    @Test
    public void subtractWithZero() {
        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firsOperand = 5;
        int secondOperand = 0;
        int expectedResult = 5;
        int result = 5;

        // Act
        result = new Calculator().subtract(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void subtractWithNegative() {
        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firsOperand = 5;
        int secondOperand = -10;
        int expectedResult = 15;
        int result = 15;

        // Act
        result = new Calculator().subtract(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void subtractWithLargeNumbers() {
        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        int firsOperand = 1000000000;
        int secondOperand = 500000000;
        int expectedResult = 500000000;
        int result = 500000000;

        // Act
        result = new Calculator().subtract(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    /**
     * Test to ensure positive and negative numbers are summed correctly.<p>
     * <p>
     * For demonstration purposes the Arrange/Act/Assert syntax is used:<p>
     * Arranje a positive number (three) and a negative number (minus two)<p>
     * Act I sum three to minus two<p>
     * Assert the sum result should be one.
     */
    @Test
    public void ensureThreePlusMinusTwoEqualsOne() {
        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firsOperand = 3;
        int secondOperand = -2;
        int expectedResult = 1;
        int result = 3;

        // Act
        result = new Calculator().sum(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }



    /**
     * Test to ensure positive and positive numbers are divided correctly.<p>
     * <p>
     * For demonstration purposes the Arrange/Act/Assert syntax is used:<p>
     * Arranje a positive number (six) and another positive but smaller number (three)<p>
     * Act I divide six with three<p>
     * Assert the quotient result should be two.
     */
    @Test
    public void ensureSixDividedByThreeEuqalsTwo() {
        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firsOperand = 6;
        int secondOperand = 3;
        int expectedResult = 2;
        double result = 2;

        // Act
        result = new Calculator().divide(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    /**
     * Test to ensure positive and negative numbers are divided correctly.<p>
     * <p>
     * For demonstration purposes the Arrange/Act/Assert syntax is used:<p>
     * Arranje a positive number (six) and a negative  smaller number (three)<p>
     * Act I divide six with minus three<p>
     * Assert the quotient result should be minus two.
     */
    @Test
    public void ensureSixDividedByNegativeThreeEuqalsNegativeTwo() {
        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firsOperand = 6;
        int secondOperand = -3;
        int expectedResult = -2;
        double result = -2;

        // Act
        result = new Calculator().divide(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    /**
     * Former Tests made that result has to be changed to double to support comma values
     * Test to ensure positive and negative numbers with double format are divided correctly.<p>
     * <p>
     * For demonstration purposes the Arrange/Act/Assert syntax is used:<p>
     * Arranje a positive number (six) and a negative  bigger number (twelve)<p>
     * Act I divide  six with minus twelve<p>
     * Assert the quotient result should be negative zero point five.
     */
    @Test
    public void ensureSixDividedByNegativeTwelveEuqalsNegativeZeroDotFive() {
        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firsOperand = 6;
        int secondOperand = -12;
        double expectedResult = -0.5;
        double result = -0.5;

        // Act
        result = new Calculator().divide(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    /**
     * Former Tests made that result has to be changed to double to support comma values
     * Test to ensure positive and negative numbers with double format are divided correctly.<p>
     * <p>
     * For demonstration purposes the Arrange/Act/Assert syntax is used:<p>
     * Arranje a negative number (six) and a negative  bigger number (twelve)<p>
     * Act I divide minus six with minus twelve<p>
     * Assert the quotient result should be zero point five.
     */
    @Test
    public void ensureNegativeSixDividedByNegativeTwelveEuqalsZeroDotFive() {
        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firsOperand = -6;
        int secondOperand = -12;
        double expectedResult = 0.5;
        double result = 0.5;

        // Act
        result = new Calculator().divide(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    /**
     * Former Tests made that result has to be changed to double to support comma values
     * Test to ensure dividing Zero with a Number gives Zero.<p>
     * <p>
     * For demonstration purposes the Arrange/Act/Assert syntax is used:<p>
     * Arrange a negative divisor and a zero divididend
     * Act divide the two numbersp>
     * Assert the quotient result should be zero.
     */
    @Test
    public void ensureDividingZerowithNumberGivesZero() {
        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firsOperand = 0;
        int secondOperand = -10;
        // this could be handled to have always 0 not -/+ 0 values or 0.0 values, but I see no advantage
        double expectedResult = -0.0;
        double result = 0;

        // Act
        result = new Calculator().divide(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    /**
     * Former Tests made that result has to be changed to double to support comma values
     * Introduced Exception handling
     * Test to ensure division by zero is handled .<p>
     * <p>
     * For demonstration purposes the Arrange/Act/Assert syntax is used:<p>
     * Arranje a positive number (six) and a negative  smaller number (three)<p>
     * Act I divide six with minus three<p>
     * Assert the quotient result should be minus two.
     */
    @Test
    public void ensureDivisionByZeroThrowsNotAllowedException() {
        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firstOperand = -6;
        int secondOperand = 0;
        Calculator calculator = new Calculator();


        // Act
        Exception exception = assertThrows(ArithmeticException.class, () ->
                calculator.divide(firstOperand, secondOperand));

        // Assert
        assertEquals("/ by zero", exception.getMessage());

    }



    /**
     * Former Tests made that result could be affected by too many comma values after zero
     * Test on a given large number with comma values<p>
     * Tried to include round after 2 commas but external, package support was broken
     * <p>

     */
    @Test
    public void ensureCommaValuesLineUpWithWhatIsExpected() {
        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        double firsOperand = 1485855652;
        double secondOperand = -1256865435;
        double expectedResult = -1.1821915144002668;
        double result = -1.1821915144002668;

        // Act
        result = new Calculator().divide(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }
    /**
     * Test to ensure positive and positive numbers are multiplied correctly.<p>
     * <p>
     * For demonstration purposes the Arrange/Act/Assert syntax is used:<p>
     * Arranje a positive number (six) and another positive but smaller number (three)<p>
     * Act I multiply six with three<p>
     * Assert the  result should be eighteen.
     */
    @Test
    public void ensureSixMultipliedByThreeEqualsEighteen() {
        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firsOperand = 6;
        int secondOperand = 3;
        int expectedResult = 18;
        double result = 18;

        // Act
        result = new Calculator().multiply(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    /**
     * Test to ensure positive and positive numbers are multiplied correctly.<p>
     * <p>
     * For demonstration purposes the Arrange/Act/Assert syntax is used:<p>
     * Arranje a positive number (six) and another positive but smaller number (three)<p>
     * Act I multiply six with minus three<p>
     * Assert the  result should be negative eighteen.
     */
    @Test
    public void ensureMinusSixMultipliedByThreeEqualsMinusEighteen() {
        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firsOperand = -6;
        int secondOperand = 3;
        int expectedResult = -18;
        double result = 18;

        // Act
        result = new Calculator().multiply(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    /**
     * Test to ensure negative float number value and negative number are multiplied correctly.<p>
     * <p>
     * For demonstration purposes the Arrange/Act/Assert syntax is used:<p>
     * Arranje a negative number (6.3) and another negative  number (three)<p>
     * Act I multiply -6.3 with minus three<p>
     * Assert the  result should be negative eighteen.
     */
    @Test
    public void ensureMinusSixCommaSixMultipliedByThreeEqualsMinusEighteen() {
        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        double firsOperand = -6.3;
        int secondOperand = -3;
        double expectedResult = 18.9;
        double result = 18;

        // Act
        result = new Calculator().multiply(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    /**
     * Test to ensure multiply by zero works.<p>
     * <p>
     * For demonstration purposes the Arrange/Act/Assert syntax is used:<p>
     * Arrange a 0 and  a  number (three)<p>
     * Act I multiply 0 with  three<p>
     * Assert the  result should be zero.
     */
    @Test
    public void ensureMultiplyByZeroGivesZero() {
        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        double firsOperand = 0;
        int secondOperand = 3;
        double expectedResult = 0;
        double result = 18;

        // Act
        result = new Calculator().multiply(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }


    /**
     * Test to ensure that factorial zero is one.<p>
     * <p>
     * For demonstration purposes the Arrange/Act/Assert syntax is used:<p>
     * Arrange a zero <p>
     * Act I calculate factorial with 0 <p>
     * Assert the  result should be one.
     */
    @Test
    public void ensureFactorialByZeroGivesOne() {
        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firstOperand = 0;
        long expectedResult = 1;
        long result;

        // Act
        result = new Calculator().factorial(firstOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    /**
     * Test to ensure that factorial one is one.<p>
     * <p>
     * For demonstration purposes the Arrange/Act/Assert syntax is used:<p>
     * Arrange a one <p>
     * Act I calculate factorial with 1 <p>
     * Assert the  result should be one.
     */
    @Test
    public void ensureFactorialByOneGivesOne() {
        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firstOperand = 1;
        long expectedResult = 1;
        long result;

        // Act
        result = new Calculator().factorial(firstOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    /**
     * Test to ensure that factorial two is two.<p>
     * <p>
     * For demonstration purposes the Arrange/Act/Assert syntax is used:<p>
     * Arrange a two <p>
     * Act I calculate factorial with two <p>
     * Assert the  result should be two.
     */
    @Test
    public void ensureFactorialByTwoGivesTwo() {
        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firstOperand = 2;
        long expectedResult = 2;
        long result;

        // Act
        result = new Calculator().factorial(firstOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    /**
     * Test to ensure that factorial five is 120.<p>
     * <p>
     * For demonstration purposes the Arrange/Act/Assert syntax is used:<p>
     * Arrange a five <p>
     * Act I calculate factorial with 5 <p>
     * Assert the  result should be 120.
     */
    @Test
    public void ensureFactorialByFiveGivesHundredTwenty() {
        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firstOperand = 5;
        long expectedResult = 120;
        long result;

        // Act
        result = new Calculator().factorial(firstOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    /**
     * Test to ensure that factorial minus five is -120.<p>
     * <p>
     * For demonstration purposes the Arrange/Act/Assert syntax is used:<p>
     * Arrange a minus five <p>
     * Act I calculate factorial with -5 <p>
     * Assert the  result should be -120.
     */
    @Test
    public void ensureFactorialByMinusFiveGivesMinusHundredTwenty() {
        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firstOperand = -5;
        long expectedResult = -120;
        long result;

        // Act
        result = new Calculator().factorial(firstOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    /**
     * Test to ensure that factorial minus four is 24.<p>
     * <p>
     * For demonstration purposes the Arrange/Act/Assert syntax is used:<p>
     * Arrange a minus four <p>
     * Act I calculate factorial with -4 <p>
     * Assert the  result should be 24.
     */
    @Test
    public void ensureFactorialByMinusFourGivesMinusTwentyFour() {
        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firstOperand = -4;
        long expectedResult = 24;
        long result;

        // Act
        result = new Calculator().factorial(firstOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    /**
     * Test to ensure that factorial 12 is 479001600.<p>
     * <p>
     * For demonstration purposes the Arrange/Act/Assert syntax is used:<p>
     * Arrange a twelve <p>
     * Act I calculate factorial with twelve <p>
     * Assert the  result should be 479001600.
     */
    @Test
    public void ensureFactorialByTwelveGivesExpectedResult() {
        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firstOperand = 12;
        long expectedResult = 479001600;
        long result;

        // Act
        result = new Calculator().factorial(firstOperand);

        // Assert
        assertEquals(expectedResult, result);
    }
}



