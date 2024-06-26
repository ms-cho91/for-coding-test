import heapq
import sys
INF = int(1e9) # 무한을 의미하는 값으로 10억을 설정

# 노드의 개수, 간선의 개수를 입력받기
# n, m = map(int, input().split())
n=5
m=7

# 2차원 리스트(그래프 표현)를 만들고, 모든 값을 무한으로 초기화
graph = [[INF] * (n + 1) for _ in range(n + 1)]

# 자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
for a in range(1, n + 1):
    for b in range(1, n + 1):
        if a == b:
            graph[a][b] = 0

ab = [
    [1, 2],
    [1, 3],
    [1, 4],
    [2, 4],
    [3, 4],
    [3, 5],
    [4, 5]
]

# # 각 간선에 대한 정보를 입력 받아, 그 값으로 초기화
# 양방향 간선 추가
# for _ in range(m):
#     # A와 B가 서로에게 가는 비용은 1이라고 설정
#     a, b = map(int, input().split())
#     graph[a][b] = 1
#     graph[b][a] = 1

# 각 간선에 대한 정보를 입력 받아, 그 값으로 초기화
for i in ab:
    # A와 B가 서로에게 가는 비용은 1이라고 설정
    graph[i[0]][i[1]] = 1
    graph[i[1]][i[0]] = 1

# 거쳐 갈 노드 X와 최종 목적지 노드 K를 입력받기
# x, k = map(int, input().split())
x = 4
k = 5

# 점화식에 따라 플로이드 워셜 알고리즘을 수행
for k in range(1, n + 1):
    for a in range(1, n + 1):
        for b in range(1, n + 1):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])

# 수행된 결과를 출력
distance = graph[1][k] + graph[k][x]

# 도달할 수 없는 경우, -1을 출력
if distance >= 1e9:
    print("-1")
# 도달할 수 있다면, 최단 거리를 출력
else:
    print(distance)