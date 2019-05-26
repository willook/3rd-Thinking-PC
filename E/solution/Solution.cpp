#include <stdio.h>
#include <assert.h>
#include <algorithm>
using namespace std;

int side[3];

int main() {
    scanf("%d %d %d", &side[0], &side[1], &side[2]);
    assert(1 <= side[0] && side[0] <= 100);
    assert(1 <= side[1] && side[1] <= 100);
    assert(1 <= side[2] && side[2] <= 100);

    sort(side, side + 3);
    int a = side[0];
    int b = side[1];
    int c = side[2];

    // (ab)^2 + 2abcd + (cd)^2 = (c^2 - a^2)(c^2 - b^2)
    for (long long d = 1; d <= c; d++) {
        int left = ((a * b) * (a * b)) + (2 * a * b * c * d) + ((c * d) * (c * d));
        int right = ((c * c) - (a * a)) * ((c * c) - (b * b));

        if (left == right) {
            printf("%d\n", d);
            return 0;
        }
    }

    printf("-1\n");
    return 0;
}
