class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        int left = height[0];
        for(int i = 0; i < height.length; i++){
            left = Math.max(left, height[i]);
            leftMax[i] = left;
        }

        int right = height[height.length - 1];
        for(int i = height.length - 1; i >= 0; i--){
            right = Math.max(right, height[i]);
            rightMax[i] = right;
        }
        
        int ret = 0;
        for(int i = 0; i < height.length; i++){
            int min = Math.min(leftMax[i], rightMax[i]);
            ret += min - height[i];
        }

        return ret;
    }
}
