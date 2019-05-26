#include <stdio.h>
#include <assert.h>
#include <algorithm>
using namespace std;

const int MAX = 2147483647;

int dist[10][10];
bool visited[10];
int N, K;
int answer = MAX;

void dfs(int n, int u, int cost) {
    if (n == N) {
        answer = min(answer, cost);
        return;
    }

    for (int v = 0; v < N; v++) {
        if (visited[v])
            continue;

        visited[v] = true;
        dfs(n + 1, v, cost + dist[u][v]);
        visited[v] = false;
    }
}

int main() {
    scanf("%d %d", &N, &K);
    assert(2 <= N && N <= 10);
    assert(0 <= K && K < N);

    for (int u = 0; u < N; u++) {
        for (int v = 0; v < N; v++) {
            int T;
            scanf("%d", &T);
            assert(0 <= T && T <= 1000);
            if (u == v)
                assert(T == 0);

            dist[u][v] = T;
        }
    }

    for (int k = 0; k < N; k++)
        for (int u = 0; u < N; u++)
            for (int v = 0; v < N; v++)
                dist[u][v] = min(dist[u][v], dist[u][k] + dist[k][v]);

    dfs(0, K, 0);
    printf("%d\n", answer);
    return 0;
}
