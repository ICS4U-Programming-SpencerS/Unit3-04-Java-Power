import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * Change me.
 *
 * @author Spencer Scarlett
 * @version 1.0
 * @since 2024-04-26
 */

// Power class
public final class Power {

    /** Private constructor to prevent instantiation. */
    private Power() {
        throw new UnsupportedOperationException("Cannot instantiate");
    }

    /**
     * This is the main method.
     *
     * @param args Unused
     */
    public static void main(final String[] args) {
        try {
            // preps file access and writing/reading
            final File fileInput = new File("input.txt");
            final File fileOutput = new File("output.txt");
            final Scanner sc = new Scanner(fileInput);
            final FileWriter fW = new FileWriter(fileOutput);
            final PrintWriter write = new PrintWriter(fW);

            // reads each line of file
            while (sc.hasNext()) {
                // needs two variables, one for power, one for number
                final String StrBase = sc.next();
                final String StrPower = sc.next();
                try {
                    // Parse the input as int
                    final int intBase = Integer.parseInt(StrBase);
                    final int intPower = Integer.parseInt(StrPower);
                    // if the input is a number, check if less than 0, no -1!
                    if (intBase < 0 || intPower < 0) {
                        System.out.println(intBase + " or " + intPower + " can't be a negative number");
                    } else {
                        // Call function and set variable
                        final int powerNum = rewPow(intBase, intPower);
                        // output message to output file
                        write.println(intBase + " to the power of " + intPower + " = " + powerNum);
                    }

                } catch (NumberFormatException Error) {
                    // error output message, only for string, decimal, and other invalid inputs
                    System.err.println("Error! " + StrBase + " or " + StrPower + " is an invalid input!");
                    System.err.println("Positive whole number's accepted only!");
                }
            }

            // program finished
            System.out.println("Done");

            // closes resources
            write.close();
            sc.close();

        } catch (IOException err) {
            // For when no input file is found.
            System.err.println("Error: " + err.getMessage());
        }
    }
    public static int rewPow (int n, int p) {
        // 0 and 1 are base case values for both if the power or number is equal to 0
        if (n == 0)
            return 1;
        if (p == 0)
            return 1;
        // function calculation
        else
            return n * rewPow(n, p - 1);
    }
}
