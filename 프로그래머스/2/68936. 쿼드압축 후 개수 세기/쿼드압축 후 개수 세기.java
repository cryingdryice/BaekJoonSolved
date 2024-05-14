class Solution {
    public int[] solution(int[][] arr) {
        int n = arr.length;
        int[] answer = {0,0};
        
        subS(0, 0, arr, n, answer);
        
        
        return answer;
    }
    
    int subS(int col, int row, int[][] arr, int length, int[] answer){
        if(length == 1){
            if(arr[col][row] == 0) answer[0]++;
            else answer[1]++;
            return arr[col][row];
        }
        
        int sum = subS(col, row, arr, length/2, answer) // 좌상
            +subS(col+length/2, row, arr, length/2, answer) // 우상
            +subS(col, row+length/2, arr, length/2, answer) // 좌하
            +subS(col+length/2, row+length/2, arr, length/2, answer); // 우하
        
        if(sum == 0){ // 서브의 합이 0이라면 4개 모두 0이라는 뜻
            answer[0] -= 3;
            return 0;
        }
        if(sum == 4){ // 서브의 합이 4이라면 4개 모두 1이라는 뜻
            answer[1] -= 3;
            return 1;
        }
        return -999; // 둘 다 아니면 이 구역을 포함한 부분은 압축할 수 없음
    }
}