class Solution {
    public int solution(String[][] board, int h, int w) {
        int cnt = 0;
        String center = board[h][w];
      
        if(h-1>=0 && center.equals(board[h-1][w])) cnt++;
        if(h+1< board.length&& center.equals(board[h+1][w])) cnt++;
        if(w-1>=0 && center.equals(board[h][w-1])) cnt++;
        if(w+1< board.length && center.equals(board[h][w+1])) cnt++;
        
        return cnt;
    }
}