package com.swapnil.adsa1.algo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by swapn on 05-10-2015.
 */
public class BinarySearch extends Searchable {

    private static boolean isSorted = false;

    public static void main(String[] args) {
        Searchable searchable = new BinarySearch();
        Integer[] input = {2, 0, 0, 2, 1, 4, 7, 0, 0, 4};

        searchable.search(input, 0);
    }

    @Override
    public void search(Integer[] inputArray, int key) {
        super.search(inputArray, key);

        if (!isSorted) {
            prerequisites();
        }

        binarySearch(key);
    }

    private void prerequisites() {
        List<Integer> list = Arrays.asList(inputArray);
        Collections.sort(list);
        inputArray = list.toArray(new Integer[list.size()]);
        isSorted = true;
    }

    public void binarySearch(int key) {

        int first = 0;
        int last = length - 1;
        int middle = (first + last) / 2;

        while (first <= last) {
            if (inputArray[middle] < key)
                first = middle + 1;
            else if (inputArray[middle] == key) {
                System.out.println(key + " found at location " + (middle + 1) + ".");
                break;
            } else
                last = middle - 1;

            middle = (first + last) / 2;
        }
        if (first > last)
            System.out.println(key + " is not present in the list.\n");
    }
}
