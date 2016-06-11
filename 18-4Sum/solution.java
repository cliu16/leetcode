public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        
        
        for(int i=0;i<nums.length-3;i++){
            for(int j=i+1;j<nums.length-2;j++){
                int s = j+1;
                int e = nums.length -1;
                while(s<e){
                    int sum = nums[i]+nums[j]+nums[s]+nums[e];
                    if(sum==target){
                        List<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[s]);
                        tmp.add(nums[e]);
                        ret.add(tmp);
                        
                        s++;
                        e--;
                        
                        while(s<e&&nums[s]==nums[s-1])s++;
                        while(s<e&&nums[e]==nums[e+1])e--;
                    }else if(sum<target){
                        s++;
                    }else{
                        e--;
                    }
                }
                 while(j<nums.length-1&&nums[j]==nums[j+1])j++;
            }
             while(i<nums.length-2&&nums[i]==nums[i+1])i++;
        }
        return ret;
    }
}