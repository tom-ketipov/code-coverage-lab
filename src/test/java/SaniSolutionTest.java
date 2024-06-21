import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.fail;

public class SaniSolutionTest {
    Solution solution = new Solution();

    @Test
    public void saniSolutionNullTest(){
        try {
            solution.makeComplement(null);
            fail("Should fail - null");
        } catch ( NullPointerException e ) {
            assertTrue( e.getMessage().contains("DNA strand cannot be null."), "No Null exception" );
        }
     }

    @Test
    //bug && instead of ||
    public void saniSolutionLongerStringTest(){
        try {
            solution.makeComplement("ATTGCATTGCATTGCATTGC");
            fail("Should fail - too long");
        } catch ( IllegalArgumentException e ) {
            assertTrue( e.getMessage().contains("Invalid DNA strand length"), "No Invalid length exception" );
        }

    }

    @Test
    //bug && instead of ||
    public void saniSolutionEmptyStringTest(){
        try {
            solution.makeComplement("");
            fail("Should fail - empty");
        } catch ( IllegalArgumentException e ) {
            assertTrue( e.getMessage().contains("Invalid DNA strand length"), "No empty string exception" );
        }
    }

    @Test
    public void saniSolutionTest(){
        String result = solution.makeComplement("ATTGC");
        assertEquals(result, "TAACG", "Returned string not as expected");
    }

    @Test
    public void saniSolutionCharNotAllowedTest(){
        try {
            solution.makeComplement("ATTGCWE");
            fail("Should fail - invalid character");
        } catch ( IllegalArgumentException e ) {
            assertTrue( e.getMessage().contains("Invalid character in DNA strand"), "No Invalid character exception" );
        }
    }

    //additional tests
    @Test
    public void saniSolutionCharSmallTest(){
        try {
            solution.makeComplement("attgc");
            fail("Should fail - invalid character");
        } catch ( IllegalArgumentException e ) {
            assertTrue( e.getMessage().contains("Invalid character in DNA strand"), "No Invalid character exception when lowercase" );
        }
    }

    @Test
    public void saniSolutionCharNumberTest(){
        try {
            solution.makeComplement("1234123412341234123412341234");
            fail("Should fail - invalid character");
        } catch ( IllegalArgumentException e ) {
            assertTrue( e.getMessage().contains("Invalid character in DNA strand"), "No Invalid character exception when numbers" );
        }
    }



}
