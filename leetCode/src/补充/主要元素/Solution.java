package 补充.主要元素;

public class Solution {
    public int majorityElement(int[] nums) {
        int flag = 0;
        int bft = 0;

        int length = nums.length;
        for (int num : nums) {
            if (flag == 0) {
                bft = num;
                flag++;
            } else if (bft == num) {
                flag++;
            } else {
                flag--;
            }
        }
        if(flag > 0){
            flag = 0;
            for (int num : nums) {
                if (num == bft){
                    flag++;
                }
            }
            if (flag > length / 2){
                return bft;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int i = new Solution().majorityElement(new int[]{1, 2, 5,6,6});
        System.out.println("主要元素：" + i);
    }
}
