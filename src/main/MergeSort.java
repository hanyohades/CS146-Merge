import java.util.*;

public class MergeSort {
    public static List<Integer> mergeSort(List<Integer> arr) {
        if (arr.size() <= 1) {
            return arr;
        } 

        int mid = arr.size() / 2;
        
        //Create subArrays from 0 to mid - 1 (Meaning not include the index at mid)
        List<Integer> leftPart = mergeSort(new ArrayList<>(arr.subList(0, mid)));

        //Create subArrays from mid to the last index
        List<Integer> rightPart = mergeSort(new ArrayList<>(arr.subList(mid, arr.size())));

        return merge(leftPart, rightPart);
    }

    public static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> finalArray = new ArrayList<>(left.size() + right.size());
        int i = 0;
        int j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                finalArray.add(left.get(i));
                i += 1;
            }
            else {
                finalArray.add(right.get(j));
                j += 1;
            }
        }

        while (i < left.size()) {
            finalArray.add(left.get(i++));
        }

        while (j < right.size()) {
            finalArray.add(right.get(j++));
        }

        return finalArray;
    }
}
