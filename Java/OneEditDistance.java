class Solution {
    public boolean isOneEditDistance(String s, String t) {
        
        if ((s == null && t == null)
             || Math.abs(s.length() - t.length()) > 1)
            return false;
        
        int i = 0;
        int j = 0;
        boolean hasMismatch = false;
        
        while (i < s.length() && j < t.length()) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(j);
            
            if (c1 == c2) {
                i++;
                j++;
            }
            else {
                if (hasMismatch)
                    return false;
                
                hasMismatch = true;
                
                // it's first mismatch
                if (s.length() > t.length())
                {
                    i++;
                }
                else if (s.length() < t.length()) {
                    j++;
                }
                else {
                    i++;
                    j++;
                }           
            }
        }
        
        return hasMismatch || s.length() != t.length();
    }
}
