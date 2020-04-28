# Flood fill

주어진 시작점으로부터 연결된 영역들을 찾아내는 알고리즘

ex) 그림판에서 페인트통 들이붓기(다른 색이 나올때까지 같은 색을 모두 칠함), 기계가 본인 주위영역을 레이더처럼 검색하여 목적지를 찾는 길찾기 기능


<pre><code>

// Java program to implement flood fill algorithm 
class GFG 
{ 
  
// 배열 크기
static int M = 8; 
static int N = 8; 

// prevC -> newC 로 바꾸는 코드
// 만약 현재 색깔이 prevC 이면 newC 로 교체
static void floodFillUtil(int screen[][], int x, int y,  
                                    int prevC, int newC) 
{ 
    // 행렬의 범위에서 벗어나면 리턴
    if (x < 0 || x >= M || y < 0 || y >= N) 
        return; 
    // 현재 값이 바꾸기 원하는 색깔이 아니면 리턴
    if (screen[x][y] != prevC) 
        return; 
  
    // 현재 색깔 변경
    screen[x][y] = newC; 
  
    // 상, 하, 좌, 우 재귀 호출
    floodFillUtil(screen, x+1, y, prevC, newC); 
    floodFillUtil(screen, x-1, y, prevC, newC); 
    floodFillUtil(screen, x, y+1, prevC, newC); 
    floodFillUtil(screen, x, y-1, prevC, newC); 
} 
  
// 재귀함수 호출
static void floodFill(int screen[][], int x, int y, int newC) 
{ 
    int prevC = screen[x][y]; 
    floodFillUtil(screen, x, y, prevC, newC); 
}

// Driver code 
public static void main(String[] args)  
{ 
    int screen[][] = {{1, 1, 1, 1, 1, 1, 1, 1}, 
                    {1, 1, 1, 1, 1, 1, 0, 0}, 
                    {1, 0, 0, 1, 1, 0, 1, 1}, 
                    {1, 2, 2, 2, 2, 0, 1, 0}, 
                    {1, 1, 1, 2, 2, 0, 1, 0}, 
                    {1, 1, 1, 2, 2, 2, 2, 0}, 
                    {1, 1, 1, 1, 1, 2, 1, 1}, 
                    {1, 1, 1, 1, 1, 2, 2, 1}, 
                    }; 
    int x = 4, y = 4, newC = 3; 
    floodFill(screen, x, y, newC); 
  
    System.out.println("Updated screen after call to floodFill: "); 
    for (int i = 0; i < M; i++) 
    {
        for (int j = 0; j < N; j++) 
        System.out.print(screen[i][j] + " "); 
        System.out.println(); 
    } 
    } 
} 


</code></pre>