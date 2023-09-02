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
        int[] cnt = new int[26]; //알파벳 카운트 배열

        for(char k: S){
            cnt[(int) k - 97] +=1;
        }
        for(int k: cnt){
            output.append(k+" ");
        }
        bw.write(output+"");
        bw.flush();
        bw.close();
    }
}