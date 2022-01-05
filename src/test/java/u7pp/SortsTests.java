package u7pp;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortsTests {

    private int[] array = {2, 4, 1, -1, 0, 9, -80, 3};
    private List<Integer> list;
    private int[] longArray;
    private int[] longArrayCorrect;
    private List<Integer> longList;
    private List<Integer> longListCorrect;
    private final int LONG_ARRAY_LENGTH = 100;

    @BeforeEach
    public void setup() {
        list = new ArrayList<Integer>();
        list.add(2);
        list.add(4);
        list.add(1);
        list.add(-1);
        list.add(0); 
        list.add(9); 
        list.add(-80);
        list.add(3);

        // fill longArray & longList with random values
        longList = new ArrayList<Integer>();
        longArray = new int[LONG_ARRAY_LENGTH];
        longArrayCorrect = new int[LONG_ARRAY_LENGTH];
        for(int i = 0; i < LONG_ARRAY_LENGTH; i++) {
            int x = (int)(Math.random() * 1000);
            longArray[i] = x;
            longArrayCorrect[i] = x;
            longList.add(x);
        }
        Arrays.sort(longArrayCorrect);
        

        longListCorrect = new ArrayList<Integer>(longList);
        Collections.sort(longListCorrect);
    } 

    @Test
    public void selectionSort_WhenArrayIsEmpty_ShouldReturnAnEmptyArray() 
    {
        array = new int[0];
        int[] sortedArray = Sorts.selectionSort(array);

        assertEquals(0, sortedArray.length);
    }

    @Test
    public void selectionSort_WhenArrayIsUnsorted_ShouldReturnAnAscendingSortedArray()
    {
        int[] correctArray = {-80, -1, 0, 1, 2, 3, 4, 9};
        int[] sortedArray = Sorts.selectionSort(array);

        assertArrayEquals(correctArray, sortedArray);
    }

    @Test
    public void selectionSort_WhenLongArrayIsUnsorted_ShouldReturnAnAscendingSortedArray()
    {
        int[] sortedArray = Sorts.selectionSort(longArray);

        assertArrayEquals(longArrayCorrect, sortedArray);
    }

    @Test
    public void selectionSort_WhenCalledWithArray_ShouldNotModifyTheParameter()
    {
        int[] correctArray = {2, 4, 1, -1, 0, 9, -80, 3};
        Sorts.selectionSort(array);

        assertArrayEquals(correctArray, array);
    }

    @Test
    public void selectionSort_WhenListIsEmpty_ShouldReturnAnEmptyList() 
    {
        list = new ArrayList<Integer>();
        List<Integer> sortedList = Sorts.selectionSort(list);

        assertEquals(0, sortedList.size());
    }

    @Test
    public void selectionSort_WhenListIsUnsorted_ShouldReturnADescendingSortedList()
    {
        List<Integer> correctList = new ArrayList<Integer>();
        correctList.add(9);
        correctList.add(4);
        correctList.add(3);
        correctList.add(2);
        correctList.add(1);
        correctList.add(0);
        correctList.add(-1);
        correctList.add(-80);

        List<Integer> sortedList = Sorts.selectionSort(list);

        assertEquals(correctList, sortedList);
    }

    @Test
    public void selectionSort_WhenLongListIsUnsorted_ShouldReturnADescendingSortedList()
    {
        List<Integer> sortedList = Sorts.selectionSort(longList);

        assertEquals(longListCorrect, sortedList);
    }

    @Test
    public void selectionSort_WhenCalledWithList_ShouldNotModifyTheParameter()
    {
        List<Integer> correctList = new ArrayList<Integer>(list);
        
        Sorts.selectionSort(list);

        assertEquals(correctList, list);
    }


    @Test
    public void insertionSort_WhenArrayIsEmpty_ShouldReturnAnEmptyArray() 
    {
        array = new int[0];
        int[] sortedArray = Sorts.insertionSort(array);

        assertEquals(0, sortedArray.length);
    }

    @Test
    public void insertionSort_WhenArrayIsUnsorted_ShouldReturnAnAscendingSortedArray()
    {
        int[] correctArray = {-80, -1, 0, 1, 2, 3, 4, 9};
        int[] sortedArray = Sorts.insertionSort(array);

        assertArrayEquals(correctArray, sortedArray);
    }

    @Test
    public void insertionSort_WhenLongArrayIsUnsorted_ShouldReturnAnAscendingSortedArray()
    {
        int[] sortedArray = Sorts.insertionSort(longArray);

        assertArrayEquals(longArrayCorrect, sortedArray);
    }

    @Test
    public void insertionSort_WhenCalledWithArray_ShouldNotModifyTheParameter()
    {
        int[] correctArray = {2, 4, 1, -1, 0, 9, -80, 3};
        Sorts.insertionSort(array);

        assertArrayEquals(correctArray, array);
    }

    @Test
    public void insertionSort_WhenListIsEmpty_ShouldReturnAnEmptyList() 
    {
        list = new ArrayList<Integer>();
        List<Integer> sortedList = Sorts.insertionSort(list);

        assertEquals(0, sortedList.size());
    }

    @Test
    public void insertionSort_WhenListIsUnsorted_ShouldReturnADescendingSortedList()
    {
        List<Integer> correctList = new ArrayList<Integer>();
        correctList.add(9);
        correctList.add(4);
        correctList.add(3);
        correctList.add(2);
        correctList.add(1);
        correctList.add(0);
        correctList.add(-1);
        correctList.add(-80);

        List<Integer> sortedList = Sorts.insertionSort(list);

        assertEquals(correctList, sortedList);
    }

    @Test
    public void insertionSort_WhenLongListIsUnsorted_ShouldReturnADescendingSortedList()
    {
        List<Integer> sortedList = Sorts.insertionSort(longList);

        assertEquals(longListCorrect, sortedList);
    }

    @Test
    public void insertionSort_WhenCalledWithList_ShouldNotModifyTheParameter()
    {
        List<Integer> correctList = new ArrayList<Integer>(list);
        
        Sorts.selectionSort(list);

        assertEquals(correctList, list);
    }
    
}
