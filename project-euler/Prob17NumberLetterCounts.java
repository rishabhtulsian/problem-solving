package projecteuler;

import java.util.HashMap;
import java.util.Map;

public class Prob17NumberLetterCounts {

	public static void main(String[] args) {
		Map<Integer, String> word = new HashMap<Integer, String>();
		word.put(1, "one");
		word.put(2, "two");
		word.put(3, "three");
		word.put(4, "four");
		word.put(5, "five");
		word.put(6, "six");
		word.put(7, "seven");
		word.put(8, "eight");
		word.put(9, "nine");
		word.put(10, "ten");
		word.put(11, "eleven");
		word.put(12, "twelve");
		word.put(13, "thirteen");
		word.put(14, "fourteen");
		word.put(15, "fifteen");
		word.put(16, "sixteen");
		word.put(17, "seventeen");
		word.put(18, "eighteen");
		word.put(19, "nineteen");
		word.put(20, "twenty");
		word.put(30, "thirty");
		word.put(40, "forty");
		word.put(50, "fifty");
		word.put(60, "sixty");
		word.put(70, "seventy");
		word.put(80, "eighty");
		word.put(90, "ninety");
		
		long lengthHundred = "hundred".length();
		long lengthAnd = "and".length();
		long lengthOneThousand = "onethousand".length();

		long totalLetters = 0;
		for(int i = 1; i <= 1000; i++) {
			int number = i;
			int sum = 0;
			if(number == 1000) {
				totalLetters += lengthOneThousand;
				System.out.println("one thousand " + lengthOneThousand);
				continue;
			}
			if(number >= 100) {
				int hundredDigit = number / 100;
				sum += word.get(hundredDigit).length();
				sum += lengthHundred;
				number = number % 100;
				System.out.print(word.get(hundredDigit) + " hundred");
				if(number > 0) {
					sum += lengthAnd;
					System.out.print(" and ");
				}
			}
			if(number >= 20) {
				int tenDigit = number / 10;
				sum += word.get(tenDigit * 10).length();
				number = number % 10;
				System.out.print(word.get(tenDigit * 10));
				if(number > 0) {
					System.out.print("-");
				}
			}
			if(number > 0) {
				sum += word.get(number).length();
				System.out.println(word.get(number) + " " + sum);
			}
			else {
				System.out.println(" " + sum);
			}
			totalLetters += sum;
			if(i %10 == 0) {
				System.out.println(totalLetters);
			}
		}
		
		System.out.println(totalLetters);
	}

}
