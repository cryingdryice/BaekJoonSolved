class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        if(triangle.length == 1) return triangle[0][0];
        
        for(int i = 1; i<triangle.length; i++){
            int n = triangle[i].length;
            triangle[i][0] += triangle[i-1][0];
            for(int j = 1; j<n-1; j++){
                triangle[i][j] += triangle[i-1][j-1] > triangle[i-1][j] ? triangle[i-1][j-1] : triangle[i-1][j];        
            }
            triangle[i][n-1] += triangle[i-1][n-2];
        }
        
        int n = triangle.length;
        for(int i = 0; i<n; i++){
            answer = answer > triangle[n-1][i] ? answer : triangle[n-1][i];
        }
        return answer;
    }
}