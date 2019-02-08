package projecteuler;

import java.math.BigInteger;

public class Prob15PascalTriangle {

	public static void main(String[] args) {
		String num = "10715086071862673209484250490600018105614048117055336074437503883703510511249361224931983788156958581275946729175531468251871452856923140435984577574698574803934567774824230985421074605062371141877954182153046474983581941267398767559165543946077062914571196477686542167660429831652624386837205668069376";
		long total = 0;
		for(int i = 0; i < num.length(); i++) {
			total += Character.digit(num.charAt(i), 10);
		}
		System.out.println(total);
		BigInteger sum = BigInteger.ONE;
		for(int i = 1; i <= 40; i++) {
			System.out.println(i + ": " + sum.toString());
			sum = sum.multiply(BigInteger.valueOf(40 - i + 1));
			sum = sum.divide(BigInteger.valueOf(i));
		}
		System.out.println(sum.toString());
	}
}
