package org.com.oop;

public class Rectangle {
	private int x;
	private int y;
	private int width;
	private int height;
	
	//4 adet parametre alan constructor bütün sınıfın bütün alanları instance yapabiliriz.
	public Rectangle(int x,int y,int width,int height) {
		//initialize variables
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
	}
	
	public Rectangle(int width,int height) {
		//oluşturduğumuz ilk constructor'u çağırabiliriz, width ve height değerlerini kendimiz veririz, x ve y değerleri default olarak
		//0 , 0 olarak belirleriz.
		this(0,0,width,height);
	}
	
	public Rectangle() {
		//bir üstte oluşturduğumuz x ve y'si default olarak 0 olan constructor'u çağırırız ve width ve height değerlerini 0 , 0 olarak ayarlarız.
		
		this(0, 0);
	}
	
	

}
