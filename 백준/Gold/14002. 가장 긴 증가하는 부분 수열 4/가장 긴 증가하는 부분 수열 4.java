import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int nums[] = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i<N; i++){
            nums[i] = Integer.parseInt((input[i]));
        }

        int dp[] = new int[1001]; // 끝이 i인 증가배열의 길이
        int child[] = new int[1001];
        int maxidx = 0;

        for(int i = 0; i<N;i++){
            for(int j = 0; j<i; j++){
                if((nums[j] < nums[i]) && (dp[j] >= dp[i])){
                    dp[i] = dp[j]+1;
                    child[i] = j;
                }
            }
            if(dp[i] == 0){
                dp[i] = 1;
                child[i] = -1;
            }
        }

        for(int i = 0; i<N; i++){
            if(dp[maxidx] < dp[i]) maxidx = i;
            //System.out.println(i+" "+child[i]);
        }

        bw.write(dp[maxidx]+"\n");
        bw.flush();

        ways(maxidx, child, nums, bw);
        bw.close();
    }

    static void ways(int i, int child[], int nums[], BufferedWriter bw) throws IOException{
        if(child[i] == -1) {
            bw.write(nums[i]+"");
            return;
        }

        ways(child[i], child, nums, bw);
        bw.write(" "+nums[i]);
    }
}
