package me.suresh301190.math;

public class Modulas {

	long modpow(long base, long exp, long modulus) {
		base %= modulus;
		long result = 1;
		while (exp > 0) {
			if ((exp&1) == 1) result = (result * base) % modulus;
			base = (base * base) % modulus;
			exp >>= 1;
		}
		return result;
	}
	
	static long inv(long n, long mod){
		long in = 1L;
		for(long i=mod - 2;i > 0;i>>=1){
			if((i&1)==1){
				in = (in*n)%mod;
			}
			n = (n*n)%mod;
		}		
		return in;
	}

}
