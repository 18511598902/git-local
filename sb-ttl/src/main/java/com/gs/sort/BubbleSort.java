package com.gs.sort;
/**
 * @author LIn
 * �㷨���ƣ�ð������(����)
 * �㷨������
 * 1.�ӵ�һ��Ԫ�ؿ�ʼ�����αȽ���������Ԫ�أ����ϴ�/��СԪ��ͨ��������������ĺ�
 *   ÿ��ð��Ч��Ϊ��һ�����/��СԪ��"�ϸ�"�������iλ(i=n...1)
 * 2.�ظ�����1
 * 
 * ���Ӷȷ�����
 * 1.ƽ��ʱ�临�Ӷȣ�O(n^2)
 * 2.�ռ临�Ӷȣ�O(1)(��ʱ���ݽ����ռ�)
 *
 */
public class BubbleSort {
	
	public static void BubbleSort(int[] a){
		for(int i = a.length-1; i > 0; i--){
			for(int j = 0; j < i; j++){
				if(a[j] > a[j+1]){
					swap(a,j,j+1);
				}
			}
		}
	}
	
	private static void swap(int[] a, int x, int y){
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}

}
