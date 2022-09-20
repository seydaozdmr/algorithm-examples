package org.seydaozdemir;

public class StringArrayTest {

	public static void main(String[] args) {
		String [] stringArray= {"ali","veli","mehmet","hüseyin","ömer"};
		
		for(String a:stringArray) {
			System.out.println(a);
		}
		for(int i=0;i<stringArray.length;i++) {
			System.out.println(stringArray[i]);
		}
		String[]names= {"John","Steve","Pooja","Rahul"};
		StringArrayTest app=new StringArrayTest();
		app.isimleriGoster(names);

	}
	void isimleriGoster(String[]names) {
		for(String name:names) {
			System.out.println(name);
		}
	}

}
