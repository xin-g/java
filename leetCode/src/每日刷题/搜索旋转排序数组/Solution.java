package 每日刷题.搜索旋转排序数组;

import com.sun.org.apache.xerces.internal.util.XMLInputSourceAdaptor;

public class Solution {
    public static boolean search(int[] nums, int target) {
        int n = nums.length;
        if(n == 0){
            return false;
        }
        if(n == 1){
            return target == nums[0] ? true : false;
        }

        int l = 0,r = n - 1;
        while (l <= r){
            int mid = (l + r) / 2;
            if(nums[mid] == target){
                return true;
            }

            // 对于重复元素，选择跳过
            if (nums[l] == nums[mid] && nums[r] == nums[mid]){
                l++;
                r--;
            }else if(nums[l] <= nums[mid]){
                if(nums[l] <= target && target < nums[mid]){
                    r = mid - 1;
                }else {
                    l = mid + 1;
                }
            }else {
                if(nums[mid] < target && target <= nums[n - 1]){
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("结果" + search(new int[]{2, 5, 6, 0, 0, 1, 2},3));
    }


}
