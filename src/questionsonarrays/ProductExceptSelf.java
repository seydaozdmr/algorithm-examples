package questionsonarrays;

public class ProductExceptSelf {
	//Kendisi dışındaki elemanların çarpımını kendi sırasına koyup böylece bir dizi geri döndüren algoritma
	
	
	public static int[] Product(int[]arr) {
		int len=arr.length;
		int [] temp=new int[len];
		
		int toplamCarpim=1;
		for(int i=0;i<arr.length;i++) {
			//toplam çarpımı bulurum
			toplamCarpim*=arr[i];
		}
		
		for(int i=0;i<temp.length;i++) {
			temp[i]=toplamCarpim/arr[i];
		}
		return temp;
	}
	
	public static int[] findProduct(int[] arr) {
		int len=arr.length;
		int[] left=new int[len];
		int[] right=new int[len];
		int[] ans=new int[len];
		left[0]=1;
		for(int i=1;i<len;i++) {
			left[i]=left[i-1]*arr[i-1];
		}
		
		right[len-1]=1;
		
		for(int i=len-2;i>=0;i--) {
			right[i]=right[i+1]*arr[i+1];
		}
		
		for(int i=0;i<len;i++) {
			ans[i]=left[i]*right[i];
		}
		
		return ans;
		
	}
	public static void main(String[] args) {
		int []arr= {4,2,1,7};
		int[]yeni=Product(arr);
		
		for(int i:yeni) {
			System.out.print(i+" -> ");
		}
		
		int[] yeni2=findProduct(arr);
		for(int i:yeni2) {
			System.out.print(i+" ");
		}

	}

}
