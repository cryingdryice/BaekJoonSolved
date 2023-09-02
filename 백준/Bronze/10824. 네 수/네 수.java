import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();

        String input = br.readLine();
        String[] str = input.split(" ");

        num1.append(str[0]).append(str[1]);
        num2.append(str[2]).append(str[3]);

        bw.write(Long.parseLong(num1.toString())+Long.parseLong(num2.toString())+"");
        bw.flush();
        bw.close();
    }
}