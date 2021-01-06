package com.gs.sort;
/**
 * @author LIn
 * �㷨���ƣ��鲢����
 * �㷨������
 * 1.�������Ϊn�ȷ�(�㷨��Ϊ2)���Ը�������ݹ���ù鲢����
 * 2.�ȷ�Ϊ2��ʱΪ2·�鲢�������������������󣬽�Ԫ�غϲ����������ƻ�ԭ����
 * 
 * ���Ӷȷ�����
 * 1.ƽ��ʱ�临�Ӷȣ�O(nlogn)
 * 2.�ռ临�Ӷȣ�O(n)(��ʱ���ݴ���ռ�)
 */
public class MergeSort {
	
	/*public�͵�mergeSort��private�͵ݹ鷽��mergeSort����������*/
	public static void mergeSort(int[] a){
		int[] tempArray = new int[a.length];   //������Ԫ��Ϊ�������ͣ��贴��Comparable������飬��ǿתΪ�ö�������
		
		mergeSort(a, tempArray, 0, a.length - 1);
	}
	
	/**
	 * �ݹ���ù鲢����
	 */
	private static void mergeSort(int[] a, int[] tempArray, int left, int right){
		if(left < right){
			int center = (left + right) / 2;
			mergeSort(a, tempArray, left, center);
			mergeSort(a, tempArray, center + 1, right);
			merge(a, tempArray, left, center + 1, right);   //��������������󣬽�������ϲ�
		}
	}
	
	/**
	 * �ϲ����ҵİ��������
	 * @param a          ����������
	 * @param tempArray  ��ʱ�洢����
	 * @param leftPos    ��������鿪ʼ���±�
	 * @param rightPos   �Ұ������鿪ʼ���±�
	 * @param rightEnd   �Ұ�������������±�
	 */
	private static void merge(int[] a, int[] tempArray, int leftPos, int rightPos, int rightEnd) {
		int leftEnd = rightPos - 1;
		int tempPos = leftPos;
		int num = rightEnd - leftPos + 1;
		
		//��ѭ��
		while(leftPos <= leftEnd && rightPos <= rightEnd){
			if(a[leftPos] <= a[rightPos]){
				tempArray[tempPos++] = a[leftPos++];
			}else{
				tempArray[tempPos++] = a[rightPos++];
			}
		}
		/*�ȽϽ�����ֻ����һ��������Ԫ��δ��ȫ���ϲ�*/
		while(leftPos <= leftEnd){        //�������������ʣ���Ԫ��
			tempArray[tempPos++]  = a[leftPos++];
		}
		while(rightPos <= rightEnd){      //�����Ұ�������ʣ���Ԫ��
			tempArray[tempPos++]  = a[rightPos++];
		}
		
		//��Ԫ�ش���ʱ���鸳ֵ��ԭ����
		for(int i = 0; i < num; i++, rightEnd--){
			a[rightEnd] = tempArray[rightEnd];
		}
		
	}

}
