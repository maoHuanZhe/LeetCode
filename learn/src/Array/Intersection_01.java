package Array;

import java.util.*;

/**
 * 数组的交集
 * 349. 两个数组的交集
 * 350. 两个数组的交集 II
 * 
 * @author fan guang rui
 * @date 2020年07月21日 20:41
 */
public class Intersection_01 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(notRepeatIntersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(notRepeatIntersection(new int[]{4,9,5}, new int[]{9,4,9,8,4})));

        System.out.println(Arrays.toString(repeatIntersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(repeatIntersection(new int[]{4,9,5}, new int[]{9,4,9,8,4})));

        System.out.println(Arrays.toString(repeatIntersectionPro1(new int[]{1,3,4,4,13}, new int[]{1,4,9,10})));
    }

    /**
     * 349. 两个数组的交集
     * 给定两个数组，编写一个函数来计算它们的交集。
     *
     * 示例 1：
     *
     * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出：[2]
     * 示例 2：
     *
     * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出：[9,4]
     *  
     * 说明：
     *
     * 输出结果中的每个元素一定是唯一的。
     * 我们可以不考虑输出结果的顺序。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] notRepeatIntersection(int[] nums1,int[] nums2){
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        int index = 0;
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }
        for (Integer integer : set2) {
            if (set.contains(integer)){
                nums1[index++] = integer;
            }
        }
        return Arrays.copyOf(nums1,index);
    }

    /**
     * 350. 两个数组的交集 II
     * 给定两个数组，编写一个函数来计算它们的交集。
     *
     * 示例 1：
     *
     * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出：[2,2]
     * 示例 2:
     *
     * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出：[4,9]
     *  
     *
     * 说明：
     *
     * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
     * 我们可以不考虑输出结果的顺序。
     * 进阶：
     *
     * 如果给定的数组已经排好序呢？你将如何优化你的算法？
     * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
     * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] repeatIntersection(int[] nums1,int[] nums2){
        Map<Integer,Integer> map = new HashMap<>();
        int index = 0;
        for (int i : nums1) {
            int count = map.getOrDefault(i,0) + 1;
            map.put(i,count);
        }
        for (int i : nums2) {
            int count = map.getOrDefault(i, 0);
            if (count>0){
                nums1[index++] = i;
                map.put(i,count-1);
            }
        }
        return Arrays.copyOf(nums1,index);
    }

    /**
     * 350. 两个数组的交集 II
     * 进阶1：如果给定的数组已经排好序呢？你将如何优化你的算法？
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] repeatIntersectionPro1(int[] nums1,int[] nums2){
        int index_nums1 = 0;
        int index_nums2 = 0;
        int index_result = 0;
        while (index_nums1<nums1.length && index_nums2<nums2.length){
            int compare = Integer.compare(nums1[index_nums1], nums2[index_nums2]);
            switch (compare){
                case -1:
                    index_nums1++;
                    break;
                case 1:
                    index_nums2++;
                    break;
                case 0:
                    nums1[index_result++] = nums1[index_nums1++];
                    index_nums2++;
                    break;
            }
        }
        return Arrays.copyOf(nums1,index_result);
    }
}
