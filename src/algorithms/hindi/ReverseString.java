package algorithms.hindi;

public class ReverseString {

	public static void main(String[] args) {
		String name="Merhaba Dünya";
		
		char[] dizi=new char[name.length()];
		int j=0;
		for(int i=name.length()-1;i>=0;i--) {
			//System.out.println(name.charAt(i));
			dizi[j]=name.charAt(i);
			j++;
		}
		
		String reverse="";
		for(int i=0;i<dizi.length;i++) {
			reverse=reverse+dizi[i];
		}
		System.out.println(reverse);
		
		
	}

}
