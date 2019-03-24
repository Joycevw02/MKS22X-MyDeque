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
    if (initialCapacity < 0){
      throw new IllegalArgumentException();
    }
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
    String ans = "{";
    if (size == 0){
      return "{}";
    }
    //If start is less than end, run through data and add the values to ans
    else if (start <= end){
      for (int i = start; i <= end; i ++){
        ans = ans + data[i] + " ";
      }
    }
    //If not, run through the data from start through the rest of the data, then
    //go back from the zeroth index to end index
    else{
      for (int i = start; i < size; i ++){
        ans = ans + data[i] + " ";
      }
      for (int i = 0; i < end; i ++){
        ans = ans + data[i] + " ";
      }
    }
    //Remove the extra comma and add the closing bracket
    ans = ans.substring(0, ans.length() - 1) + "}";
    return ans;
  }

  @SuppressWarnings("unchecked")
  public void addFirst(E element){
    //If the added element is null, throw an excepti
    if (element == null){
      throw new NullPointerException();
    }

    //If size is equal to the length of data, resize the array
    if (size == data.length){
      resize();
    }

    //If size isn't zero.....
    if (size != 0){
      //If start is zero, set start to the last index
      if (start == 0){
        start = data.length - 1;
      }
      //Else, decrease start
      else{
        start --;
      }
    }

    //Set the value at start to the element and increase the size
    data[start] = element;
    size ++;
  }

  public void addLast(E element){
    if (element == null){
      throw new NullPointerException();
    }
    //Resize if the array is full
    if (data.length == size){
      resize();
    }
    //Set the next value to element and increase size and end
    data[size] = element;
    size ++;
    end ++;
  }

  public E removeFirst(){
    if (this.size() == 0){
      throw new NoSuchElementException();
    }
    //E ans is the returned element
    E ans = data[start];
    //Shifts start over one
    start ++;
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
    end --;
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

  @SuppressWarnings("unchecked")
  private void resize(){
    //Eveytime you resize, double the size of the array
    E[] temp = (E[]) new Object[(data.length * 2) + 1];
    int Ei = 0; //Index in temp

    //Loop through the array...
    for (int i = start; i < data.length; i ++){
      //If start is greater than end, set the temp value to the data value
      if (start > end){
        temp[Ei] = data[i];
        Ei ++;
      }
      //If start and i are less than or equal to end, set the temp value to the
      //data value
      else if (start <= end && i <= end){
        temp[Ei] = data[i];
        Ei ++;
      }
    }

    //If start is still greater than end, loop through the array from zero to
    //the end and set the value at temp to the value at data
    if (start > end){
      for (int i = 0; i <=end; i ++){
        temp[Ei] = data[i];
        Ei ++;
      }
    }

    //Set data to temp, start to 0, and end to size - 1
    data = temp;
    start = 0;
    end = size - 1;
  }
}
