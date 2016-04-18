// Sum square difference
// https://projecteuler.net/problem=6

#include <iostream>
using namespace std;

int main() {
	int sum = 0;
	for(int i = 1; i <= 100; i++) {
		for(int j = i + 1; j <= 100; j++) {
			sum += i * j;
		}
	}
	sum *= 2;
	cout << sum << endl;
	return 0;
}
