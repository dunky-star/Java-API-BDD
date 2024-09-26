package com.dunky;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    public void addTest(){
        Calculator calc = new Calculator();
        int actualResult = calc.add(10,2);
        assertEquals(12, actualResult);

    }
}
