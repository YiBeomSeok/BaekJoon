A, B, V = map(int, input().split())

# V를 A - B로 나눈 나머지는 항상 A보다 작다
# 일단 V에서 A를 빼서 나온 값이 0이 아닌 한 최소 하루는 가야한다.
# V에서 A를 빼고 남은 값을 A - B로 나누었을 때의 몫 + (나머지가 있을경우 + 1)이 답이 된다.
if (V-A) % (A-B) != 0:
  print(int((V-A)/(A-B)) + 2)
else:
  print(int((V-A)/(A-B)) + 1)
