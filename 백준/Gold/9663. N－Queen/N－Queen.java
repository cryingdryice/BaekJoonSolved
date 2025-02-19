import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int[] visited;
//    static ArrayList<int[]> queens;
    static int N;
    static int cnt;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        visited = new int[N];
//        queens = new ArrayList<int[]>();
        bt(0);

        System.out.println(cnt);
    }

    static void bt(int depth){
        if(depth == N){
            cnt++;
//            for(int[] queen : queens){
//                System.out.print("["+queen[0]+", "+queen[1]+"]");
//            }
//            System.out.println();
            return;
        }

        for(int i = 0; i<N; i++){ // i는 열 번호
            boolean flag = false;
            for(int j = 0; j<depth; j++){
                if(visited[j]==i || j-visited[j] == depth-i || j+visited[j]==depth+i) flag = true;
            }
//            for(int[] queen : queens){
//                if(queen[1] == i) flag=true; // 열 중복 확인
//                // 대각선 중복 확인
//                if(queen[0]-queen[1] == depth-i || queen[0]+queen[1] == depth+i) flag=true;
//            }
            if(flag) continue;

//            int[] pos = new int[]{depth, i};
//            queens.add(pos);
            visited[depth] = i;
            bt(depth+1);
            visited[depth] = 0;
//            queens.remove(depth);
        }
    }
}
