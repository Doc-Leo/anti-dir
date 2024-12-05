package leo;

import java.util.Scanner;

public class RentazidaLagrangeInterpolationProject {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of data points
        System.out.print("Table size: ");
        int n = scanner.nextInt();

        double[] x = new double[n];
        double[] y = new double[n];

        // Input the data points
        for (int i = 0; i < n; i++) {
            System.out.print("Enter x[" + i + "]: ");
            x[i] = scanner.nextDouble();
            System.out.print("Enter y[" + i + "]: ");
            y[i] = scanner.nextDouble();
        }

        // Input the value for interpolation
        System.out.print("X Value: ");
        double interpolateX = scanner.nextDouble();

        // Compute the interpolated value
        double result = lagrangeInterpolation(x, y, interpolateX);

        System.out.printf("Interpolated value at x = %.1f: %.3f%n", interpolateX, result);
        scanner.close();
    }

    // Lagrange Interpolation Function
    public static double lagrangeInterpolation(double[] x, double[] y, double interpolateX) {
        double result = 0;

        for (int i = 0; i < x.length; i++) {
            double term = y[i];
            for (int j = 0; j < x.length; j++) {
                if (j != i) {
                    term = term * (interpolateX - x[j]) / (x[i] - x[j]);
                }
            }
            result += term;
        }

        return result;
    }
}
