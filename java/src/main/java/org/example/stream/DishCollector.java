package org.example.stream;

import org.example.stream.model.Dish;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

public class DishCollector {
    public IntSummaryStatistics getCalorieStatistics(List<Dish> dishes) {
        return dishes.stream()
                .collect(summarizingInt(Dish::calories));
    }

    public String getDishNames(List<Dish> dishes) {
        return dishes.stream()
                .map(Dish::name)
                .collect(joining(","));
    }

    public Map<Dish.Type, List<Dish>> groupByDishType(List<Dish> dishes) {
        return dishes.stream().collect(groupingBy(Dish::type));
    }

    public Map<Dish.CaloricLevel, List<Dish>> groupByCaloricLevel(List<Dish> dishes) {
        return dishes.stream().collect(groupingBy(Dish::caloricLevel));
    }

    public Map<Dish.Type, Long> countDishesByDishType(List<Dish> dishes) {
        return dishes.stream().collect(groupingBy(Dish::type, counting()));
    }

    public Map<Dish.Type, Map<Dish.CaloricLevel, List<String>>> groupDishNamesByTypeAndCaloricLevel(List<Dish> dishes) {
        return dishes.stream()
                .collect(groupingBy(Dish::type, groupingBy(Dish::caloricLevel, mapping(Dish::name, toList()))));
    }

    public Map<Dish.Type, Optional<Dish>>  mostCaloricByType(List<Dish> dishes) {
        return dishes.stream().collect(groupingBy(Dish::type, maxBy(Comparator.comparing(Dish::calories))));
    }

}

