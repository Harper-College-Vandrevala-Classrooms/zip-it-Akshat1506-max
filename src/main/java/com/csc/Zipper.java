package com.csc;

import java.util.ArrayList;
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
}