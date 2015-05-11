// Multiples of 3 and 5
// https://projecteuler.net/problem=1

#include <iostream>
using namespace std;

int sumOfMultiplesOf3() {
	int count = 999/3;
	return 3 * count * (count + 1) / 2;
}

int sumOfMultiplesOf5() {
	int count = 999/5;
	return 5 * count * (count + 1) / 2;
}

int sumOfMultiplesOf15() {
	int count = 999/15;
	return 15 * count * (count + 1) / 2;
}

int main() {
	cout << sumOfMultiplesOf3() + sumOfMultiplesOf5() - sumOfMultiplesOf15() << endl;
	return 0;
}