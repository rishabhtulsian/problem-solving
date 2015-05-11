// Summation of primes
// https://projecteuler.net/problem=10

#include <iostream>
#include <cmath>
#include <list>
using namespace std;

list<long> primes;

bool isPrime(long num) {
	if(num == 2 || num == 3 || num == 5 || num == 7) {
		return true;
	}
	if(num % 2 == 0) {
		return false;
	}
	long root = (long) sqrt(num);
	for (list<long>::iterator it = primes.begin(); (*(it)) <= root && it != primes.end(); it++) {
		if(num % (*it) == 0) {
			return false;
		}
	}
	primes.push_back(num);
	return true;
}

int main() {
    double duration;
	clock_t start = clock();

	for(int i = 0; i < 100; i++) {
		list<long> empty;
		swap(primes, empty);

		primes.push_back(2);
		primes.push_back(3);
		primes.push_back(5);
		primes.push_back(7);
		long sum = 0;
		for(long i = 2; i < 2000000L; i++) {
			if(isPrime(i)) {
				sum += i;
			}
		}
		cout << sum << endl;
	}

	duration = ( std::clock() - start ) / (double) CLOCKS_PER_SEC;
	cout << duration << endl;
	return 0;
}
