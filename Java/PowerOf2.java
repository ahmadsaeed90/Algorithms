
public class PowerOf2 {
	
	public static boolean isPowerOf2Fast(int n) {
		return n > 0 && (n & (n-1)) == 0;
	}

	public static boolean isPowerOf2(int n) {
		int oneCount = 0;

		while (n > 0) {
			oneCount += (n & 1) == 1? 1 : 0;
			
			if (oneCount > 1)
				return false;
			
			n = n >> 1;
		}
		
		return oneCount == 1;
	}

	public static void main(String[] args) {
		System.out.println(isPowerOf2Fast(1));
		System.out.println(isPowerOf2Fast(3));
		System.out.println(isPowerOf2Fast(16));
	}
}
