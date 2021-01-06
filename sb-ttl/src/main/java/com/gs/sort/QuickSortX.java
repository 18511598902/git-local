package com.gs.sort;
/**
 * @author LIn
 * �㷨���ƣ���������
 * �㷨������
 * 1.ͨ��һ������Ҫ��������ݷָ�ɶ����������֣�����һ���ֵ��������ݶ�������һ���ֵ��������ݶ�ҪС
 * 2.�ظ�����1�������������ݷֱ���п�����������������̿��Եݹ���У��Դ˴ﵽ�������ݱ���������С�
 * �㷨�Ľ���
 * 1.������ֵ�ָѡ���׼��/��ŦԪ
 * 2.ѡ���ֹ��Χ(cutoff range)�Լӿ�����(�������Сʱ����������ȿ��������)
 *
 * ���Ӷȷ�����
 * 1.ƽ��ʱ�临�Ӷȣ�O(nlogn)
 * 2.�ռ临�Ӷȣ�O(logn)(��ֵԪ�ش洢�ռ�)
 */
public class QuickSortX {
	private final static int CUTOFF = 0;  //�ضϷ�Χ
	
	public static void QuickSort(int[] a, int left, int right){
		if(left + CUTOFF <= right){
			int pivot = median3(a, left, right);
			
			//��ʼ����
			int i = left, j = right - 1;
			for( ; ; ){
				while(i < j && a[++i] < pivot){}
				while(i < j && a[--j] > pivot){}
				if(i < j){
					swap(a, i, j);
					
				}
				else{
					break;
				}
			}
			
			swap(a, i, right-1);    //�����׼��
			
			QuickSort(a, left, i - 1);    //����СԪ������
			QuickSort(a, i + 1, right);   //���ϴ�Ԫ������
		}
		else{   //������������ò�������
			InsertSort.InsertSort(a, left, right);
		}
	}
	
	/**
	 * �����������������ػ�׼��
	 * ��������������ֵ
	 */
	private static int median3(int[] a, int left, int right) {
		int center = (left + right) / 2;
		if(a[center] < a[left]){
			swap(a, left, center);
		}
		if(a[right] < a[left]){
			swap(a, left, right);
		}
		if(a[right] < a[center]){
			swap(a, center, right);
		}
		
		//����׼�������right-1λ����
		swap(a, center, right - 1);
		return a[right-1];
	}

	private static void swap(int[] a, int x, int y){
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}

}
