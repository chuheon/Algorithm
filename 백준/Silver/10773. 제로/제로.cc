#include <bits/stdc++.h>
#include <stack>

using namespace std;

int main() {
  cin.tie(0) ->sync_with_stdio(false);
  int n, sum;
  sum = 0 ;
  cin >> n;
  stack <int> st;
  for(int i=0;i<n;i++){
    int x;
    cin >> x;
    if(x == 0){
      sum -= st.top();
      st.pop();
    }
    else {
      st.push(x);
      sum+=x;
    }
  }
  cout<< sum;
  return 0;

  
}