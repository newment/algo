package ink.ican.algo.heima.P001;

public class BinarySearch {

    /**
     * 二分查找基础版
     * @param a 有序数组
     * @param target 目标值
     * @return 目标索引
     */
    public static int binarySearch(int[] a, int target){
        int  left= 0, right = a.length-1;
        int mid;
        while (left <= right){
            mid = (left+right)>>>1;     // 使用右移代替除法,防止溢出同时能提高效率
            if(a[mid] < target){
                left = mid + 1;
            }
            else if (target < a[mid]){
                right = mid - 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 二分查找改动版
     * @param a 有序数组
     * @param target 目标值
     * @return 目标索引
     */
    public static int binarySearchAlternative(int[] a, int target){
        int  left= 0, right = a.length;
        int mid;
        while (left < right){
            mid = (left+right)>>>1;     // 使用右移代替除法,防止溢出同时能提高效率
            if(a[mid] < target){
                left = mid + 1;
            }
            else if (target < a[mid]){
                right = mid;
            }
            else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 二分查找平衡版
     * @param a 有序数组
     * @param target 目标值
     * @return 目标索引
     */
    public static int binarySearchBalance(int[] a, int target){
        int  left= 0, right = a.length;
        int mid = -1;
        while (left < right - 1){
            mid = (left+right)>>>1;     // 使用右移代替除法,防止溢出同时能提高效率
            if (target < a[mid]){
                right = mid;
            }
            else {
                left = mid;
            }
        }
        if(a[left] == target){
            return left;
        }
        return -1;
    }

    /**
     * 二分查找 LeftMost
     * @param a 待查找的升序数组
     * @param target 待查找的目标值
     * @return 找到返回索引, 找不到返回-1
     */
    public static int binarySearchLeftMost(int[] a, int target){

        int  left= 0, right = a.length - 1;
        int mid, candidate = -1;
        while (left <= right){
            mid = (left+right)>>>1;     // 使用右移代替除法,防止溢出同时能提高效率
            if(a[mid] < target){
                left = mid + 1;
            }
            else if (target < a[mid]){
                right = mid-1;
            }
            else {
                candidate = mid;
                right = mid-1;
            }
        }
        return candidate;
    }

    /**
     * 二分查找 LeftMost 返回值修改
     * @param a 待查找的升序数组
     * @param target 待查找的目标值
     * @return 大于等于target的最靠左的索引
     */
    public static int binarySearchLeftMost1(int[] a, int target){

        int  left= 0, right = a.length - 1;
        int mid;
        while (left <= right){
            mid = (left+right)>>>1;     // 使用右移代替除法,防止溢出同时能提高效率
            if(a[mid] < target){
                left = mid + 1;
            }
            else {
                right = mid-1;
            }
        }
        return left;
    }


    /**
     * 二分查找 RightMost
     * @param a 待查找的升序数组
     * @param target 待查找的目标值
     * @return 找到返回索引, 找不到返回-1
     */
    public static int binarySearchRightMost(int[] a, int target){

        int  left= 0, right = a.length - 1;
        int mid, candidate = -1;
        while (left <= right){
            mid = (left+right)>>>1;     // 使用右移代替除法,防止溢出同时能提高效率
            if(a[mid] < target){
                left = mid + 1;
            }
            else if (target < a[mid]){
                right = mid-1;
            }
            else {
                candidate = mid;
                left = mid+1;
            }
        }
        return candidate;
    }

    /**
     * 二分查找 RightMost 返回值
     * @param a 待查找的升序数组
     * @param target 待查找的目标值
     * @return 小于等于target的最靠右索引
     */
    public static int binarySearchRightMost1(int[] a, int target){

        int  left= 0, right = a.length - 1;
        int mid;
        while (left <= right){
            mid = (left+right)>>>1;     // 使用右移代替除法,防止溢出同时能提高效率
            if(a[mid] <= target){
                left = mid + 1;
            }
            else {
                right = mid-1;
            }
        }
        return left-1;
    }



}
