import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class 寻找两个正序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result;
        ArrayList<Integer> n1 = new ArrayList<>();
        ArrayList<Integer> n2 = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            n1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            n2.add(nums2[i]);
        }
        n1.addAll(n2);
        Collections.sort(n1);
        if(n1.size()%2 == 0){
            result = (n1.get(n1.size()/2) + n1.get(n1.size()/2 - 1))/2;
        }else {
            result = n1.get(n1.size()/2);
        }
        return result;
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2){
        ArrayList<Integer> merge = new ArrayList<>();
        int p = (nums1.length+nums2.length)/2+1;
        int i = 0,j = 0;
        while (i+j!=p && i<nums1.length && j<nums2.length){
            if(nums1[i] >= nums2[j]){
                merge.add(nums2[j]);
                j++;
            }else{
                merge.add(nums1[i]);
                i++;
            }
        }
        while(i+j!=p){
            if(i<nums1.length){
                merge.add(nums1[i]);
                i++;
            }
            if(j<nums2.length){
                merge.add(nums2[j]);
                j++;
            }
        }
        if ((nums1.length+nums2.length)%2==0){
            return (double) (merge.get(merge.size()-1) + merge.get(merge.size()-2)) / 2;
        }else {
            return merge.get(merge.size()-1);
        }
    }

    public static void main(String[] args) {
        寻找两个正序数组的中位数 test = new 寻找两个正序数组的中位数();
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(test.findMedianSortedArrays2(nums1,nums2));
    }
}
