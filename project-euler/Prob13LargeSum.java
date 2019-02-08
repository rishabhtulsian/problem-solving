package projecteuler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Prob13LargeSum {

	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			BigInteger sum = BigInteger.ZERO;
			for (int i = 0; i < 100; i++) {
				String s = reader.readLine();
				String sub = s.substring(0, 12);
				sum = sum.add(new BigInteger(sub));
			}
			
			System.out.println(sum.toString());
			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
