// Smallest multiple
// https://projecteuler.net/problem=5

#include <iostream>
using namespace std;

int main() {
	int a[20];
	for(int i = 0; i < 20; i++) {
		a[i] = i + 1;
	}
	long num = 1;
	for(int i = 0; i < 20; i++) {
		num *= a[i];
		for(int j = i + 1; j < 20; j++) {
			if(a[j] % a[i] == 0) {
				a[j] /= a[i];
			}
		}
	}
	cout << num << endl;
	return 0;
}
