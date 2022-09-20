package two_sums_1;

import java.util.HashMap;
import java.util.Map;

class Solution {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(Integer.valueOf(nums[0]), 0);
    for (int index = 1; index < nums.length; index++) {
      int current = nums[index];
      int toBeMatched = target - current;
      if (map.containsKey(toBeMatched)) {
        return new int[]{map.get(toBeMatched), index};
      }
      map.put(current, index);
    }
    return null;
  }
}