// 10001st prime
// https://projecteuler.net/problem=7

#include <iostream>
#include <cmath>
using namespace std;

bool isPrime(long num) {
	if(num == 2 || num == 3 || num == 5 || num == 7) {
		return true;
	}
	if(num % 2 == 0) {
		return false;
	}
	long root = (long) sqrt(num);
	for(long i = 3; i <= root; i += 2) {
		if(num % i == 0) {
			return false;
		}
	}
	return true;
}

int main() {
	int i = 6;
	long n = 13;
	while (i < 10001) {
		n++;
		if(isPrime(n)) {
			i++;
		}
	}
	cout << i << endl;
	cout << n << endl;
	return 0;
}
