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

        String input = br.readLine();
        char[] S = input.toCharArray(); // 단어를 문자 배열로 저장
        int[] order = new int[26]; //알파벳 순서 배열
        for(int i = 0; i<order.length; i++){
            order[i] = -1; // order의 모든 요소를 -1로 바꾸기
        }

        int cnt = 0; // 알파벳 순서

        for(int i = 0; i<S.length; i++){
            if(order[(int) S[i] - 97] == -1){
                order[(int) S[i] - 97] = cnt;
            }
            cnt++;
        }
        for(int k: order){
            output.append(k+" ");
        }
        bw.write(output+"");
        bw.flush();
        bw.close();
    }
}