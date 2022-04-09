
//This is a sorting algorithm for hashmaps

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int[] numArray = new int[100000];

        for (int i = 0; i < numArray.length; i++) {
            numArray[i] = (int) (Math.random() * 1000);
        }

        int[] sortedArray = selectionSort(numArray);
        for (int i = 0; i < sortedArray.length; i++) {
            System.out.println("S-i:" + i + " " + sortedArray[i]);
        }

        /*int range = 0;
        HashMap<Integer, Integer> numberOccurrence = new HashMap<>();
        for (int i = 0; i < numArray.length; i++) {
            if (!numberOccurrence.containsKey(numArray[i])) {
                numberOccurrence.put(numArray[i], 1);
            } else {
                numberOccurrence.put(numArray[i], numberOccurrence.get(numArray[i]) + 1);
            }
        }

        //sorting keys in hashmap
        HashMap<Integer, Integer> numberOccurrenceSorted = new HashMap<>();
        int maxKey = numberOccurrence.get(0);
        int jPos = 0;
        for (int i = 0; i < numberOccurrence.size(); i++) {
            for (int j = 1; j <= i; j++) {
                if (numberOccurrence.get(j) > maxKey) {
                    jPos = j;
                    maxKey = numberOccurrence.get(j);
                }
            }
            System.out.println("put " + jPos + " maxKey: " + maxKey);
            numberOccurrenceSorted.put(jPos, maxKey);
        }

        for (int i = 0; i < numberOccurrenceSorted.size(); i++) {
            System.out.println(i + " " + numberOccurrence.get(i));
        }
        System.out.println("size:" + numberOccurrenceSorted);
        System.out.println("size:" + numberOccurrence);
        //print numberOccurence
        for (int i = 0; i < numberOccurrence.size(); i++) {
            System.out.println(numberOccurrence.get(i));
        }*/

    }

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
}
