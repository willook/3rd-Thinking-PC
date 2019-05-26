#include <stdio.h>
#include <assert.h>
#include <algorithm>
using namespace std;

const int MAX = 2147483647;

int dy[] = { -1, 0, 1, 0 };
int dx[] = { 0, 1, 0, -1 };

int table[51][51];
int dp[51][51][3];
int N, M;
int answer = MAX;

void dfs(int y, int x, int letter, int count) {
    if (dp[y][x][letter] <= count)
        return;
    dp[y][x][letter] = count;

    for (int i = 0; i < 4; i++) {
        int ny = y + dy[i];
        int nx = x + dx[i];
        if (ny < 0 || ny >= N || nx < 0 || nx >= M)
            continue;

        if (letter == 0 && table[ny][nx] >= 14)
            dfs(ny, nx, 1, count + 1);
        if (letter == 1 && table[ny][nx] <= 13) {
            dfs(ny, nx, 2, count);
            dfs(ny, nx, 0, count);
        }
        if (letter == 2 && table[ny][nx] <= 13)
            dfs(ny, nx, 0, count);
    }
}

int main() {
    scanf("%d %d", &N, &M);
    assert(4 <= N && N <= 50);
    assert(4 <= M && M <= 50);

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            int n;
            scanf("%d", &n);
            assert(0 <= n && n <= 34);

            table[i][j] = n;
            for (int k = 0; k < 3; k++)
                dp[i][j][k] = MAX;
        }
    }

    if (table[0][0] <= 13)
        dfs(0, 0, 0, 0);

    int answer = min(dp[N - 1][M - 1][1], dp[N - 1][M - 1][2]);
    if (answer == MAX)
        printf("BAD\n");
    else
        printf("%d\n", answer);

    return 0;
}
