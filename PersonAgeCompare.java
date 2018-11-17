/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midtermexam;

import java.util.Comparator;

public class PersonAgeCompare implements Comparator <Person> {
 
    public int compare(Person a1,Person a2){
        
        int age = a1.getAge();
        int age1 = a2.getAge();
 
        return age1-age;
    }
}    
