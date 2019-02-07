#include <iostream>
#include <vector>

using namespace std;

void solve() {
  unsigned long n;
  cin >> n;

  vector<unsigned long> first;
  first.resize((n+1)/2);

  vector<unsigned long> second;
  second.resize(n/2);

  for (unsigned long i = 0; i < n; i++) {
    unsigned long v;
    cin >> v;
    if (i % 2 == 0) {
      first[i/2] = v;
    } else {
      second[i/2] = v;
    }
  }

  sort(first.begin(), first.end());
  sort(second.begin(), second.end());

  unsigned long index;
  int flag = 0;
  for (unsigned long i = 0; i < n/2; i++) {
    if (first[i] > second[i]) {
      index = i * 2;
      flag = 1;
      break;
    }
    if ((i+1) < first.size() && second[i] > first[i+1]) {
      index = i * 2 + 1;
      flag = 1;
      break;
    }
  }

  if (flag == 1) {
    cout << index << endl;
  } else {
    cout << "OK" << endl;
  }
}

int main() {
  unsigned long n;
  cin >> n;
  for (unsigned long i = 1; i <= n; i ++) {
    cout << "Case #" << i << ": ";
    solve();
  }
  return 0;
}