package questionsonarrays;

public class FindPairsGivenSum {

	public static void main(String[] args) {
		int [] arr= {1,2,3,4,5,6,7};
		int key=9;
		int lo=0;
		int hi=arr.length-1;
		
		
			while(lo<hi) {
				if(arr[lo]+arr[hi]>key) {
					hi--;
				}else if(arr[lo]+arr[hi]<key) {
					lo++;
				}else if(arr[lo]+arr[hi]==key) {
					System.out.println("hi: "+arr[hi]+" lo: "+arr[lo]);
					lo++;
					hi--;
				}
			}
		

	}

}
