package org.example.stream;

import org.example.stream.model.Dish;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class CustomCollector {
    public List<String> getFishDish(List<Dish> dishes) {
        return dishes.stream()
                .filter(dish -> dish.type() == Dish.Type.FISH)
                .map(Dish::name)
                .collect(new ToListCollector<>());
    }

    public Map<Boolean, List<Integer>> partitionByPrime(int N) {
        return IntStream.rangeClosed(2, N).boxed().collect(new PartitionNumberByPrimality());
    }
}
