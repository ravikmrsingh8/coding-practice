package org.example.dp;

import java.util.Arrays;

public class LCS {
    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        int m = s1.length();
        int n = s2.length();
        int length = lcs(s1, s2);
        System.out.println(length);

        int M = s1.length();
        int N = s2.length();

        int[][] dp = new int[M+1][N+1];
        for(int i=0;i<M+1; i++) {
            Arrays.fill(dp[i], -1);
        }

    }

    static int lcs(String s1, String s2) {
        if(s1.isEmpty() || s2.isEmpty()) return 0;

        if (s1.charAt(0) == s2.charAt(0)) {
            return 1 + lcs(s1.substring(1), s2.substring(1));
        } else {
            return Math.max(lcs(s1, s2.substring(1)), lcs(s1.substring(1), s2));
        }
    }
}


