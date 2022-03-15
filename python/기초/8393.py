import sys
sys.setrecursionlimit(10**8)

def fac(n):
  if n == 0:
    return 0
  return n + fac(n-1)

n = int(input())
print(fac(n))
