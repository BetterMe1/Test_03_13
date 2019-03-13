package Test_0313;

import java.util.Arrays;

/*
1005. K 次取反后最大化的数组和 
给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个个索引 i 并将 A[i] 替换为 -A[i]，
然后总共重复这个过程 K 次。（我们可以多次选择同一个索引 i。）
以这种方式修改数组后，返回数组可能的最大和。
示例 1：
输入：A = [4,2,3], K = 1
输出：5
解释：选择索引 (1,) ，然后 A 变为 [4,-2,3]。
示例 2：
输入：A = [3,-1,0,2], K = 3
输出：6
解释：选择索引 (1, 2, 2) ，然后 A 变为 [3,1,0,2]。
示例 3：
输入：A = [2,-3,-1,5,-4], K = 2
输出：13
解释：选择索引 (1, 4) ，然后 A 变为 [2,3,-1,5,4]。
提示：
1 <= A.length <= 10000
1 <= K <= 10000
-100 <= A[i] <= 100
 */
/*
 * 分析：
 * 先对数组A排序，i指针遍历数组，当i>=K时跳出循环，此时i即代表了数组的索引，也累加了次数，
 * 若A[i]是负数，将A[i]取反，
 * 若A[i]不是负数，判断K-i是不是偶数，
 *             若是偶数，只需将A[i]取反K-i次，相当于不需要操作，
 *             若是奇数，说明将A[i]取反K-i-1次无用操作后，还需要再进行一次有用的操作，
 *             这时我们就需要找出代价最小的操作，
 *             判断取反A[i-1]、A[i]、A[i+1]哪个代价会最小，就取反哪个，同时需要注意避免数组越界，
 *             上述操作完成后，跳出循环，返回此时数组的元素和。
 */
public class LeetcodeTest {
	public static void main(String[] args) {
		Solution So = new Solution();
		int[] A = {2,-3,-1,5,-4};
		int K = 2;
		System.out.println(So.largestSumAfterKNegations(A, K));
	}
}
class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        for(int i=0; i<K;i++){
        	if(A[i] < 0 && i<A.length){
        		A[i] = -A[i];
        	}else if(A[i] != 0){
        		if((K-i)%2 != 0){
        			if(i+1<A.length){
        				if(i-1>=0){
        					if(A[i+1] <= A[i] && A[i+1] <= A[i-1]){
        						A[i+1] = -A[i+1];
        					}else if(A[i] <= A[i+1] && A[i] <= A[i-1]){
        						A[i] = -A[i];
        					}else{
        						A[i-1] = -A[i-1];
        					}
        				}else{
        					if(A[i] <= A[i+1]){
    							A[i] = -A[i];	
    						}else{
    							A[i+1] = -A[i+1];
    						}
        				}
        			}else{
        				if(i-1>=0){
    						if(A[i] <= A[i-1]){
    							A[i] = -A[i];	
    						}else{
    							A[i-1] = -A[i-1];
    						}
    					}else{
    						A[i] = -A[i];
    					}
        			}
        		}
        		break;
        	}
        }
        int sum = 0;
        for(int j=0; j<A.length; j++){
        	sum += A[j];
        }
        return sum;
    }
}