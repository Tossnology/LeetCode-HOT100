import java.util.ArrayList;
import java.util.Collections;

public class 最长回文子串 {
    public String longestPalindrome(String s) {
        String result = "";
        ArrayList<String> pldrms = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.reverse();
        String rs = sb.toString();

        StringBuilder pldrm = new StringBuilder();
        int count = 0;

        for (int j = s.length()-1; j >= 0; j--) {
            for (int k = j; k < s.length(); k++) {
                if (rs.charAt(k)==s.charAt(k-j)){
                    pldrm.append(rs.charAt(k));
                    count++;
                }else if(count!=0){
                    pldrms.add(pldrm.toString());
                    pldrm.delete(0,count);
                    count = 0;
                }
            }
            if(count!=0){
                pldrms.add(pldrm.toString());
                pldrm.delete(0,count);
                count = 0;
            }
        }


        for (int i = 1; i < s.length(); i++) {
            for (int k = i; k < s.length(); k++) {
                if (s.charAt(k)==rs.charAt(k-i)){
                    pldrm.append(s.charAt(k));
                    count++;
                }else if(count!=0){
                    pldrms.add(pldrm.toString());
                    pldrm.delete(0,count);
                    count = 0;
                }
            }
            if(count!=0){
                pldrms.add(pldrm.toString());
                pldrm.delete(0,count);
                count = 0;
            }
        }

        //返回pldrms中最长的
        String tmp = pldrms.get(0);
        for (String p : pldrms) {
            if (p.length() > tmp.length() && isPalindrome(p)){
                tmp = p;
            }
        }
        result = tmp;
        return result;
    }

    boolean isPalindrome(String s){
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.reverse();
        return s.equals(sb.toString());
    }

    public static void main(String[] args) {
        String s = "aca";
        最长回文子串 n = new 最长回文子串();
        System.out.println(n.longestPalindrome(s));
    }

    //复杂度太高了，没通过
    public String longestPalindrome2(String s){
        String result;
        ArrayList<String> pldrms = new ArrayList<>();
        String tmp;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                tmp = s.substring(i,j+1);
                if(isPalindrome(tmp)){
                    pldrms.add(tmp);
                }
            }
        }
        tmp = pldrms.get(0);
        for (String p : pldrms) {
            if (p.length() > tmp.length()){
                tmp = p;
            }
        }
        result = tmp;
        return result;
    }
}
