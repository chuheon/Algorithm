#include <bits/stdc++.h>

using namespace std;



int main(void) {
    cin.tie(0) -> sync_with_stdio(false);
    int t;
    string a;
    cin >> t;
    for(int i=0; i<t;i++){
        cin >> a;
        cout << a[0] << a[a.size()-1] << '\n';
    }
    return 0;
}
