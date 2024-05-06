/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package palindromeproducts;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 * @author jorge
 */
public class PalindromeProducts {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // start of range
        int n1 = 10;
        // end of range
        int n2 = 99;
        // position used to print the products
        int pos = 1;
        // boolean used to print elements
        boolean noFirstElement = false;
        // to save the result of all the products
        HashSet<Integer> products = new HashSet<>();
        // current product
        int product;
        // to save all the products within this range 
        HashMap<Integer, Number> numbers = new HashMap<>();
        
        // first loop - travel from the first element of the range
        for(int i = n1; i <= n2; i++) {

            // second loop - travel from the second element of the range            
            for(int j = n1; j <= n2; j++) {
                
                // generate current product
                product = i * j;
                                                
                // if the current product is not in the set
                if (!products.contains(product)) {
                    
                    if (noFirstElement) 
                        System.out.print(", ");
                    
                    // print product
                    System.out.print("[" + pos + ": " + product + "]");
                    ++pos;
                    // add current product to the set
                    products.add(product);
                    // add product and their multiplicand and multiplier to the hash map
                    numbers.put(product, new Number(product, new Pair(i , j)));
                    // to start to print commas
                    noFirstElement = true;
                    
                } else {
                    // otherwise only add the multiplicand and multiplier for current product to the hash map
                    numbers.get(product).addPair(new Pair(i,j));
                }
               
                
            }
            
        }
        
        
        // calculate minimum and maximum
        products.clear();
        Integer min = null;
        Integer max = null;
        // all the products for min
        LinkedList<Pair> productsMin = new LinkedList<>();
        // all the products for max
        LinkedList<Pair> productsMax = new LinkedList<>();
        // iterator to go through the hash map
        Iterator hmIterator = numbers.entrySet().iterator();
        
        // calculate min and max
        while (hmIterator.hasNext()) {
            
            Map.Entry mapElement = (Map.Entry)hmIterator.next();
             
            // if the element is palindrome, could be min or max
            if (isPalindrome(((Number)mapElement.getValue()).getN())) {
                
                // min or max, first time both are set
                if (min == null && max == null) {
                    min = ((Number)mapElement.getValue()).getN();
                    productsMin = ((Number)mapElement.getValue()).getProducts();
                    max = ((Number)mapElement.getValue()).getN();
                    productsMax = ((Number)mapElement.getValue()).getProducts();                 
                } 
                
                // the current element is less than min
                if (((Number)mapElement.getValue()).getN() < min) {
                    min = ((Number)mapElement.getValue()).getN();
                    productsMin = ((Number)mapElement.getValue()).getProducts();
                }
                 // the current element is greater than max               
                if (((Number)mapElement.getValue()).getN() > max) {
                    max = ((Number)mapElement.getValue()).getN();
                    productsMax = ((Number)mapElement.getValue()).getProducts();                 
                }
               
            }    
        }
        // print results
        System.out.println(System.getProperty("line.separator"));

        System.out.println("min" + ": " + min);
        
        for(Pair p: productsMin) {
            System.out.println("( " + p.getN1() + ", " + p.getN2() + " )");
        }
       
        System.out.println("max" + ": " + max);
        
        for(Pair p: productsMax) {
            System.out.println("( " + p.getN1() + ", " + p.getN2() + " )");
        }
    }
    
    public static boolean isPalindrome(int number) {
        int temp = 0;
        int numberAux = number;
        int x;
        while (numberAux > 0) {
            x = numberAux % 10;
            numberAux = numberAux / 10;
            temp = temp * 10 + x;
        }
        if (temp == number) {
            return true;
        } else {
            return false;
        }
    }
    
}
