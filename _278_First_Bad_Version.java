/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    // in binary search, we should use:
    // mid = start + (end - start) / 2
    // because in mid = (start+end)/2
    // start + end will usually overflow
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while(end > start){
            int mid = start + (end - start) / 2;
            System.out.println(mid);
            if(isBadVersion(mid)){
                // bad version
                end = mid;
            }else{
                // good version
                start = mid + 1;
            }
        }
        return start;
    }
}
