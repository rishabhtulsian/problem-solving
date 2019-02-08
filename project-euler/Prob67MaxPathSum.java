package projecteuler;

import java.io.BufferedReader;
import java.io.FileReader;

public class Prob67MaxPathSum {

	public static void main(String[] args) {
		int[][] numbers = new int[100][];

		try {
			BufferedReader reader = new BufferedReader(new FileReader("/Users/rishabhtulsian/Desktop/workspace/projecteuler/p067_triangle.txt"));
			for(int i = 0; i < 100; i++) {
				String[] numberLine = reader.readLine().split(" ");
				numbers[i] = new int[numberLine.length];
				for(int j = 0; j < numberLine.length; j++) {
					numbers[i][j] = Integer.parseInt(numberLine[j]);
				}
			}
			reader.close();
		} catch(Exception ex) {
			
		}
		
		for(int i = numbers.length - 2; i >= 0; i--) {
			for(int j = 0; j < numbers[i].length; j++) {
				int left = numbers[i][j] + numbers[i+1][j];
				int right = numbers[i][j] + numbers[i+1][j+1];
				if(left > right) {
					numbers[i][j] = left;
				} else {
					numbers[i][j] = right;
				}
			}
		}
		System.out.println(numbers[0][0]);
	}
}
