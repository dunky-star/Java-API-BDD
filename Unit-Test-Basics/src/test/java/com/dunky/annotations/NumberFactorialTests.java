package com.dunky.annotations;

import com.dunky.NumberFactorial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberFactorialTests {

    @Test
    public void calFactorialTest(){
        NumberFactorial fac = new NumberFactorial();
        int actualFactorial = fac.calFactorial(5);
        assertEquals(120, actualFactorial);
    }
}
