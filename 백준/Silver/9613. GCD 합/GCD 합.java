import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[] nums = new int[101];

        for(int i = 0; i<T; i++){
            long sum = 0;
            String[] input = br.readLine().split(" ");
            for(int j = 0; j<=Integer.parseInt((input[0])); j++){ // 입력배열 정수로 초기화
                nums[j] = Integer.parseInt(input[j]); // nums[0] 은 뒷 수의 개수
            }

            for(int j = 1; j<nums[0]; j++){ // GCD 비교
                for(int k =j+1; k<=nums[0]; k++){
                    sum+= GCD(nums[j], nums[k]);
                }
            }
            bw.write(sum+"\n");
        }
        bw.flush();
        bw.close();
    }
    static int GCD(int a, int b){
        while(b != 0){
            int tmp = a%b;
            a = b;
            b = tmp;
        }
        return a;
    }
}