package com.swapnil.adsa1.algo;

/**
 * Created by swapn on 05-10-2015.
 */
public abstract class Searchable {

    protected Integer[] inputArray;
    protected Integer length;

    private void preSearch(Integer[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            System.err.println("Input Array is Empty");
            return;
        }
        this.inputArray = inputArray;
        this.length = inputArray.length;
    }

    public void search(Integer[] inputArray, int key) {
        preSearch(inputArray);
    }
}
