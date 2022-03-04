n1, n2, n3 = map(int, input().split())
dic = {}

dic[n1] = 1

if n2 in dic:
  dic[n2] += 1
else:
  dic[n2] = 1
  
if n3 in dic:
  dic[n3] += 1
else:
  dic[n3] = 1

price = 0
max = n1
for key in dic:
  if dic[key] == 3:
    price = 10000 + key*1000
    break
  elif dic[key] == 2:
    price = 1000 + key*100
    break
  if key > max: max = key

if price == 0: price = max * 100

print(price)

  