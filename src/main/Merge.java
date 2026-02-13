import java.util.*;

public class Merge {
    public static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> combinedArray = new ArrayList<>(left.size() + right.size());
        int i = 0;
        int j = 0;

        /*  
        Continue looping while both lists have remaining elements.
        Compare the current elements from each list and add the smaller one
        to the combined list.
        */
        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                combinedArray.add(left.get(i));
                i += 1;
            }
            else {
                combinedArray.add(right.get(j));
                j += 1;
            }
        }

        //Add any remaining elements from the left list.
        while (i < left.size()) {
            combinedArray.add(left.get(i++));
        }

        //Add any remaining elements from the right list.
        while (j < right.size()) {
            combinedArray.add(right.get(j++));
        }

        return combinedArray;
    }
}


