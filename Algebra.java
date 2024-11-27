// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		// Replace the following statement with your code
			if (x2>0){
				for (int i = 0; i < x2 ; i++){
					x1++;
				}
			}
			else if (x2<0){
				for (int r = 0; r < Math.abs(x2); r++ ){
					x1--;
				}
			}
		
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
	if (x2>0){
		for (int i = 0; i<x2;i++){
			x1--;
		}
	}
	else if (x2<0) {
		for (int i = 0; i < Math.abs(x2); i++) {
            x1++;
	}
		}
	return x1;
	}	
	
	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int result = 0;
		boolean negetive = (x1<0) ^ (x2<0);
		x1 = Math.abs(x1);
		x2 = Math.abs(x2);
		
		for (int i = 0; i < x2; i++) {
    		 for (int r = 0; r < x1; r++) {
            	result = plus(result, 1); 
       		 }
    }
		if (negetive){
			result = minus(0,result);
		}
		return result;
	}
		


	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		boolean neg = false;
		if (x<0 && mod(n,2)!=0){
			 neg = true; 
		}
		x = Math.abs(x);

		
		int result = 1;
		for (int i = 0; i < n; i++){
			result = times(result,x);
		}
		
	if (neg){
		result = minus(0,result);
	}
		return result;
	}

	// Returns the integer part of x1 / x2 
	
public static int div(int x1, int x2) {
    boolean neg1 = (x1 < 0);
    boolean neg2 = (x2 < 0);

    x1 = Math.abs(x1);
    x2 = Math.abs(x2);

   
    int result = 0;
    while (x1 >= x2) {
        x1 = minus(x1, x2); 
        result++;
    }

    if (neg1 != neg2) {
        result = minus(0, result);  
    }

    return result;
}


	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int step = div(x1,x2);
		int step2 = times(step,x2);
		int result = minus(x1,step2);

		return result;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int val = 0;
		while (times(val,val)<=x){
			val ++;
		} 
	return minus(val,1);
	}	  	  
}