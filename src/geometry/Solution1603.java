package geometry;

import java.util.Arrays;

/**
 * @author wangyisu
 */
public class Solution1603 {
    public class Line{
        public double k;
        public double b;

        public Line(int[] start, int[] end) {
            int x1 = start[0];
            int y1 = start[1];
            int x2 = end[0];
            int y2 = end[1];
            k = (y2-y1)/(x2-x1*1.0); // 有一个1.0,默认返回double
            if(k==Double.NEGATIVE_INFINITY){
                k = Double.POSITIVE_INFINITY;
            }
            b = y1 - k*x1;
        }
    }

    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        Line line1 = new Line(start1,end1);
        Line line2 = new Line(start2,end2);
        double[] intersectionPoint = intersectionOfTwoLines(start1, end1, start2, end2);
        System.out.println(line1.k);
        System.out.println(line2.k);
        System.out.println(Arrays.toString(intersectionPoint));
        if(intersectionPoint.length==0){
            double dis=1e-6;
            System.out.println("here");
            if(Math.abs(line1.b-line2.b)<dis || (line1.k==Double.POSITIVE_INFINITY && line2.k==Double.POSITIVE_INFINITY)){
                if(isCoincide(start1, end1, start2, end2)){
                    int[][] points = new int[][]{start1, end1, start2, end2};
                    double[] point = new double[]{Double.MAX_VALUE,Double.MAX_VALUE};
                    for(int i = 0; i < points.length; i++) {
                        if(points[i][0]==point[0]){
                            if(points[i][1]<point[1]){
                                if(i==0 || i==1){
                                    if(isIn(points[i][0],start2[0],end2[0])&&isIn(points[i][1],start2[1],end2[1])){
                                        point[0] = points[i][0];
                                        point[1] = points[i][1];
                                    }
                                }
                                if(i==2 || i==3){
                                    if(isIn(points[i][0],start1[0],end1[0])&&isIn(points[i][1],start1[1],end1[1])){
                                        point[0] = points[i][0];
                                        point[1] = points[i][1];
                                    }
                                }
                            }
                        }
                        if(points[i][0]<point[0]){
                            if(i==0 || i==1){
                                if(isIn(points[i][0],start2[0],end2[0])&&isIn(points[i][1],start2[1],end2[1])){
                                    point[0] = points[i][0];
                                    point[1] = points[i][1];
                                }
                            }
                            if(i==2 || i==3){
                                if(isIn(points[i][0],start1[0],end1[0])&&isIn(points[i][1],start1[1],end1[1])){
                                    point[0] = points[i][0];
                                    point[1] = points[i][1];
                                }
                            }
                        }
                    }
                    return point;
                }
                return new double[]{};
            }
        }
        assert intersectionPoint != null;
        if(intersectionPoint.length==2){
            if(isIn(intersectionPoint[0],start1[0],end1[0])&& isIn(intersectionPoint[1],start1[1],end1[1])){
                if(isIn(intersectionPoint[0],start2[0],end2[0])&&isIn(intersectionPoint[1],start2[1],end1[1])){
                    return intersectionPoint;
                }
            }
        }
        return new double[]{};
    }

    public boolean isCoincide(int[] start1, int[] end1, int[] start2, int[] end2){ // 默认两条线段的斜率相同
        int x1 = start1[0];
        int y1 = start1[1];
        int x2 = end1[0];
        int y2 = end1[1];
        int x3 = start2[0];
        int y3 = start2[1];
        int x4 = end2[0];
        int y4 = end2[1];
        if(isIn(x1,x3,x4)&&isIn(y1,y3,y4)){
            return true;
        }
        if(isIn(x2,x3,x4)&&isIn(y2,y3,y4)){
            return true;
        }
        if(isIn(x3,x1,x2)&&isIn(y3,y1,y2)){
            return true;
        }
        if(isIn(x4,x1,x2)&&isIn(y4,y1,y2)){
            return true;
        }
        return false;
    }

    public boolean isIn(double x1, double x2, double x3){ // 判断x1是不是在x2和x3之间
        if(x2>x3){
            double temp = x2;
            x2 = x3;
            x3 = temp;
        }
        if(x1>=x2 && x1<=x3){
            return true;
        }
        return false;
    }

    public double[] intersectionOfTwoLines(int[] start1, int[] end1, int[] start2, int[] end2){ // 约定k1==k2时就返回null
        Line line1 = new Line(start1,end1);
        Line line2 = new Line(start2,end2);
        double k1 = line1.k;
        double b1 = line1.b;
        double k2 = line2.k;
        double b2 = line2.b;
        double dis=1e-6;
        if(Math.abs(k1-k2)<dis || (k1==Double.POSITIVE_INFINITY && k2==Double.POSITIVE_INFINITY)){
            return new double[]{};
        }
        // 斜率不存在的情况下需要特别讨论
        if(k1*k2==Double.POSITIVE_INFINITY){ // 有一条线的k是无穷大
            if(start1[0]==end1[0]){
                return new double[]{start1[0],start1[0]*k2+b2};
            }else{
                return new double[]{start2[0],start2[0]*k1+b1};
            }
        }
        double x = (b2-b1)/(k1-k2);
        double y = k1*x + b1;
        return new double[]{x,y};
    }

    public static void main(String[] args) {
        Solution1603 solu = new Solution1603();
//        int[] start1 = new int[]{0,3};
//        int[] end1 = new int[]{0,6};
//        int[] start2 = new int[]{0,1};
//        int[] end2 = new int[]{0,5};
//        int[] start1 = new int[]{0,0};
//        int[] end1 = new int[]{0,1};
//        int[] start2 = new int[]{0,0};
//        int[] end2 = new int[]{0,-1};
        int[] start1 = new int[]{1,0};
        int[] end1 = new int[]{1,1};
        int[] start2 = new int[]{-1,0};
        int[] end2 = new int[]{3,2};
        System.out.println(solu.isCoincide(start1, end1, start2, end2));
        System.out.println(Arrays.toString(solu.intersection(start1, end1, start2, end2)));
        System.out.println(Double.POSITIVE_INFINITY);

    }
}
