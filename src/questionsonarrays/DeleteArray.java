package questionsonarrays;

public class DeleteArray {
	public static int[] delete(int []arr,int key) {
		if(key<0 || key>arr.length) {
			return null;
		}else {
			int [] temp=new int[arr.length-1];
			for(int i=key-1;i<arr.length-1;i++) {
				arr[i]=arr[i+1];
			}
			for(int i=0;i<temp.length;i++) {
				temp[i]=arr[i];
			}
			
			
			return temp;
		}
	}

	public static void main(String[] args) {
		int [] arr= {1,2,3,4,5,6,7,8};
		arr=delete(arr,9);
		for(int i:arr) {
			System.out.print(i+"-> ");
		}

	}

}
