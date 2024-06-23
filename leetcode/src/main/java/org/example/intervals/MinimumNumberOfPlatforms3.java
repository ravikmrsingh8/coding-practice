package org.example.intervals;

import java.util.ArrayList;
import java.util.List;

public class MinimumNumberOfPlatforms3 {
    static class TrainEvent{
        int time;
        char type;
        TrainEvent(int time, char type) {
            this.time = time;
            this.type = type;
        }

        int time() {
            return this.time;
        }

        char type() {
            return this.type;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{900, 940, 950, 1100, 1500,1800};
        int[] dep = new int[]{910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(findPlatform(arr, dep, arr.length));
    }
    static int findPlatform(int arr[], int dep[], int n) {
        // add your code here
        int N = arr.length;
        List<TrainEvent> events = new ArrayList<>();

        for(int i=0; i<N; i++) {
            events.add(new TrainEvent(arr[i], 'A'));
            events.add(new TrainEvent(dep[i], 'D'));
        }

        events.sort((e1, e2)-> e1.time() - e2.time());

        int platforms = 0;
        int platNeeded = 0;

        for(TrainEvent event: events) {
            if(event.type() == 'A') {
                platNeeded += 1;
            } else {
                platNeeded -= 1;
            }
            platforms = Math.max(platforms, platNeeded);
        }
        return platforms;

    }
}
