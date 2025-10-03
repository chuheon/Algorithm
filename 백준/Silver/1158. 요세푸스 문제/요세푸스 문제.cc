#include <bits/stdc++.h>
#include <stack>

using namespace std;

int main() {
  cin.tie(0) ->sync_with_stdio(false);

  int N,k, y;
  cin >> N >> k ;
  queue<int> q, el;
  cout << '<';
  for(int i=1;i<=N;i++) q.push(i);
  while(q.size()>1){
    for(int j = 0; j<k-1;j++){
      q.push(q.front());
      q.pop();
    }
    y = q.front();
    q.pop();
    cout << y << ", ";
  }
  cout << q.front() << '>';
  
} 

