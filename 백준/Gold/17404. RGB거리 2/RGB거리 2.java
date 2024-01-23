import java.io.*;

public class Main {
    final static int inf = 999999999;
    
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
        int min = inf;
        
        // 첫번째로 실행할때
        dp[1][1] = cost[1][1]; dp[1][2] = inf; dp[1][3] = inf;
        for(int i= 2; i<=T; i++){
            dp[i][1] = cost[i][1] + (dp[i-1][2] < dp[i-1][3] ? dp[i-1][2] : dp[i-1][3]);
            dp[i][2] = cost[i][2] + (dp[i-1][1] < dp[i-1][3] ? dp[i-1][1] : dp[i-1][3]);
            dp[i][3] = cost[i][3] + (dp[i-1][2] < dp[i-1][1] ? dp[i-1][2] : dp[i-1][1]);
        }
        dp[T][1] = inf;
        
        for(int i = 1; i<=3; i++){
            min = dp[T][i] < min ? dp[T][i] : min;
        }
        
        // 두번째로 실행할때
        dp[1][1] = inf; dp[1][2] = cost[1][2]; dp[1][3] = inf;
        for(int i= 2; i<=T; i++){
            dp[i][1] = cost[i][1] + (dp[i-1][2] < dp[i-1][3] ? dp[i-1][2] : dp[i-1][3]);
            dp[i][2] = cost[i][2] + (dp[i-1][1] < dp[i-1][3] ? dp[i-1][1] : dp[i-1][3]);
            dp[i][3] = cost[i][3] + (dp[i-1][2] < dp[i-1][1] ? dp[i-1][2] : dp[i-1][1]);
        }
        dp[T][2] = inf;
        for(int i = 1; i<=3; i++){
            min = dp[T][i] < min ? dp[T][i] : min;
        }
        
        // 세번째로 실행할때
        dp[1][1] = inf; dp[1][2] = inf; dp[1][3] = cost[1][3];
        for(int i= 2; i<=T; i++){
            dp[i][1] = cost[i][1] + (dp[i-1][2] < dp[i-1][3] ? dp[i-1][2] : dp[i-1][3]);
            dp[i][2] = cost[i][2] + (dp[i-1][1] < dp[i-1][3] ? dp[i-1][1] : dp[i-1][3]);
            dp[i][3] = cost[i][3] + (dp[i-1][2] < dp[i-1][1] ? dp[i-1][2] : dp[i-1][1]);
        }
        dp[T][3] = inf;
        for(int i = 1; i<=3; i++){
            min = dp[T][i] < min ? dp[T][i] : min;
        }

        bw.write(min+"\n");
        bw.flush();
        bw.close();
    }
}