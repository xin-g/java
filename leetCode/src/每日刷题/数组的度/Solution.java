package 每日刷题.数组的度;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer,int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            }else {
                map.put(nums[i],new int[]{1,i,i});
            }
        }
        int max = 0,resLen = 0;
        for(Map.Entry<Integer,int[]> entry : map.entrySet()){
            if (entry.getValue()[0] > max){
                max = entry.getValue()[0];
                resLen = entry.getValue()[2] - entry.getValue()[1] + 1;
            }else if(entry.getValue()[0] == max){
                int len = entry.getValue()[2] - entry.getValue()[1] + 1;
                if(resLen > len){
                    max = entry.getValue()[0];
                    resLen = entry.getValue()[2] - entry.getValue()[1] + 1;
                }
            }

        }

        return resLen;
    }

    public static void main(String[] args) {
        int shortestSubArray = new Solution().findShortestSubArray(new int[]{1,2,2,3,1});
        System.out.println(shortestSubArray);
    }
}
