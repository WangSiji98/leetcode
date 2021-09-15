package com.oasis.datastructure;

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

    public boolean search(String word) {
        Trie trie = commonSearch(word);
        return trie != null && trie.endFlag;
    }

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
