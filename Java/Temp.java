import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Temp {
	public static void main(String[] args) {

		var pq = new PriorityQueue<TempNode>(new Comparator<TempNode>() {
			@Override
			public int compare(TempNode o1, TempNode o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		});
	}

	class TempNode {
		public int x;
		public int y;
	}
}
