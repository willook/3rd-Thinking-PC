#include <stdio.h>
#include <assert.h>

const int MOD = 1000000007;

int fibo[51];

int main() {
    int N;
    scanf("%d", &N);
    assert(0 <= N && N <= 50);

    fibo[0] = 1;
    fibo[1] = 1;
    for (int i = 2; i <= N; i++)
        fibo[i] = (fibo[i - 1] + fibo[i - 2] + 1) % MOD;

    printf("%d\n", fibo[N]);
}
