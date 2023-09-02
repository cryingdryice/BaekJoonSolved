import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder output = new StringBuilder();
        
        int[] nums = new int[2];
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i<T; i++){
            String[] input = br.readLine().split(" ");
            nums[0] = Integer.parseInt(input[0]);
            nums[1] = Integer.parseInt(input[1]);
            output.append(LCM(nums[0], nums[1])+"\n");
        }
        bw.write(output+"");
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