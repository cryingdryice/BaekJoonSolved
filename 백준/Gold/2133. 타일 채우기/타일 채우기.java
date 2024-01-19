import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int dp[] = new int[31];
        int ways[] = new int[31];

        if(T%2==1){
            bw.write(0+"\n");
            bw.flush();
        }else{
            ways[0] = 1; ways[1] = 3;
            for(int i = 2; i<=30; i++) ways[i] = 2;

            dp[0] = 1; dp[1] = ways[1];
            for(int i = 2; i<=T/2; i++){
                dp[i] = 0;
                for(int j = 1; j<=i; j++){
                    dp[i] += dp[i-j] * ways[j];
                }
            }

            bw.write(dp[T/2]+"\n");
            bw.flush();
        }

        bw.close();
    }
}
