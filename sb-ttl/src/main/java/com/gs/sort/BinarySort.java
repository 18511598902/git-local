package com.gs.sort;
/**
 * @author LIn
 * ???????????????(??????????)
 * ????????????????????????????????i-1?????????????
 *        ???????????????????????????????????????
 * ?????????????????????O(nlogn)??????? ???????O(n^2)
 * 
 * ??????????
 * 1.??????????O(n^2)
 * 2.???????O(1)(?????????????)
 */
public class BinarySort {

	public static void BinarySort(int[] a){
		int low,high,mid;
		int temp;
		for(int i = 0; i < a.length; i++){
			temp = a[i];
			low = 0;
			high = i - 1;
			while(low <= high){
				mid = (low + high) / 2;
				if(a[mid] > temp){
					high = mid - 1;
				}else{
					low = mid + 1;
				}
			}
			for(int j = i-1; j > high; j--){
				a[j+1] = a[j];
			}
			a[high+1] = temp;
		}
	}

}
