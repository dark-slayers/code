package person.liuxx.learn.code.leetcode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:<br>
 * 输入: s = "abcabcbb"<br>
 * 输出: 3 <br>
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:<br>
 * 输入: s = "bbbbb"<br>
 * 输出: 1<br>
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:<br>
 * 输入: s = "pwwkew"<br>
 * 输出: 3<br>
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。<br>
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。<br>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 5 * 10的4次方<br>
 * s 由英文字母、数字、符号和空格组成
 * <p>
 * 
 * @author
 * 
 * @version 1.0.0<br>
 *          创建时间：2022年3月15日 下午5:22:34
 * 
 * @since 1.0.0
 */
public class Problem3 {
    public int lengthOfLongestSubstring(String s) {
        if (Objects.equals(1, s.length())) {
            return 1;
        }
        int max = 0;
        for (int left = 0, length = s.length(); left < length; left++) {
            if ((length - left) <= max) {
                return max;
            }
            Set<Character> set = new HashSet<>();
            set.add(s.charAt(left));
            for (int right = left + 1; right < length; right++) {
                if (set.contains(s.charAt(right))) {
                    int value = right - left;
                    if (value > max) {
                        max = value;
                    }
                    break;
                } else if (Objects.equals(right, length - 1)) {
                    return length - left;
                }
                set.add(s.charAt(right));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "au";
        System.out.println(new Problem3().lengthOfLongestSubstring(s));
    }
}
