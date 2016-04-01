package me.suresh301190.math;

import java.util.ArrayList;
import java.util.Iterator;

public class Primes {
	
	static ArrayList<Integer> prime;
	
	void setPrime(int num) {
		// TODO Auto-generated method stub
		for(int i=3; i < num;i++){
			isPrime(i);
		}
	}

	boolean isPrime(int num){
		int sqrt = (int) Math.ceil(Math.sqrt(num)), n;
		for(Iterator<Integer> iter = prime.iterator(); iter.hasNext();){
			n = iter.next();
			if(n > sqrt) break;
			else if((num%n) == 0) return false;
		}
		prime.add(num);
		return true;
	}
}
