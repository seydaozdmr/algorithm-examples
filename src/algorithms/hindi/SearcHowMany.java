package algorithms.hindi;

import java.util.Arrays;

public class SearcHowMany {
	//önce arama yapacağımız geçici dizimizi boş olarak oluşturuyoruz.
	private int[] a;
	
	public SearcHowMany(int []keys) {
		a=new int[keys.length];
		//keys dizisini a'ya kopyalıyoruz.
		for(int i=0;i<keys.length;i++) {
			a[i]=keys[i];
		}
		//kopyaladığımız a dizisini sıralıyoruz.
		Arrays.sort(a);
	}
	//Bu metot ile item değerinin dizi içerisinde olup olmadığını arıyoruz.
	public boolean contains(int item) {
		return rank(item)!= -1;
	}
	
	 private int rank(int key) {
	        //Binary search
	        int low = 0;
	        int high = a.length - 1;

	        while(low <= high) {
	            //Key is in a[low..high] or not present
	            int mid = low + (high - low) / 2;

	            if (key < a[mid]) {
	                high = mid - 1;
	            } else if (key > a[mid]) {
	                low = mid + 1;
	            } else {
	                return mid;
	            }
	        }

	        return -1;
	    }
	
	
	 private int recursiveRank(int key, int low, int high) {
	        int middle = low + (high - low) / 2;

	        if (low > high) {
	            return -1;
	        }

	        if (a[middle] > key) {
	            return recursiveRank(key, low, middle - 1);
	        } else if (a[middle] < key) {
	            return recursiveRank(key, middle + 1, high);
	        } else {
	            return middle;
	        }
	    }
	
	private int howMany(int item) {
		//indexFromRank arama algoritmasında bulunan index'i tutuyor
		int indexFromRank=rank(item);
		//eğer hiç bir şey bulunmamışsa 0 olarak geri döndürecek
		if(indexFromRank==-1) {
			return 0;
		}
		//aranan değerden kaç tane olduğunu tutan sayı
		int count;
		//aranan değerden bulunan ilk index
		int previousIndex = indexFromRank;
        int currentPreviousIndex = previousIndex;
		//aranan değerden bulunan son index
        int nextIndex = indexFromRank;
        int currentNextIndex = nextIndex;
		
		//bulunan elemanın en küçük indexini bulmak için
		while(currentPreviousIndex!= -1) {
			currentPreviousIndex=recursiveRank(item,0,currentPreviousIndex-1);
			
			if(currentPreviousIndex != -1) {
				previousIndex=currentPreviousIndex;
			}
		}
		
		//bulunan elamanın en büyük indexini bulmak için
		
		while(currentNextIndex != -1) {
			currentNextIndex=recursiveRank(item,currentNextIndex+1,a.length-1);
			
			if(currentNextIndex!= -1) {
				nextIndex=currentNextIndex;
			}
		}
		
		count=nextIndex-previousIndex+1;
		
		//O(n) -> Doğrusal arama için: Not: Büyük boyutlu dizilerde aramak zaman kaybına neden olur.
        //count would have been initialized to 1
//        while(previousIndex - 1 >= 0 && a[previousIndex - 1] == key) {
//            count++;
//            previousIndex--;
//        }
//
//        while(nextIndex + 1 < a.length && a[nextIndex + 1] == key) {
//            count++;
//            nextIndex++;
//        }
		return count;
		
	}

	public static void main(String[] args) {
		int[] array = {2, 4, 8, 16, 16, 16, 32, 64, 128, 128};
		SearcHowMany arama=new SearcHowMany(array);
		
		System.out.println(arama.howMany(128));
		System.out.println(arama.contains(128));

	}

}
