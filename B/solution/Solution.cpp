#include <stdio.h>
#include <assert.h>

int main() {
    int N, M;
    scanf("%d %d", &N, &M);
    assert(2 <= N && N <= 100000);
    assert(2 <= M && M <= N);

    int count = N;
    while (N > 0) {
        count += N / M;
        N /= M;
    }

    printf("%d\n", count);
}