import java.io.*;
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nums = new int[2]; // nums[0] == n, nums[1] = m
        String[] input = br.readLine().split(" ");
        for(int i = 0; i<2; i++){ // 입력배열 정수로 초기화
            nums[i] = Integer.parseInt(input[i]);
        }
        // nCm의 인수중 5인수의 개수가 0의 개수(어떤 수든 5보다 2의 인수개수가 많기 때문)
        int Ncnt5 = 0; // n의 5인수 개수
        int Ncnt2 = 0;

        // n!/(n-m)! 중 5와 2의 인수개수 구하기
        Ncnt5 += checkFive(nums[0]);
        Ncnt2 += checkTwo(nums[0]);
        
        //(n-m)! 중 5와 2의 인수개수 구하기
        Ncnt5 -= checkFive(nums[0]-nums[1]);
        Ncnt2 -= checkTwo(nums[0]-nums[1]);
        
        // m! 중 5와 2의 인수개수 구하기
        Ncnt5 -= checkFive(nums[1]);
        Ncnt2 -= checkTwo(nums[1]);

        bw.write(Math.min(Ncnt5, Ncnt2) + "");
        bw.flush();
        bw.close();
    }
    static int checkFive(int n){ // n!의 5인수 개수 구하기
        int cnt5 = 0;
        int five = n;
        while(five>0){ // ... 125의 배수의 개수는 five/5, 25의 배수의 개수는 five/5, 5의 배수의 개수는 five/5 ...
            cnt5+=five/5;
            five /= 5;
        }
        return cnt5;
    }
    static int checkTwo(int n){ // n!의 2인수 개수 구하기
        int cnt2 = 0;
        int two = n;
        while(two >0){
            cnt2+=two/2;
            two /= 2;
        }
        return cnt2;
    }
}
