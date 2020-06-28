import java.util.Arrays;
import java.util.List;

public class BinarySearch {
	
	/**
	 * Returns index of element if it exists. If not, it returns (-tagretIndex-1) similar to Collections.binarySearch
	 * @param list
	 * @param timestamp
	 * @return
	 */
	private static int binarySearch(List<Integer> list, int val) {

		int lo = 0;
		int hi = list.size() - 1;
		int mid = 0;

		while (lo <= hi) {
			mid = (lo + hi) / 2;

			var minVal = list.get(mid);

			if (minVal == val)
				return mid;
			else if (minVal < val)
				lo = mid + 1;
			else
				hi = mid - 1;
		}
		
		// when above loop terminates, "lo" is the index where element should have been
		// we can return lo if we just want new index but that will be confusing because
		// that number could mean the element was found at that positive index
		
		return -lo-1;
	}
	
	public static void main(String[] args) {
		System.out.println(binarySearch(Arrays.asList(10,20), 10));
		System.out.println(binarySearch(Arrays.asList(10,20), 15));
		System.out.println(binarySearch(Arrays.asList(10,20), 25));
	}
}
