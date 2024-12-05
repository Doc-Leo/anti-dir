package leo;

import java.util.Scanner;

public class RentazidaNewtonsInterpolationProject {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Number of data points
        System.out.print("Enter the number of data points: ");
        int n = scanner.nextInt();

        // Arrays to store x and y values
        double[] x = new double[n];
        double[] y = new double[n];

        // Inputting the data points
        System.out.println("size of table:");
        for (int i = 0; i < n; i++) {
            System.out.print("x[" + i + "] = ");
            x[i] = scanner.nextDouble();
            System.out.print("y[" + i + "] = ");
            y[i] = scanner.nextDouble();
        }

        // Value for which interpolation is required
        System.out.print("X Value: ");
        double xValue = scanner.nextDouble();

        // Calculation of divided differences
        double[][] dividedDifferences = calculateDividedDifferences(x, y);

        // Printing the computation table
        System.out.println("\nInterpolation Table:");
        System.out.println("------------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-20s | %-12s | %-12s | %-12s | %-12s | %-12s | %n", "x", "y", "1st Diff", "2nd Diff", "3rd Diff", "...", "");
        System.out.println("------------------------------------------------------------------------------");

        for (int i = 0; i < n; i++) {
            System.out.printf("| %-10.4f | %-20.4f | %-12.4f | %-12.4f | %-12.4f | %-12.4f | %-12.4f | %n", x[i], y[i], dividedDifferences[i][1], dividedDifferences[i][2], dividedDifferences[i][3], dividedDifferences[i][4], dividedDifferences[i][5]);
        }
        System.out.println("------------------------------------------------------------------------------");

        // Interpolation
        double interpolatedValue = interpolate(x, dividedDifferences, xValue);

        // Printing the interpolated value
        System.out.println("\nInterpolated value at x = " + xValue + " is: " + interpolatedValue);
    }

    // Function to calculate divided differences
    private static double[][] calculateDividedDifferences(double[] x, double[] y) {
        int n = x.length;
        double[][] dividedDifferences = new double[n][n];
        for (int i = 0; i < n; i++) {
            dividedDifferences[i][0] = y[i];
        }
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < n - j; i++) {
                dividedDifferences[i][j] = (dividedDifferences[i + 1][j - 1] - dividedDifferences[i][j - 1]) / (x[i + j] - x[i]);
            }
        }
        return dividedDifferences;
    }

    // Function to interpolate
    private static double interpolate(double[] x, double[][] dividedDifferences, double xValue) {
        int n = x.length;
        double result = dividedDifferences[0][0];
        for (int i = 1; i < n; i++) {
            double term = dividedDifferences[0][i];
            for (int j = 0; j < i; j++) {
                term *= (xValue - x[j]);
            }
            result += term;
        }
        return result;
    }
}