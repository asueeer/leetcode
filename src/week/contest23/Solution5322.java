package week.contest23;

/**
 * @author wangyisu
 */
public class Solution5322 {
    public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
        int rec_x = (x1+x2)/2;
        int rec_y = (y1+y2)/2;
        int rec_width = Math.abs(x1-x2);
        int rec_high = Math.abs(y1-y2);
        int cir_x = x_center;
        int cir_y = y_center;
        int cir_size = radius;
        int x = Math.min( Math.abs( rec_x + rec_width / 2 - cir_x), Math.abs(rec_x - rec_width / 2 - cir_x));
        int y = Math.min( Math.abs(rec_y + rec_high / 2 - cir_y), Math.abs(rec_y - rec_high / 2 - cir_y ));
        if  (x * x + y * y < cir_size * cir_size * 4){
            return true;
        }
        if((Math.abs(rec_x - cir_x) < ((rec_width + cir_size) / 2) )&& Math.abs(rec_y - cir_y) < (rec_high / 2)){
            return true;
        }
        if (Math.abs(rec_y - cir_y ) < ((rec_high + cir_size) / 2 ) && Math.abs(rec_x - cir_x) < (rec_width / 2)){
            return true;
        }
        return false;
    }
}
