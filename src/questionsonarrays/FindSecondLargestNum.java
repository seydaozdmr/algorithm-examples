package questionsonarrays;

public class FindSecondLargestNum {
	public static void findSecond(int [] arr) {
		if(arr.length<2) {
			System.out.println("İkinci büyük eleman yoktur.");
			return;
		}
		
		int largest=Integer.MIN_VALUE;
		int secondLargest=Integer.MIN_VALUE;
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>largest) {
				secondLargest=largest;
				largest=arr[i];
			}
			
			if(arr[i]!=largest && arr[i]>secondLargest) {
				secondLargest=arr[i];
			}
		}
		
		if(secondLargest== Integer.MIN_VALUE) {
			System.out.println("İkinci büyük eleman bulunamadı");
		}
		else{
			System.out.println("dizideki en büyük ikinci eleman: "+secondLargest);
		}
	}

	public static void main(String[] args) {
		int[] arr= {1,2,3,4,88,3,3,444};
		findSecond(arr);

	}

}
