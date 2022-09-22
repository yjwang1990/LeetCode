package lengthOfLongestSubstring3;

import java.util.HashMap;
import java.util.Map;

class Solution {
  public int lengthOfLongestSubstring(String s) {
    int indexSlow = 0;
    int indexFast = 0;
    int longest = 0;
    Map<Character, Integer> map = new HashMap<>();
    while (indexFast < s.length()) {
      char currentChar = s.charAt(indexFast);
      if (map.containsKey(currentChar)) {
        longest = Math.max(longest, indexFast - indexSlow);
        Integer targetPosition = map.get(currentChar);
        while (indexSlow <= targetPosition) {
          map.remove(s.charAt(indexSlow));
          indexSlow++;
        }
      }
      map.put(currentChar, indexFast);
      indexFast++;
    }
    return Math.max(longest, indexFast - indexSlow);
  }
}