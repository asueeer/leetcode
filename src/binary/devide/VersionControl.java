package binary.devide;

/**
 * @author wangyisu
 * leetcode278里的一个类
 */
public class VersionControl {
    static int firstBadVersion = 1702766719;
    public VersionControl() {
    }

    /**The isBadVersion API is defined in the parent class VersionControl.*/
    static boolean isBadVersion(int version) {
        if(version<firstBadVersion && version>0){
            return false;
        }else{
            return true;
        }
    }
}
