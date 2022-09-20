package org.com.algo.java;

public class FindSecondSmallest {
	public static int findSecendSmallest(int []arr) {
		int smallest=Integer.MAX_VALUE;
		int secondSmallest=Integer.MAX_VALUE;
		
		for(int i=0;i<arr.length;i++) { 
			//bütün diziyi geziyoruz ve en küçüğü bulmaya çalışıyoruz.
			if(arr[i]<smallest) {
				//ikinci en küçük en küçüğün taşıdığı değeri alıyor
				secondSmallest=smallest;
				//en küçük ise karşılaşılan yeni en küçüğü alıyor.
				smallest=arr[i];
				System.out.println("smallest: "+smallest);
			}
			//eğer karşılaşılan değer en küçükten büyükse ve karşılaşılan değer ikinci en küçükten küçükse yeni ikinci en küçük karşılaşılan değer oluyor.
			if(arr[i]>smallest && arr[i]<secondSmallest) {
				secondSmallest=arr[i];
				System.out.println("second: "+secondSmallest);
			}
		}
		return secondSmallest;
	}
	

	public static void main(String[] args) {
		int[]arr= {5,4,6,1,3,2};
		
		System.out.println(findSecendSmallest(arr));

	}

}
