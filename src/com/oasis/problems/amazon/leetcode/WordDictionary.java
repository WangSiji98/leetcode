package com.oasis.problems.amazon.leetcode;

import java.util.ArrayList;
import java.util.List;

public class WordDictionary {
    public class Trie {
        private boolean endFlag;
        private Trie[] alphabet;

        public Trie() {
            this.endFlag = false;
            this.alphabet = new Trie[26];
        }

        public void insert(String word) {
            Trie trie = this;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int index = ch - 'a';
                if (trie.alphabet[index] == null) {
                    trie.alphabet[index] = new Trie();
                }
                trie = trie.alphabet[index];
            }
            trie.endFlag = true;
        }

        private boolean fuzzySearch(String target, Trie t , int index) {
            if (index == target.length()) {
                if (t.endFlag) {
                    return true;
                } else {
                    return false;
                }
            }
            char ch = target.charAt(index);
            if (ch != '.') {
                if (t.alphabet[ch - 'a'] == null) {
                    return false;
                } else {
                    return fuzzySearch(target, t.alphabet[ch - 'a'], index + 1);
                }
            } else {
                for (int i = 0; i < 26; ++i) {
                    if (t.alphabet[i] != null) {
                        if (fuzzySearch(target, t.alphabet[i], index + 1)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }

    // 字典树（前缀树）Trie
    private Trie trie;

    private List<List<Character>> dic = new ArrayList<>();

    /** Initialize your data structure here. */
    public WordDictionary() {
        trie = new Trie();
    }

    public void addWord(String word) {
        trie.insert(word);
    }

    public boolean search(String word) {
        return trie.fuzzySearch(word, trie, 0);
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("at");
        wordDictionary.addWord("and");
        wordDictionary.addWord("an");
        wordDictionary.addWord("add");
        System.out.println(wordDictionary.search("a"));
        System.out.println(wordDictionary.search(".at"));
        wordDictionary.addWord("bat");
        System.out.println(wordDictionary.search(".at"));
        System.out.println(wordDictionary.search("an."));
        System.out.println(wordDictionary.search("a.d."));
        System.out.println(wordDictionary.search("b."));
        System.out.println(wordDictionary.search("a.d"));
        System.out.println(wordDictionary.search("."));
    }


}

