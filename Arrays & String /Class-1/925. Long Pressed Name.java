class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int nameLength = name.length();
        int typedLength = typed.length();
        int i = 0 , j = 0;
        while(i < nameLength && j < typedLength)
        {
           char c_i = name.charAt(i);
           char c_j = typed.charAt(j);
           if(c_i == c_j)
           {
                i += 1;
                j += 1;
           }
           else
           {
                if(j != 0 && c_j == typed.charAt(j - 1))
                j += 1;
                else
                return false;
           }
        }
        if(i != nameLength)
        return false;
        else
        {
            while(j < typedLength)
            {
                if(typed.charAt(j - 1) != typed.charAt(j))
                return false;

                j += 1;  
            }
            return true;
        }
        
    }
}
// TC : O(N + M)
// SC : O(1)
