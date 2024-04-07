package org.example.stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DailyTemperatureTest {

    @Test
    @DisplayName("Find next warmer day test1")
    public void findNextWarmerDayTest1() {
        DailyTemperature temperature = new DailyTemperature();
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] actual = temperature.dailyTemperatures(temperatures);
        assertArrayEquals(new int[]{1,1,4,2,1,1,0,0}, actual);
    }

    @Test
    @DisplayName("Find next warmer day test2")
    public void findNextWarmerDayTest2() {
        DailyTemperature temperature = new DailyTemperature();
        int[] temperatures = {30,40,50,60};
        int[] actual = temperature.dailyTemperatures(temperatures);
        assertArrayEquals(new int[]{1,1,1,0}, actual);
    }

    @Test
    @DisplayName("Find next warmer day test3")
    public void findNextWarmerDayTest3() {
        DailyTemperature temperature = new DailyTemperature();
        int[] temperatures = {30,60,90};
        int[] actual = temperature.dailyTemperatures(temperatures);
        assertArrayEquals(new int[]{1,1,0}, actual);
    }

}