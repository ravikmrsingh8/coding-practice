package org.example.slidingwindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockTest {

    @Test
    @DisplayName("Max Profit Test 1")
    public void maxProfitTest1(){
        int[] prices = {7,1,5,3,6,4};
        Stock stock = new Stock();
        Assertions.assertEquals(5, stock.maxProfit(prices));
    }

    @Test
    @DisplayName("Max Profit Test 2")
    public void maxProfitTest2(){
        int[] prices = {7,6,4,3,1};
        Stock stock = new Stock();
        Assertions.assertEquals(0, stock.maxProfit(prices));
    }

}