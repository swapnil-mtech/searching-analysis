package com.swapnil.adsa1.algo;

import com.swapnil.adsa1.searcher.Searchable;
import com.swapnil.adsa1.util.ArrayUtil;

/**
 * Created by swapn on 05-10-2015.
 */
public class BinarySearch extends Searchable {

    private static boolean isSorted = false;

    public static void main(String[] args) {
        Searchable searchable = new BinarySearch();
        int[] input = {2, 0, 0, 2, 1, 4, 7, 0, 0, 4};

        searchable.search(input, 0);
    }

    @Override
    public void search(int[] inputArray, int key) {
        super.search(inputArray, key);

        binarySearch(key);
    }

    private void prerequisites() {
    	ArrayUtil.quickSort(inputArray, 0, length - 1);
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
