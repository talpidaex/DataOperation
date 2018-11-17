

package midtermexam;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

 public class Person implements Comparable <Person>{
    

    private String name;
    private String surname;
    private Integer age;
    
    public Person(String name,String surname, Integer age) {
        this.name = name;
        this.surname=surname;
        this.age = age;
    }
    public Person(){
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getSurname(){
        return surname;
    }
    public void setSurname(String surname){
        this.surname =surname;
    }
    
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    
    public static void PersonData(){
    
        File data = new File("C:\\Users\\ousha\\Desktop\\Vilnius Gediminas\\Programming Language\\Midterm\\MidtermExam\\src\\midtermexam\\veri.txt");
        char [] veri  = new char[(int)data.length()];
        ArrayList<Person> PerArray = new  ArrayList<Person>(); 
        try {
            
            FileReader text = new FileReader(data);
            text.read(veri);
            String read = new String(veri);
            StringTokenizer storedwords= new StringTokenizer (read ,"\r\n\r\n"); // parse etme işlemini yaptım iki satır atlatmak için file dan 
            while(storedwords.hasMoreTokens()){ 
                
                String as = storedwords.nextToken();
                System.out.println(as);
                
                Person perType = new Person();
                String[] stringSplit=as.split(":| ");
                perType.setAge(Integer.parseInt(stringSplit[0]));
                perType.setName(stringSplit[1]);
                perType.setSurname(stringSplit[2]);   
                PerArray.add(perType); // file da bulunan dataların bilgileri tutuyorum
                
            } 
                
            Collections.sort(PerArray,new PersonNameCompare()); // collection sort ile oluştuduğum listedeki age lerin göre sıraladık
            Collections.sort(PerArray,new PersonAgeCompare());
            //String letters = PerArray.get(1).name.substring(0,3); // managementı ulaşmak istiyorsak get (1) yap
            System.out.println(PerArray);
                
                
            BufferedWriter writerFile = new BufferedWriter(new FileWriter("C:\\Users\\ousha\\Desktop\\Vilnius Gediminas\\Programming Language\\Midterm\\MidtermExam\\src\\midtermexam\\storewords.txt"));
            writerFile.write(PerArray.get(3).name.toUpperCase().toString()+ " ");
            writerFile.write(PerArray.get(3).surname.substring(0,3).toString()+ " ");
            writerFile.write(String.valueOf(2016-PerArray.get(3).age));// we convert to age to string
            
            writerFile.close();
                
               
            
        }
        catch (Exception e){
            e.printStackTrace();
        }
         
    
    }

    @Override
    public int compareTo(Person per) {
       
        int age1= ((Person)per).getAge();
   
        return this.age- age1;
    }
    
    @Override
    public String toString(){
        return "{" + "person name : "+" "+ name.substring(0,3)+ " " +"surname : "+ surname.toUpperCase() + " age : "+ (2016-age)+ "}" ; 
        
    }
    
    
 }



