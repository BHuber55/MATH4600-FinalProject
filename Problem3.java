// Brennan Huber
// MATH 4600

public class Problem3 {
/*
 *	Write a problem to apply the formula
 *		f^(4) (x) = a ton of shit.
 *
 * to approximate the fourth derivative of f(x) = cos(2x) at x=pi/8, with h= 1/3, 1/9, 1/27.... 1/3^5. Print out the error
 * 		in absolute value for each choice of h, and verify that your numerical results have the correct order of accuracy.
 */

	private static double h[] = new double[5];
	private static double x = Math.PI/8;
	private static double fourth = 16*Math.cos(2*x);
	private static int N = h.length;
	
	
	public static void main(String args[]) {
		// setting up h
		for(int i = 0; i < 5; i++) {
			h[i] = 1/Math.pow(3, (i+1));
		}
		
		// so apply a formula to get 4th derivative equivalent
		double answer[] = approximation(h);
		
		// Printing out the solution
		System.out.println("Solution: ");
		for(int i = 0; i < N; i++) {
			System.out.println(answer[i]);
		}
		
		System.out.println();
		double error[] = new double[N];
		// Printing out the absolute error
		for(int i = 0; i < N; i++) {
			error[i] = Math.abs(fourth - answer[i]);
			System.out.println(error[i]);
		}
		
		// =================================================
		// BLAH BLAH BLAH verify correct order of accuracy.
	}
	
	public static double[] approximation(double h[]) {
		double solution[] = new double[N];
		
		// Applying the given formula to approximate the fourth derivative.
		for(int i = 0; i < N; i++) {
			solution[i] = (f(x - 2*h[i]) - 4*f(x - h[i]) + 6*f(x) - 4*f(x+h[i]) + f(x + 2*h[i]) ) / Math.pow(h[i], 4);
		}
		
		return solution;
	}

	
	private static double f(double z) {
		return Math.cos(2*z);
	}

}
