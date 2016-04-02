package me.suresh301190.math;

import java.util.ArrayList;
import java.util.Iterator;

public class Primes {

    static ArrayList<Integer> primes;

    void setPrime(int num) {
        for (int i = 3; i < num; i++) {
            isPrime(i);
        }
    }

    private boolean isPrime(int num) {
        int sqrt = (int) Math.ceil(Math.sqrt(num)), n;
        for (Integer prime : primes) {
            n = prime;
            if (n > sqrt) break;
            else if ((num % n) == 0) return false;
        }
        primes.add(num);
        return true;
    }
}
