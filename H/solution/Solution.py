
def solve(n,m,s1, s2):
    inf = 1000000
    x = [ord(s1[i]) for i in range(n)]
    y = [ord(s2[i]) for i in range(m)]
    assert len(x)
    assert len(y)
    r, c = len(x), len(y)
    D0 = [[0 for _ in range(len(y)+1)] for _ in range(len(x)+1)]

    D0[0][1:] = [inf for _ in range(len(y))]
    for i in range(1,r+1):
        D0[i][0] = inf

    for i in range(r):
        for j in range(c):
            D0[i+1][j+1] = abs(x[i]-y[j])

    for i in range(r):
        for j in range(c):
            min_list = [D0[i][j]]
            #for k in range(1, 2):
            i_k = min(i + 1, r)
            j_k = min(j + 1, c)
            min_list += [D0[i_k][j], D0[i][j_k]]
            D0[i+1][j+1] += min(min_list)
  
    return D0[-1][-1]

if __name__ == '__main__':
    
    n, m = map(int, input("").split())
    s1 = input("")
    s2 = input("")
    ret = solve(n, m, s1, s2)
    print(ret)