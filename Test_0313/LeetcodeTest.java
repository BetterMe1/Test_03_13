package Test_0313;

import java.util.Arrays;

/*
1005. K ��ȡ������󻯵������ 
����һ���������� A������ֻ�������·����޸ĸ����飺����ѡ��ĳ�������� i ���� A[i] �滻Ϊ -A[i]��
Ȼ���ܹ��ظ�������� K �Ρ������ǿ��Զ��ѡ��ͬһ������ i����
�����ַ�ʽ�޸�����󣬷���������ܵ����͡�
ʾ�� 1��
���룺A = [4,2,3], K = 1
�����5
���ͣ�ѡ������ (1,) ��Ȼ�� A ��Ϊ [4,-2,3]��
ʾ�� 2��
���룺A = [3,-1,0,2], K = 3
�����6
���ͣ�ѡ������ (1, 2, 2) ��Ȼ�� A ��Ϊ [3,1,0,2]��
ʾ�� 3��
���룺A = [2,-3,-1,5,-4], K = 2
�����13
���ͣ�ѡ������ (1, 4) ��Ȼ�� A ��Ϊ [2,3,-1,5,4]��
��ʾ��
1 <= A.length <= 10000
1 <= K <= 10000
-100 <= A[i] <= 100
 */
/*
 * ������
 * �ȶ�����A����iָ��������飬��i>=Kʱ����ѭ������ʱi�������������������Ҳ�ۼ��˴�����
 * ��A[i]�Ǹ�������A[i]ȡ����
 * ��A[i]���Ǹ������ж�K-i�ǲ���ż����
 *             ����ż����ֻ�轫A[i]ȡ��K-i�Σ��൱�ڲ���Ҫ������
 *             ����������˵����A[i]ȡ��K-i-1�����ò����󣬻���Ҫ�ٽ���һ�����õĲ�����
 *             ��ʱ���Ǿ���Ҫ�ҳ�������С�Ĳ�����
 *             �ж�ȡ��A[i-1]��A[i]��A[i+1]�ĸ����ۻ���С����ȡ���ĸ���ͬʱ��Ҫע���������Խ�磬
 *             ����������ɺ�����ѭ�������ش�ʱ�����Ԫ�غ͡�
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