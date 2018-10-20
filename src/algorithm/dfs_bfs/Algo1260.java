package algorithm.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Algo1260 {

    static int[][] mat;
    static boolean visited[];
    static int N, M, V;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        mat = new int [10001][10001];
        M = scanner.nextInt();
        visited = new boolean[10001];
        V = scanner.nextInt();

        int a,b;

        for(int i = 1; i <= M; i++){
            a = scanner.nextInt();
            b = scanner.nextInt();

            mat[a][b] = mat[b][a] = 1;
        }

        dfs(V);

        for(int j =1; j<=N; j++){
            visited[j] = false;
        }
        System.out.println();

        bfs(V);
    }

    public static void dfs(int i){
        visited[i] = true;
        System.out.print(i+" ");

        for(int j=1; j<=N; j++){
            if(mat[i][j]==1&& visited[j]==false){
                dfs(j);
            }
        }
    }

    public static void bfs(int i){

        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(i);
        visited[i] = true;
        System.out.print(i+" ");

        int temp;
        while(!q.isEmpty()){
            temp = q.poll();
            for(int j=0; j<N+1; j++){
                if(mat[temp][j]==1&&visited[j]==false){
                    q.offer(j);
                    visited[j]=true;
                    System.out.print(j+" ");
                }
            }
        }

    }

}
