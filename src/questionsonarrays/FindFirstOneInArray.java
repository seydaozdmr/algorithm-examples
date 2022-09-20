package questionsonarrays;

import algorithms.StdOut;

public class FindFirstOneInArray {
	
	private static int findFloorInLgN(int[] floors) {
		int low=0;
		int high=floors.length-1;
		
		return findFloorInLgN(floors,low,high);
	}

	private static int findFloorInLgN(int[] floors, int low, int high) {
		int key=1;
		
		if(low<=high) {
			int mid=low+(high-low)/2;
			//şu an ki index'i yazdır:		
			StdOut.println("Debug - current index: " + mid);
			//aranan 1 değeri orta noktadan büyük ise yani 0'ların olduğu bölümde isek:
			if(key>floors[mid]) {
				return findFloorInLgN(floors,mid+1,high);
			}else {
				//eğer orta nokta 1'lerin olduğu bir bölüme denkgelmişse daha düşük indexlerde 1 var mı onu aramamız gerekiyor
				int lowerFloor=findFloorInLgN(floors,low,mid-1);
				//eğer lowerFloor'un aramaları sonrasında en son bir sayı bulamamış isek en son bulunan orta değeri döndürür.
				if(lowerFloor==-1) {
					return mid;
				}else {
					//değilse lowerFloor'un son değerini döndürür.
					return lowerFloor;
				}
			}
			
		}
		return -1;
	}
	
	

	public static void main(String[] args) {
		int[] floors = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1};
		System.out.println(findFloorInLgN(floors));
		

	}

}
