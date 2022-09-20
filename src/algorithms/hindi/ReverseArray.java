package algorithms.hindi;

public class ReverseArray {
	public static void reverse(int[]array,int start,int last) {
		while(start<last) {
			int temp=array[start];
			array[start]=array[last];
			array[last]=temp;
			start++;
			last--;
		}
	}

	public static void main(String[] args) {
		int [] dizi=new int[10];
		for(int i=0;i<10;i++) {
			dizi[i]=i*i;
		}
		reverse(dizi,0,dizi.length-1);
		for(int i:dizi) {
			System.out.println(i);
		}

	}

}
