import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int pre[] = new int[10001];
        int BSTlength = 0;
        int idx = 0;
        while(true){
            try {
                pre[idx++] = Integer.parseInt(br.readLine());
            }catch (NumberFormatException e){
                break;
            }
        }
        
        // 트리배열 길이 구하기
        for (idx = 0; pre[idx] >0; idx++){
            BSTlength++;
        }

        post_order(pre, 0, BSTlength-1);

//        bw.write(BSTlength+"\n");
//        bw.flush();
        bw.close();
    }

    static void post_order(int[] pre, int rootIdx, int endIdx){
        // 존재하지 않는 트리면 리턴
        if(rootIdx > endIdx) return;
//        if(rootIdx == endIdx){
//            System.out.println(pre[rootIdx]);
//            return;
//        }


        // L R 서브트리를 구분하는 R시작인덱스 구하기
        int RStartIdx = rootIdx;
        while(true){
            // R 서브트리가 존재하지 않을경우
            if(RStartIdx > endIdx) break;
            if(pre[RStartIdx] > pre[rootIdx]) break;
            RStartIdx++;
        }

        // L subtree 순회
        post_order(pre, rootIdx+1, RStartIdx-1);
        // R subtree 순회
        post_order(pre, RStartIdx, endIdx);
        // root 출력
        System.out.println(pre[rootIdx]);

        return;
    }
}
