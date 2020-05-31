import java.util.ArrayDeque;
import java.util.Deque;

class HitCounter {
    Deque<Integer> queue;
    /** Initialize your data structure here. */
    public HitCounter() {
        queue = new ArrayDeque<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    // hit: store timesstamp
    public void hit(int timestamp) {
        queue.offer(timestamp);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    // getHits: we remove earilier timestamp based on the current timestamp, get the total size
    public int getHits(int timestamp) {
        while (!queue.isEmpty() && queue.peek() <= timestamp - 300) {
            queue.poll();
        }
        return queue.size();
    }
}
