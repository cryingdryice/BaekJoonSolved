import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int dp[] = new int[100001];

        dp[0] = 1; dp[1] = 3; dp[2] = 7;
        for(int i = 2; i<100001; i++){
            dp[i] = ((dp[i-1]*2)%9901 + dp[i-2]%9901)%9901;
        }

        bw.write(dp[T]+"\n");
        bw.flush();
        bw.close();
    }
}