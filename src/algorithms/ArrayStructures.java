package algorithms;
//Bu sayfadaki kodlar:
//Dizi oluşturup bu diziye eleman eklemek,çıkartmak,sıralamak,aramak ve yazdırmak üzerine yazılmıştır.
//İçerisinde elemanBul verilen index numarasındaki elemanı geri döndürür.
//generateArray boş diziye rastgele elamanları eklemek üzerine çalışır.
//
public class ArrayStructures {
	private int [] dizi=new int[50];
	private int diziBoyutu=10;
	
	public void generateArray() {
		for(int i=0;i<diziBoyutu;i++) {
			dizi[i]=(int)(Math.random()*10)+10;
		}
	}
	
	public void printArray() {
		System.out.println("----------");
		for(int i=0;i<diziBoyutu;i++) {
			System.out.print("| "+i+" | ");
			System.out.print(dizi[i]+" |");
		}
		System.out.println("----------");
	}
	
	public int elemanBul(int index) {
		if(index<diziBoyutu) return dizi[index];
		return -1;
	}
	
	public boolean diziicerisindevarmi(int deger) {
		boolean valueinArray=false;
		for(int i=0;i<diziBoyutu;i++) {
			if(dizi[i]==deger) valueinArray=true;
			//return
		}
		
		return valueinArray;
	}
	
	public void elemansil(int index) {
		if(index<diziBoyutu) {
			for(int i=index;i<(diziBoyutu-1);i++) {
				dizi[i]=dizi[i+1];
			}
			diziBoyutu--;
		}
	}
	public void ekle(int deger) {
		if(diziBoyutu<50) {
			dizi[diziBoyutu]=deger;
			diziBoyutu++;
		}
	}
	
	public String ara(int key) {
		boolean degerVar=false;
		
		String indexDegeri="";
		System.out.println("Aranan Değerler Bulundu: ");
		for(int i=0;i<diziBoyutu;i++) {
			if(dizi[i]==key) {
				degerVar=true;
				System.out.println(i+" ");
				indexDegeri+=i+" ";
				
			}
		}
		if(!degerVar) {
			indexDegeri="None";
			System.out.println("Aranan Değer Bulunamadı");
		}
		System.out.println();
		return indexDegeri;
		
	}
	//BubbleSort Algorithms
	public void bubbleSort() {
		for(int i=diziBoyutu-1;i>1;i--) {
			for(int j=0;j<i;j++) {
				//en büyüğü sona taşıyor
				//daha sonra dıştaki döngü 1 azalıyor.
				//ikinci en büyüğü en sonra taşıyor .... bu işlem dıştaki döngü bitene kadar devam ediyor.
				if(dizi[j]>dizi[j+1]) {
					swap(j,j+1);
				}
			}
		}
	}
	//Klasik binary ikili arama algoritması
	public void binarySeach(int key) {
		int lo=0;
		int hi=diziBoyutu-1;
		
		while(lo<=hi) {
			int mid=(hi+lo)/2;
			if(dizi[mid]<key) lo=mid+1;
			else if(dizi[mid]>key) hi=mid-1;
			else {
				System.out.println("\n Aranan eleman "+key+"index numarası: "+mid);
				//Döngüyü bitirmek için lo değerini hi değerinin bir fazlasına eşitliyoruz böylece while döngüsü son buluyor.
				lo=hi+1;
			}
		}
	}
	//Selection Sort
	public void selectionSort() {
		for(int i=0;i<diziBoyutu;i++) {
			int minimum=i;
			for(int j=i;j<diziBoyutu;j++) {
				if(dizi[minimum]>dizi[j]) {
					minimum=j;
				}
				
			}
			//i değeri ile minumum değerlerini yer değiştir.
			swap(i,minimum);
			printArray();
		}
	}

	private void swap(int j, int i) {
		int temp=dizi[j];
		dizi[j]=dizi[i];
		dizi[i]=temp;
		
	}

	public static void main(String[] args) {
		ArrayStructures yenidizi=new ArrayStructures();
		yenidizi.generateArray();
		yenidizi.printArray();
		
		System.out.println(yenidizi.elemanBul(6));
		System.out.println(yenidizi.diziicerisindevarmi(11));
		
		yenidizi.elemansil(4);
		yenidizi.printArray();
		for(int i=0;i<10;i++) {
			yenidizi.ekle(i*i);
		}
		//yenidizi.printArray();
		//yenidizi.ara(17);
		//yenidizi.bubbleSort();
		//yenidizi.printArray();
		//yenidizi.binarySeach(11);
		System.out.println("************************************");
		yenidizi.selectionSort();
		
		
	}

}
