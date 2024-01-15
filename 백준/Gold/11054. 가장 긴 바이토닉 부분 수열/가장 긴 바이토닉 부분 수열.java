import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        String input[] = br.readLine().split(" ");
        int dp_in[] = new int[1001];
        int dp_de[] = new int[1001];
        int nums[] = new int[1001];

        for(int i = 0; i<T; i++){
            nums[i] = Integer.parseInt(input[i]);
        }

        for(int i = 0; i<T; i++){
            dp_in[i] = 1;
            for(int j = 0; j<i; j++){
                if(nums[j] < nums[i] && dp_in[j]+1 > dp_in[i]) dp_in[i] = dp_in[j]+1;
            }
        }
        for(int i = T-1; i>=0; i--){
            dp_de[i] = 1;
            for(int j = T-1; j>i; j--){
                if(nums[j] < nums[i] && dp_de[j]+1 > dp_de[i]) dp_de[i] = dp_de[j]+1;
            }
        }

        int max = 0;
        for(int i = 0; i<T; i++){
            max = (dp_in[i]+dp_de[i]-1 > max ? dp_in[i]+dp_de[i]-1 : max);
        }

        bw.write(max+"\n");
        bw.flush();
        bw.close();
    }
}