import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder output = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int[] nums = new int[3];
        for(int i = 0; i<3;i++){ // 입력을 정수 배열로 변환
            nums[i] = Integer.parseInt(input[i]);
        }
        output.append((nums[0]+nums[1])%nums[2]+"\n"); // (A+B)%C
        output.append(((nums[0]%nums[2])+(nums[1]%nums[2]))%nums[2]+"\n"); // ((A%C) + (B%C))%C
        output.append((nums[0]*nums[1])%nums[2]+"\n"); // (A×B)%C
        output.append(((nums[0]%nums[2])*(nums[1]%nums[2]))%nums[2]); // ((A%C) × (B%C))%C

        bw.write(output+"");
        bw.flush();
        bw.close();
    }

}