package algorithms.datastructures;

import java.util.Iterator;
import java.util.StringJoiner;

import algorithms.StdOut;

public class QueueCift<Item> implements Iterable<Item> {
	//Item tipinde generic dizi oluşturuyoruz, size dizinin boyutu, first ilk eleman, last son eleman
	private Item[] array;
    private int size;
    private int first;
    private int last;

    @SuppressWarnings("unchecked")
    public QueueCift() {
    	//Nesne yaratırken dizimizi bir elemanlı olarak oluşturuyoruz.
        array = (Item[]) new Object[1];
        size = 0;
        first = -1;
        last = -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void pushLeft(Item item) {
    	//Sola ekleme işlemi sırasında eğer dizinin size dizinin boyutuna kadar büyümüş ise dizinin boyutunu iki katına çıkarıyoruz.
        if (size == array.length) {
            resize(size * 2);
        }
        //eğer ilk eleman 0 ise elemanları sağa taşıyoruz.
        if (first == 0) {
            moveArrayRight();
        }
        //eğer dizimiz boş ise ilk eleman first değerine yani 0 değerine eklenir.
        if (isEmpty()) {
            first = 0;
            last = 0;
            array[first] = item;
        } else {
        	//değilse eleman first'in bir eksik sırasına eklenir böylece eklenen her eleman en başa eklenir.
            array[first - 1] = item;
            //ilk değeri bir azaltılır.
            first = first - 1;
        }
        //size yani eleman sayısı değeri bir arttılır.
        size++;
    }

    public void pushRight(Item item) {
        if (size == array.length) {
            resize(size * 2);
        }
        //eğer sona gelmişsek elemanlar sola kaydırılır.
        if (last == array.length - 1) {
            moveArrayLeft();
        }

        if (isEmpty()) {
            first = 0;
            last = 0;
            array[last] = item;
        } else {
        	//eğer dizi boş değilse eleman son elemanın bir sonrası sıraya eklenir ve son değeri bir arttırılır.
            array[last + 1] = item;
            last = last + 1;
        }

        size++;
    }
    
    public Item popLeft() {
        if (isEmpty()) {
            throw new RuntimeException("Deque underflow");
        }
        //ilk değer item değerine atanır ve array[first] silinir.
        Item item = array[first];
        array[first] = null; //avoid loitering

        size--;

        if (isEmpty()) {
            first = -1;
            last = -1;
        } else {
        	//ilk değeri tutan first değeri bir ilerletilir.
            first = first + 1;
        }

        if (size == array.length / 4) {
            resize(array.length / 2);
        }

        return item;
    }

    public Item popRight() {
        if (isEmpty()) {
            throw new RuntimeException("Deque underflow");
        }
        //son değer item değerine atanır ve last değeri silinir.
        Item item = array[last];
        array[last] = null; //avoid loitering

        size--;

        if (isEmpty()) {
        	//eğer dizi boş ise first ve last başlangıçtaki -1 değerlerien dönerler.
            first = -1;
            last = -1;
        } else {
        	//son değeri tutan last değeri bir azaltılır.
            last = last - 1;
        }

        if (size == array.length / 4) {
            resize(array.length / 2);
        }

        return item;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newSize) {
        Item[] newArray = (Item[]) new Object[newSize];

        int j = 0;
        for(int i = first; i <= last; i++) {
            newArray[j] = array[i];
            j++;
        }

        first = 0;
        last = size-1;

        array = newArray;
    }

    private void moveArrayRight() {
    	//bütün elemanlar birer sıra sağa kaydırılır.
        for (int i = last; i >= first; i--) {
            array[i + 1] = array[i];
        }
        first++;
        last++;
    }
    //bütün elemanlar birer sıra sola kaydırılır.
    private void moveArrayLeft() {
        for (int i = first; i <= last; i++) {
            array[i - 1] = array[i];
        }
        first--;
        last--;
    }

    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {

        int index = first;

        @Override
        public boolean hasNext() {
            return index <= last;
        }

        @Override
        public Item next() {
            Item item = array[index];
            index++;
            return item;
        }
    }


    public static void main(String[] args) {
        QueueCift<String> deque = new QueueCift<>();

        deque.testPushLeft();
        deque.testPushRight();
        deque.testPopLeft();
        deque.testPopRight();
    }

    private void testPushLeft() {
        StdOut.println("Test Push Left");
        StdOut.println("Eklenen her yeni eleman başa eklenecektir.");
        QueueCift<String> deque = new QueueCift<>();
        deque.pushLeft("a");
        deque.pushLeft("b");
        deque.pushLeft("c");
        deque.pushLeft("d");
        deque.pushLeft("e");
        deque.pushLeft("f");
        
        StringJoiner dequeItems = new StringJoiner(" ");
        for (String item : deque) {
            dequeItems.add(item);
        }

        StdOut.println("Deque items: " + dequeItems.toString());
        StdOut.println("Expected: c b a");
    }

    private void testPushRight() {
        StdOut.println("\nTest Push Right");
        StdOut.println("Eklenen her yeni eleman sona eklenecektir.");
        QueueCift<String> deque = new QueueCift<>();
        deque.pushRight("a");
        deque.pushRight("b");
        deque.pushRight("c");
        deque.pushRight("d");
        deque.pushRight("e");
        deque.pushRight("f");
        StringJoiner dequeItems = new StringJoiner(" ");
        for (String item : deque) {
            dequeItems.add(item);
        }

        StdOut.println("Deque items: " + dequeItems.toString());
        StdOut.println("Expected: a b c");
    }

    private void testPopLeft() {
        StdOut.println("\nTest Pop Left");

        QueueCift<String> deque = new QueueCift<>();
        deque.pushRight("a");
        deque.pushRight("b");
        deque.pushRight("c");

        deque.popLeft();
        deque.popLeft();

        StringJoiner dequeItems = new StringJoiner(" ");
        for (String item : deque) {
            dequeItems.add(item);
        }

        StdOut.println("Deque items: " + dequeItems.toString());
        StdOut.println("Expected: c");
    }

    private void testPopRight() {
        StdOut.println("\nTest Pop Right");

        QueueCift<String> deque = new QueueCift<>();
        deque.pushRight("a");
        deque.pushRight("b");
        deque.pushRight("c");

        deque.popRight();
        deque.popRight();

        StringJoiner dequeItems = new StringJoiner(" ");
        for (String item : deque) {
            dequeItems.add(item);
        }

        StdOut.println("Deque items: " + dequeItems.toString());
        StdOut.println("Expected: a");
    }
	

}
