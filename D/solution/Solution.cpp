#include <iostream>
#include <assert.h>
using namespace std;

int encode[53];
int decode[53];

int main() {
    int N;
    cin >> N;
    assert(1 <= N && N <= 100000);

    for (int i = 0; i < N; i++) {
        int n;
        cin >> n;
        assert(0 <= n && n <= 52);

        encode[n]++;
    }

    cin.ignore();
    string line;
    getline(cin, line);

    for (int i = 0; i < N; i++) {
        assert(line[i] == ' ' || ('a' <= line[i] && line[i] <= 'z') || ('A' <= line[i] && line[i] <= 'Z'));

        if (line[i] == ' ')
            decode[0]++;
        else if ('A' <= line[i] && line[i] <= 'Z')
            decode[line[i] - 'A' + 1]++;
        else
            decode[line[i] - 'a' + 27]++;
    }

    for (int i = 0; i < 53; i++) {
        if (encode[i] != decode[i]) {
            cout << "n\n";
            return 0;
        }
    }

    cout << "y\n";
    return 0;
}
