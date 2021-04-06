package 每日刷题.删除有序数组中的重复项;

/**
 * 双指针
 *
 * 慢指针i，快指针j
 * 由于前两个数字必备保留
 * 所有两个指针初始值从2开始
 * 当 num[i - 2] != num[j] ,num[i] = num[j]
 * 如此便覆盖了前面的数字
 * 最后 i 为数组长度
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(nums == null || nums.length <= 2)
            return n;
        int i = 2;
        for (int j = 2; j < n; j++) {
            if(nums[i - 2] != nums[j]){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
