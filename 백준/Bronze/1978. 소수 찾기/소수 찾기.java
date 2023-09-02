import java.io.*;

class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int cnt = 0; // 소수 개수
        int T = Integer.parseInt(br.readLine());
        int[] nums = new int[T];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i<T; i++){ // 입력배열 정수로 초기화
            nums[i] = Integer.parseInt(input[i]);
        }
        for(int k : nums){
            if(isPrime(k)){
                cnt++;
            }
        }
        
        bw.write(cnt+"");
        bw.flush();
        bw.close();
        
    }
    static boolean isPrime(int n){
        if(n == 1) return false;
        else{
            for(int i = 2; i<n; i++){
                if(n%i==0) return false;
            }
            return true;
        }
    }
    
}