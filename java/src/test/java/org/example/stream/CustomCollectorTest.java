package org.example.stream;

import org.example.stream.model.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CustomCollectorTest {

    @Test
    @DisplayName("Should Return All Fish Dish Names in Menu")
    public void fishDishes() {
        CustomCollector collector = new CustomCollector();
        List<String> fishes = collector.getFishDish(Menu.dishes);
        List<String> expected = List.of("prawns", "salmon");
        assertEquals(expected, fishes);
    }


    @Test
    @DisplayName("Partition By Custom Collector Test")
    public void shouldPartitionNumbersBetweenPrimeAndNonPrime() {
        CustomCollector collector = new CustomCollector();
        Map<Boolean, List<Integer>> partitions = collector.partitionByPrime(20);
        Map<Boolean, List<Integer>> expected = Map.of(
                false, List.of(4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20),
                true, List.of(2, 3, 5, 7, 11, 13, 17, 19)
        );
        expected.forEach((k, v)-> assertEquals(v,partitions.get(k)));
    }
}