import java.util.*;
import java.io.*;
public class Calculator{
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
//    public static double eval(String s){
//    }

    public static void main(String[] args){
      String test = "1 23 4 56 7 + * - -";
      Queue<String> testQ = new LinkedList<>();
      String temp = "";
      for (int i = 0; i < test.length(); i ++){
        if (test.charAt(i) != ' '){
          temp += test.substring(i, i + 1);
        }
        else{
          testQ.add(temp);
          temp = "";
        }
      }
      System.out.println(testQ);
    }
}
