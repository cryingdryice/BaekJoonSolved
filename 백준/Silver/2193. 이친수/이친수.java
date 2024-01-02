import java.io.*;
public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long dp[][] = new long[91][2];

        dp[1][0] = 0; dp[1][1] = 1;
        for(int i = 2; i <= 90; i++){
            dp[i][0] = dp[i-1][0]+dp[i-1][1];
            dp[i][1] = dp[i-1][0];
        }
        bw.write((dp[N][0]+dp[N][1])+"\n");
        bw.flush();
        bw.close();
    }
}