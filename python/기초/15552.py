from sys import stdin as std

t = int(input())

for i in range(t):
  a, b = map(int, std.readline().rstrip().split())
  print(a+b)
