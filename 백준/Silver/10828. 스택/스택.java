import java.util.Scanner;

public class Main {

    static int[] stack;
    static int size=0;


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        StringBuilder output = new StringBuilder();

        int N = in.nextInt();
        stack = new int[N];

        for(int i = 0; i < N; i++) {
            String input = in.next();
            switch (input) {
                case "push":
                    push(in.nextInt());
                    break;
                case "pop":
                    output.append(pop()).append('\n');
                    break;
                case "size":
                    output.append(size()).append('\n');
                    break;
                case "empty":
                    output.append(empty()).append('\n');
                    break;
                case "top":
                    output.append(top()).append('\n');
                    break;
            }
        }
        System.out.println(output);
    }

    public static void push(int input) {
        stack[size] = input;
        size++;
    }

    public static int pop() {
        if(size == 0) {return -1;}
        else {
            int topNum = stack[size - 1];
            stack[size - 1] = 0;
            size--;
            return topNum;
        }
    }

    public static int size() {return size;}

    public static int empty() {
        if(size == 0) {return 1;}
        else {return 0;}
    }

    public static int top() {
        if(size == 0) {return -1;}
        else {return stack[size - 1];}
    }
}