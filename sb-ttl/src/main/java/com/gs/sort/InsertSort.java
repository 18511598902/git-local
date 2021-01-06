package com.gs.sort;
/**
 * @author LIn
 * �㷨���ƣ���������
 * �㷨������
 * 1.�Ե�i����������ǰi-1��Ԫ��Ϊ�����򣬽���i��Ԫ�ز�������������
 * 2.�ҵ����ʵ�λ�ú󣬸���/��С��Ԫ�������ƶ�һ��λ�ã����뵱ǰ����
 * 3.��i=1...n�ظ�ִ�в���1��2
 * 
 * ���Ӷȷ�����
 * 1.ƽ��ʱ�临�Ӷȣ�O(n^2)
 * 2.�ռ临�Ӷȣ�O(1)(��ʱ���ݽ����ռ�)
 */
public class InsertSort {
	
	public static void InsertSort(int[] a){
		int j;
		for(int i = 1; i < a.length; i++){
			int temp = a[i];
			for(j = i; j > 0 && temp < a[j-1]; j--){
				a[j] = a[j-1];
			}
			a[j] = temp;
		}
	}
	
	//����ֲ�����
	public static void InsertSort(int[] a, int left, int right){
		int j;
		for(int i = left + 1; i <= right; i++){
			int temp = a[i];
			for(j = i; j > 0 && temp < a[j-1]; j--){
				a[j] = a[j-1];
			}
			a[j] = temp;
		}
	}
}
