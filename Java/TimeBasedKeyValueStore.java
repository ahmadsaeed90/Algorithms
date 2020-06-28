import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValueStore {
	private Map<String, List<Pair>> map;

	/** Initialize your data structure here. */
	public TimeBasedKeyValueStore() {
		map = new HashMap();
	}

	public static void main(String[] args) {

		var store = new TimeBasedKeyValueStore();
		store.set("love", "high", 10);
		store.set("love", "low", 20);

		System.out.println(store.get("love", 15));
	}

	public void set(String key, String value, int timestamp) {

		var list = map.get(key);

		if (list == null) {
			list = new ArrayList<Pair>();
			map.put(key, list);
		}

		list.add(new Pair(timestamp, value));
	}

	public String get(String key, int timestamp) {

		var list = map.get(key);

		if (list == null)
			return "";

		int index = Collections.binarySearch(list, new Pair(timestamp, ""),
				(a, b) -> Integer.compare(a.Timestamp, b.Timestamp));

		if (index >= 0) {
			return list.get(index).Value;
		} else if (index == -1) {
			return "";
		} else
			return list.get(-index - 2).Value;
	}

	class Pair {
		public int Timestamp;
		public String Value;

		public Pair(int timeStamp, String value) {
			Timestamp = timeStamp;
			Value = value;
		}
	}
}
