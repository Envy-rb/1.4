package com.envy.day41.entity;

public class IntExtension {
    private static final int FIRST_PRIME_NUMBER = 2;
    private static final int THREE_DIGIT_MAX = 999;
    private static final int THREE_DIGIT_MIN = 100;
    private static final int NOTATION = 10;

    public static boolean isPrime(int num) { 
        int currentNum = FIRST_PRIME_NUMBER;
        boolean result = true;

        if (num == 1 || num == 2)//non prime numbers lesser than first prime
        {
            result = false;
        }
        while (currentNum * currentNum <= num) {
            if (num % currentNum == 0) {
             result = false;
             break;
            }
            currentNum++;
        }
        return result;
    }

    public static boolean isFibonacci(int num) {
        boolean result = true;
        int current = 0;
        int prev0 = 0;
        int prev1 = 1;

        while (current < num) {
            current = prev1 + prev0;
            prev1 = prev0;
            prev0 = current;
        }
        if (num != current) {
            result = false;
        }
        return result;
    }

    private static boolean isThreeDigit(int num) {
        boolean result = false;

        if (num >= THREE_DIGIT_MIN && num <= THREE_DIGIT_MAX) {
            result = true;
        }
        return  result;
    }

    public static boolean isThreeDigitUnique(int num) {
        boolean result = false;

        if (isThreeDigit(num)) {
            int digit2 = num % NOTATION;
            int digit1 = (num / NOTATION) % NOTATION;
            int digit0 = (num / NOTATION * NOTATION) % NOTATION;
            if (digit0 != digit1 && digit1 != digit2 && digit0 != digit2) {
                result = true;
            }
        }
        return result;
    }
}
