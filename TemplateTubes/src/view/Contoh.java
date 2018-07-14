/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author USER
 */
public class Contoh {
    
    public static void main(String[] args) {
        List <String> listString = new ArrayList<>();
        listString.add("Bokir");
        listString.add("Bokirs");
        listString.add("Bokirsss");
        
        String [] arrIsi = listString.toArray(new String[listString.size()]);
    }
    
}
