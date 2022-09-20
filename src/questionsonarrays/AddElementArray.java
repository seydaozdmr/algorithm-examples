package questionsonarrays;

public class AddElementArray {

	public static void main(String[] args) {
		int arr[] =new int[20];
		for(int i=0;i<10;i++) {
			arr[i]=i;
		}
		
		int a=99;
		int pos=2;
		for(int i=arr.length-1;i>pos;i--) {
			arr[i]=arr[i-1];
		}
		arr[pos]=a;
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
}
