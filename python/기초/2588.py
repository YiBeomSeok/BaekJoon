a = int(input())
b = int(input())
sum = 0
i = 0

while(i<=2):
  temp = a*(b%10)
  print(temp)
  sum += (temp * (10 ** i))
  b = int(b/10)
  i += 1
  
print(sum)