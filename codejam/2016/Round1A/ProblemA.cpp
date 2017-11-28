#include <iostream>
#include <string>
#include <sstream>

using namespace std;

void solve() {
  string s;
  cin >> s;
  string o;
  for(string::iterator it = s.begin(); it != s.end(); ++it) {
    if (o.size() > 0 && o[0] > *it) {
      o.insert(o.end(), *it);
    } else {
      o.insert(o.begin(), *it);
    }
  }
  cout << o << endl;
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
