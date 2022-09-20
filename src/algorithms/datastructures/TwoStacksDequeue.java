package algorithms.datastructures;

import java.util.Iterator;

import algorithms.StdOut;

public class TwoStacksDequeue<Item> implements Iterable<Item> {
	//Daha önce yaptığımız çift sonlu kuyruk, kuyruğun her iki tarafından da ekleme silme işlemlerinin gerçekleştirilebildiği, sınıfımızdan bir nesne oluşturuyoruz.
	private QueueCift<Item> deque;
	private int stack1Size;
	private int stack2Size;
	
	public TwoStacksDequeue() {
		deque=new QueueCift<>();
	}
	
	public boolean isStack1Empty() {
		return stack1Size == 0;
	}

	public boolean isStack2Empty() {
		return stack2Size == 0;
	}

	public int stack1Size() {
		return stack1Size;
	}

	public int stack2Size() {
		return stack2Size;
	}
	
	public void pushStack1(Item item) {
		deque.pushLeft(item);
		stack1Size++;
	}
	
	public void pushStack2(Item item) {
		deque.pushRight(item);
		stack2Size++;
	}

	public Item popStack1() {
		if (isStack1Empty()) {
			throw new RuntimeException("Stack 1 underflow");
		}

		stack1Size--;
		return deque.popLeft();
	}

	public Item popStack2() {
		if (isStack2Empty()) {
			throw new RuntimeException("Stack 2 underflow");
		}

		stack2Size--;
		return deque.popRight();
	}
	
	@Override
	public Iterator<Item> iterator() {
		return new TwoStacksDequeIterator();
	}
	@SuppressWarnings("unchecked")
	 private class TwoStacksDequeIterator implements Iterator<Item> {
		//Item tipinde items dizisi oluşturuluyor.
		private int index;
		private Item[] items;
		private boolean hasNext;
		
		
		private TwoStacksDequeIterator() {
			//item dizisinin boyutu deque kuyruğunun boyutu kadar ayarlanıyor.
			items=(Item[]) new Object[deque.size()];
			//currentIndex 0 olarak ayarlanıyor.
			int currentIndex=0;
			hasNext=true;
			//deque içersindeki düğümler items dizisine ekleniyor.
			for(Item item:deque) {
				items[currentIndex++]=item;
			}
			//stack1 boş ise ve stack2 boş değilse index değeri deque kuyruğunun boyutunun 1 eksiği oluyor.
			if(isStack1Empty() && !isStack2Empty()) {
				index=deque.size()-1;
			}
		}
		
		@Override
		public boolean hasNext() {
			return hasNext;
		}
		
		@Override
		public Item next() {
			if (index == 0 && stack1Size() > 0) {
				StdOut.println("Stack 1");
			}
			if (index == deque.size() - 1 && stack2Size() > 0) {
				StdOut.println("Stack 2");
			}
			Item item = items[index];
			if (isIteratingStack1(index)) {
                if (index != stack1Size - 1) {
                    index++;
                } else if (!isStack2Empty()) {
                    index = deque.size() - 1;
                } else {
                    hasNext = false;
                }
            } else {
                if (index != stack1Size) {
                    index--;
                } else {
                    hasNext = false;
                }
            }

            return item;
		}
		private boolean isIteratingStack1(int index) {
            return index < stack1Size;
        }
		 
	 }
	
	

	public static void main(String[] args) {
		TwoStacksDequeue<String> deque = new TwoStacksDequeue<>();
		
		deque.testPushStack1();
        deque.testPushStack2();
        deque.testPopStack1();
        deque.testPopStack2();
        deque.testMixedOperations();

	}
	
	private void testPushStack1() {
        TwoStacksDequeue<String> deque = new TwoStacksDequeue<>();
        deque.pushStack1("a");
        deque.pushStack1("b");
        deque.pushStack1("c");

        StdOut.println("Test Push on stack 1:");
        for (String item : deque) {
            StdOut.println(item);
        }

        StdOut.println("Expected: c b a");
        StdOut.println();
    }

    private void testPushStack2() {
    	TwoStacksDequeue<String> deque = new TwoStacksDequeue<>();
        deque.pushStack2("a");
        deque.pushStack2("b");
        deque.pushStack2("c");

        StdOut.println("Test Push on stack 2:");
        for (String item : deque) {
            StdOut.println(item);
        }

        StdOut.println("Expected: c b a");
        StdOut.println();
    }

    private void testPopStack1() {
    	TwoStacksDequeue<String> deque = new TwoStacksDequeue<>();
        deque.pushStack1("a");
        deque.pushStack1("b");
        deque.pushStack1("c");

        deque.popStack1();
        deque.popStack1();

        StdOut.println("Test Pop on stack 1:");
        for (String item : deque) {
            StdOut.println(item);
        }

        StdOut.println("Expected: a");
        StdOut.println();
    }

    private void testPopStack2() {
    	TwoStacksDequeue<String> deque = new TwoStacksDequeue<>();
        deque.pushStack2("a");
        deque.pushStack2("b");
        deque.pushStack2("c");

        deque.popStack2();
        deque.popStack2();

        StdOut.println("Test Pop on stack 2:");
        for (String item : deque) {
            StdOut.println(item);
        }

        StdOut.println("Expected: a");
        StdOut.println();
    }

    private void testMixedOperations() {
    	TwoStacksDequeue<String> deque = new TwoStacksDequeue<>();
        deque.pushStack1("rene");
        deque.pushStack2("a");
        deque.pushStack1("stack");
        deque.pushStack2("b");
        deque.pushStack1("deque");
        deque.pushStack2("c");

        StdOut.println("Test stack 1 and stack 2 together:");
        for (String item : deque) {
            StdOut.println(item);
        }

        StdOut.println("Expected: Stack 1 - deque stack rene");
        StdOut.println("Expected: Stack 2 - c b a");

        StdOut.println();
        StdOut.println("Test stack 1 and stack 2 after pop:");

        deque.popStack1();
        deque.popStack2();

        for (String item : deque) {
            StdOut.println(item);
        }

        StdOut.println("Expected: Stack 1 - stack rene");
        StdOut.println("Expected: Stack 2 - b a");
    }

	

}
