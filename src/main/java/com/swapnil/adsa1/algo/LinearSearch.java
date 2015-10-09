package com.swapnil.adsa1.algo;

import com.swapnil.adsa1.searcher.Searchable;

/**
 * Created by swapn on 05-10-2015.
 */
public class LinearSearch extends Searchable {

    public static void main(String[] args) {
        Searchable searchable = new LinearSearch();
        int[] input = {2, 0, 0, 2, 1, 4, 7, 0, 0, 4};

        searchable.search(input, 2);
    }

    @Override
    public void search(int[] inputArray, int key) {
        super.search(inputArray, key);

        linearSearch(key);

    }

    private void linearSearch(int key) {
        for (int index = 0; index < length; index++) {
            if (inputArray[index] == key) {
                System.out.println(key + " found at location " + (index + 1) + ".");
                break;
            }
        }
    }
}