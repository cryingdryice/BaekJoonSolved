import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int nums[] = new int[4];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i<4; i++){
            nums[i] = Integer.parseInt((input[i]));
        }

        int minx = nums[0] < (nums[2] - nums[0]) ? nums[0] : (nums[2] - nums[0]);
        int miny = nums[1] < (nums[3] - nums[1]) ? nums[1] : (nums[3] - nums[1]);

        bw.write((minx < miny ? minx : miny)+"\n");
        bw.flush();
        bw.close();
    }
}