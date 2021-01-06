package com.gs.sort;
/**
 * @author LIn
 * �㷨���ƣ�������
 * �㷨������
 * 1.������ʱ�佨��һ����
 * 2.������/���ˣ�ÿ�ν����/��СԪ��"�ϸ�"���Ѷ���
 * 3.�����е����Ԫ����Ѷ�Ԫ�ؽ�����Ȼ�󽫶ѵĴ�С����1�����в���2
 * 
 * ���Ӷȷ�����
 * 1.ƽ��ʱ�临�Ӷȣ�O(nlogn)
 * 2.�ռ临�Ӷȣ�O(1)(��ʱ���ݽ����ռ�)
 * 
 */
public class HeapSort {
	/**
	 * ������������
	 * @param a  ���������Ŀ������
	 */
	public static void HeapSort(int[] a){
		int i;
		int len = a.length;
		for(i = len / 2 - 1; i >= 0; i--){  /*��ʼ��*/
			adjustMinHeap(a, i, len);  
		}
		for(i = len - 1; i > 0; i--){
			swap(a, 0, i);                    /*ɾ�����ֵ*/
			adjustMinHeap(a, 0, i);         /*������*/ 
		}
	}
	
	/**
	 * ��������������
	 * @param i  ���е�Ԫ�ص��±�
	 * @return   ���ӵ��±�
	 */
	private static int leftChild(int i){
		return 2 * i + 1;
	}
	
	/**
	 * ����������С����
	 * @param a  ��Ƚϵ���Ŀ������
	 * @param i  �ѵ��������
	 * @param n  �ѵĴ�С
	 */
	private static void adjustMinHeap(int[] a,int i,int n){
		int temp;
		int child;
		
		for(temp = a[i]; leftChild(i) < n; i = child){
			child = leftChild(i);
			if(child != n - 1 && a[child] < a[child+1]){
				child++;
			}
			if(a[child] > temp){
				a[i] = a[child];
			}else{
				break;
			}
		}
		a[i] = temp;
	}
	/**
	 * �������е�ֵ
	 * @param a
	 * @param x
	 * @param y
	 */
	private static void swap(int[] a, int x, int y){
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
}
