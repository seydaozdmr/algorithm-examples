package questionsonarrays;

import java.util.HashSet;
import java.util.Set;

public class Finddublicates {

	public static void main(String[] args) {
		int [] arr= {1,5,4,2,1,4,5,6,7};
		
		Set<Integer> uniq=new HashSet<>();
		
		boolean isDublicate=false;
		
		for(int i=0;i<arr.length;i++) {
			if(uniq.contains(arr[i])) {
				isDublicate=true;
				System.out.println("Dublicate element" +arr[i]);
			}else {
				uniq.add(arr[i]);
			}
		}
		if(isDublicate==false){
			System.out.println(-1);
		}

	}

}
