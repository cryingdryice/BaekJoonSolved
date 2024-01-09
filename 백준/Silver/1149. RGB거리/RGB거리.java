import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[][] dp = new int[1001][4];
        String[] input;
        int[][] cost = new int[1001][4];

        for(int j = 1; j<=T; j++){
            input = br.readLine().split(" ");
            for(int i = 1; i<=3; i++){
                cost[j][i] = Integer.parseInt((input[i-1]));
            }
        }

        dp[1][1] = cost[1][1]; dp[1][2] = cost[1][2]; dp[1][3] = cost[1][3];
        for(int i = 2; i<=T; i++){
            for(int j = 1; j<=3; j++){
                if(j == 1){
                    dp[i][1] = cost[i][1] + (dp[i-1][2] < dp[i-1][3] ? dp[i-1][2] : dp[i-1][3]);
                }else if(j == 2){
                    dp[i][2] = cost[i][2] + (dp[i-1][1] < dp[i-1][3] ? dp[i-1][1] : dp[i-1][3]);
                }else{
                    dp[i][3] = cost[i][3] + (dp[i-1][1] < dp[i-1][2] ? dp[i-1][1] : dp[i-1][2]);
                }
            }
        }

        int min = dp[T][1];
        for(int i = 1; i<=3; i++){
            if(dp[T][i] < min) min = dp[T][i];
        }

        bw.write(min+"\n");
        bw.flush();
        bw.close();
    }
}