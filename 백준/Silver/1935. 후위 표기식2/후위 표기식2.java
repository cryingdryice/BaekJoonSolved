import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder output = new StringBuilder();

        Stack<Double> stack = new Stack<>(); // ABC..피연산자들을 담음

        int N = Integer.parseInt(br.readLine());
        Double[] nums = new Double[N]; // ABC에 대응하는 값저장
        String input = br.readLine();
        char[] expresston = input.toCharArray(); // 식을 문자 배열로 저장

        for(int i = 0; i<N; i++){
            nums[i] = Double.parseDouble(br.readLine());
        }

        for(char c : expresston){
            switch (c){
                case '+':
                    stack.push(stack.pop()+stack.pop());
                    break;
                case '-':
                    Double mop2 = stack.pop(); // 뒤의 수
                    Double mop1 = stack.pop(); // 앞의 수
                    stack.push(mop1-mop2);
                    break;
                case '*':
                    stack.push(stack.pop()*stack.pop());
                    break;
                case '/':
                    Double dop2 = stack.pop(); // 뒤의 수
                    Double dop1 = stack.pop(); // 앞의 수
                    stack.push(dop1/dop2);
                    break;
                default:
                    stack.push(nums[(int) c - 65]);
                    break;
            }
        }
        output.append(String.format("%.2f", stack.pop())); //소수점 둘째자리까지
        bw.write(output+"");
        bw.flush();
        bw.close();
    }
}