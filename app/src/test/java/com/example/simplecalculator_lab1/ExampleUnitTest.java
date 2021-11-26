package com.example.simplecalculator_lab1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals("Integer addition: 2+2 ",4, 2 + 2);
        assertEquals("negative Integer addition: -3+2 ",-1, -3 + 2);
        assertEquals("decimal addition: 0.5+0.2 ",0.7, 0.5 + 0.2, 0.01);

    }
    @Test
    public void subtraction_isCorrect() {
        assertEquals("Integer subtraction: 70-35 ",35, 70 - 35);
        assertEquals("Integer subtraction with negative values: -70-35 ",-105, -70 - 35);
        assertEquals("subtraction with decimal values: 5-8.7 ",-3.7, 5 - 8.7, 0.01);
    }

    @Test
    public void multiplication_isCorrect() {
        assertEquals("Integer multiplication: 9*8 ",72, 9 * 8);
        assertEquals("Integer multiplication with negative values: -2*3 ",-6, -2 * 3);
        assertEquals("multiplication with decimal values: 3*1.5 ",4.5, 3 * 1.5, 0.01);
    }
    @Test
    public void division_isCorrect() {
        assertEquals("Integer division: 9/9 ",1, 9 / 9);
        assertEquals("Integer division: 144/-12 ",-12, 144/-12 );
        assertEquals("Division with decimal values: 5/8.7 ",0.5747, 5 / 8.7, 0.0001);
    }

}