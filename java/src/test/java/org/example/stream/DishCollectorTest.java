package org.example.stream;

import org.example.stream.model.Dish;
import org.example.stream.model.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class DishCollectorTest {

    @Test
    @DisplayName("Get Calorie Statistics of Dishes")
    public void calorieStatistics() {
        DishCollector collector = new DishCollector();
        IntSummaryStatistics statistics = collector.getCalorieStatistics(Menu.dishes);
        assertEquals(9, statistics.getCount());
        assertEquals(4200, statistics.getSum());
        assertEquals(120, statistics.getMin());
        assertEquals(800, statistics.getMax());
        assertEquals((statistics.getSum()*1.0)/statistics.getCount(), statistics.getAverage());
    }

    @Test
    @DisplayName("Get Dish Names")
    public void testDishNames() {
        DishCollector collector = new DishCollector();
        String dishes = collector.getDishNames(Menu.dishes);
        StringJoiner joiner = new StringJoiner(",");
        for(Dish dish: Menu.dishes) {
            joiner.add(dish.name());
        }
        String expected = joiner.toString();
        assertEquals(expected, dishes);
    }

    @Test
    @DisplayName("Should group by Dish Type")
    public void groupByDishType() {
        DishCollector collector = new DishCollector();
        Map<Dish.Type, List<Dish>> dishGroups = collector.groupByDishType(Menu.dishes);

        // Perform grouping
        Map<Dish.Type, List<Dish>> expected = new HashMap<>();
        for (Dish dish: Menu.dishes) {
            List<Dish> dishes = expected.getOrDefault(dish.type(), new ArrayList<>());
            dishes.add(dish);
            expected.put(dish.type(), dishes);
        }

        // Test groups
        expected.forEach((key, value) -> assertIterableEquals(value, dishGroups.get(key)));

    }

    @Test
    @DisplayName("Should group by Caloric level")
    public void groupByDishCaloricLevel() {
        DishCollector collector = new DishCollector();
        Map<Dish.CaloricLevel, List<Dish>> dishGroups = collector.groupByCaloricLevel(Menu.dishes);
        // Perform grouping
        Map<Dish.CaloricLevel, List<Dish>> expected = new HashMap<>();
        for (Dish dish: Menu.dishes) {
            List<Dish> dishes = expected.getOrDefault(dish.caloricLevel(), new ArrayList<>());
            dishes.add(dish);
            expected.put(dish.caloricLevel(), dishes);
        }
        // Test groups
        expected.forEach((key, value) -> assertIterableEquals(value, dishGroups.get(key)));

    }

    @Test
    @DisplayName("Count Dishes in Each Type Category")
    public void countByDishType() {
        DishCollector collector = new DishCollector();
        Map<Dish.Type, Long> group = collector.countDishesByDishType(Menu.dishes);

        Map<Dish.Type, Long> expected = Map.of(Dish.Type.MEAT, 3L,
                Dish.Type.FISH , 2L,
                Dish.Type.OTHER, 4L);

        expected.forEach((k, v) -> assertEquals(v,group.get(k)));
    }

    @Test
    @DisplayName("Should group by Dish Type and Caloric level")
    public void groupByDishTYpeAndCaloricLevel() {
        DishCollector collector = new DishCollector();
        Map<Dish.Type, Map<Dish.CaloricLevel, List<String>>> dishGroups = collector.groupDishNamesByTypeAndCaloricLevel(Menu.dishes);

        Map<Dish.Type, Map<Dish.CaloricLevel, List<String>>> expected = Map.of(
                Dish.Type.OTHER,
                Map.of(Dish.CaloricLevel.NORMAL, List.of("french fries", "pizza"),
                        Dish.CaloricLevel.DIET, List.of("rice", "season fruit")),

                Dish.Type.FISH,
                Map.of(Dish.CaloricLevel.NORMAL, List.of("salmon"),
                        Dish.CaloricLevel.DIET, List.of("prawns")),

                Dish.Type.MEAT,
                Map.of(Dish.CaloricLevel.NORMAL, List.of("chicken"),
                        Dish.CaloricLevel.FAT, List.of("pork", "beef"))
        );

        expected.forEach((key, value) -> {
            var actual = dishGroups.get(key);
            value.forEach((k2, v2) -> {
                assertIterableEquals(v2,actual.get(k2));
            });
        });
    }

    @Test
    @DisplayName("Most caloric By Type")
    public void mostCaloricByType() {
        DishCollector collector = new DishCollector();
        Map<Dish.Type, Optional<Dish>> dishByType = collector.mostCaloricByType(Menu.dishes);
        Map<Dish.Type, Optional<Dish>> expected = Map.of(
                Dish.Type.MEAT, Optional.of(new Dish("pork", false, 800, Dish.Type.MEAT)),
                Dish.Type.FISH, Optional.of(new Dish("salmon", false, 450, Dish.Type.FISH)),
                Dish.Type.OTHER, Optional.of(new Dish("pizza", true, 550, Dish.Type.OTHER))
        );
        expected.forEach((key, value) -> assertEquals(dishByType.get(key), value));
    }
}