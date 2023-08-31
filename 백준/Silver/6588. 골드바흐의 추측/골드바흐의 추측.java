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
        int N;

        boolean[] isnotprime = new boolean[1000001]; // 모든 요소가 false
        for(int i = 2; i<1000000; i++){ // 소수라면 isnotprime은 false
            if(isnotprime[i]) continue; // 이미 소수가 아닌걸로 판명났으면 continue
            for(int j=i*2;j<=1000000; j+=i) { // 판명난 수가 아니면, 그 배수(*2)부터 출발하여, 소수아닌 것 판별하기( 4, 6, 8... 6, 9, 12... 10 20 30...)
                isnotprime[j] = true;
            }
        }
        isnotprime[1] = true; // 1은 소수가 아님

        while((N = Integer.parseInt(br.readLine())) != 0){ // 가장 작은 소수에서 입력 값빼고 그 수가 소수인지 확인
            int a;
            int b;
            for(int i = 2; i<N; i++){
                if(isnotprime[i]) continue; // 소수가 아니면 continue;
                else{
                    a = i;
                    b = N-a;
                    if(isnotprime[b]) continue; // b가 소수가 아니면 continue;
                    else{
                        output.append(N+" = "+a+" + "+b+"\n");
                        break;
                    }
                }
            }
        }
        bw.write(output+"");
        bw.flush();
        bw.close();
    }
}