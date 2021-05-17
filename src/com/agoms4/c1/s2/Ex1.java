package com.agoms4.c1.s2;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Ex1 {


    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        Point2D[] points = new Point2D[n];
        drawAndCreatePoints(points);
        double shortestDistance = calculateShortestDistance(points);
        System.out.println(shortestDistance);
    }

    private static void drawAndCreatePoints(Point2D[] points) {
        StdDraw.setCanvasSize(1024, 512);
        StdDraw.setPenRadius(0.015);
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);

        for (int i = 0; i < points.length; i++) {
            double pointX = StdRandom.uniform();
            double pointY = StdRandom.uniform();

            Point2D point = new Point2D(pointX, pointY);
            StdDraw.point(point.x(), point.y());

            points[i] = point;
        }
    }

    private static double calculateShortestDistance(Point2D[] points) {
        double shortestDistance = Double.MAX_VALUE;
        double currentDistance;
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                currentDistance = points[i].distanceSquaredTo(points[j]);
                if (currentDistance < shortestDistance) {
                    shortestDistance = currentDistance;
                }
            }
        }
        return shortestDistance;
    }

}
