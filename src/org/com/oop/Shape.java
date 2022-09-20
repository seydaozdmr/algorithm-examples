package org.com.oop;

class Shape {
	private int x;
	private int y;
	
	public Shape(int x,int y){
		this.x=x;
		this.y=y;
	}
}

class Rectangle2 extends Shape{
	private int width;
	private int height;
	
	public Rectangle2(int x,int y) {
		this(x,y,0,0);
	}
	//aşağıdaki constructor yukarıdaki Shape sınıfının özellikleri instance(ilkleyen) main constructor'dur
	// yukarıda oluşturulan constructor alttaki constructor'un özellikleri kullanır ve buna bağlı olarak çalışır.
	public Rectangle2(int x, int y,int width,int height) {
		super(x, y);
		this.height=height;
		this.width=width;
		// TODO Auto-generated constructor stub
	}
	
}
