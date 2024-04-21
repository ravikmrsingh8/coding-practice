package org.example.bit;

public class CountSetBits {
    public int hammingWeight(int n) {
        int count = 0;
        for(int i=0; i<32; i++) {
            if ((n>>i & 1) != 0) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        CountSetBits setBits = new CountSetBits();
        System.out.println(setBits.hammingWeight(2147483645));
    }
}
