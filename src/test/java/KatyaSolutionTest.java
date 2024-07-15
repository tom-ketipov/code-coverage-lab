
import org.junit.jupiter.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class KatyaSolutionTest {

    /*
            Notes:
            1) You use both Assertions from JUnit and Assert from TestNG.
            2) Great job with the naming of your test methods!
            3) Be cautious with setups  where a single instance is shared across all test methods.
                In the current case it works perfectly fine, but if we have a situation where we are updating the state of the Solution,
                we risk affecting the test suite with flaky tests.
            4) Try not to write too many asserts in your test cases, because it tends to cloud the core idea of the test + in more complex scenarios it may slow down the core information you want from your check.
                For example in makeComplement_matches_complementary_dna_for_single_character_input() what exactly do you aim to test ?
                - that the method works as expected with a single case character
                - or that every character is translated to its correct opposite one
            5) What is your test idea behind the second assert in makeComplement_matches_complementary_dna_for_multiple_character_input() ?
            6) You've handled the makeComplement_throws_illegal_argument_exception_for_lowercase_characters_which_uppercase_is_a_valid_entry() case very well!
     */

    Solution solution = new Solution();

    @Test
    public void makeComplement_matches_complementary_dna_for_single_character_input() {
        Assertions.assertEquals("T", solution.makeComplement("A"));
        Assertions.assertEquals("A", solution.makeComplement("T"));
        Assertions.assertEquals("G", solution.makeComplement("C"));
        Assertions.assertEquals("C", solution.makeComplement("G"));
    }

    @Test
    public void makeComplement_matches_complementary_dna_for_multiple_character_input() {
        Assertions.assertEquals("TGCA", solution.makeComplement("ACGT"));
        Assertions.assertEquals("TAAACC", solution.makeComplement("ATTTGG"));
    }

    @Test
    public void makeComplement_matches_complementary_dna_for_maximum_length_input() {
        Assertions.assertEquals("TGCATGCATG", solution.makeComplement("ACGTACGTAC"));
    }

    @Test
    public void makeComplement_throws_illegal_argument_exception_for_dna_input_exceeding_maximum_length() {
        String dna = "ACGTACGTACGA";

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> solution.
                makeComplement(dna));
        Assertions.assertEquals("Invalid DNA strand length: " + dna.length() + ". Length must be between 1 and " +
                "10 inclusively.", exception.getMessage());
    }

    @Test
    public void makeComplement_throws_illegal_argument_exception_for_empty_dna_input() {
        String dna = "";

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> solution.
                makeComplement(dna));
        Assertions.assertEquals("Invalid DNA strand length: " + dna.length() + ". Length must be between 1 and " +
                "10 inclusively.", exception.getMessage());
    }

    @Test
    public void makeComplement_throws_null_pointer_exception_for_null_dna_input() {
        String dna = null;

        NullPointerException exception = Assertions.assertThrows(NullPointerException.class, () -> solution.
                makeComplement(dna));
        Assertions.assertEquals("DNA strand cannot be null.", exception.getMessage());
    }

    @Test
    public void makeComplement_throws_illegal_argument_exception_for_dna_input_with_invalid_character() {
        String dna = "ACGTU";

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> solution.
                makeComplement(dna));
        Assertions.assertEquals("Invalid character in DNA strand: '" + 'U' + "'. Allowed characters are A, T, C," +
                " and G.", exception.getMessage());
    }

    @Test
    public void makeComplement_throws_illegal_argument_exception_for_lowercase_characters_which_uppercase_is_a_valid_entry() {
        String[] lowerCaseDnas = {"AtTGC", "ATTGc", "aTTGC", "ATTgC"};
        char[] invalidChars = {'t', 'c', 'a', 'g'};

        for (int i = 0; i < lowerCaseDnas.length; i++) {
            String dna = lowerCaseDnas[i];
            char invalidChar = invalidChars[i];
            try {
                solution.makeComplement(dna);
                Assert.fail("Expected IllegalArgumentException for input: " + dna);
            } catch (IllegalArgumentException e) {
                Assertions.assertEquals("Invalid character in DNA strand: '" + invalidChar + "'. Allowed " +
                        "characters are A, T, C, and G.", e.getMessage());
            }
        }
    }
}

