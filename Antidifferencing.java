package leo;

public class Antidifferencing {

    public static void main(String[] args) {



        System.out.println("\nLeo Gabriel L. Rentazida\n");
        System.out.println("1BSCS-2");
        System.out.println("\nMake a simple program for antidifferencing of x^-m where m is 0,1,2,3,4,5...20. Show your output.\n");
        for (int m = 0; m <= 20; m++) {
            System.out.println(getAntidifference(m));
        }
    }

    public static String getAntidifference(int m) {
        if (m == 0) {
            return "|--- ƒ x⁰ dx = √ 1 dx = x + C  |";
        } else if (m == 1) {
            return "|--- ƒ x⁻¹ dx = 1n|x| + C      |";
        } else if (m == 2) {
            return "|--- ƒ x⁻² dx = -1/2 x^(-2) + C|\n";
        } else {
            return "\t\t\t\t\t\t\t\t\t|--- ƒ x^(-" + m + ") dx = " + "1/" + (-m + 1) + "[x^(" + (-m + 1) + ")]" + " + C|";
        }
    }
}