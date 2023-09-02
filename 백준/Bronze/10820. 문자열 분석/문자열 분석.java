import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;

        while((input = br.readLine()) != null){
            char[] S = input.toCharArray(); // 단어를 문자 배열로 저장
            int[] cnt = new int[4]; // 소문자, 대문자, 숫자, 공백 수 저장

            for(int j = 0; j<S.length; j++){
                if((int)S[j] >= 97 && (int)S[j] <= 122){ // 소문자라면
                    cnt[0] +=1;
                }else if((int)S[j] >= 65 && (int)S[j] <= 90){ // 대문자라면
                    cnt[1] +=1;
                }else if((int)S[j] >= 48 && (int)S[j] <= 57){ // 숫자라면
                    cnt[2] +=1;
                }else{ //공백이라면
                    cnt[3] +=1;
                }
            }
            for(int k: cnt){
                bw.write(k+" ");
            }
            bw.write("\n");
            bw.flush();
        }
        bw.close();
    }
}