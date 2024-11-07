package com.csc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Zipper {

    // Generic zip method to merge two lists into one alternating list
    public <T> List<T> zip(List<T> list1, List<T> list2) {
        List<T> mergedList = new ArrayList<>();
        int size1 = list1.size();
        int size2 = list2.size();
        int minSize = Math.min(size1, size2);

        // Alternate elements from both lists
        for (int i = 0; i < minSize; i++) {
            mergedList.add(list1.get(i));
            mergedList.add(list2.get(i));
        }

        // Add leftover elements from the longer list
        if (size1 > minSize) {
            mergedList.addAll(list1.subList(minSize, size1));
        } else if (size2 > minSize) {
            mergedList.addAll(list2.subList(minSize, size2));
        }

        return mergedList;
    }

    // Add-on: Method to create a HashMap from two lists (one for keys, one for values)
    public <K, V> HashMap<K, V> hashmapify(List<K> keys, List<V> values) {
        if (keys.size() != values.size()) {
            throw new IllegalArgumentException("The lists must have the same size.");
        }

        HashMap<K, V> map = new HashMap<>();
        for (int i = 0; i < keys.size(); i++) {
            map.put(keys.get(i), values.get(i));
        }

        return map;
    }
}