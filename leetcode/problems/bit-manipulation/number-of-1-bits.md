# [Number of 1 Bits](https://leetcode.com/problems/number-of-1-bits/description/)
https://leetcode.com/problems/number-of-1-bits/description/
<hr />

### Problem Statement
Write a function that takes a positive integer and returns the number of set bits it has.
It is also known as the Hamming weight.

#### Example 1:

```
Input: n = 11
Output: 3
```
Explanation:
The input binary string 1011 has a total of three set bits.
#### Example 2:

```
Input: n = 128
Output: 1
```
Explanation:
The input binary string 10000000 has a total of one set bit.
#### Example 3:

```
Input: n = 2147483645
Output: 30
```
Explanation:
The input binary string 1111111111111111111111111111101 has a total of thirty set bits.

<hr />

### Solution

[CountSetBits.java](../../src/main/java/org/example/bit/CountSetBits.java)

```java
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
        System.out.println(setBits.hammingWeight(16));
    }
}

```