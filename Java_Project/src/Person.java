import java.util.*;

public class Person {
    private String name;
    List<String> loves = new ArrayList<String>();
     List<String> likes = new ArrayList<String>();
     List<String> hates = new ArrayList<String>();

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public Person(String name) {
         this.name = name;
     }
     public void print() {
         System.out.println(name + ": [Likes: " + likes + "] [Loves: " + loves + "] [Hates " + hates + "]" );
     }
 }
