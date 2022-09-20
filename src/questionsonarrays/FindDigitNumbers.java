package questionsonarrays;
//bir dizideki sayılardan eleman değerlerinin toplamı 6 olan sayıların bulunması
public class FindDigitNumbers {
	public static int findDigit(int num) {
		int sum=0;
		while(num>0) {
			int digit=num%10;
			sum+=digit;
			num=num/10;
		}
		return sum;
	}

	public static void main(String[] args) {
		  int[] arr = {123,51,33,678,67};
		  int digitSum = 6;
		  
		  for(int i=0;i<arr.length;i++) {
			  
			  int sum=findDigit(arr[i]);
			  if(sum==digitSum) {
				  System.out.println(arr[i]);
			  }
			  
		  }

	}

}
