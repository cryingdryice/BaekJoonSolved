import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N, M;
    static int[][] maze;
    static int[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        maze = new int[N][M];
        visited = new int[N][M];

        for(int i = 0; i<N; i++){
            input = br.readLine().split("");
            for(int j = 0; j<M; j++){
                maze[i][j] = Integer.parseInt(input[j]);
            }
        }

        bfs(0, 0);
        bw.write(visited[N-1][M-1]+"\n");

        bw.flush();
        bw.close();
    }

    public static void bfs(int start_x, int start_y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start_x, start_y});
        visited[start_x][start_y] = 1;

        while (!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            if(x == N-1 && y == M-1){
                return;
            }

            for(int i = 0; i<4; i++){
                int next_x = x + dx[i];
                int next_y = y + dy[i];

                if(next_x >= 0 && next_x < N && next_y >= 0 && next_y < M && maze[next_x][next_y] == 1 && visited[next_x][next_y] == 0){
                    q.add(new int[]{next_x, next_y});
                    visited[next_x][next_y] = visited[x][y] + 1;
                }
            }
        }
    }
}
