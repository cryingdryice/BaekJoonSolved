import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int nums[] = new int[1001];
        int dp[] = new int[1001];
        String[] input = br.readLine().split(" ");
        
        for(int i = 0; i<T; i++){
            nums[i] = Integer.parseInt((input[i]));
        }

        for(int i = 0; i<T; i++){
            dp[i] = nums[i];
            for(int j = 0; j<i; j++){
                if(nums[j] < nums[i] && dp[j]+nums[i] > dp[i]){
                    dp[i] = dp[j]+nums[i];
                }
            }
        }
        int max = 0;
        for(int i = 0; i<T; i++){
            max = dp[i] > max ? dp[i] : max;
        }

        bw.write(max+"\n");
        bw.flush();
        bw.close();
    }
}