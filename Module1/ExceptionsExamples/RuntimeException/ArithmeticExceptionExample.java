/**
 * Title: Java Exceptions Example - ArithmeticException
 * 
 * From:
 *  - M1-3:Basic Java Programming
 * 
 * Problem statement:
 * This example shows Java exceptions: ArithmeticException
 * Thia is an unchecked exception.
 * 
 * Why it occurs (in this code):
 * The expression 10 / 0 attempts integer division by zero, which triggers an 
 * ArithmeticException.
 * 
 * @date 2026-01-25
 */

package Module1.ExceptionsExamples.RuntimeException;

public class ArithmeticExceptionExample {
    public static void main(String[] args) {
        int x = 10 / 0;
    }
}
