package com.problem.solving.algorithms.sorting;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by VijaySidhu on 2/6/2018.
 */
public class SortByValueMap {

    /**
     * Descending Order SOrt by value
     *
     * @param map
     * @return
     */
    public static List<Map.Entry<Integer, Integer>> sortByValue(Map<Integer, Integer> map) {
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(entries);
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
      return list;
    }
}
