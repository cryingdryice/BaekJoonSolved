import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int output= 0;
        Stack<Character> stack = new Stack<>();

        String input = br.readLine();
        for(int i = 0; i<input.length(); i++){
            if(input.charAt(i) == '('){
                stack.push('(');
            }else{ // ')'가 들어왔을 때
                stack.pop();
                if(input.charAt(i-1) == '('){ //레이저
                    output += stack.size(); // 스택안의 개수가 레이저로 잘린 쇠막대기 개수
                }else{ // ')'뒤에 또 ')'가 왔을때
                    output++;
                }
            }
        }
        bw.write(output+"");
        bw.flush();
        bw.close();
    }
}