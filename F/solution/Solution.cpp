#include <iostream>
#include <assert.h>
#include <string>
#include <stack>
#include <set>
#include <algorithm>
using namespace std;

typedef struct Ticket {
    char letter;
    int number;
} Ticket;

bool comp(const Ticket &a, const Ticket &b) {
    if (a.letter == b.letter)
        return (a.number < b.number);
    return (a.letter < b.letter);
}

Ticket origin[500];
Ticket tickets[500];

int main() {
    int N;
    cin >> N;
    assert(1 <= N && N <= 100);
    N *= 5;

    set<string> t_set;
    for (int i = 0; i < N; i++) {
        string s;
        cin >> s;
        char letter = s.substr(0, 1)[0];
        int number = stoi(s.substr(2, s.size() - 2));
        assert(t_set.find(s) == t_set.end());
        assert('A' <= letter && letter <= 'Z');
        assert(1 <= number && number <= 999);
        assert(s[1] == '-');
        t_set.insert(s);

        origin[i].letter = letter;
        origin[i].number = number;
        tickets[i].letter = letter;
        tickets[i].number = number;
    }
    sort(tickets, tickets + N, comp);

    stack<Ticket> stk;
    int idx = 0;
    for (int i = 0; i < N; i++) {
        if (origin[i].letter == tickets[idx].letter && origin[i].number == tickets[idx].number) {
            idx++;
            continue;
        }
        while (!stk.empty()) {
            if (stk.top().letter != tickets[idx].letter || stk.top().number != tickets[idx].number)
                break;
            idx++;
            stk.pop();
        }

        stk.push(origin[i]);
    }

    while (!stk.empty()) {
        if (stk.top().letter != tickets[idx].letter || stk.top().number != tickets[idx].number) {
            cout << "BAD\n";
            return 0;
        }

        idx++;
        stk.pop();
    }

    cout << "GOOD\n";
    return 0;
}
