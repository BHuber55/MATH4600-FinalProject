// Brennan Huber and Katie Rouse
// MATH 4600

public class Problem3 {

	private static double h[] = new double[5];
	private static double x = Math.PI/8;
	private static double fourth = 16*Math.cos(2*x);
	private static int N = h.length;
	
	public static void main(String args[]) {
		// setting up h
		System.out.println("H:");
		for(int i = 0; i < 5; i++) {
			h[i] = Math.pow(3, (-(i+1)));
			System.out.println(h[i]);
		}
		
		System.out.println();
		
		// so apply a formula to get 4th derivative equivalent
		double answer[] = approximation(h);
		
		// Printing out the solution
		System.out.println("Solution: ");
		for(int i = 0; i < N; i++) {
			System.out.println(String.format("%1$.8f", answer[i]));
		}
		
		System.out.println();
		double error[] = new double[N];
		
		// Printing out the absolute error
		System.out.println("Error: ");
		for(int i = 0; i < N; i++) {
			error[i] = Math.abs(fourth - answer[i]);
			System.out.println(String.format("%1$.8f", error[i]));
		}
		
		System.out.println();
		double accuracy;
		
		// calculating and displaying order of accuracy.
		accuracy = error[4]/error[3];
		double delta_h = h[4]/h[3];
		
		double order = Math.log(accuracy)/Math.log(delta_h);
		System.out.println("Order = " + Math.round(order));
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
