package com.csc;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ZipperTest {

    Zipper zipper;

    @BeforeEach
    void setUp() {
        zipper = new Zipper();
    }

    @Test
    void testZipEqualLengthLists() {
        List<Integer> nums1 = List.of(1, 3, 5, 7);
        List<Integer> nums2 = List.of(2, 4, 6, 8);
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7, 8);

        assertEquals(expected, zipper.zip(nums1, nums2));
    }

    @Test
    void testZipFirstListLonger() {
        List<String> colors1 = List.of("Red", "Green", "Blue", "Yellow");
        List<String> colors2 = List.of("White", "Black");
        List<String> expected = List.of("Red", "White", "Green", "Black", "Blue", "Yellow");

        assertEquals(expected, zipper.zip(colors1, colors2));
    }

    @Test
    void testZipSecondListLonger() {
        List<String> colors1 = List.of("Red", "Green");
        List<String> colors2 = List.of("White", "Black", "Orange", "Pink");
        List<String> expected = List.of("Red", "White", "Green", "Black", "Orange", "Pink");

        assertEquals(expected, zipper.zip(colors1, colors2));
    }

    @Test
    void testZipEmptyFirstList() {
        List<Integer> nums1 = List.of();
        List<Integer> nums2 = List.of(2, 4, 6, 8);
        List<Integer> expected = List.of(2, 4, 6, 8);

        assertEquals(expected, zipper.zip(nums1, nums2));
    }

    @Test
    void testZipEmptySecondList() {
        List<Integer> nums1 = List.of(1, 3, 5, 7);
        List<Integer> nums2 = List.of();
        List<Integer> expected = List.of(1, 3, 5, 7);

        assertEquals(expected, zipper.zip(nums1, nums2));
    }

    @Test
    void testZipBothEmptyLists() {
        List<Integer> nums1 = List.of();
        List<Integer> nums2 = List.of();
        List<Integer> expected = List.of();

        assertEquals(expected, zipper.zip(nums1, nums2));
    }

    // Tests for hashmapify method
    @Test
    void testHashmapifyWithEqualSizedLists() {
        List<String> keys = List.of("White", "Black", "Orange", "Pink");
        List<Integer> values = List.of(1, 3, 5, 7);
        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("White", 1);
        expected.put("Black", 3);
        expected.put("Orange", 5);
        expected.put("Pink", 7);

        assertEquals(expected, zipper.hashmapify(keys, values));
    }

    @Test
    void testHashmapifyWithDifferentSizedLists() {
        List<String> keys = List.of("White", "Black", "Orange");
        List<Integer> values = List.of(1, 3);

        assertThrows(IllegalArgumentException.class, () -> {
            zipper.hashmapify(keys, values);
        });
    }
}