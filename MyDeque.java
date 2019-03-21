public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  public MyDeque(){

  }

  public MyDeque(int initialCapacity){
    //Set size to the initial capacity and since data is currently empty, start
    //and end are both zero
    size = initialCapacity;
    start = 0;
    end = 0;
  }

  //Return size
  public int size(){
    return size;
  }

  public String toString(){
    String ans = "[";
    //If start is less than end, run through data and add the values to ans
    if (start < end){
      for (int i = start; i < end; i ++){
        ans = ans + data[i] + ",";
      }
    }
    //If not, run through the data from start through the rest of the data, then
    //go back from the zeroth index to end index
    else{
      for (int i = start; i < size; i ++){
        ans = ans + data[i] + ",";
      }
      for (int i = 0; i < end; i ++){
        ans = ans + data[i] + ",";
      }
    }
    //Remove the extra comma and add the closing bracket
    ans = ans.substring(0,size - 1) + "]";
    return ans;
  }

  public void addFirst(E element){

  }

  public void addLast(E element){

  }

  public E removeFirst(){

  }

  public E removeLast(){

  }

  public E getFirst(){

  }

  public E getLast(){

  }
}
