import com.it_academy.practice.junit_basics.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleTests {

    @ParameterizedTest
    @CsvSource({"1, 3, 4", "-3, 15, 12", "-4, -8, -12"})
    void testParameterizedPrimitivesPlus(int a, int b, int result) {
        assertEquals(result, new Calculator(a, b).calculate('+'));
    }

    @ParameterizedTest
    @CsvSource({"1, 3, -2", "-3, 15, -18", "-4, -8, 4"})
    void testParameterizedPrimitivesMinus(int a, int b, int result) {
        assertEquals(result, new Calculator(a, b).calculate('-'));
    }

    @ParameterizedTest
    @CsvSource({"1, 3, 3", "-3, 0, 0", "-4, -8, 32"})
    void testParameterizedPrimitivesMultiply(int a, int b, int result) {
        assertEquals(result, new Calculator(a, b).calculate('*'));
    }

    @ParameterizedTest
    @CsvSource({"9, 3, 3", "15, 2, 7.5", "-21, 3, -7"})
    void testParameterizedPrimitivesMinus(int a, int b, double result) {
        assertEquals(result, new Calculator(a, b).calculate('/'));
    }

    @Test
    public void testException() throws IOException {
        Scanner sc = new Scanner(Paths.get("Data.txt"));
        assertThrows(NumberFormatException.class, () ->
                new Calculator(Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine())).calculate('/'));
        sc.close();
    }

    @Test
    public void testOutOfRange() {
        String s = "6963253325252237";
        assertThrows(NumberFormatException.class, () -> new Calculator(7, Integer.parseInt(s))
                .calculate('*'));
    }

    @ParameterizedTest
    @CsvSource({"1, 3, 1", "-15, 2, 225", "5, 1, 5", "5, 0, 1"})
    void testExponentiation(int one, int two, int result) {
        assertEquals(result, new Calculator(one, two).calculate('^'));
    }

    @ParameterizedTest
    @CsvSource({"225, 2, 15", "27, 3, 3", "5, 1, 5", "8, 2, 2.828", "-27, 3, -3", "0, 2, 0"})
    void testExtractingTheRoot(int one, int two, double result) {
        assertTrue(compareDoubles(result, new Calculator(one, two).calculate('√'), 0.001));
    }

    public static boolean compareDoubles(double x, double y, double delta) {
        return Math.abs(x - y) < delta;
    }

    @Test
    void testDifferentNumberOfInputParametersPlus() {
        assertEquals(18, new Calculator(new ArrayList<>(Arrays.asList(5, 10, 2, 1)))
                .calculateMoreParameters('+'));
    }

    @Test
    void testDifferentNumberOfInputParametersMinus() {
        assertEquals(129, new Calculator(new ArrayList<>(Arrays.asList(100, 10, 30, 1, -59, -11)))
                .calculateMoreParameters('-'));
    }

    @Test
    void testDifferentNumberOfInputParametersMultiply() {
        assertEquals(12, new Calculator(new ArrayList<>(Arrays.asList(2, 6)))
                .calculateMoreParameters('*'));
    }

    @Test
    void testDifferentNumberOfInputParametersDivision() {
        assertEquals(-0.5, new Calculator(new ArrayList<>(Arrays.asList(100, 5, 4, 5, -2)))
                .calculateMoreParameters('/'));
    }
}

