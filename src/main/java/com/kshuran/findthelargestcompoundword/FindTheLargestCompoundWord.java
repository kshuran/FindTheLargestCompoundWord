package com.kshuran.findthelargestcompoundword;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 *
 * @author Кулацкий
 */
public class FindTheLargestCompoundWord {

    private List<String> list;

    public FindTheLargestCompoundWord(List<String> list) {
        this.list = list;
    }

    //find the largest word in list
    public String findCompoundWord() {
        int wordLength = findMaxLength(this.list);
        while (true) {
            List<String> findingList = listOfMaxLengthWords(this.list, wordLength);
            for (String lst : findingList) {
                if (findingWord(list, lst)) {
                    return lst;
                }
            }
            wordLength--;
        }
    }


    //looking for the greatest length of the word
    private int findMaxLength(List<String> list) {
        int b = 0;
        for (String list1 : list) {
            int a = list1.length();
            if (a > b) {
                b = a;
            }
        }
        return b;
    }

    //looking for the words with the largest number of letters
    private List<String> listOfMaxLengthWords(List<String> list, int length) {
        List<String> listOfMaxLengthWords = new ArrayList<>();
        for (String list1 : list) {
            if (list1.length() == length) {
                listOfMaxLengthWords.add(list1);
            }
        }
        return listOfMaxLengthWords;
    }

    //this is method find the largest word in list
    private boolean findingWord(List<String> list, String word) {
        int begin = 0;
        int helpIndex = 0;
        String s;
        List<String> helpList = new ArrayList<>(list);
        Deque<String> stack = new ArrayDeque<>();

        do {

            M1:
            {
                for (int i = helpIndex; i < list.size(); i++) {
                    s = list.get(i);
                    String d = String.valueOf(word.charAt(begin));
                    if (word.contains(s) && s.startsWith(d)
                            && word.substring(begin, (begin + s.length())).equals(s)
                            && (word.length() > s.length())) {
                        stack.addLast(s);
                        begin += s.length();
                        helpIndex = 0;
                        if (word.length() <= begin) {
                            String concatWordsFromStack = "";
                            for (String lst : stack) {
                                concatWordsFromStack = concatWordsFromStack.concat(lst);
                            }
                            if (word.equals(concatWordsFromStack)) {
                                return true;
                            }
                        }
                        break M1;
                    }
                }
                if (!stack.isEmpty()) {
                    helpIndex = helpList.indexOf(stack.pollLast()) + 1;
                } else {
                    return false;
                }
            }

        } while (true);
    }

}
