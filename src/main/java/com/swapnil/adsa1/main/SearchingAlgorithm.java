package com.swapnil.adsa1.main;

import com.swapnil.adsa1.algo.BinarySearch;
import com.swapnil.adsa1.algo.LinearSearch;
import com.swapnil.adsa1.searcher.Searchable;

public enum SearchingAlgorithm {

	LINEAR_SEARCH_ALGORITHM(SearchingAlgorithmName.LINEAR_SEARCH, new LinearSearch()),
	BINARY_SEARCH_ALGORITHM(SearchingAlgorithmName.BINARY_SEARCH, new BinarySearch());
	
	private final SearchingAlgorithmName name;
    private final Searchable algorithm;

    SearchingAlgorithm(final SearchingAlgorithmName name, final Searchable algorithm) {
        this.name = name;
        this.algorithm = algorithm;
    }
    
    public static SearchingAlgorithm getSearchingAlgorithm(SearchingAlgorithmName name) {
    	SearchingAlgorithm algorithm = null;
        switch (name) {
            case LINEAR_SEARCH:
                algorithm = SearchingAlgorithm.LINEAR_SEARCH_ALGORITHM;
                break;

            case BINARY_SEARCH:
                algorithm = SearchingAlgorithm.BINARY_SEARCH_ALGORITHM;
                break;

                       	
            default:
                System.err.println("No Such Algorithm Defined");
        }
        return algorithm;
    }

    public Searchable getAlgorithm() {
        return algorithm;
    }

    public SearchingAlgorithmName getName() {
        return name;
    }
}
