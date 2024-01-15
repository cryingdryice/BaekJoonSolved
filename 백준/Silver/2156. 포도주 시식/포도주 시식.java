import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int dp[][] = new int[10001][6];
        int nums[] = new int[10001];

        for(int i = 0; i<T; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }
        
        for(int i = 0; i<6; i++){
            dp[0][i] = nums[0];
        }
        dp[1][0] = nums[0]; dp[1][1] = 0; dp[1][2] = nums[0];
        dp[1][3] = nums[1]; dp[1][4] = nums[0]+nums[1]; dp[1][5] = nums[1];
        
        for(int i = 2; i<T; i++){
            dp[i][0] = dp[i-1][4];
            dp[i][1] = dp[i-1][0] > dp[i-1][2] ? dp[i-1][0] : dp[i-1][2];
            dp[i][2] = dp[i-1][3] > dp[i-1][5] ? dp[i-1][3] : dp[i-1][5];
            dp[i][3] = nums[i] + (dp[i-1][0] > dp[i-1][2] ? dp[i-1][0] : dp[i-1][2]);
            dp[i][4] = nums[i] + (dp[i-1][3] > dp[i-1][5] ? dp[i-1][3] : dp[i-1][5]);
            dp[i][5] = nums[i] + dp[i-1][1];
        }
        int max = 0;
        
        
        if(T==1) max = nums[0];
        else if(T==2) max = nums[0] + nums[1];
        else{
            for(int i = 0; i<6; i++){
                max = dp[T-1][i] > max ? dp[T-1][i] : max;
            }
        }
        
        bw.write(max+"\n");
        bw.flush();
        bw.close();
    }
}