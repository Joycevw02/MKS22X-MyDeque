public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  //Everything is zero
  @SuppressWarnings("unchecked")
  public MyDeque(){
    size = 0;
    start = 0;
    end = 0;
    data = (E[])new Object[0];
  }

  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    //Set size to the initial capacity and since data is currently empty, start
    //and end are both zero
    size = initialCapacity;
    start = 0;
    end = 0;
    data = (E[])new Object[size];
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
    //E ans is the returned element
    E ans = data[start];
    //Set the value at start to null and shift start over one
    data[start] = null;
    start += 1;
    size --;
    return ans;
  }

  public E removeLast(){
    //E ans is the returned element
    E ans = data[end];
    //Set the value at end to null and shift end down one index
    data[end] = null;
    end -= 1;
    size --;
    return ans;
  }
//
// public E getFirst(){
//
//  }
//
//  public E getLast(){
//
//  }

  public static void main(String[] args){

  }
}
