import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class MergeSortTest {

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
    public void emptyList() {
        List<Integer> input = new ArrayList<>();
        List<Integer> result = MergeSort.mergeSort(input);
        assertWithOutput("emptyList", new ArrayList<>(), result);
    }

    @Test
    public void singleElement() {
        List<Integer> input = Arrays.asList(5);
        List<Integer> result = MergeSort.mergeSort(input);
        assertWithOutput("singleElement", Arrays.asList(5), result);
    }

    @Test
    public void alreadySorted() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4);
        List<Integer> result = MergeSort.mergeSort(input);
        assertWithOutput("alreadySorted", Arrays.asList(1, 2, 3, 4), result);
    }

    @Test
    public void reverseSorted() {
        List<Integer> input = Arrays.asList(4, 3, 2, 1);
        List<Integer> result = MergeSort.mergeSort(input);
        assertWithOutput("reverseSorted", Arrays.asList(1, 2, 3, 4), result);
    }

    @Test
    public void duplicates() {
        List<Integer> input = Arrays.asList(3, 1, 3, 2, 1);
        List<Integer> result = MergeSort.mergeSort(input);
        assertWithOutput("duplicates", Arrays.asList(1, 1, 2, 3, 3), result);
    }

    @Test
    public void myExample() {
        List<Integer> input = Arrays.asList(5, 4, 2, 1, 7, 8, 9, 3);
        List<Integer> result = MergeSort.mergeSort(input);
        assertWithOutput("myExample", Arrays.asList(1, 2, 3, 4, 5, 7, 8, 9), result);
    }
}
