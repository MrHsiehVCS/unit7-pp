package u7pp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import org.junit.jupiter.api.Test;
import java.time.Duration;

public class SearchTests {

     
    @Test
    public void binarySearch_OneElem_IsFound_returnsCorrect() {
        int[] data = {0};
        assertEquals(0, Search.binarySearch(data, 0));
    }

    @Test
    public void binarySearch_OneElem_IsNotFound_returnsCorrect() {
        int[] data = {10};
        assertEquals(-1, Search.binarySearch(data, 0));
    }

    @Test
    public void binarySearch_ThreeElem_IsFoundInMiddle_returnsCorrect() {
        int[] data = {-10,0,10};
        assertEquals(1, Search.binarySearch(data, 0));
    }

    @Test
    public void binarySearch_ThreeElem_IsFoundInFront_returnsCorrect() {
        int[] data = {0,10,20};
        assertEquals(0, Search.binarySearch(data, 0));
    }

    @Test
    public void binarySearch_ThreeElem_IsFoundInBack_returnsCorrect() {
        int[] data = {-20,-10,0};
        assertEquals(2, Search.binarySearch(data, 0));
    }

    @Test
    public void binarySearch_ThreeElem_IsNotFound_returnsCorrect() {
        int[] data = {-20,-10,10};
        assertEquals(-1, Search.binarySearch(data, 0));
    }

    @Test
    public void binarySearch_SevenElemIsFound_returnsCorrect() {
        int[] data = {10,20,30,40,50,60,70};
        assertEquals(0, Search.binarySearch(data, 10));
        assertEquals(1, Search.binarySearch(data, 20));
        assertEquals(2, Search.binarySearch(data, 30));
        assertEquals(3, Search.binarySearch(data, 40));
        assertEquals(4, Search.binarySearch(data, 50));
        assertEquals(5, Search.binarySearch(data, 60));
        assertEquals(6, Search.binarySearch(data, 70));
    }

    @Test
    public void binarySearch_SevenElemNotFound_returnsCorrect() {
        int[] data = {10,20,30,40,50,60,70};
        assertEquals(-1, Search.binarySearch(data, 5));
        assertEquals(-1, Search.binarySearch(data, 15));
        assertEquals(-1, Search.binarySearch(data, 25));
        assertEquals(-1, Search.binarySearch(data, 35));
        assertEquals(-1, Search.binarySearch(data, 45));
        assertEquals(-1, Search.binarySearch(data, 55));
        assertEquals(-1, Search.binarySearch(data, 65));
        assertEquals(-1, Search.binarySearch(data, 75));
    }

    @Test
    public void binarySearch_TwoElem_returnsCorrect() {
        int[] data = {10,20};
        assertEquals(0, Search.binarySearch(data, 10));
        assertEquals(1, Search.binarySearch(data, 20));
        assertEquals(-1, Search.binarySearch(data, 5));
        assertEquals(-1, Search.binarySearch(data, 15));
        assertEquals(-1, Search.binarySearch(data, 25));
    }


    @Test
    public void binarySearch_manyElemWhenFound_returnsCorrect() {
        int[] data = {10,20,30,40,50,60,70,80,90,110,120,130,140,150,160,170,180,190,200,210,220,230,240,250,260,270,280,290,300};
        assertEquals(0, Search.binarySearch(data, 10));
        assertEquals(1, Search.binarySearch(data, 20));
        assertEquals(2, Search.binarySearch(data, 30));
        assertEquals(4, Search.binarySearch(data, 50));
        assertEquals(7, Search.binarySearch(data, 80));
        assertEquals(15, Search.binarySearch(data, 170));
        assertEquals(16, Search.binarySearch(data, 180));
        assertEquals(17, Search.binarySearch(data, 190));
        assertEquals(19, Search.binarySearch(data, 210));
        assertEquals(28, Search.binarySearch(data, 300));
    }



    @Test
    public void binarySearch_manyElemWhenNotFound_returnsCorrect() {
        int[] data = {10,20,30,40,50,60,70,80,90,110,120,130,140,150,160,170,180,190,200,210,220,230,240,250,260,270,280,290,300};
        assertEquals(-1, Search.binarySearch(data, 1));
        assertEquals(-1, Search.binarySearch(data, 11));
        assertEquals(-1, Search.binarySearch(data, 21));
        assertEquals(-1, Search.binarySearch(data, 31));
        assertEquals(-1, Search.binarySearch(data, 51));
        assertEquals(-1, Search.binarySearch(data, 81));
        assertEquals(-1, Search.binarySearch(data, 171));
        assertEquals(-1, Search.binarySearch(data, 181));
        assertEquals(-1, Search.binarySearch(data, 191));
        assertEquals(-1, Search.binarySearch(data, 211));
        assertEquals(-1, Search.binarySearch(data, 301));
    }

    
    @Test
    // test that your binary search works fast enough, as we would expect a binary search to.
    public void binarySearch_hugeArray_returnsFastEnoughAndCorrect() {
        assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
            int[] data = new int[2000000];
            for(int i = 0; i < data.length; i++) {
                data[i] = i;
            }
    
            for(int i = 0; i < data.length; i++) {
                assertEquals(i, Search.binarySearch(data, i));
            }
        });
    }
}