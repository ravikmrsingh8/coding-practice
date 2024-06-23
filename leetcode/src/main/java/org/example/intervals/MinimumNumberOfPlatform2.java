package org.example.intervals;

import java.util.ArrayList;
import java.util.List;

/**
 * create record TrainEvent and put time and type of event(Arrival or Departure)
 * sort it based on time
 * Then go through each event and if arrival increase platformNeeded if departure decrease platformNeeded
 * Keep track of maximum of platformNeeded
 */
public class MinimumNumberOfPlatform2 {

    static record TrainEvent(int time, char type){}

    public static void main(String[] args) {
        int[] arr = new int[]{900, 940, 950, 1100, 1500,1800};
        int[] dep = new int[]{910, 1200, 1120, 1130, 1900, 2000};

        int platforms = findPlatforms(arr, dep);
        System.out.println(platforms);
    }

    private static int findPlatforms(int[] arr, int[] dep) {
        int N = arr.length;
        List<TrainEvent> events = new ArrayList<>();

        for(int i=0; i<N; i++) {
            events.add(new TrainEvent(arr[i], 'A'));
            events.add(new TrainEvent(dep[i], 'D'));
        }

        events.sort((i1, i2) -> {
            if(i1.time() == i2.time()) {
                return i1.type() - i2.type();
            }
            return i1.time() - i2.time();
        });

        int platNeeded = 0;
        int platforms = 0;

        for(TrainEvent event : events) {
            if(event.type() == 'A') {
                platNeeded++;
            } else {
                platNeeded--;
            }
            platforms = Math.max(platforms, platNeeded);
        }

        return platforms;
    }
}
