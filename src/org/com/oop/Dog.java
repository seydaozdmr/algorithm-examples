package org.com.oop;
//inheriting Animal Class
public class Dog extends Animal {
	private int eyes;
	private int legs;
	private int tail;
	private int teeth;
	private String coat;
	//brain ve body parametrelerini silip kendimiz değer verebiliriz.
	//orjinal:String name, int brain, int body, int size, int weight
	public Dog(String name, int size, int weight,int eyes,int legs,int tail,int teeth,String coat) {
		super(name, 1, 1, size, weight);
		this.eyes=eyes;
		this.legs=legs;
		this.tail=tail;
		this.teeth=teeth;
		this.coat=coat;
	}
	
	//yukarıdaki Constructor'ı çağırıp yalnızca istediğimiz alanların girildiği diğerlerini default belirlendiği bir constructor.
	public Dog(String name,int size,int weight,String coat) {
		this(name, size, weight, 2, 4, 1, 14, coat);

	}
	private void chew() {
		System.out.println("Dog.chew() called");
	}
	@Override
	public void eat() {
		System.out.println("Dog.eat() called");
		chew();
		super.eat();
	}
	
	public void walk() {
		System.out.println("Dog.walk() called.");
		//eğer super.move dersek kendi sınıfımızda move metodunu override etsek bile Animal (base class) sınıfındaki move metodunu çağırır.
		super.move(5);
	}
	
	public void run() {
		System.out.println("Dog.run() called.");
		//ilk başta move metodunu override etmeden çalıştıracağım.
		//bu durumda base classtaki move metodunu çağırır.
		move(10);
	}
	//şimdi move metodunu override edeceğim.
	//move metodu içerisinde çağırılması için moveLegs() metodunu oluşturuyorum.
	public void moveLegs(int speed) {
		System.out.println("Dog.moveLegs() called.. speed at: "+speed);
	}
	@Override
	public void move(int speed) {
		System.out.println("Dog.move() called.");
		moveLegs(speed);
		//burada super kullanmazsak metot override yaparken aynı isimli olduğu için recursive olur ve sonsuz olarak çalışır
		//ya da bilgisayarın rami tamamen kullanılana kadar.
		super.move(speed);
	}
	
	
	
	
	
	
	
	
	
	

}
