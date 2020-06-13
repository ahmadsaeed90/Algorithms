class HouseRobWithCircular {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        
        if (nums.length == 1)
            return nums[0];
        
        // do not include first house
        int [] dp1 = new int[nums.length];
        
        dp1[0] = 0;
        dp1[1] = nums[1];
        
        for (int i = 2; i < dp1.length; i++) {
            dp1[i] = Math.max(nums[i] + dp1[i-2], dp1[i-1]);
        }
        
        // do not include last house
        int [] dp2 = new int[nums.length];
        
        dp2[0] = nums[0];
        dp2[1] = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < nums.length-1; i++) {
            dp2[i] = Math.max(nums[i] + dp2[i-2], dp2[i-1]);
        }
        
        return Math.max(dp1[dp1.length-1], dp2[dp2.length - 2]);
    }
}
