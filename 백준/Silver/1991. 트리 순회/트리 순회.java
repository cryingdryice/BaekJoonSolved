import java.io.*;
import java.util.HashMap;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] input;
        HashMap<Character, Node> tree = new HashMap<Character, Node>();
        for(int i = 0; i<N; i++){
            input = br.readLine().split(" ");

            char middle = input[0].charAt(0);
            char left = input[1].charAt(0);
            char right = input[2].charAt(0);

            tree.putIfAbsent(middle, new Node(middle));
            Node M = tree.get(middle);

            if(left != '.'){
                Node L = new Node(left);
                M.left = L;
                tree.put(left, L);
            }
            if(right != '.'){
                Node R = new Node(right);
                M.right = R;
                tree.put(right, R);
            }
        }

        preOrder(tree.get('A'));
        System.out.println();
        inOrder(tree.get('A'));
        System.out.println();
        postOrder(tree.get('A'));
    }

    static void preOrder(Node n){
        if(n == null) return;
        System.out.print(n.value);
        preOrder(n.left);
        preOrder(n.right);
    }
    static void inOrder(Node n){
        if(n == null) return;
        inOrder(n.left);
        System.out.print(n.value);
        inOrder(n.right);
    }
    static void postOrder(Node n){
        if(n == null) return;
        postOrder(n.left);
        postOrder(n.right);
        System.out.print(n.value);
    }

    static class Node{
        char value;
        Node left;
        Node right;
        Node(char value){
            this.value = value;
        }
    }

}
