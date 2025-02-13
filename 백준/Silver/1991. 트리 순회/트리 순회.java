import java.io.*;

public class Main {
    static Node root;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] input;
        for(int i = 0; i<N; i++){
            input = br.readLine().split(" ");
            create(input[0], input[1], input[2]);
        }

        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
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
        String value;
        Node left;
        Node right;
        Node(String value){
            this.value = value;
        }
    }

    static void create(String value, String left, String right){
        if(root == null){
            root = new Node(value);
            if(!left.equals(".")) root.left = new Node(left);
            if(!right.equals(".")) root.right = new Node(right);
        }
        search(root, value, left, right);
    }

    static void search(Node n, String target, String left, String right){
        if(n == null) return;

        if(n.value.equals(target)){
            if(!left.equals(".")) n.left = new Node(left);
            if(!right.equals(".")) n.right = new Node(right);
        }

        search(n.left, target, left, right);
        search(n.right, target, left, right);
    }
}
