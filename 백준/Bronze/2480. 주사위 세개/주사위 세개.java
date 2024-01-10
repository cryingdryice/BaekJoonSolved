import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int nums[] = new int[3];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i<3; i++){
            nums[i] = Integer.parseInt((input[i]));
        }

        int price = 0;
        int same = 0;
        int max = 1;
        int cnt = 0;
        for(int i = 0; i<=1; i++){
            for(int j = i+1; j<=2; j++){
                if(nums[i] == nums[j])  {same = nums[i]; cnt++;}
            }
        }

        if(cnt == 3){
            price = 10000 + 1000 * same;
        }else if(cnt == 1){
            price = 1000 + 100 * same;
        }else{
            for(int i = 0; i<3; i++){
                if(nums[i] > max) max = nums[i];
            }
            price = max*100;
        }

        bw.write(price+"\n");
        bw.flush();
        bw.close();
    }
}