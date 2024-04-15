/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package palindromeproducts;

import java.util.LinkedList;

/**
 *
 * @author jorge
 */
public class Number {
    
    private int n;
    private LinkedList<Pair> products;

    public Number(int n, Pair p) {
        this.n = n;
        products = new LinkedList<>();
        products.add(p);
    }
    
   
    public int getN() {
        return n;
    }

    public void addPair(Pair p) {
        
        for(Pair p1: products) {
            
            if (p.getN1() == p1.getN2() && p.getN2() == p1.getN1())
               return;
            
        }
        
        products.add(p);
        
    }

    public LinkedList<Pair> getProducts() {
        return products;
    }
    
    
}
