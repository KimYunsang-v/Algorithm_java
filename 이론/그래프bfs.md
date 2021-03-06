# 그래프 최댄 거리 구하기

## bfs로 구하기

1. 노드가 이어져있는지 확인할 수 있는 배열 만들기
2. 처음 방문할 노드를 큐에 넣는다
3. 다음 방문 할 노드가 없을 때 까지 while loop 돌기
4. while loop 안에서 큐가 빌 때 가지 while loop 돌기
5. 큐에서 poll 한 노드에서 다음 노드 찾는다.
6. 방문한 적이 없고 연결이 되어있으면 다음 노드리스트에 추가 -> 방문 체크

<pre><code>

        boolean[] visit = new boolean[n+1];
        boolean[][] connect = new boolean[n+1][n+1];

        // 노드 연결여부 매트릭스
        for(int i = 0; i < edge.length; i++) {
            connect[edge[i][0]][edge[i][1]] = connect[edge[i][1]][edge[i][0]] = true;
        }

        Queue< Integer> queue = new LinkedList<>();
        List< Integer> nextNodes = new ArrayList<>();

        // 1번 노드 부터
        queue.add(1);
        visit[0] = visit[1] = true;
        while(true) {
            // 현재 답은 다음에 방문 할 노드의 갯수
            answer = queue.size();
            while(!queue.isEmpty()) {
                int node = queue.poll();
                for(int j = 1; j <= n; j++) {
                    // 방문 안했고 연결되어있으면
                    if(!visit[j] && connect[node][j]) {
                        // 다음 노드 추가
                        nextNodes.add(j);
                        // 방문
                        visit[j] = true;
                    }
                    
                }
            }
            
            // 다음 방문 할 노드가 없으면 break;
            if(nextNodes.isEmpty()) {
                break;
            }
            // 큐에 다음 노드들 add all
            queue.addAll(nextNodes);
            // 다음 노드 클리어
            nextNodes.clear();
        }

</code></pre>