package com.swapnil.adsa1.searcher;

/**
 * Created by swapn on 05-10-2015.
 */
public abstract class Searchable {

    protected int[] inputArray;
    protected int length;

    private void preSearch(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            System.err.println("Input Array is Empty");
            return;
        }
        this.inputArray = inputArray;
        this.length = inputArray.length;
    }

    public void search(int[] inputArray, int key) {
        preSearch(inputArray);
    }
}
