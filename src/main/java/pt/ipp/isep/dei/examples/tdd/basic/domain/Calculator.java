package pt.ipp.isep.dei.examples.tdd.basic.domain;


//import static jdk.nashorn.internal.objects.NativeMath.round;

/**
 * Calculator class.
 * This class is very simple in order to demonstrate how to build test cases for Unit Testing.
 */
public class Calculator {

    /**
     * Sums one operand to the other, returning the result.
     *
     * @param firstOperand  First operand to sum.
     * @param secondOperand Second Operand to sum.
     * @return The sum of firstOperand with secondOperand.
     */
    public int sum(int firstOperand, int secondOperand) {
        return firstOperand + secondOperand;
    }

    public int subtract(int firstOperand, int secondOperand) { return firstOperand - secondOperand; }

    public double divide(double dividend, double divisor) {
        if (divisor == 0) throw new java.lang.ArithmeticException("/ by zero");

      //  return round(dividend/divisor, 2);
        return dividend / divisor;
    }

    public double multiply(double firstOperand, double secondOperand) {
        return firstOperand * secondOperand;
    }

    public int factorial(int firstOperand) {

        int fact = 1;
        for (int i = 2; i <= firstOperand; i++) {
            fact = fact * i;
        }
        return fact;

    }
}
