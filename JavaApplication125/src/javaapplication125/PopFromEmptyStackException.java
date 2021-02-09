/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication125;

/**
 *
 * @author pavel1709
 */
public class PopFromEmptyStackException extends Exception {
   PopFromEmptyStackException() {
       System.out.println("Вы не можете удалить элемент из пустого стэка");
   }
    
}
