package org.example.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        System.out.println(sieve(1_000_000, 100));
    }

    public static List<Integer> sieve(int n, int nth) {
        int N = n + 1;
        boolean[] nums = new boolean[N];
        Arrays.fill(nums, true);
        int count=0;
        for(int i=2; i*i < N; i++) {
            if(nums[i]) {
                count++;
                if(count==nth) break;
                //mark all multiples false
                for(int j=i*i ; j < N; j+=i) {
                    nums[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        int count1=0;
        for(int i=2; i<N; i++) {
            if(nums[i]) {
                primes.add(i);
                count1++;
            }

            if(count1 == 100) break;
        }
        return primes;

    }
}
