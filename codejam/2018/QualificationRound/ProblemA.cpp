#include <iostream>

using namespace std;

void solve() {
  unsigned long D;
  string P;
  cin >> D;
  cin >> P;

  unsigned long c = 1;
  unsigned long d = 0;
  int shots = 0;

  for(string::iterator it = P.begin(); it != P.end(); ++it) {
    if (*it == 'C') {
      c *= 2;
    } else {
      d += c;
      shots++;
    }
  }

  int h = 0;
  if (D < shots) {
    h = -1;
  } else {
    int s = 0;
    for (string::reverse_iterator rit = P.rbegin(); rit != P.rend() && d > D; ++rit) {
      if (*rit == 'C') {
        c /= 2;
        for (int i = 0; i < s && d > D; i++) {
          d -= c;
          h++;
        }
      } else {
        s++;
      }
    }
  }

  if (h >= 0) {
    cout << h << endl;
  } else {
    cout << "IMPOSSIBLE\n";
  }
}

int main() {
  int n;
  cin >> n;
  for (int i = 1; i <= n; i ++) {
    printf("Case #%d: ", i);
    solve();
  }
  return 0;
}