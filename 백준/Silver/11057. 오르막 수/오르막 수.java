import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        long dp[][] = new long[1001][10];

        for(int i = 0; i<=9; i++){
            dp[1][i] = 1;
        }
        for(int i = 2; i<=1000; i++){
            for(int j = 0; j<=9; j++){
                dp[i][j] = 0;
                for(int k = j; k<=9; k++){
                    dp[i][j] = (dp[i][j]%10007 + dp[i-1][k]%10007)%10007;
                }
            }
        }

        int sum = 0;
        for(int i = 0; i<=9; i++) sum += dp[T][i]%10007;

        bw.write(sum%10007+"\n");
        bw.flush();
        bw.close();
    }
}