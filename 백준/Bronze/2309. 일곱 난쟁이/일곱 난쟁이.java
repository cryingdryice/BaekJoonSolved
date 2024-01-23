import java.io.*;

public class Main {
    static int inf = 999999999;
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int nums[] = new int[9];

        for(int i = 0; i<9; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }

        int sum = 0;
        for(int i = 0; i<9; i++){
            sum += nums[i];
        }
        int find = sum-100;
        
        int first = 0;
        int second = 0;;
        for(int i = 0; i<8; i++){
            for(int j = i+1; j<9; j++){
                if(nums[i]+nums[j] == find){
                    first = i; second = j;
                }
            }
        }
        nums[first] = inf; nums[second] = inf;
        
        int min = 0;
        for(int i  = 0; i<8; i++){
            min = i;
            for(int j = i+1; j<9; j++){
                if(nums[j]<nums[min]) min = j;
            }
            int temp = nums[min];
            nums[min] = nums[i];
            nums[i] = temp;
        }
        
        for(int i = 0; i <7; i++){
            bw.write(nums[i]+"\n");
            bw.flush();
        }
        

        bw.close();
    }
}