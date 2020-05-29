//https://leetcode.com/problems/logger-rate-limiter/

class Logger {
    
    private Map<String, Integer> map;
    

    /** Initialize your data structure here. */
    public Logger() {
        map = new HashMap<String, Integer>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        
      int lastPrint = map.getOrDefault(message, -1);

          var shouldPrint = lastPrint == -1
                              || Math.abs(lastPrint - timestamp) >= 10;

      if (shouldPrint) {
        map.put(message, timestamp);
        return true;
      }
      else {
        return false;
      }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
