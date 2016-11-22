// Brennan Huber
// MATH 4600

// Should be done.

public class Problem1 {
/*
 * 
 * 		Write a program to apply Gaussian Elimination to solve the linear system
 * 
 * 			4x4 matrix. b = [26.6654, 37,7765, 54.4432, 37.7779]
 * 
 * 		You may or may not use the partial pivoting. Clearly present your results for the forward elimination and 
 * 		backwards substitution. Present your solution to 5 decimal digits.
 * 
 */

	private static double A[][] = {	{4,3,-2,5},
										{8,1, 0,6},
										{2,4, 5,6},
										{3,1, 7,2}	};
	
	private static double b[] = {	26.6654,
									37.7765,
									54.4432,
									37.7779 };
	
	private static int N = b.length;
	
	public static void main(String args[]) {
		
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
		
		
		// Backwards Substitution
		// pretty sure this is right.. obviously going to need to double check.
		double[] x = new double[N];
		
		for(int i = N - 1; i >= 0; i--) {
			double sum = 0.0;
			
			for(int j = i + 1; j < N; j++) {
				sum += A[i][j]*x[j];
			}
			
			x[i] = (b[i] - sum)/A[i][i];
		}
		
		return x;
	}
}
