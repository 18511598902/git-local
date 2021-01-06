package com.gs.sort;
/**
 * @author LIn
 * �㷨���ƣ�ѡ������(�򵥹���ʵ���������)
 * �㷨������
 * 1.�Ӵ����������Ԫ����ѡ����С/����һ��Ԫ�أ���������е���ʼλ��
 * 2.��i=1...n�ظ�����1
 *
 * ���Ӷȷ�����
 * 1.ƽ��ʱ�临�Ӷȣ�O(n^2)
 * 2.�ռ临�Ӷȣ�O(1)(��ֵԪ�ش洢�ռ�)
 */

/*���ݱȽϽӿ�*/
interface IntCompare{
	public boolean cmp(int x,int y);
}
/*����*/
class Cmp1 implements IntCompare{
	public boolean cmp(int x,int y){
		if(x > y){
			return true;
		}else{
			return false;
		}
	}
}
/*����*/
class Cmp2 implements IntCompare{
	public boolean cmp(int x,int y){
		if(x > y){
			return false;
		}else{
			return true;
		}
	}
}
//ѡ������ʵ��
public class SelectSortX {

	public static void SelectSort(int[] a, IntCompare cmp){
		for(int i = 0; i < a.length; i++){
			int min = i;
			for(int j = i + 1; j < a.length; j++){
				if(cmp.cmp(a[min], a[j])){
					min = j;
				}
				if (i != min){
					swap(a, i, min);
				}
			}
		}
	}
	
	public static void swap(int[] a, int x, int y){
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	
	
	public static void main(String[] args) {
		int[] array = {4,2,1,6,3,6,0,-5,1,1};
//		SelectSort(array, new Cmp1());      //��������
		SelectSort(array, new Cmp2());      //��������
		for(int i = 0; i < array.length; i++){
			System.out.printf("%d ",array[i]);
		}

	}

}
