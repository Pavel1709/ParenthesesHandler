/*
Программа для проверки корректности парности скобок
 */
package javaapplication125;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pavel1709
 */
public class ParenthesesHandler {
    
    static String s;
    static String chars[];
    static List<String> elements; 
    static int amount = 0;
    
    public static void main(String[] args) throws IOException {
      s = readWord();
      chars = s.split("");
      elements = Arrays.asList(chars);
      elements.forEach(x -> {
          if (x.equals("[") || x.equals("]") || x.equals("{") || x.equals("}") || x.equals("(") || x.equals(")")) {
              amount++;
          }
      });
      Stack stack = new Stack(amount); 
      while (true) {
      if(elements.get(0).equals("}") || elements.get(0).equals("]") || elements.get(0).equals(")")) {
          System.out.println("Строка некорректна");
          break;
      }
      elements.forEach(x -> {
          if (x.equals("[") || x.equals("(") || x.equals("{") ) {
              stack.push(x);
          }
          if (( (x.equals("}") && stack.peek().equals("{")) 
                  || (x.equals(")") && stack.peek().equals("(")) 
                    || (x.equals("]") && stack.peek().equals("[")) ) ) {
             
              try {
                  stack.pop();
              } catch (PopFromEmptyStackException ex) {
                  System.out.println("Строка некорректна");
                  
              }
          }
      });
      if (stack.isEmpty()) {
          System.out.println("Строка корректна");
          break;
      }
      else {
          System.out.println("Строка некорректна");
          break;
      }
      }
    }
    public static String readWord() throws IOException {
        InputStreamReader stream = new InputStreamReader(System.in);
        BufferedReader reader= new BufferedReader(stream);
        String s = reader.readLine();
        return s;
    }
    
}
class Stack {
    String elements[];
    int maxSize;
    int top;
    Stack(int size){
        elements = new String[size];
        maxSize = size;
        top = -1;
    }
    public void push(String element) {
        elements[++top] = element;
    } 
    public String pop() throws PopFromEmptyStackException {
        if (top >= 0) {
            return elements[top--];
        }
        else {
            throw new PopFromEmptyStackException();
        }
    }
    public String peek() {
        return elements[top];
    }
    public boolean isEmpty() {
        return (top == -1);
    }
}