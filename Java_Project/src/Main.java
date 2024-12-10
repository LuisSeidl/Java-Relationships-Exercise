import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static String inputText(){
        Scanner sc = new Scanner(System.in);
        System.out.println("For inputting your own Text press 1, for using the Default String Press 0");
        int decision = sc.nextInt();
        if (decision == 1){
            return sc.nextLine();


        } else if (decision == 0){
            sc.close();
            return """
            Jim likes Larry and Jean, but hates Kim.Bob loves Jean, and
            likes Larry and Kim.
            Jean loves Bob, likes Jim, but hates Kim.
            Kim hates Jim, likes Larry and Bob.
            Larry loves Martin, and hates Karl and Jean.""";
        } else {
            return "";
        }
    }


    public static String[] splitSentence(String text){
        return text.split("\\.");
    }

    public static List<Person> likes_loves_hates(String[] sentences){
        List<Person> people = new ArrayList<>();
        for(String s : sentences){
            String[] parts = s.split(" ");
            Person person = new Person(parts[0]); // first word is always a name
            people.add(person);
            for(int i = 0; i< parts.length ; i++){
                switch (parts[i]){
                    case "likes":
                        person.likes.add(parts[i+1]);
                        if(i+2 == parts.length) {
                            break;
                        } else if (parts[i+2].equals("and")){
                            person.likes.add(parts[i+3]);
                            break;
                        } else{
                            break;
                        }
                    case "loves":
                        person.loves.add(parts[i+1]);
                        if(i+2 == parts.length){
                            break;
                        } else if (parts[i+2].equals("and")){
                            person.loves.add(parts[i+3]);
                            break;
                        } else{
                            break;
                        }

                    case "hates":
                        person.hates.add(parts[i+1]);
                        if(i+2 == parts.length){
                            break;
                        } else if (parts[i+2].equals("and")){
                            person.hates.add(parts[i+3]);
                            break;
                        } else {
                            break;
                        }

                    default:
                        break;
                }
            }

        }
        return people;

    }
    public static void printRelations(List<Person> people){
        for(Person p : people){
            p.print();
        }
    }

    public static void main(String[] args) {

        String text = inputText();
        String[] sentences = splitSentence(text);
        List<Person> people = likes_loves_hates(sentences);
        printRelations(people);


    }
}