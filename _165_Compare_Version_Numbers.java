public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");
        int i = 0;
        for(; i < nums1.length && i < nums2.length; i++){
            if(Integer.parseInt(nums1[i]) > Integer.parseInt(nums2[i])){
                return 1;
            }else if(Integer.parseInt(nums1[i]) < Integer.parseInt(nums2[i])){
                return -1;
            }
        }
        if(nums1.length > nums2.length){
            int j = i;
            while(j < nums1.length){
                if(Integer.parseInt(nums1[j]) > 0){
                    return 1;
                }
                j ++;
            }
        }else if(nums1.length < nums2.length){
            int j = i;
            while( j < nums2.length){
                if(Integer.parseInt(nums2[j]) > 0){
                    return -1;
                }
                j ++;
            }
        }
        return 0;
    }
}
