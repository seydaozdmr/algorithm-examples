package org.com.oop;

public class Main {

	public static void main(String[] args) {
		Car porsche;
		porsche=new Car();
		
		porsche.setModel("Caymen");
		System.out.println(porsche.getModel());
		
		Account seydaAccount=new Account();
		seydaAccount.withdrawFunds(100.0);
		System.out.println("*****Hesap Bilgileri");
		seydaAccount.depositFunds(50.0);
		System.out.println(seydaAccount);
		seydaAccount.withdrawFunds(100.0);
		seydaAccount.depositFunds(51.0);
		seydaAccount.withdrawFunds(101.0);
		
		Animal animal=new Animal("Animal",1,1,5,5);
		Dog dog=new Dog("Yaz",8,20,2,4,1,20,"long silky");
		//dog.eat();
		//dog.walk();
		dog.run();
		Fish fish=new Fish("Nemo",3,1,30,2,1);
		fish.eat();
	}

}
