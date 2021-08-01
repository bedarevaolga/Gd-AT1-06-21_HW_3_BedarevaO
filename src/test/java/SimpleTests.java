import com.it_academy.practice.junit_basics.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleTests {
    @Test
    public void testAssertTrueSimpleExample() {
        assertTrue(5 + 3 == 8);
    }

    @Test
    public void testAssertFalseSimpleExample() {
        assertFalse(5 * 3 == 8);
    }

    @Test
    public void testAssertEqualsSimpleExample() {
        assertEquals("+", "*");
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

    @Test
    public void testDeleteByZero() {
        assertThrows(ArithmeticException.class, () -> new Calculator(594, 0).calculate('/'));
    }

    @Test
    public void testDeleteByZeroException() {
        try {
            assertFalse(5 / 0 == 1);
        } catch (ArithmeticException e) {
            System.out.println("Made arithmetic mistake:" + e.getMessage());
        }
    }

    @ParameterizedTest
    @CsvSource({"1, 3", "15, 2", "5, 1"})
    void testExponentiationAndExtractingTheRoot(int one, int two) {
        assertAll(
                () -> assertTrue(new Calculator(one, two).calculate('^') > 0),
                () -> assertFalse(new Calculator(one, two).calculate('√') == 4)
        );
    }

    @ParameterizedTest
    @CsvSource({"1, 3, 0, 6, 11", "15, 2, 0, 1, 4"})
    void testExponentiationAndExtractingTheRoot(int one, int two, int three, int four, int five) {
        assertAll(
                () -> assertTrue(new Calculator(one, two, three, four, five)
                        .calculateMoreParameters('+') > 0),
                () -> assertFalse(new Calculator(one, two, three, four, five)
                        .calculateMoreParameters('-') == 4),
                () -> assertThrows(ArithmeticException.class, () -> new Calculator(one, two, three, four, five)
                        .calculateMoreParameters('/'))
        );
    }
}

