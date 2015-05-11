// Special Pythagorean triplet
// https://projecteuler.net/problem=9

#include <iostream>
using namespace std;

int main() {
	for(int a = 1; a < 333; a++) {
		int b = 1000 * (a - 500) / (a - 1000);
		int c = (-a * a + 1000 * a - 500000) / (a - 1000);
		if(b > 0 && c > 0 && (a + b + c) == 1000) {
			cout << a * b * c << endl;
			break;
		}
	}
	return 0;
}
