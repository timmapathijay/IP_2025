class Solution {
    public boolean isVowel(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
        return true;
        else
        return false;
    }
    public String reverseVowels(String s) {
       StringBuilder str = new StringBuilder(s);
       int start = 0;
       int end = s.length() - 1;
       while(start < end){
        char c_start = str.charAt(start);
        char c_end = str.charAt(end);
        if(isVowel(c_start) && isVowel(c_end)){
            str.setCharAt(start , c_end);
            str.setCharAt(end , c_start);
            start += 1;
            end -= 1;
        }else if(isVowel(c_start)){
            end -= 1;
        }else if(isVowel(c_end)){
            start += 1;
        }else{
            start += 1;
            end -= 1;
        }
       }
       return str.toString(); 
    }
}
// TC : O(N)
// SC : O(1)
