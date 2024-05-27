"""
[문제2] 시각: 문제 설명
정수 N이 입력되면 00시 00분 00초부터 N시 59분 59초까지의 모든 시각 중에서
3이 하나라도 포함되는 모든 경우의 수를 구하는 프로그램을 작성하세요.
예를 들어 1을 입력했을 때 다음은 3이 하나라도 포함되어 있으므로 세어야 하는 시각입니다.
00시 00분 03초
00시 13분 30초
이러한 유형은 완전 탐색(Brute Forcing) 문제 유형이라고 불립니다.
가능한 경우의 수를 모두 검사해보는 탐색 방법을 의미합니다.

1. 아이디어
이동에 따른 변화량 정의
dx = [0, 0, -1, 1]  # L, R, U, D
dy = [-1, 1, 0, 0]  # L, R, U, D
2. 시간복잡도
O(n)

3. 자료구조

"""
n = int(input("시간 입력:"))
count = 0

for hour in range(n + 1):
    for minute in range(60):
        for second in range(60):
            # 현재 시각에서 '3'이 포함되어 있는지 확인
            if '3' in f"{hour:02d}{minute:02d}{second:02d}":
                count += 1
print(count)