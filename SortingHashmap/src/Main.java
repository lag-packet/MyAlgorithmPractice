/*
@author: lag-packet
This is my implementation of sorting the values in a hashmap.
It currently supports:
    - selection sort
 */
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) {
        int[] numArray = new int[1000];
        for (int i = 0; i < numArray.length; i++) {
            numArray[i] = (int) (Math.random() * 1000);
        }

        //populate the hashmap
        HashMap<Integer, Integer> numberOccurrence = new HashMap<>();
        for (int i = 0; i < numArray.length; i++) {
            if (!numberOccurrence.containsKey(numArray[i])) {
                numberOccurrence.put(numArray[i], 1);
            } else {
                numberOccurrence.put(numArray[i], numberOccurrence.get(numArray[i]) + 1);
            }
        }

        LinkedHashMap<Integer, Integer> numberOccurrenceSorted = selectionSort(numberOccurrence);
        System.out.println("unsorted size:" + numberOccurrence.size() + " map:" + numberOccurrence);
        System.out.println("sorted size: " + numberOccurrenceSorted.size() + " map: "+ numberOccurrenceSorted);
    }

    /*
    Selection sort for regular arrays as demonstration.
     */
    public static int[] selectionSort(int num[]) {
        int[] sortedArray = num;
        for (int i = 0; i < sortedArray.length; i++) {
            int currentMaxPos = i;
            boolean swap = false;
            for (int j = i; j < sortedArray.length; j++) {
                if (sortedArray[currentMaxPos] < sortedArray[j]) {
                    currentMaxPos = j;
                    swap = true;
                }
            }
            if (swap) {
                int temp = sortedArray[i];
                sortedArray[i] = sortedArray[currentMaxPos];
                sortedArray[currentMaxPos] = temp;
            }
        }
        return sortedArray;
    }

    /*
    Selection sort for hashmaps to sort by values with distinct keys.
    uses while sorted size != map size for multiple pass through due to missing keys.
    ?? better solution to be found ??
     */
    public static LinkedHashMap<Integer, Integer> selectionSort(HashMap<Integer, Integer> map) {
        LinkedHashMap<Integer, Integer> sortedMap = new LinkedHashMap<>();
        while(sortedMap.size() != map.size()) {
            for (int i : map.keySet()) {
                int currentMaxPos = i;
                for (int j : map.keySet()) {
                    if (sortedMap.containsKey(j)) {continue;}
                    if (map.get(currentMaxPos) < map.get(j)) {
                        currentMaxPos = j;
                    }
                }
                sortedMap.put(currentMaxPos, map.get(currentMaxPos));
            }
        }
        return sortedMap;
    }
}
