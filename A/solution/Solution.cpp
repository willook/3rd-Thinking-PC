#include <stdio.h>
#include <assert.h>
#include <set>
using namespace std;

set<int> k_set;
bool check[1001];

int main() {
    int N, K;
    scanf("%d %d", &N, &K);
    assert(2 <= N && N <= 1000);
    assert(1 <= K && K < N);

    int prev = 0;
    for (int i = 0; i < K; i++) {
        int k;
        scanf("%d", &k);
        assert(2 <= k && k <= 1000);
        assert(prev < k);
        assert(k_set.find(k) == k_set.end());
        k_set.insert(k);
        prev = k;

        for (int j = k; j <= N; j += k)
            check[j] = true;
    }

    int sum = 0;
    for (int i = 2; i <= N; i++)
        if (check[i])
            sum += i;

    printf("%d\n", sum);
    return 0;
}

