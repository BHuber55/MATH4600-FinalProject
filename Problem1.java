// Brennan Huber and Katie Rouse
// MATH 4600

public class Problem1 {
	
	public static void main(String args[]) {
		double A[][] = {	{4,3,-2,5},
							{8,1, 0,6},
							{2,4, 5,6},
							{3,1, 7,2}	};

		double b[] = {	26.6654,
						37.7765,
						54.4432,
						37.7779 };

		int N = b.length;
		
		
		// printing the original problem.
		System.out.println("Original Problem: ");
		
		for(int i = 0; i < N; i++) {
			
			for(int j = 0; j < N; j++) {
				System.out.print(A[i][j] + "   ");
			}
			
			System.out.println( "x_" + (i + 1) + " =   " + b[i]);
		}
		
		// solving the original problem.
		double x[] = solve(A, b);

		System.out.println();
		System.out.println("Solution: ");
		
		// printing solution
		// formatted so it only has 5 decimal digits.
		for(int i = 0; i < N; i++) {
			System.out.println("x_" + (i + 1) + " = " + String.format("%1$.5f", x[i]));
		}
	}
	
	
	public static double[] solve(double[][] A, double[] b) {
		
		int N = b.length;
		
		// Forward Elimination
		for(int i = 0; i < N; i++) {
			int max = i;
			
			// partial pivoting part
			for(int j = i + 1; j < N; j++) {
				if(Math.abs(A[j][i]) > Math.abs(A[max][i])) {
					max = j;
				}
			}
			
			// row swapping OG matrix to partial pivoted matrix.
			double temp_A[] = A[i];
			A[i] = A[max];
			A[max] = temp_A;
			
			// row swapping OG constants
			double temp_b = b[i];
			b[i] = b[max];
			b[max] = temp_b;
			
			// actual elimination process
			for(int j = i + 1; j < N; j++) {
				double alpha = A[j][i] / A[i][i];
				
				b[j] -= alpha*b[i];
				
				for(int k = i; k < N; k++) {
					A[j][k] -= alpha*A[i][k];
				}
			}
		}
		
		System.out.println();
		System.out.println("Forward Elimination: ");
		
		for(int i = 0; i < N; i++) {
			
			for(int j = 0; j < N; j++) {
				System.out.print(A[i][j] + "   ");
			}
			
			System.out.println( "x_" + (i + 1) + " =   " + b[i]);
		}
		
		// Backwards Substitution
		double mult;
		
		for(int i = N - 1; i >= 0; i--) {
			mult = 0;
			// fixing diagonals
			mult = A[i][i];
			A[i][i] = A[i][i]/mult;
			b[i] = b[i]/mult;
			
			for(int j = i + 1; j < N; j++) {
				A[i][j] = A[i][j]/mult;
			}
			
			for(int k = i - 1; k >= 0; k--) {
				b[k] = b[k] - A[k][i]*b[i];
				A[k][i] = 0;
			}
		}
		
		System.out.println();
		System.out.println("Backwards Substitution: ");
		
		for(int i = 0; i < N; i++) {
			
			for(int j = 0; j < N; j++) {
				System.out.print(A[i][j] + "   ");
			}
			
			System.out.println( "x_" + (i + 1) + " =   " + b[i]);
		}
		
		return b;
	}
}
