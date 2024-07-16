
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
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

    /*
        1) I decided to use TestNG and rework my tests. Considering the available options in TestNG,
         I've decided to use the try-catch approach for testing exceptions because it offers better flexibility for testing various properties of exceptions, including their type and message.

         Answer: => Nice work

        3) I used a separate instance for each test using BeforeMethod.
        4) In makeComplement_matches_complementary_dna_for_single_character_input() I'm testing the translation of each nucleotide.
        Do you think it will be a better idea to split this test into four separate tests and name them like this makeComplement_matches_complementary_dna_for_input_C(),makeComplement_matches_complementary_dna_for_input_A() etc.?

        Answer: => I think that it is kind of a personal preference for the specific test and how we want to debug the output information from our tests. Personally I would probably make single character translations checks.
        In this way, in my opinion I would have less friction in getting back the information from a potential test output report.

        Having said all that, the case is simple enough to be handled in a single case too, but I would probably think a little bit about the naming of it.

        In my head I imagine the following situation when writing test case names:
            - You have a test results report and developers look at it. They might not know the assertions made in each case.
             So... If you are a developer what is the name that would give the most accurate information about the case checked in your test.

                * if a test case named makeComplement_matches_complementary_dna_for_single_character_input() fails, my first though would be that I have a problem with the length validation on its lower boundary
                    "if (dna.isEmpty() || dna.length() > 10)"

                * if a test case named  for example makeComplement_translates_all_valid_nucleotide_characters() fails, my though would probably be to:
                    1. check the getComplement(char c) branches
                    2. I would probably think about the length

           PS: I think that naming of the test cases is of major importance when writing an automation checks tool. It can be pain in the ass to focus this much on your test methods, but
           I think in the long run is always beneficial both for you and everyone that is going to use your tool.

        5) The second assertion in makeComplement_matches_complementary_dna_for_multiple_character_input() checks if the makeComplement method can handle repeating characters.
         I rename the test to makeComplement_handles_repeating_characters().The new name could improve the readability and understanding of the test.

         Answer: ===> Do we need the first assert in that case? Does it provide you any information about repeating characters?
     */

    private Solution solution;

    @BeforeMethod
    public void setUp() {
        solution = new Solution();
    }

    @Test
    public void makeComplement_matches_complementary_dna_for_single_character_input() {
        Assert.assertEquals("T", solution.makeComplement("A"));
        Assert.assertEquals("A", solution.makeComplement("T"));
        Assert.assertEquals("G", solution.makeComplement("C"));
        Assert.assertEquals("C", solution.makeComplement("G"));
    }

    @Test
    public void makeComplement_handles_repeating_characters() {
        Assert.assertEquals("TGCA", solution.makeComplement("ACGT"));
        Assert.assertEquals("TAAACC", solution.makeComplement("ATTTGG"));
    }

    @Test
    public void makeComplement_matches_complementary_dna_for_maximum_length_input() {
        Assert.assertEquals("TGCATGCATG", solution.makeComplement("ACGTACGTAC"));
    }

    @Test
    public void makeComplement_throws_illegal_argument_exception_for_dna_input_exceeding_maximum_length() {
        String dna = "ACGTACGTACGA";
        try {
            solution.makeComplement(dna);
            Assert.fail("Expected IllegalArgumentException was not thrown.");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals(e.getMessage(), "Invalid DNA strand length: " + dna.length() + ". Length must be" +
                    " between 1 and 10 inclusively.");
        }
    }

    @Test
    public void makeComplement_throws_illegal_argument_exception_for_empty_dna_input() {
        String dna = "";
        try {
            solution.makeComplement(dna);
            Assert.fail("Expected IllegalArgumentException was not thrown.");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals(e.getMessage(), "Invalid DNA strand length: " + dna.length() + ". Length must be" +
                    " between 1 and 10 inclusively.");
        }
    }

    @Test
    public void makeComplement_throws_null_pointer_exception_for_null_dna_input() {
        String dna = null;
        try {
            solution.makeComplement(dna);
            Assert.fail("Expected NullPointerException was not thrown.");
        } catch (NullPointerException e) {
            Assert.assertEquals(e.getMessage(), "DNA strand cannot be null.");
        }
    }

    @Test
    public void makeComplement_throws_illegal_argument_exception_for_dna_input_with_invalid_character() {
        String dna = "ACGTU";
        try {
            solution.makeComplement(dna);
            Assert.fail("Expected IllegalArgumentException was not thrown.");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals(e.getMessage(), "Invalid character in DNA strand: '" + 'U' + "'. Allowed " +
                    "characters are A, T, C, and G.");
        }
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
                Assert.assertEquals("Invalid character in DNA strand: '" + invalidChar + "'. Allowed " +
                        "characters are A, T, C, and G.", e.getMessage());
            }
        }
    }
}

