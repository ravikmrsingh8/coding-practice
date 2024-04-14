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
