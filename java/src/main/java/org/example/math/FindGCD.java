package org.example.math;


/***
 * GCD has recursive properties
 * gcd(a, 0) = a
 * gcd(0, b) = b
 * gcd(a, b) = gcd(a%b, b) if a > b
 * gcd(a, b) = gcd(a, b%a) if b > a
 */


public class FindGCD {
    public static void main(String[] args) {

    }

    public static int gcd(int num1, int num2) {
        // Write your code here
        if(num1 == 0) return num2;
        if(num2 == 0) return num1;

        if(num1> num2) return gcd(num1% num2, num2);
        else return gcd(num2%num1, num1);

    }
}
