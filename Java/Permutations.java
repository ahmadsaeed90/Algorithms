public class Permutations {

	/*
	 * To generate permutations of an array 
	 * l is the current location at which we should move all chars one by one. 
	 * Once moved, recursively solve the remaining array from l+1
	 * Then put pack the char in its original place
	 */

	public static void permute(char [] chars, int l) {
		
		if (l >= chars.length)
			return;
		
		if (l == chars.length - 1)
			System.out.println(new String(chars));
		else {
			for (var i = l; i < chars.length; i++) {
				
				swap(chars, i, l);
				permute(chars, l+1);
				swap(chars, i, l);
			}
		}
	}
	
	private static void swap(char [] chars, int i, int j) {
		var c = chars[i];
		chars[i] = chars[j];
		chars[j] = c;
	}

	public static void main(String[] args) {
		
		String s = "abc";
		permute(s.toCharArray(), 0);
	}
}
