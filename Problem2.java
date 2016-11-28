// Brennan Huber
// MATH 4600

public class Problem2 {
	
	// all thats left to do is verify convergence.
	// m=1 should be linear convergence.
	// m=2 should be quadratic. 
	
	public static void main(String args[]) {

		// Initializing variables.
		int N = 25;
		
		double x_m1[] = new double[N];
		double x_m2[] = new double[N];
		x_m1[0] = 3.0;
		x_m2[0] = 3.0;
		
		int m1 = 1;
		int m2 = 2;
		
		double error = Math.pow(10, -12);
		double backwards_error = 0.0;
		
		// backwards error of approximation x_c is abs(f(x_c))
		
		for(int i = 0; i < N - 1; i++) {
			
			// calculating our approximation.
			x_m1[i + 1] = x_m1[i] - m1*(f(x_m1[i])/fPrime(x_m1[i]));
			
			// calculating backwards error.
			backwards_error = Math.abs(f(x_m1[i]));
			
			// printing intermediate points, and backwards error.
			System.out.println("x_" + i + " = " + x_m1[i]);
			System.out.println("Backwards error = " + backwards_error);
			
			// if the backwards error is lower than we want, we are exiting the loop.
			if(backwards_error < error) {
				System.out.println("Backwards error is now lower than designated error: Stopping computation.");
				break;
			}
		}
		
		System.out.println();
		
		for(int i = 0; i < N - 1; i++) {
			
			// calculating approximation
			x_m2[i + 1] = x_m2[i] - m2*(f(x_m2[i])/fPrime(x_m2[i]));
			
			// calculating backwards error
			backwards_error = Math.abs(f(x_m1[i]));

			// printing intermediate points, and backwards error.
			System.out.println("x_" + i + " = " + x_m2[i]);
			System.out.println("Backwards error = " + backwards_error);

			// if the backwards error is lower than we want, we are exiting the loop.
			if(backwards_error < error) {
				System.out.println("Backwards error is now lower than designated error: Stopping computation.");
				break;
			}
		}
		
	}
	
	// given formula: f(x)
	private static double f(double z) {
		return (z*z*z) - 3*(z*z) + 4;
	}
	
	// derivative of given formula: f'(x)
	private static double fPrime(double z) {
		return 3*(z*z) - 6*z;
	}

}
