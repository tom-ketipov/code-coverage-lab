import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    /*
        todo:
            1. Checkout a feature branch named after yourself from the master branch.
            2. Write unit tests with the goal of achieving 100% statement and branch coverage.
            3. Check for any missed cases or bugs, even with 100% coverage. If you find any bugs, fix them and write tests to cover them.
             If there are no issues, add a short comment explaining why.
            4. Commit your branch to the remote repository.
     */

    private Solution solution;

    @BeforeEach
    public void setUp() {
        solution = new Solution();
    }

    @Test
    public void can_complement_dna_string_with_only_valid_characters() {
        String dna = "A";
        Assertions.assertEquals("T", solution.makeComplement(dna));
    }

    @Test
    public void can_complement_max_allowed_length_dna_strings_with_only_valid_characters() {
        String dna = "ATTGCGTATT";
        Assertions.assertEquals("TAACGCATAA", solution.makeComplement(dna));
    }

    @Test
    public void makeComplement_throws_illegal_argument_exception_for_empty_dna_input() {
        String dna = "";

        try {
            solution.makeComplement(dna);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("Invalid DNA strand length: " + dna.length() + ". Length must be between 1 and 10 inclusively.", e.getMessage());
        }
    }

    @Test
    public void makeComplement_throws_illegal_argument_exception_for_dna_input_that_are_bigger_than_allowed_max_length() {
        String dna = "ATATATATATA";

        try {
            solution.makeComplement(dna);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("Invalid DNA strand length: " + dna.length() + ". Length must be between 1 and 10 inclusively.", e.getMessage());
        }
    }

    @Test
    public void makeComplement_throws_illegal_argument_exception_for_lowercase_characters_which_uppercase_is_a_valid_entry() {
        String dna = "AtTGC";

        try {
            solution.makeComplement(dna);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("Invalid character in DNA strand: 't'. Allowed characters are A, T, C, and G.", e.getMessage());
        }
    }

    @Test
    public void makeComplement_throws_illegal_argument_exception_for_illegal_uppercase_characters() {
        String dna = "AGCB";

        try {
            solution.makeComplement(dna);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("Invalid character in DNA strand: 'B'. Allowed characters are A, T, C, and G.", e.getMessage());
        }
    }

    @Test
    public void makeComplement_throws_null_pointer_exception_for_null_input() {
        try {
            solution.makeComplement(null);
        } catch (NullPointerException e) {
            Assertions.assertEquals("DNA strand cannot be null.", e.getMessage());
        }
    }
}