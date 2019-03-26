import java.util.*;
import java.io.*;
public class Calculator{
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    public static double eval(String s){
      MyDeque<Double> temp = new MyDeque<>();
      String current = "";
      for (int i = 0; i < s.length(); i ++){
        char c = s.charAt(i);
        if (c != ' '){
          if (c != '+' && c != '-' && c != '*' && c != '/' && c != '%'){
            current += c;
            System.out.println("Current : " + current);
          }
          else{
            double x = temp.removeLast();
            double y = temp.removeLast();
            if (c == '+'){
              System.out.println("Add!");
              temp.addLast(x + y);
              System.out.println("Deque : " + temp);
            }
            else if (c == '-'){
              System.out.println("Subtract!");
              temp.addLast(y - x);
              System.out.println("Deque : " + temp);
            }
            else if (c == '*'){
              System.out.println("Multiply!");
              temp.addLast(x * y);
              System.out.println("Deque : " + temp);
            }
            else if (c == '/'){
              System.out.println("Divide!");
              temp.addLast(y / x);
              System.out.println("Deque : " + temp);
            }
            else if (c == '%'){
              System.out.println("Mod!");
              temp.addLast(y % x);
              System.out.println("Deque : " + temp);
            }
          }
        }
        else if (c == ' '){
          System.out.println("New Int : " + current);
          temp.addLast(Double.valueOf(current));
          current = "";
        }
      }
      return temp.getLast();
    }

    public static void main(String[] args){
      String test = "1 23 4 + -";
      MyDeque<String> testQ = new MyDeque<>();
      String temp = "";
      for (int i = 0; i < test.length(); i ++){
        if (test.charAt(i) != ' '){
          temp += test.substring(i, i + 1);
        }
        else{
          testQ.addLast("Deque : " + temp);
          temp = "";
        }
      }
      //System.out.println(testQ);
      //System.out.println(Double.valueOf("2"));
      eval(test);

    }
}
