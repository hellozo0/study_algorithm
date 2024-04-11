import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {

        int N = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i < N; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            } else {
                map.put(nums[i], 1);
            }
        }
        
        if(N/2 <= map.size()){
            System.out.println("! " + N/2);
            return N/2;
        } else {
            System.out.println("? " + map.size());
            return map.size();
        }
        
    }
}