package Utils;

import anagram.DataLoader;

import java.util.ArrayList;
import java.util.List;

public class Util {

    public static List<String> generateWordPermutations(String word) {
        List<String> result = new ArrayList<>();
        generateWordPermutationsHelper(word.toCharArray(), 0, result);
        return result;
    }

    private static void generateWordPermutationsHelper(char[] wordArray, int index, List<String> result) {
        if (index == wordArray.length - 1) {
            result.add(new String(wordArray));
        } else {
            for (int i = index; i < wordArray.length; i++) {
                swap(wordArray, index, i);
                generateWordPermutationsHelper(wordArray, index + 1, result);
                swap(wordArray, index, i);
            }
        }
    }

    private static void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
