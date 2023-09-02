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
        StringBuilder output = new StringBuilder();
        Stack<Character> stack = new Stack<>(); // 연산자 담는 스택

        String input = br.readLine();
        char[] expresston = input.toCharArray(); // 식을 문자 배열로 저장

        for(int i = 0; i<expresston.length; i++){
            if(expresston[i] == '('){ // 바로 스택에 담기
                stack.push(expresston[i]);
            }else if(expresston[i] == ')'){ // '('만나기 전까지의 연산자 pop
                while(stack.peek() != '('){
                    output.append(stack.pop());
                }
                stack.pop(); // '('없애기
            }else if(expresston[i] == '*' || expresston[i] == '/'){ // 이전 연산자(스택의 탑)가 *, / 인 경우에만 순서대로 진행(이전 연산자 먼저 처리)
                while(!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')){
                    output.append(stack.pop());
                }
                stack.push(expresston[i]);
            }else if(expresston[i] == '+' || expresston[i] == '-'){ // 이전 연산자(스택의 탑)가 '('에만 우선적으로 처리(그 외에는 모두 후순위)
                while(!stack.isEmpty() && stack.peek() != '('){
                    output.append(stack.pop());
                }
                stack.push(expresston[i]);
            }else{ // 피연산자일경우 그대로 출력
                output.append(expresston[i]);
            }
        }
        while(!stack.isEmpty()){ // 남아있는 연산자 모두 꺼내기
            output.append(stack.pop());
        }
        bw.write(output+"");
        bw.flush();
        bw.close();
    }
}