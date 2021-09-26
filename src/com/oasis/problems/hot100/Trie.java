package com.oasis.problems.hot100;

import javax.rmi.CORBA.Tie;

public class Trie {
    private boolean endFlag;
    private Trie[] alphabet;

    /** Initialize your data structure here. */
    public Trie() {
        this.endFlag = false;
        this.alphabet = new Trie[26];
    }

    /** Inserts a word into the trie. */
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

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie trie = commonSearch(word);
        return trie != null && trie.endFlag;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie trie = commonSearch(prefix);
        return trie != null;
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

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("bp"));
    }
}
