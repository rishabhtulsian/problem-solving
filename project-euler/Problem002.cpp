// Even Fibonacci numbers
// https://projecteuler.net/problem=2

#include <iostream>
using namespace std;

int main() {
	int prev1 = 1, prev2 = 1, curr = 2;
	int sum = 0;
	for(int i = 0; curr < 4000000; i++) {
		if(i % 3 == 0) {
			sum += curr;
		}
		prev1 = prev2;
		prev2 = curr;
		curr = prev1 + prev2;
	}

	cout << sum << endl;
	return 0;
}