def char2int(ch):
    if ch == ' ':
        return 0
    if ch < 'a':
        return ord(ch) - ord('A') + 1
    return ord(ch) - ord('a') + 27
    
def solve(n,arr,s0):
    count1 = [0]*53;
    count2 = [0]*53;
    for i in range(n):
        count1[arr[i]] += 1
        count2[char2int(s0[i])] += 1
    for i in range(53):
        if count1[i] != count2[i]:
            return 'n'
    return 'y'

inputs = input("")
n = int(inputs)
inputs = input("").split(" ")
arr = [int(v) for v in inputs]
s0 = input("")

ret = solve(n,arr,s0)
print(ret)

