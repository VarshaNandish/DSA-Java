/*
Given an array of words arr[], the task is to groups strings that are anagrams. An anagram is a word or phrase formed by rearranging the letters of another, using all the original letters exactly once.
Example:
Input: arr[] = ["act", "god", "cat", "dog", "tac"]
Output: [["act", "cat", "tac"], ["god", "dog"]]
Explanation: There are 2 groups of anagrams "god", "dog" make group 1. "act", "cat", "tac" make group 2.
Input: arr[] = ["listen", "silent", "enlist", "abc", "cab", "bac", "rat", "tar", "art"]
Output: [["abc", "cab", "bac"], ["listen", "silent", "enlist"],["rat", "tar", "art"]]
Explanation:
Group 1: "abc", "bac" and "cab" are anagrams.
Group 2: "listen", "silent" and "enlist" are anagrams.
Group 3: "rat", "tar" and "art" are anagrams.
*/
import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] arr) {
        // Map: sorted word -> list of anagrams
        Map<String, List<String>> map = new HashMap<>();

        for (String word : arr) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars); // sort characters to form the key
            String key = new String(chars);

            // Add the word to the correct anagram group
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }

        // Return all groups
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] arr1 = {"act", "god", "cat", "dog", "tac"};
        System.out.println(groupAnagrams(arr1));

        String[] arr2 = {"listen", "silent", "enlist", "abc", "cab", "bac", "rat", "tar", "art"};
        System.out.println(groupAnagrams(arr2));
    }
}
