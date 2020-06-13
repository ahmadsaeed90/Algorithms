
public class MatrixCreation {
	public static int[][] createMatrix(int m, int n, String startPos, String movingDirection) {

		var matrix = new int[m][n];

		int step = 1;
		int i = 0, j = 0;
		int iDir = 0, jDir = 0; // direction 1 means right, -1 means left, 0 no change

		// Initialize position and direction
		switch (startPos) {
		case "TL":
			i = j = 0;
			iDir = movingDirection.equals("V") ? 1 : 0;
			jDir = movingDirection.equals("H") ? 1 : 0;
			break;
		case "TR":
			i = 0;
			j = n - 1;
			iDir = movingDirection.equals("V") ? 1 : 0;
			jDir = movingDirection.equals("H") ? -1 : 0;
			break;
		case "BL":
			i = m - 1;
			j = 0;
			iDir = movingDirection.equals("V") ? -1 : 0;
			jDir = movingDirection.equals("H") ? 1 : 0;
			break;
		case "BR":
			i = m - 1;
			j = n - 1;
			iDir = movingDirection.equals("V") ? -1 : 0;
			jDir = movingDirection.equals("H") ? -1 : 0;
			break;
		}

		int maxStep = m * n;

		while (step <= maxStep) {

			matrix[i][j] = step++;

			j += jDir;		// update horizontal direction

			var horizontalOut = false;

			if (j >= n) {
				j = n - 1;
				horizontalOut = true;
			} else if (j < 0) {
				j = 0;
				horizontalOut = true;
			}

			if (horizontalOut) {
				if (startPos.charAt(0) == 'T') {
					i++;
				} else {
					i--;
				}
				jDir *= -1;		// reverse horizontal direction
			}

			i = i + iDir;
			boolean verticalOut = false;

			if (i >= m) {
				i = m - 1;
				verticalOut = true;
			} else if (i < 0) {
				i = 0;
				verticalOut = true;
			}

			if (verticalOut) {
				if (startPos.charAt(1) == 'L') {
					j++;
				} else {
					j--;
				}
				iDir *= -1;
			}
		}
		return matrix;
	}

	public static void main(String[] args) {

		int m = 3;
		int n = 3;
		String startPos = "TR";
		String movingDirection = "H";

		var matrix = createMatrix(m, n, startPos, movingDirection);

		for (var row : matrix) {
			for (var col : row)
				System.out.print(col + " ");
			System.out.println();
		}
	}
}
