
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
 
public class HashCodeForString{
  public static void main(String[] args) {
    // Create a hash set 
    Set<String> set = new HashSet<>();
  
    //Add strings to the set
    set.add("CIS 315");
    set.add("Java");
    set.add("Programming");
    set.add("Jared Truitt"); // Replace "John Doe" with your own name
  
    ArrayList<String> myArrayList = setToList(set);
    
    //Display the hash code for each element in the array list
    for (String str : myArrayList) {
      System.out.println("The hash code for \"" + str + "\" = " + hashCodeForString(str));
    }
  }
     
    //Return a hash code for a string
    public static int hashCodeForString(String s) {
      int b = 31;
      int hashCode = 0;
      for(int i=0; i<s.length(); i++){
        hashCode = b * hashCode + (int)s.charAt(i);
      }

      return hashCode;
    }
      
    //Return an ArrayList from a set
    public static <E> ArrayList<E> setToList(Set<E> s) {
      ArrayList<E> list = new ArrayList<>();
      for(E elem : s){
        list.add(elem);
      }
      return list;
    }
}
