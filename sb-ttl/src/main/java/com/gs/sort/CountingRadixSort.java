package com.gs.sort;
/**
 * @author LIn
 * �㷨���ƣ�������������
 * �㷨�������䳤�ַ����Ļ�������ʹ��in��out����
 * Ч������ͬ�ֵ�����������
 * 
 * ���Ӷȷ�����
 * 1.ƽ��ʱ�临�Ӷȣ�
 * 2.�ռ临�Ӷȣ�
 */
public class CountingRadixSort {
	
	public static void CountingRadixSort(String[] a, int stringLen){
		final int BUCKETS = 256;
		
		int n = a.length;
		String[] buffer = new String[n];
		
		String[] in = a;
		String[] out = buffer;
		
		for(int pos = stringLen - 1; pos >= 0; pos--){
			int[] count = new int[BUCKETS + 1];
			
			for(int i = 0; i < n; i++){
				count[in[i].charAt(pos) + 1]++;
			}
			
			for(int b = 1; b <= BUCKETS; b++){
				count[b] += count[b - 1];
			}
			
			for(int i = 0; i < n; i++){
				out[ count[ in[i].charAt(pos) ]++ ] = in[i];
			}
			
			//��in��out����
			String[] temp = in;
			in = out;
			out = temp;
		}
		
		/*  ���ַ�����ĳ�����ż����out������õ���a���������
		 *  ���ַ�����ĳ�������������Ҫ��in������out
		 * */
		if(stringLen % 2 == 1){
			for(int i = 0; i < a.length; i++){
				out[i] = in[i];
			}
		}
	}
}
