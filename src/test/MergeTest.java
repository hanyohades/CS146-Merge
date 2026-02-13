import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class MergeTest {

    private void assertWithOutput(String testName, List<Integer> expected, List<Integer> actual) {
        try {
            assertEquals(expected, actual);
            System.out.println("✅\u001B[32m " + testName + " PASSED\u001B[0m");
        } catch (AssertionError e) {
            System.out.println("\u001B[31m❌ " + testName + " FAILED\u001B[0m");
            System.out.println("   expected: " + expected);
            System.out.println("   actual  : " + actual);
            throw e;
        }
    }

    @Test
    public void mergeBasic() {
        List<Integer> left = Arrays.asList(1, 3, 5);
        List<Integer> right = Arrays.asList(2, 4, 6);

        List<Integer> result = Merge.merge(left, right);

        assertWithOutput("Basic Merge: ",
                Arrays.asList(1, 2, 3, 4, 5, 6),
                result);
    }

    @Test
    public void mergeWithDuplicates() {
        List<Integer> left = Arrays.asList(1, 2, 2);
        List<Integer> right = Arrays.asList(2, 3);

        List<Integer> result = Merge.merge(left, right);

        assertWithOutput("Duplicate Merge: ",
                Arrays.asList(1, 2, 2, 2, 3),
                result);
    }

    @Test
    public void mergeOneEmpty() {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = Arrays.asList(1, 2, 3);

        List<Integer> result = Merge.merge(left, right);

        assertWithOutput("One Empty List Merge: ",
                Arrays.asList(1, 2, 3),
                result);
    }
}
