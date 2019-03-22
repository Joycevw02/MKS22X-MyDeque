import java.util.*;
import java.io.*;

public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  //Everything is zero
  @SuppressWarnings("unchecked")
  public MyDeque(){
    size = 0;
    start = 0;
    end = 0;
    data = (E[])new Object[10];
  }

  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    //Create a data of size initialCapacity and set the other values to zero
    size = 0;
    start = 0;
    end = 0;
    data = (E[])new Object[initialCapacity];
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
    if (this.size() == 0){
      throw new NoSuchElementException();
    }
    //E ans is the returned element
    E ans = data[start];
    //Shifts start over one
    start += 1;
    size --;
    return ans;
  }

  public E removeLast(){
    if (this.size() == 0){
      throw new NoSuchElementException();
    }
    //E ans is the returned element
    E ans = data[end];
    //Shifts end down one index
    end -= 1;
    size --;
    return ans;
  }

 public E getFirst(){
   if (this.size() == 0){
     throw new NoSuchElementException();
   }
   //Return the value at start
   return data[start];
  }

  public E getLast(){
    if (this.size() == 0){
      throw new NoSuchElementException();
    }
    //Return the value at end
    return data[end];
  }

  private void resize(){

  }
}
