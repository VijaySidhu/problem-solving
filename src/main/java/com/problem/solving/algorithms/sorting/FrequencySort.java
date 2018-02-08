package com.problem.solving.algorithms.sorting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by VijaySidhu on 2/6/2018.
 */
public class FrequencySort {


    /**
     * Insert all elements and count into map. This step takes O(n)
     * We copy content of hash into array an sort This step takes O(MLogM)
     * For maintaining the order of elements if the frequency is same, we use another hash which has the key as elements of the array and value as the index.
     * If the frequency is same for two elements then sort elements according to the index.
     * TC : O(n + m Log m)
     */
    public static void sortByFrequency(int array[]) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer val : array) {
            if (map.containsKey(val)) {
                map.put(val, ++count);

            } else {
                map.put(val, 1);
            }
        }
        List<Map.Entry<Integer, Integer>> sortedMap = SortByValueMap.sortByValue(map);
        for (Map.Entry<Integer, Integer> entry : sortedMap) {
            System.out.println(entry.getKey() + " <-> " + entry.getValue());
        }
    }


}
