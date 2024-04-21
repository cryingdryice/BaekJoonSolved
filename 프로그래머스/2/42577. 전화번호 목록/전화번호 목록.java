import java.util.HashMap;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        int len = phone_book.length;

        HashMap<String, Integer> hm = new HashMap<>(); // 탐색을 빠르게 하기 위해 전화번호를 해쉬맵으로 변환.
        for(int i = 0; i<len; i++){
            hm.put(phone_book[i], i);
        }
        
        for(int i = 0; i<len; i++){
            for(int j = 1; j<phone_book[i].length();j++){
                if(hm.containsKey(phone_book[i].substring(0,j))) return false;
            }
        }
        
        return answer;
    }
}