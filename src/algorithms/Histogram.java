package algorithms;

public class Histogram {
	public static int [] his(int a[],int m){
		int []newArr=new int[m];
		
		for(int i=0;i<a.length;i++) {
			if(a[i]<m) {
				System.out.println("a[i].eleman: "+a[i]);
				//Eğer a[i]. eleman değeri m değerinden küçükse newArr[i]. elemanının değerini bir arttır.
				newArr[a[i]]++;
			}
		}
		return newArr;
		
	}
	public static void main(String[] args) {
		int[] a = {0,1, 2, 3, 4,5,6,7,1,4,5};
		
		int[] newArr = his(a, 5);
		//a dizisinde 5'den küçük kaç eleman vardır.
		System.out.println("0 1 2 3 4");
		System.out.println();
		for(int i=0;i<newArr.length;i++) {
			
			System.out.print(newArr[i]+" ");
		}
		

	}

}
