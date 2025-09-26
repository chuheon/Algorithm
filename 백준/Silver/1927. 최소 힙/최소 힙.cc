#include <bits/stdc++.h>
using namespace std;

int main() {
  cin.tie(0)->sync_with_stdio(false);
  priority_queue <int, vector<int>, greater<int>> pq;
  int N;
  cin >> N;
  for(int i=0; i < N; i++){
    int x;
    cin >> x;
    if(x !=0) pq.push(x);
    else{
      if(pq.empty()) cout << 0 << "\n";
      else{
        cout << pq.top() << "\n";
        pq.pop();
      }
    }
  }
}