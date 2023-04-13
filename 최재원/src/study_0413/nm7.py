N, M = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()
# print(arr)

# from itertools import permutations
# from itertools import combinations
from itertools import product

# p = permutations(arr, M)
# c = combinations(arr, M)
s = product(arr, repeat=M)
# print(list(s))
for i in s:
    str = ""
    for j in i:
        print(j, end=' ')
        # str += str(j) + " "
    print()