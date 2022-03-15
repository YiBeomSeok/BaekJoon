
n = int(input())

m = 1
while(n > m):
  n -= m
  m += 1

if m % 2 == 0:
  print(f"{n}/{m - n + 1}")
else:
  print(f"{m - n + 1}/{n}")