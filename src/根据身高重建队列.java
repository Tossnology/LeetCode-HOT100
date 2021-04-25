import java.util.*;

public class 根据身高重建队列 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] person1, int[] person2) {
                if (person1[0] != person2[0]) {
                    return person1[0] - person2[0];
                } else {
                    return person2[1] - person1[1];
                }
            }
        });

        int[][] queue = new int[people.length][people[0].length];
        boolean[] used2 = new boolean[people.length];
        Map<Integer, Integer> map = new HashMap<>();

        int cur = people[0][0];
        int count1 = -1;
        for (int k = 0; k < people.length; k++) {
            if (!used2[k]) {
                count1++;
                map.put(count1, k);
            }
        }
        for (int[] person : people) {
            if (person[0] != cur) {
                map.clear();
                count1 = -1;
                for (int k = 0; k < people.length; k++) {
                    if (!used2[k]) {
                        count1++;
                        map.put(count1, k);
                    }
                }
                cur = person[0];
            }
            insert(queue, used2, person[0], person[1], map);
        }

//        int count = 0;
//        while(count < people.length) {
//
//            map.clear();
//            int count1 = -1;
//            for(int k = 0; k <people.length; k++) {
//                if(!used2[k]) {
//                    count1++;
//                    map.put(count1, k);
//                }
//            }
//
//            for(int j = 0; j < people.length; j++) {
//                insert(queue, used2, people[j][0], people[j][1], map);
//                used1[j] = true;
//                count++;
//            }
//        }


        return queue;
    }

    public void insert(int[][] queue, boolean[] used2, int height, int k, Map<Integer, Integer> map) {
        queue[map.get(k)][0] = height;
        queue[map.get(k)][1] = k;
        used2[map.get(k)] = true;
    }

    public static void main(String[] args) {
        //new一个test对象
        根据身高重建队列 test = new 根据身高重建队列();
        //自定义测试用例
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        long startTime = System.currentTimeMillis();
        //输出结果
        test.reconstructQueue(people);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");

    }
}
