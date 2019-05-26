def solve(TC,m,l,slices,query):
    ret = [0 for _ in range(TC)]
    for tc in range(TC):
        n = query[tc]
        left = 0
        right = l
        mid = (left+right)//2
        while left+1 < right:
            det = isSlices(n,m,l,slices,mid)
            if det:
                left = mid
            else:
                right = mid-1;
            mid = (left+right)//2
        if isSlices(n,m,l,slices,right):
            ret[tc] = right
        else:
            ret[tc] = left
            
    return ret
            
def isSlices(n,m,l,slices,mid):
    k=0;
    block = mid;
    for i in range(m):
        if slices[i] < block:
            continue
        if slices[i] + mid > l:
            break
        block = slices[i] + mid;
        k = k+1
    return n <= k

if __name__ == '__main__':
    n,m,l = map(int, input().split())
    slices = [0 for _ in range(m)]
    query = [0 for _ in range(n)]
    
    for i in range(m):
        slices[i] = int(input())
    for i in range(n):
        query[i] = int(input())
    ret = solve(n,m,l,slices,query)
    for i in range(n):
        print(ret[i])
    
