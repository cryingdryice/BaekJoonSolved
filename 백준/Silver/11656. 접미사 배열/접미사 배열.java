import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder output = new StringBuilder();

        String input = br.readLine();
        StringBuilder suffix = new StringBuilder(input);
        String[] Array = new String[input.length()];

        Array[0] = suffix.toString(); // 접미사 배열 만들기
        for(int i = 1; i < input.length(); i++){
            Array[i] = suffix.deleteCharAt(0).toString();
        }
        Arrays.sort(Array); // 사전순으로 만들기
        for(String k: Array){
            output.append(k+"\n");
        }
        bw.write(output+"");
        bw.flush();
        bw.close();
    }
}