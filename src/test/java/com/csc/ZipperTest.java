package com.csc;

import static org.junit.jupiter.api.Assertions.*;

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
}