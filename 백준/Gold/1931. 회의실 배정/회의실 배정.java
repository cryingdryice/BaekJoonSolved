import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input;
        int[][] times = new int[N][2];

        for(int i = 0; i<N; i++){
            input = br.readLine().split(" ");
            times[i][0] = Integer.parseInt(input[0]);
            times[i][1] = Integer.parseInt(input[1]);
        }

        Arrays.sort(times, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);


        int cur = 0;
        int cnt = 1;
        int i = 0;
        while(i<N){
            for(i = cur+1; i<N; i++){
                if(times[i][0] >= times[cur][1]){
                    cur = i;
                    cnt++;
                    break;
                }
            }
        }
//        for(int i = 1; i<N;){
//            if(times[i][0] >= times[cur][1]){
//                cur = i;
//                i = cur+1;
//                cnt++;
//            }else{
//                i++;
//            }
//        }

        System.out.println(cnt);
    }

}
