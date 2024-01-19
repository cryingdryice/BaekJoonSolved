
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        String input[] = br.readLine().split(" ");
        int dp[] = new int[100001];
        int dp_sub[] = new int[100001];
        int nums[] = new int[100001];

        for(int i = 0; i<T; i++){
            nums[i] = Integer.parseInt(input[i]);
        }

        dp[0] = nums[0];
        for(int i = 1; i<T; i++){ // 숫자를 빼지 않았을 때의 dp
            dp[i] = nums[i];
            if(dp[i-1]+dp[i] > dp[i]) dp[i] = dp[i-1]+dp[i];
        }

        dp_sub[0] = nums[0];
        for(int i = 1; i<T; i++){ // i-1??
            dp_sub[i] = nums[i];
            dp_sub[i] = dp[i-1] > dp_sub[i-1] + nums[i] ? dp[i-1] : dp_sub[i-1] + nums[i];
        }

        int max = nums[0];
        for(int i = 0; i<T; i++){
            max = dp_sub[i] > max ? dp_sub[i] : max;
        }
        for(int i = 0; i<T; i++){
            max = dp[i] > max ? dp[i] : max;
        }
        bw.write(max+"\n");
        bw.flush();
        bw.close();
    }
}
