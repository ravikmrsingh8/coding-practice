package org.example.intervals;

/**
 * Assuming array is sorted based on arrival time
 * for each interval check all next intervals if they overlap and keep track of maximum overlaps
 */
public class MinimumNumberOfPlatform1 {
    public static void main(String[] args) {
        int[] arr = new int[]{900, 940, 950, 1100, 1500,1800};
        int[] dep = new int[]{910, 1200, 1120, 1130, 1900, 2000};

        int platforms = findPlatforms(arr, dep);
        System.out.println(platforms);

    }

    private static int findPlatforms(int[] arr, int[] dep) {
        int N = arr.length;
        if (N == 0) return 0;
        int platforms = 0;

        for(int i=0; i<N; i++) {
            int platformNeeded = 1;
            for(int j=i+1; j<N; j++) {
                if(arr[j] < dep[i]) platformNeeded++;
            }
            platforms = Math.max(platforms, platformNeeded);
        }

        return platforms;
    }


}
