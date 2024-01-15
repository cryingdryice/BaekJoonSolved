import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int nums[][] = new int[501][501];
        int dp[][] = new int[501][501];
        String[] input;
        
        for(int i = 1; i<=T; i++){
            input = br.readLine().split(" ");
            for(int j = 1; j<=i; j++){
                nums[i][j] = Integer.parseInt((input[j-1]));
            }
        }
        dp[1][1] = nums[1][1];
        for(int i = 2; i <=T; i++){
            dp[i][1] = nums[i][1] + dp[i-1][1];
            for(int j = 2; j<=i-1; j++){
                dp[i][j] = nums[i][j] + (dp[i-1][j-1] > dp[i-1][j] ? dp[i-1][j-1] : dp[i-1][j]);
            }
            dp[i][i] = nums[i][i] + dp[i-1][i-1];
        }
        int max = 0; 
        
        for(int i = 1; i<=T; i++){
            max = (dp[T][i] > max ? dp[T][i] : max);
        }
        
        bw.write(max+"\n");
        bw.flush();
        bw.close();
    }
}