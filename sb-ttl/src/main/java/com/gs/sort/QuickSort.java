package com.gs.sort;
/**
 * @author LIn
 * �㷨���ƣ���������
 * �㷨������
 * 1.ͨ��һ������Ҫ��������ݷָ�ɶ����������֣�����һ���ֵ��������ݶ�������һ���ֵ��������ݶ�ҪС
 * 2.�ظ�����1�������������ݷֱ���п�����������������̿��Եݹ���У��Դ˴ﵽ�������ݱ���������С�
 *
 * ���Ӷȷ�����
 * 1.ƽ��ʱ�临�Ӷȣ�O(nlogn)
 * 2.�ռ临�Ӷȣ�O(logn)(��ֵԪ�ش洢�ռ�)
 */
public class QuickSort {
	
	public static void quickSort(int[] a){
		quickSort(a, 0, a.length);
	}

	private static void quickSort(int[] a, int left, int right){
		int pivotpos;  //���ֺ��׼��λ��
		if(left < right){
			pivotpos = Partition(a, left ,right);
			quickSort(a, left, pivotpos);
			quickSort(a, pivotpos+1, right);
		}
	}
	
	/**
	 * ��ͨѡ���׼
	 */
	private static int Partition(int[] a, int i, int j){
		//����Partition(a,left,right)ʱ����a[left...right]������
		//�����ػ�׼��¼��λ��
		int flag = i;
		int pivot = a[i];  //������ĵ�һ����¼��Ϊ��׼
		
		while (true) {
			while (i < j && a[--j] >= pivot)
				;
			while (i < j && a[++i] <= pivot)
				;
			if (i < j) {
				swap(a, i, j);
			} else {
				break;
			}
		}
		
		swap(a, i, flag);
		return i;
	}
	
	public static int find_K_Max(int[] a, int k){
		int low = 0, high = a.length;
		int target = 0;
		while(low < high){
			int pivot = Partition(a, low, high);
			if(k - 1 == pivot){
				target =  a[pivot];
				break;
			}else if(pivot > k - 1){
				high = pivot;
			}else{
				low = pivot + 1;
			}
			
		}
		
		return target;
	}
	

	private static void swap(int[] a, int x, int y){
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}

}
