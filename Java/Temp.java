import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Temp {
	public static void main(String[] args) {
		var list = Arrays.asList(10);
		
		int element = 8;
		
		System.out.println(Collections.binarySearch(list, element));
		System.out.println(binarySearch(list, element));
	}
	
	private static int binarySearch(List<Integer> list, int timestamp) {

		int lo = 0;
		int hi = list.size() - 1;
		int mid = 0;

		while (lo <= hi) {
			mid = (lo + hi) / 2;

			var midStamp = list.get(mid);

			if (midStamp == timestamp)
				return mid;
			else if (midStamp < timestamp)
				lo = mid + 1;
			else
				hi = mid - 1;
		}

		return -lo-1;
	}
}
