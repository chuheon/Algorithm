#include <bits/stdc++.h>
using namespace std;

int T, N, M, K, cnt, X, Y;
int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };
vector <vector<int>> m;
vector <vector<bool>> check;

void DFS(int y, int x)
{
   for (int k = 0; k < 4; k++)
   {
      int xx = x + dx[k];
      int yy = y + dy[k];
      if (xx < 0 || xx >= M || yy < 0 || yy >= N || check[yy][xx] || m[yy][xx] != 1)
         continue;
      check[yy][xx] = true;
      DFS(yy, xx);
   }
}

int main(void)
{
   cin.tie(0)->sync_with_stdio(false);

   cin >> T;

   for (int t = 0; t < T; t++)
   {
      cin >> M >> N >> K;

      cnt = 0;
      m = vector<vector<int>>(N, vector<int>(M, 0));
      check = vector<vector<bool>>(N, vector<bool>(M, false));

      for (int k = 0; k < K; k++)
      {
         cin >> X >> Y;
         m[Y][X] = 1;
      }

      for (int i = 0; i < N; i++)
      {
         for (int j = 0; j < M; j++)
         {
            if (!check[i][j] && m[i][j] == 1)
            {
               check[i][j] = true;
               DFS(i, j);
               cnt++;
            }
         }
      }

      cout << cnt << '\n';
   }

   return 0;
}