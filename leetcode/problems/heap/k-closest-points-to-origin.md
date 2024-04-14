# [K Closest Points to Origin](https://leetcode.com/problems/k-closest-points-to-origin/description/)
https://leetcode.com/problems/k-closest-points-to-origin/description/
<hr />

### Problem Statement
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

#### Example 1:
![image](./closestplane1.jpg)
```
Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]
```
Explanation:
- The distance between (1, 3) and the origin is sqrt(10).
- The distance between (-2, 2) and the origin is sqrt(8).
- Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
- We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
#### Example 2:

```
Input: points = [[3,3],[5,-1],[-2,4]], k = 2
Output: [[3,3],[-2,4]]
 
```
Explanation: The answer [[-2,4],[3,3]] would also be accepted.

<hr />

### Solution

[ClosestPointsToOrigin.java](../../src/main/java/org/example/heap/ClosestPointsToOrigin.java)

```java
package org.example.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ClosestPointsToOrigin {
    record Point(int x, int y, double dist){}

    public int[][] kClosest(int[][] points, int k) {
        int N = points.length;
        PriorityQueue<Point> q = new PriorityQueue<>(Comparator.comparingDouble(Point::dist).reversed());

        for(int i=0; i<k; i++) {
            q.offer(getPoint(points, i));
        }

        for(int i=k; i<N; i++) {
            Point point = getPoint(points, i);
            if(q.peek().dist > point.dist) {
                q.poll();
                q.offer(point);
            }
        }

        int[][] nearestPoints = new int[q.size()][];
        int i= 0;
        while(!q.isEmpty()) {
            Point point = q.poll();
            nearestPoints[i++] = new int[]{point.x(), point.y()};
        }
        return nearestPoints;
    }

    public Point getPoint(int[][] points, int i) {
        int x = points[i][0];
        int y = points[i][1];
        double dist = Math.sqrt(x*x + y*y);
        return new Point(x, y, dist);
    }
}

```