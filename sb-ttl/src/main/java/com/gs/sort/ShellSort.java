package com.gs.sort;
/**
 * @author LIn
 * �㷨���ƣ�ϣ������
 * �㷨����:
 * 1.ϣ������(Shell Sort)�ǲ��������һ�֡�Ҳ����С����������ֱ�Ӳ��������㷨��һ�ָ���Ч�ĸĽ��汾��
 * �㷨������
 * 1.ϣ�������ǰѼ�¼���±��һ���������飬��ÿ��ʹ��ֱ�Ӳ��������㷨����
 * 2.���������𽥼��٣�ÿ������Ĺؼ���Խ��Խ�ֱ࣬����������1��
 * 
 * ���Ӷȷ�����
 * 1.ƽ��ʱ�临�Ӷȣ�O(nlogn)
 * 2.�ռ临�Ӷȣ�O(1)(��ʱ���ݽ����ռ�)
 */
public class ShellSort {
	
	public static void ShellSort(int[] a){
		int gap, i, j;
		for(gap = a.length / 2; gap > 0; gap /= 2){
			for(i = gap; i < a.length; i++){
				int temp = a[i];
				for(j = i; j >= gap && temp < a[j - gap]; j -= gap){
					a[j] = a[j - gap];
				}
				a[j] = temp;
			}
		}
	}

}
