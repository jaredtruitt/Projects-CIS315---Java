class StackOfIntegers{
	private int[] elements;
	private int size;

	StackOfIntegers(){
	     elements = new int[16];
	}

	StackOfIntegers(int capacity){
	     elements = new int[capacity];
	}

	public boolean empty(){
	     if(size == 0){
		return false;
	     }
	     else{
		return true;
	     }
	}

	public int peek(){
	     while(empty()){
		return elements[size-1];
	     }
	     return -1;
	}

	public void push(int value){
	     if(size >= elements.length){
		System.out.println("Stack Overflow");
	     }
	     else{
		elements[size] = value;
		size = size + 1;
	     }
	}

	public int pop(){
	     while(empty()){
		int value = elements[size -1];
		size = size - 1;
		return value;
	     }
	     return -1;
	}

	public int getSize(){
	     return size;
	}
}

