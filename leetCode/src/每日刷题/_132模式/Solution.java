package 每日刷题._132模式;

import java.util.TreeMap;

public class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if(n < 3){
            return false;
        }

        // 左侧最小
        int leftMin = nums[0];
        // 右侧所有元素
        TreeMap<Integer,Integer> rightAll = new TreeMap<>();

        // 从第三个数开始，全部加入右侧Map集合中
        for (int k = 2; k < n; k++) {
            rightAll.put(nums[k],rightAll.getOrDefault(nums[k],0) + 1);
        }

        // 做比较
        for (int j = 1; j < n - 1; j++) {
            if(leftMin < nums[j]){
                Integer next = rightAll.ceilingKey(leftMin + 1);
                if(next != null && next < nums[j])
                    return true;
            }
            // 选取一个最小的数
            leftMin = Math.min(leftMin,nums[j]);

            // 将下一个右侧的数，个数减一；如果个数为0，则将这个数移除
            rightAll.put(nums[j + 1], rightAll.get(nums[j + 1]) - 1);
            if(rightAll.get(nums[j + 1]) == 0){
                rightAll.remove(nums[j + 1]);
            }
        }
        return false;
    }


}
