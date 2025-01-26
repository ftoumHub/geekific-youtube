package com.youtube.geekific;

import java.util.*;

/*
 * Video Reference: https://youtu.be/mQYABctoZ3E & https://youtu.be/VEPCm3BCtik
 * LeetCode Reference: https://leetcode.com/problems/two-sum/
 */
public class _0001_TwoSum {

    // Returns values
    public int[] twoSum_bruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{nums[i], nums[j]};
                }
            }
        }
        return new int[2];
    }

    // Returns values
    public int[] twoSum_sorting(int[] nums, int target) {
        Arrays.sort(nums);
        return twoSum_sortedArray(nums, target);
    }

    private int[] twoSum_sortedArray(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) left++;
            else if (sum > target) right--;
            else return new int[]{nums[left], nums[right]};
        }
        return new int[2];
    }

    // Returns values
    public int[] twoSum_linear(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(target - num)) {
                return new int[]{target - num, num};
            }
            set.add(num);
        }
        return new int[2];
    }

    // Returns indices
    public int[] twoSum_noDuplicateAllowed(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int idx = 0; idx < nums.length; idx++) {
            map.put(nums[idx], idx);
        }
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) left++;
            else if (sum > target) right--;
            else return new int[]{map.get(nums[left]), map.get(nums[right])};
        }
        return new int[2];
    }

    // Returns indices
    public int[] twoSum_leetCode(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[2];
    }

}
