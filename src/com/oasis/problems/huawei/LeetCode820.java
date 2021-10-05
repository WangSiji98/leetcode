package com.oasis.problems.huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Trie {
    private boolean endFlag;
    private Trie[] alphabet;
    private List<String> endList;

    public Trie() {
        this.endFlag = false;
        this.alphabet = new Trie[26];
        endList = new ArrayList<>();
    }

    public void insert(String word) {
        Trie trie = this;
        boolean flag = false;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (trie.alphabet[index] == null) {
                flag = true;
                trie.alphabet[index] = new Trie();
            }
            trie = trie.alphabet[index];
        }
        if (flag) {
            endList.add(word);
        }
        trie.endFlag = true;
    }

    public boolean search(String word) {
        Trie trie = commonSearch(word);
        return trie != null && trie.endFlag;
    }

    public boolean startsWith(String prefix) {
        Trie trie = commonSearch(prefix);
        return trie != null;
    }

    public List<String> getEndList() {
        return endList;
    }

    private Trie commonSearch(String target) {
        Trie trie = this;
        for (int i = 0; i < target.length(); i++) {
            char ch = target.charAt(i);
            int index = ch - 'a';
            if (trie.alphabet[index] == null) {
                return null;
            }
            trie = trie.alphabet[index];
        }
        return trie;
    }
}

public class LeetCode820 {

    private Trie trie = new Trie();

    public int minimumLengthEncoding(String[] words) {
        List<String> list = new ArrayList<>();
        for (String word: words) {
            list.add(new StringBuffer(word).reverse().toString());
        }
        list.sort(
            new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o2.compareTo(o1);
                }
            }
        );
        System.out.println(list);
        for (String word: list) {
            trie.insert(word);
        }
        List<String> endList = trie.getEndList();
        StringBuilder stringBuilder = new StringBuilder();
        for (String s: endList) {
            stringBuilder.append(s);
            stringBuilder.append("#");
        }
        return stringBuilder.toString().length();
    }

    public static void main(String[] args) {
        LeetCode820 leetCode820 = new LeetCode820();
        String[] words = new String[]{"time", "me"};
        System.out.println(leetCode820.minimumLengthEncoding(words));
    }

}
