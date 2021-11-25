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
        assertEquals(4, 2 + 2);
        assertEquals(-1, -3 + 2);
    }
    @Test
    public void subtraction_isCorrect() {
        assertEquals(35, 70 - 35);
        assertEquals(-105, -70 - 35);
    }

    @Test
    public void multiplication_isCorrect() {
        assertEquals(72, 9 * 8);
        assertEquals(-6, -2 * 3);
    }
    @Test
    public void division_isCorrect() {
        assertEquals(1, 9 / 9);
        assertEquals(-12, 144/-12 );
    }

}