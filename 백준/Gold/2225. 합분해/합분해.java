import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int nums[] = new int[2];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i<2; i++){
            nums[i] = Integer.parseInt((input[i]));
        }
        long dp[][] = new long[201][201];

        for(int k = 1; k<=200; k++){
            for(int n = 0; n<=200; n++){
                if(k==1) dp[n][k] = 1;
                for(int i = 0; i<=n && k!=1 ; i++){
                    dp[n][k] += dp[i][k-1]%1000000000;
                }
            }
        }

        bw.write((dp[nums[0]][nums[1]])%1000000000+"\n");
        bw.flush();
        bw.close();
    }
}