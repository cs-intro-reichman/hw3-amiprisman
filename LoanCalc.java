// Computes the periodical payment necessary to pay a given loan.
public class LoanCalc {
    static double epsilon = 0.001;  // Approximation accuracy
    static int iterationCounter;    // Number of iterations

    public static void main(String[] args) {
        // Get the loan data
        double loan = Double.parseDouble(args[0]);
        double rate = Double.parseDouble(args[1]);
        int n = Integer.parseInt(args[2]);
        System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

        // Compute the periodical payment using brute force search
        System.out.print("\nPeriodical payment, using brute force: ");
        System.out.println((int) Math.round(bruteForceSolver(loan, rate, n, epsilon)));
        System.out.println("number of iterations: " + iterationCounter);

        // Compute the periodical payment using bisection search
        System.out.print("\nPeriodical payment, using bisection search: ");
        System.out.println((int) Math.round(bisectionSolver(loan, rate, n, epsilon)));
        System.out.println("number of iterations: " + iterationCounter);
    }

    private static double endBalance(double loan, double rate, int n, double payment) {
    double balance = loan;
    double monthlyRate = rate / 100 / 12;  

    for (int i = 0; i < n; i++) {
        balance = balance * (1 + monthlyRate);  
        balance = balance - payment;  
        if (balance < 0) { 
            return 0;  
        }
    }
    return balance;
}

    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
        double x = loan / n;  // Initial guess
        iterationCounter = 0;
        while (true) {
            iterationCounter++;
            double balance = endBalance(loan, rate, n, x);
            if (Math.abs(balance) <= epsilon) {
                return x;
            } else if (balance > 0) {
                x += epsilon;
            } else {
                x -= epsilon;  
            }
        }
    }

    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {
    double L = 0;  // Lower bound starts from 0 (no payment)
    double H = loan * (1 + rate / 100);  // Upper bound assumes max compounding
    double M = 0;  // Midpoint
    iterationCounter = 0;

    while (H - L > epsilon) {
        iterationCounter++;
        M = (H + L) / 2;  // Compute midpoint
        double balance = endBalance(loan, rate, n, M);

        if (balance > 0) {  // If balance is positive, payment is too low
            L = M;
        } else {  // If balance is negative, payment is too high
            H = M;
        }
    }
    return M;  // Return the midpoint as the approximate payment
}
}
