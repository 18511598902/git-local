package com.gs.sort;
/**
 * @author LIn
 * �㷨���ƣ���������
 * �㷨�������䳤�ַ����Ļ�������ʹ��ArrayList
 * Ч������ͬ�ֵ�����������
 * 
 * ���Ӷȷ�����
 * 1.ƽ��ʱ�临�Ӷȣ�O(p(n+r)),����p������/λ����n�Ǵ���Ԫ�ظ�����r�ǻ���/Ͱ�ĸ���
 * 2.�ռ临�Ӷȣ�O(n+r*p)(��ʱ���ݽ����ռ估Ͱ�Ŀռ�)
 */
import java.util.ArrayList;

public class RadixSort {
	
	public static void RadixSort(String[] a, int maxLen){
		final int BUCKETS = 256;
		
		ArrayList<String>[] wordsByLength = new ArrayList[maxLen + 1];
		ArrayList<String>[] buckets = new ArrayList[BUCKETS];
		
		//��ʼ�������б�
		for(int i = 0; i < wordsByLength.length; i++){
			wordsByLength[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < BUCKETS; i++){
			buckets[i] = new ArrayList<>();
		}
		//�����ַ������ȼ����Ӧ��Ͱ��
		for(String s:a){
			wordsByLength[s.length()].add(s);
		}
		//��Ͱ��Ԫ�ؼ�����������
		int idx = 0;
		for(ArrayList<String> wordList:wordsByLength){
			for(String s:wordList){
				a[idx++] = s;
			}
		}
		/*�����ַ������ȴӴ�С�鿴posλ���ϵ��ַ�������buckets��������������*/
		int startingIndex = a.length;
		for(int pos = maxLen - 1; pos >= 0; pos --){
			startingIndex -= wordsByLength[pos + 1].size();
			
			for(int i = startingIndex; i < a.length; i++){
				buckets[a[i].charAt(pos)].add(a[i]);
			}
			
			idx = startingIndex;
			for(ArrayList<String> thisBucket:buckets){
				for(String s:thisBucket){
					a[idx++] = s;
				}
				thisBucket.clear();
			}
		}
	}

}
