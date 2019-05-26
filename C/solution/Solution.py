def solve(n):
    global dp
    if n < 2:
        return 1
    if dp[n] == 0:
        dp[n] = solve(n-1)+solve(n-2)+1
    return dp[n] % 1000000007
    
if __name__ == '__main__':
    n = int(input(""))
    dp = [0 for _ in range(n+1)]
    print(solve(n))