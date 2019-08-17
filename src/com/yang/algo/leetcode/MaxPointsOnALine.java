package com.yang.algo.leetcode;


/**
 *Given n points on a 2D plane,
 * find the maximum number of points that lie on the same straight line.
 * */
public class MaxPointsOnALine {
    public static class Point{
        int x;
        int y;

        public Point(){
            this.x = 0;
            this.y = 0;
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int maxPoints(Point[] points){
        if (points == null || points.length < 3){
            return points.length;
        }
        int res = 0;
        for (int i = 1; i < points.length; i ++){
            int count = 0;
            int a = points[i].x;
            int b = points[i].y;
            int dx = a - points[i - 1].x;
            int dy = b - points[i - 1].y;
            if (dx == 0 && dy == 0){
                for (int j = 0; j < points.length; j ++){
                    if (points[j].x == a && points[j].y == b){
                        count ++;
                    }
                }
            }else {
                for (int j = 0; j < points.length; j ++){
                    if ((points[j].x - a) * dy == (points[j].y - b) * dx) {
                        count++;
                    }
                }
            }
            res = Math.max(res,count);
        }
        return res;
    }
}
