package org.example.hashing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EncodeDecodeString {
    public String encode(List<String> strs) {
        String encoded = strs.stream()
                .map(str -> str.length() + "@" + str)
                .collect(Collectors.joining());
        System.out.println(encoded);
        return encoded;
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int index = -1;
        int start = 0;
        while((index = str.indexOf('@', start)) != -1) {
            int numChars = Integer.parseInt(str.substring(start, index));
            list.add(str.substring(index + 1, index + 1 + numChars));
            start = index + 1 + numChars;
        }
        return list;

    }

}
