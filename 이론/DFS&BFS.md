# DFS & BFS

## dfs

깊이 우선 탐색

갈 수 있는 깊이까지 갔다가 돌아와서 다음 노드 탐색

<pre><code>

static void dfs(boolean[][] matrix, int V, boolean[] visited){
    // 만약 방문한 노드면 리턴
    if(visited[V]) return;
    // 현재 노드 탐색
    visited[V] = true;
    // 현재 노드와 연결된 노드 방문
    for (int i = 0; i < matrix[V].length; i++) {
        if(matrix[V][i]) dfs(matrix, i, visited);
    }
}

</code></pre>



## bfs

넓이 우선 탐색 

자식 노드들 다 방문한 다음 자식 노드의 자식 노드 방문

<pre><code>

static void bfs(boolean[][] matrix, int V , boolean[] visited){
    Queue< Integer> queue = new LinkedList<>();

    // 현재 노드 큐에 넣음
    queue.offer(V);
    
    while(!queue.isEmpty()) {
        // 현재 노드 방문
        int current = queue.poll();
        // 만약 방문했던 노드면 넘어가기
        if(visited[current]) continue;
        // 현재 노드 방문 체크
        visited[current] = true;
        // 현재 노드의 자식노드 큐에 넣기
        for (int i = 0; i < matrix[current].length; i++) {
            if(!visited[i] && matrix[current][i]) queue.offer(i);
        }
    }
}

</code></pre>

현재 노드의 자식노드를 먼저 큐에 넣기 때문에 그 다음 노드의 자식노드는 현재노드의 자식노드를 모두 방문하고 방문하게 된다.
