
/**
 * https://leetcode.com/problems/maximum-swap/
 * @author Ahmad
 */
class MaximumSwap {
    public int maximumSwap(int num) {
        
        var chars = (num + "").toCharArray();
        var lastIndexes = new int[10];
        
        // keep track of last index of each digit
        for (int i = 0; i < chars.length; i++)
            lastIndexes[chars[i] - '0'] = i;
        
        for (var i = 0; i < chars.length; i++) {
            
            // try to see if larger digit from right can be put here
            for (int j = 9; j >= 0; j--) {
                if ((chars[i] - '0') < j) {
                    var index = lastIndexes[j];
                    if (index > i) {
                        swap(chars, i, index);
                        return Integer.parseInt(new String(chars));
                    }
                }
            }
        }
        
        return num;
    }
    
    private void swap(char []chars, int i, int j) {
        var temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}