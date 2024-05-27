class Solution {
    public String solution(String number, int k) {
        StringBuilder output = new StringBuilder(number);
        int l = output.length();

        while (k>0){
            for (int i = 0; i< l; i++){
                if(i == l-1 || output.charAt(i) < output.charAt(i+1)){
                    output.deleteCharAt(i);
                    l--;
                    k--;
                    break;
                }
            }
        }

        return output.toString();
    }
}