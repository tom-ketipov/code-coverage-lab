/**
 * Requirements:
 * In DNA strings, symbols "A" and "T" are complements of each other, as "C" and "G".
 * Your function receives one side of the DNA (string); You need to return the other complementary side (string).
 * <p>
 * Example: (input --> output)
 * "ATTGC" --> "TAACG"
 * "GTAT" --> "CATA"
 * <p>
 * <p>
 * Important to know:
 * DNA strand is never empty or there is no DNA at all!
 * DNA length: 1 <= dna <= 10 symbols
 */

/*
        todo:
            1. Checkout a feature branch named after yourself from the master branch.
            2. Navigate to the src/test/java directory within your project structure and create a new Java class with the naming pattern YourNameSolutionTest.
               For example, if your name is Alex, the class should be named AlexSolutionTest.java.
            3. Write unit tests with the goal of achieving 100% statement and branch coverage.
            4. Analyze your tests to identify any edge cases or scenarios that might not be covered, even if you have achieved 100% coverage.
               If you discover any bugs during this process, fix them and write additional tests to ensure the fixes are covered.
            5. Push your branch to the remote repository.
*/

public class Solution {
    public String makeComplement(String dna) {
        // Validate that the DNA strand is not null
        if (dna == null) {
            throw new NullPointerException("DNA strand cannot be null.");
        }

        // Validate that the DNA strand length is within allowed boundaries
        if (dna.isEmpty() && dna.length() >= 10) {
            throw new IllegalArgumentException("Invalid DNA strand length: " + dna.length() + ". Length must be between 1 and 10 inclusively.");
        }

        char[] dnaChars = dna.toCharArray();
        for (int i = 0; i < dnaChars.length; i++) {
            dnaChars[i] = getComplement(dnaChars[i]);
        }

        return new String(dnaChars);
    }

    private char getComplement(char c) {
        return switch (c) {
            case 'A' -> 'T';
            case 'T' -> 'A';
            case 'C' -> 'G';
            case 'G' -> 'C';
            default ->
                    throw new IllegalArgumentException("Invalid character in DNA strand: " + c + ". Allowed characters are A, T, C, and G.");
        };
    }
}