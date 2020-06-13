
public class MaxImageSize {

	public static int[] getImageMaxSize(int x, int y, int max_x, int max_y) {

		double ratio = x / y;

		int newX = max_x;				// try taking full width
		int newY = (int) (max_x / ratio);
		
		// if taking full width has resulted in overflow height
		if (newY > max_y) {
			// take full height
			newY = max_y;
			newX = (int) (max_y * ratio);
		}

		return new int[] { newX, newY };
	}

	public static void main(String[] args) {
		var res = getImageMaxSize(200, 100, 600, 200);
		System.out.println(res[0] + "," + res[1]);
	}
}
