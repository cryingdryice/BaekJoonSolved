import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input[] = br.readLine().split(" ");
        // E S M
        int nums[] = new int[3];
        int ESM[] = new int[3];
        int count = 1;
        for(int i = 0; i<3; i++) ESM[i] = 1;
        for (int i = 0; i<3; i++){
            nums[i] = Integer.parseInt(input[i]);
        }

        while(!Arrays.equals(nums, ESM)){
            if(ESM[0] == 15){
                ESM[0] = 1;
            }else{
                ESM[0]++;
            }

            if(ESM[1] == 28){
                ESM[1] = 1;
            }else{
                ESM[1]++;
            }
            if(ESM[2] == 19){
                ESM[2] = 1;
            }else{
                ESM[2]++;
            }
            count++;
        }

        bw.write(count+"\n");
        bw.flush();
        bw.close();
    }
}