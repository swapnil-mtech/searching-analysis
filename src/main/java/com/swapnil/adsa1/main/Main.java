package com.swapnil.adsa1.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.swapnil.adsa1.searcher.Searchable;
import com.swapnil.adsa1.util.ArrayUtil;
import com.swapnil.adsa1.util.FileUtil;

public class Main {

   //private static final String reportFilePath = "F:\\Swapnil\\Sorting_Analysis_Report.csv";
    
    // Office Location
	private static final String reportFilePath = "/home/swapper/labs/Searching_Analysis_Report.csv";
	
	private static final int[] NUMBER_OF_ELEMENTS_IN_EACH_SET = {10, 100, 1000, 10000, 20000, 40000, 60000};
    private static final int SHUFFLE_EACH_SET_COUNT = 1;
    private static final String[] KEY_POSITION = {"FIRST_ELEMENT", "LAST_ELEMENT", "MINIMUM_VALUE", "MAXIMUM_VALUE"};
    
	public static void main(String[] args) {
		int numberOfSets = NUMBER_OF_ELEMENTS_IN_EACH_SET.length;
        int elementsInSet;
        int[] newArray;
        
        List<Integer> keys = null;

        long startTime, endTime, duration;
        String line;
        Searchable searcher = null;
        
        try {

            if (FileUtil.isFileExist(reportFilePath)) {
                FileUtil.backupFile(reportFilePath);
            }
            FileUtil.writeToFile(reportFilePath, "ALGORITHM_NAME, SET_NUMBER(ELEMENTS_COUNTS), SHUFFLE_NUMBER, KEY, DURATION (NANOSECONDS), DURATION (MILLISECONDS) \n");

            for (int setNumber = 0; setNumber < numberOfSets; setNumber++) {

                for (int shuffleNumber = 1; shuffleNumber <= SHUFFLE_EACH_SET_COUNT; shuffleNumber++) {

                    elementsInSet = NUMBER_OF_ELEMENTS_IN_EACH_SET[setNumber];
                    newArray = ArrayUtil.createArray(elementsInSet);
                    ArrayUtil.shuffleArray(newArray);
                    
                    keys = new ArrayList<Integer>();
                    
                    keys.add(newArray[0]); // First Element
                    keys.add(newArray[newArray.length - 1]); // Last Element
                    keys.add(ArrayUtil.minValue(newArray)); // Minimum Value
                    keys.add(ArrayUtil.maxValue(newArray)); // Maximum Value
                    
                    for (SearchingAlgorithmName algorithmName : SearchingAlgorithmName.values()) {
                    	SearchingAlgorithm algorithm = SearchingAlgorithm.getSearchingAlgorithm(algorithmName);
                    	searcher = algorithm.getAlgorithm();
                        
                    	int[] temp = newArray.clone();
                        ArrayUtil.quickSort(temp, 0, temp.length - 1);
                        
                    	for(int i = 0; i < keys.size(); i++) {
                    
                    		startTime = System.nanoTime();

                            searcher.search(temp,keys.get(i));

                            endTime = System.nanoTime();
                            duration = (endTime - startTime);

                            line = algorithm.getName() + "," + (setNumber + 1) + "(" + elementsInSet + ")" + ","
                                    + shuffleNumber + "," + KEY_POSITION[i] + "," + duration + "," + (duration / 1000000) + "\n";
                            FileUtil.writeToFile(reportFilePath, line);

                    	}
                	}
                }
            }

        } catch (IOException ioException) {
            System.err.println("File Handling Error Occurred. " + ioException.getMessage());
            ioException.printStackTrace();

        } catch (Exception exception) {
            System.err.println("Unknown Error Occurred. " + exception.getMessage());
            exception.printStackTrace();
        }
    }
}
