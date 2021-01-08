import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class 无重复字符的最长字串 {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        if(s.equals("")){
            return result;
        }
        char[] arr = s.toCharArray();
        Set<Character> sub = new HashSet<>();
        ArrayList counter = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            while(!sub.contains(arr[j]) && j != arr.length-1){
                sub.add(arr[j]);
                j++;
            }
            if(j == arr.length-1){
                sub.add(arr[j]);
            }
            counter.add(sub.size());
            sub.clear();
        }
        result = (Integer) Collections.max(counter);
        return result;
    }
}