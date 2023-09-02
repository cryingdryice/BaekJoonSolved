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
        char[] str = input.toCharArray();

        for(int i = 0; i<str.length; i++){
            if(str[i]>='A' && str[i]<='M'){ // 대문자중 절반 전 바꾸기
                output.append((char)(str[i]+13));
            }else if(str[i]>='N' && str[i]<='Z'){ // 대문자중 절반 후 바꾸기
                output.append((char)(str[i]-13));
            }else if(str[i]>='a' && str[i]<='m'){ // 소문자중 절반 후 바꾸기
                output.append((char)(str[i]+13));
            }else if(str[i]>='n' && str[i]<='z') { // 소문자중 절반 후 바꾸기
                output.append((char) (str[i] - 13));
            }else{ // 공백이나 숫자 등 그 외는 그대로
                output.append(str[i]);
            }
        }
        bw.write(output+"");
        bw.flush();
        bw.close();
    }
}