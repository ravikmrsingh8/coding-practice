package org.example.ds.trie;

public class Trie {
    static class Node {
        char letter;
        boolean isWord;
        Node[] children = new Node[26];

        Node(char letter) {
            this.letter = letter;
        }

        Node getNode(char ch) {
            return children[ch - 'a'];
        }

        void addNode(char ch) {
            children[ch - 'a'] = new Node(ch);
        }
    }

    Node root;

    public Trie() {
        root = new Node('/');
    }

    public void insert(String word) {
        char[] letters = word.toCharArray();
        Node itr  = root;
        for(char ch : letters) {
            if(itr.getNode(ch) == null)  {
                itr.addNode(ch);
            }
            itr = itr.getNode(ch);
        }
        itr.isWord = true;
        //System.out.println(root);
    }

    public boolean search(String word) {
        char[] letters = word.toCharArray();
        Node itr  = root;
        for(char ch : letters) {
            Node node = itr.getNode(ch);
            if(node == null) return false;
            itr = node;
        }
        return itr.isWord;
    }


    public boolean startsWith(String prefix) {
        char[] letters = prefix.toCharArray();
        Node itr  = root;
        for(char ch : letters) {
            Node node = itr.getNode(ch);
            if(node == null) return false;
            itr = node;
        }
        return true;
    }
}
