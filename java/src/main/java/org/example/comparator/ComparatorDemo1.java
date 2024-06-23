package org.example.comparator;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemo1 {

    static record TrainEvent(int time, char type) { }

    public static void main(String[] args) {
        TrainEvent e1 = new TrainEvent(10,'A');
        TrainEvent e2 = new TrainEvent(1,'A');
        TrainEvent e3 = new TrainEvent(9,'D');
        TrainEvent e4 = new TrainEvent(9,'B');
        List<TrainEvent> list = new ArrayList<>();
        list.add(e1);
        list.add(e2);
        list.add(e3);
        list.add(e4);
        list.sort(Comparator.comparingInt(TrainEvent::time).thenComparing(TrainEvent::type));
        System.out.println(list);
    }
}
