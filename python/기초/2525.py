hour, minute = map(int, input().split())
amount = int(input())
minute += amount
while minute>=60:
  minute -= 60
  hour += 1
while hour>=24:
  hour -= 24

print(hour,minute)