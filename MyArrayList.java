
public class MyArrayList<T> {

	private int initialCapacity;
	private T[] array; 
	private int arrayEnd = 0;
	
	public MyArrayList(){
		this(10);
	}
	
	public MyArrayList(int initialCapacity){
		this.initialCapacity = initialCapacity;
		this.array = (T[]) new Object[this.initialCapacity];
	}
	
	public int getInitialCapacity(){
		return this.initialCapacity;
	}
	
	public int size(){
		return arrayEnd;
	}
	
	public boolean add(T element){
		this.ensureCapacity();
		this.array[arrayEnd] = element;
		arrayEnd++;
		return true;
	}
	
	public void add(int index, T element) throws IndexOutOfBoundsException{
		if (index < 0 || index > arrayEnd){
			throw new IndexOutOfBoundsException();
		}
		else{
			arrayEnd++;
			this.ensureCapacity();
			for(int i = arrayEnd; i > index; i--){
				this.array[i] = this.array[i-1];
			}
			this.array[index] = element;
			//throw exception for index out of bounds			
		}
	}
	
	
	public void clear(){		
		this.array = (T[]) new Object[this.initialCapacity];
		this.arrayEnd = 0;
	}
	
	public boolean contains(Object o){
		for (int i = 0; i < arrayEnd; i++){
			if (o.equals(this.array[i])){
				return true;
			}
		}
		return false;
	}
	
	public void ensureCapacity(){
		if (this.array.length == arrayEnd ){
			T[] temp = (T[])new Object[this.array.length*2];
			for (int i = 0; i < arrayEnd; i++){
				temp[i] = this.array[i];
			}
			this.array = (T[]) new Object[this.array.length*2];
			this.array = temp;
		}
	}
	
	public T get(int index) throws IndexOutOfBoundsException{
		if (index < 0 || index > arrayEnd - 1){
			throw new IndexOutOfBoundsException();
		}
		else{
			return this.array[index];
		}
		
	}
	
	public int indexOf(Object o){
		for(int i = 0; i < arrayEnd; i++){
			if (o.equals(array[i])){
				return i;
			}
		}
		return -1;
	}
	
	
	
	public boolean isEmpty(){
		if (this.size()==0){	
			return true;
		}
		return false;
	}
	
	public T remove(int index) throws IndexOutOfBoundsException{
		if (index < 0 || index >= arrayEnd){
			throw new IndexOutOfBoundsException();
		}
		T temp = (T)this.array[index];
		int i;
		for (i = index; i < arrayEnd; i++){
			this.array[i] = this.array[i+1];
		}
		this.array[i + 1] = null;
		arrayEnd--;
		
		return temp;
	}
	
	public boolean remove(Object o){
		for(int i = 0; i < arrayEnd; i++){
			if (o.equals(this.array[i])){
				for (i = i; i < arrayEnd; i++){
					this.array[i] = this.array[i+1];
				}
				this.array[i + 1] = null;
				arrayEnd--;
				return true;
			}
		}
		return false;
	}
	
	public T set(int index, T element) throws IndexOutOfBoundsException{
		if (index < 0 || index >= arrayEnd){
			throw new IndexOutOfBoundsException();
		}
		T temp = this.array[index];
		this.array[index] = element;
		return (T) temp;
	}
	
 
	
	
}
	
	
	 
	 
	

