// Brennan Huber and Katie Rouse
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
		
		double error = Math.pow(10, -12);
		double backwards_error1[] = new double[N];
		double backwards_error2[] = new double[N];
		int steps1 = 0;
		int steps2 = 0;
		
		backwards_error1[0] = Math.abs(f(x_m1[0]));
		backwards_error2[0] = Math.abs(f(x_m2[0]));
		
		for(int i = 0; i < N - 1; i++) {
			
			// calculating our approximation, with m=1
			x_m1[i + 1] = x_m1[i] - (f(x_m1[i])/fPrime(x_m1[i]));
			
			// calculating backwards error.
			backwards_error1[i + 1] = Math.abs(f(x_m1[i + 1]));
			
			// printing intermediate points, and backwards error.
			System.out.println("x_" + i + " = " + x_m1[i]);
			System.out.println("Backwards error = " + backwards_error1[i]);
			
			// if the backwards error is lower than we want, we are exiting the loop.
			if(backwards_error1[i] < error) {
				System.out.println("Backwards error is now lower than designated error: Stopping computation.");
				break;
			}
			
			// incrementing number of steps taking
			steps1++;
		}
		
		System.out.println();
		
		for(int i = 0; i < N - 1; i++) {
			
			// calculating approximation, with m=2
			x_m2[i + 1] = x_m2[i] - (2*(f(x_m2[i])/fPrime(x_m2[i])));
			
			// calculating backwards error
			backwards_error2[i] = Math.abs(f(x_m1[i]));

			// printing intermediate points, and backwards error.
			System.out.println("x_" + i + " = " + x_m2[i]);
			System.out.println("Backwards error = " + backwards_error2[i]);
			
			// if the backwards error is lower than we want, we are exiting the loop.
			if(backwards_error2[i] < error) {
				System.out.println("Backwards error is now lower than designated error: Stopping computation.");
				break;
			}
			
			// incrementing number of steps taking
			steps2++;
		}
		System.out.println();
		
		// verifying convergence rates
		double convergence1 = backwards_error1[steps1] / backwards_error1[steps1 - 1];
		double convergence2 = backwards_error2[steps2] / backwards_error2[steps2 - 1];
		
		// this is just wrong. I am getting linear for both.
		
		System.out.println("Convergence 1 = " + convergence1);
		System.out.println("Convergence 2 = " + convergence2);
		System.out.println();
		
		if(convergence1 < 1.0) {
			System.out.println("Linear Convergence");
		} else {
			System.out.println("Quadatic Convergence");
		}
		
		if(convergence1 < 1.0) {
			System.out.println("Linear Convergence");
		} else {
			System.out.println("Quadatic Convergence");
		}
	}
	
	// given formula: f(x)
	private static double f(double z) {
		return (z*z*z) - (3*(z*z)) + 4;
	}
	
	// derivative of given formula: f'(x)
	private static double fPrime(double z) {
		return (3*(z*z)) - (6*z);
	}

}
