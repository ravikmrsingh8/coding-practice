package org.example.ds.trie;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DictionaryApp {
    public static void main(String[] args) throws IOException, URISyntaxException {
        Trie trie = new Trie();
        URI uri = DictionaryApp.class.getClassLoader().getResource("words.txt").toURI();
        try(Stream<String> words = Files.lines(Paths.get(uri))) {
            words.map(String::toLowerCase).forEach(word-> {
                try {
                    trie.insert(word);
                }catch (Exception ex) {
                    System.out.println("Error Inserting word: "+ word);
                }
            });
        }
        System.out.println(trie.search("hmm"));
        System.out.println(trie.search("umm"));
        System.out.println(trie.search("baby"));
        System.out.println(trie.search("blabla"));
        System.out.println(trie.search("bandit"));
    }
}
