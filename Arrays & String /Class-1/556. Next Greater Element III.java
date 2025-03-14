class Solution {
    public String swap(String num , int i , int j){
        StringBuilder number = new StringBuilder(num);
        char temp = number.charAt(i);
        number.setCharAt(i , number.charAt(j));
        number.setCharAt(j , temp);
        return number.toString();
    }
    public String reverse(String num , int start , int end){
        while(start < end){
            num = swap(num , start , end);
            start++;
            end--;
        }
        return num;
    }
    public int nextGreaterElement(int n) {
        String num = Integer.toString(n);
        int numLength = num.length();
        int swapIndex = -1;
        for(int i = numLength - 2; i >= 0; i--){
            int currDigit = num.charAt(i) - '0';
            int prevDigit = num.charAt(i + 1) - '0';
            if(currDigit < prevDigit)
            {
                swapIndex = i;
                break;
            }
        }
        if(swapIndex != -1)
        {
            int swapIndexDigit = num.charAt(swapIndex) - '0'; 
            for(int i = numLength - 1; i > swapIndex; i--)
            {
                int currDigit = num.charAt(i) - '0';
                if(currDigit > swapIndexDigit)
                {
                    num = swap(num , swapIndex , i);
                    num = reverse(num , swapIndex + 1 , numLength - 1);
                    break;
                }
            }
            long number = Long.valueOf(num);
            if(number < Integer.MIN_VALUE || number > Integer.MAX_VALUE)
            return -1;
            else
            return (int)number;
        }
        return -1;    
    }
}
