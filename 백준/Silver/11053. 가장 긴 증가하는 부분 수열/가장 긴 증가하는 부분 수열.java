import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int nums[] = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i<N; i++){
            nums[i] = Integer.parseInt((input[i]));
        }

        int dp[] = new int[1001]; // 끝이 i인 증가배열의 길이
        int max = 1;

        for(int i = 0; i<N;i++){
            for(int j = 0; j<i; j++){
                if((nums[j] < nums[i]) && (dp[j] >= dp[i])){
                    dp[i] = dp[j]+1;
                }
            }
            if(dp[i] == 0){
                dp[i] = 1;
            }
        }

        for(int i = 0; i<N; i++){
            if(max < dp[i]) max = dp[i];
        }

        bw.write(max+"\n");
        bw.flush();
        bw.close();
    }
}