package com.gs.sort;
/**
 * @author LIn
 * �㷨���ƣ�ѡ������
 * �㷨������
 * 1.�Ӵ����������Ԫ����ѡ����С/����һ��Ԫ�أ���������е���ʼλ��
 * 2.��i=1...n�ظ�����1
 *
 * ���Ӷȷ�����
 * 1.ƽ��ʱ�临�Ӷȣ�O(n^2)
 * 2.�ռ临�Ӷȣ�O(1)(��ֵԪ�ش洢�ռ�)
 */
public class SelectSort {
	
	public static void SelectSort(int[] a){
		for(int i = 0; i < a.length; i++){
			int min = i;
			for(int j = i + 1; j < a.length; j++){
				if (a[j] < a[min]) { //�����С�ڵ�ǰ��Сֵ��Ԫ��
					min = j;
                }
			}
			if (i != min){
				swap(a, i, min);
			}
		}
	}
	
	private static void swap(int[] a, int x, int y){
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}

}
