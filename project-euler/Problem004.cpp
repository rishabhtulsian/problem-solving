// Largest palindrome product
// https://projecteuler.net/problem=4

#include <iostream>
using namespace std;

bool isPalindrome(int num) {
	int p = 0, n = num;
	while(n > 0) {
		p *= 10;
		p += (n % 10);
		n /= 10;
	}
	return p == num;
}

int main() {
	int a = 999, b = 1;
	int lp = 0;
	while(a >= 100) {
		if(a % 11 == 0) {
			b = 999;
			while(b >= a) {
				int product = a * b;
				if(isPalindrome(product) && product > lp) {
					lp = product;
				}
				b--;
			}
		} else {
			b = 990;
			while(b >= a) {
				int product = a * b;
				if(isPalindrome(product) && product > lp) {
					lp = product;
				}
				b -= 11;
			}
		}
		a--;
	}
	cout << lp << endl;
	return 0;
}
