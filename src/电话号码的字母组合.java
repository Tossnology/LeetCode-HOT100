import java.util.*;


public class 电话号码的字母组合 {
    static final Map<Character, List<String>> BUTTONS = new HashMap<>();
    static {
        BUTTONS.put('2', Arrays.asList("a", "b", "c"));
        BUTTONS.put('3', Arrays.asList("d", "e", "f"));
        BUTTONS.put('4', Arrays.asList("g", "h", "i"));
        BUTTONS.put('5', Arrays.asList("j", "k", "l"));
        BUTTONS.put('6', Arrays.asList("m", "n", "o"));
        BUTTONS.put('7', Arrays.asList("p", "q", "r", "s"));
        BUTTONS.put('8', Arrays.asList("t", "u", "v"));
        BUTTONS.put('9', Arrays.asList("w", "x", "y", "z"));
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length()==1){
            return BUTTONS.get(digits.charAt(0));
        }else {
            List<String> ans = new ArrayList<>();
            if (digits.equals("")){
                return ans;
            }
            List<String> subans = new ArrayList<>();
            subans.addAll(letterCombinations(digits.substring(1)));
            char current = digits.charAt(0);
            for (int i = 0; i < BUTTONS.get(current).size(); i++) {
                List<String> tmp = new ArrayList<>();
                tmp.addAll(subans);
                for (int j = 0; j < tmp.size(); j++) {
                    tmp.set(j, BUTTONS.get(current).get(i) + tmp.get(j));
                }
                ans.addAll(tmp);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        电话号码的字母组合 test = new 电话号码的字母组合();
        System.out.println(test.letterCombinations(digits));
    }
}
