import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void name() {
    Solution solution = new Solution();
    solution.lengthOfLongestSubstring("abcabcbb");
  }
}