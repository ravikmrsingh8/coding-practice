# [Encode and Decode Strings](https://www.lintcode.com/problem/659/)
https://www.lintcode.com/problem/659/
<hr />

### Problem Statement

Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.
Please implement encode and decode

You are not allowed to solve the problem using any serialize methods (such as eval).

#### Example 1

```
 Input: ["lint","code","love","you"]
 Output: ["lint","code","love","you"]
 Explanation:
 One possible encode method is: "lint:;code:;love:;you"

```
#### Example 2

```
 Input: ["we", "say", ":", "yes"]
 Output: ["we", "say", ":", "yes"]
 Explanation:
 One possible encode method is: "we:;say:;:::;yes"
```

<hr />

### Solution

[EncodeDecodeString.java](../../src/main/java/org/example/hashing/EncodeDecodeString.java)

```java
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

```