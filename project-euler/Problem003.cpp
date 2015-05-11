// Largest prime factor
// https://projecteuler.net/problem=3

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
	long n = 600851475143;
	long root = (long) sqrt(n);
	long factor = 0;
	for(long i = 3; i <= root; i += 2) {
		if(n % i == 0 && isPrime(i)) {
			factor = i;
		}
	}
	cout << factor << endl;
	return 0;
}
