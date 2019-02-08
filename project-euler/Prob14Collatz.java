package projecteuler;

import java.util.Arrays;

public class Prob14Collatz {

	public static void main(String[] args) {
		long[] termCounter = new long[1000001];
		Arrays.fill(termCounter, -1);

		termCounter[0] = 0;
		termCounter[1] = 1;
		termCounter[2] = 2;

		long num = 2;
		long maxTerms = 2;
		for(int i = 3; i <= 1000000; i++) {
			termCounter[i] = collatz(i, termCounter);
			if(maxTerms < termCounter[i]) {
				num = i;
				maxTerms = termCounter[i];
			}
		}
		
		System.out.println(num);
	}
	
	private static long collatz(long original, long[] termCounter) {
		if(original < termCounter.length && termCounter[(int)original] != -1) {
			return termCounter[(int)original];
		}

		long terms = 1;
		if(original % 2 == 0) {
			terms += collatz(original / 2, termCounter);
		} else {
			terms += collatz(3 * original + 1, termCounter);
		}
		
		if(original < termCounter.length) {
			termCounter[(int)original] = terms;
		}
		return terms;
	}

}
