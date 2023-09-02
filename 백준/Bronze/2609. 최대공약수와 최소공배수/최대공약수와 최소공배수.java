import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int[] nums = new int[2];
        for(int i = 0; i<2;i++){ // 입력을 정수 배열로 변환
            nums[i] = Integer.parseInt(input[i]);
        }

        bw.write(GCD(nums[0], nums[1])+"\n"+LCM(nums[0], nums[1])+"");
        bw.flush();
        bw.close();
    }
    static int GCD(int a, int b){ // 최대공약수
        int min; // 작은수 구하기
        if(a<b) min = a;
        else if(b<a) min = b;
        else return a; // 수가 같다면 최대공약수는 그 수

        for(int i = min; i>=1;i--){
            if((a%i == 0) && (b%i) == 0){
                return i;
            }
        }
        return 1;
    }
    static int LCM(int a, int b){ // 최소공배수
        return a*b/GCD(a,b);
    }
}