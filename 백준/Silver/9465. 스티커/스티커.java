import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int dp[][] = new int[100001][2];
        int nums[][] = new int[100001][2];
        String[] input;

        int n;
        for(int i = 0; i<T; i++){
            n = Integer.parseInt(br.readLine());
            input = br.readLine().split(" ");
            for(int j = 0; j<n; j++){
                nums[j][0] = Integer.parseInt((input[j]));
            }
            input = br.readLine().split(" ");
            for(int j = 0; j<n; j++){
                nums[j][1] = Integer.parseInt((input[j]));
            }

            dp[0][0] = nums[0][0]; dp[0][1] = nums[0][1];
            dp[1][0] = dp[0][1]+nums[1][0]; dp[1][1] = dp[0][0]+nums[1][1];
            for(int j = 2; j<n; j++){
                dp[j][0] = (dp[j-1][1] > dp[j-2][1] ? dp[j-1][1] : dp[j-2][1]) + nums[j][0];
                dp[j][1] = (dp[j-1][0] > dp[j-2][0] ? dp[j-1][0] : dp[j-2][0]) + nums[j][1];
            }

            bw.write((dp[n-1][0] > dp[n-1][1] ? dp[n-1][0] : dp[n-1][1])+"\n");
            bw.flush();
        }

        bw.close();
    }
}