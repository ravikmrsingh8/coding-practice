# [Implement Trie](https://leetcode.com/problems/implement-trie-prefix-tree/description/)
https://leetcode.com/problems/implement-trie-prefix-tree/description/
<hr />

### Problem Statement
A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

- Trie() Initializes the trie object.
- void insert(String word) Inserts the string word into the trie.
- boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
- boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.

#### Example 1:

```
Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]
Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True
```

<hr />

### Solution

[Trie.java](../../src/main/java/org/example/trie/Trie.java)

```java
package org.example.trie;

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

```