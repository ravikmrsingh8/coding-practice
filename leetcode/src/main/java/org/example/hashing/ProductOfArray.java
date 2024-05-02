package org.example.hashing;

import java.util.Arrays;

public class ProductOfArray {
    public int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        int[] ans = new int[N];

        // Get product of prefix array
        ans[0] = 1;
        for(int i=1; i<N; i++) {
            ans[i] = ans[i-1] * nums[i-1];
        }
        //System.out.println(Arrays.toString(ans));

        // Keep track of post product and multiply the ans array with post product
        int post = 1;
        for (int i=N-2; i>=0; i--) {
            post = post * nums[i+1];
            ans[i] = ans[i] * post;
        }
        //System.out.println(Arrays.toString(ans));
        return ans;
    }

    public static void main(String[] args) {
        ProductOfArray product = new ProductOfArray();
        int[] arr = product.productExceptSelf(new int[]{1,2,3,4});
        System.out.println(Arrays.toString(arr));

        arr = product.productExceptSelf(new int[]{-1,1,0,-3,3});
        System.out.println(Arrays.toString(arr));

    }
}
