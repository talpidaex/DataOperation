
package midtermexam;

import java.util.Comparator;

/**
 *
 * @author khas
 */
public class PersonNameCompare implements Comparator <Person> {
    public int compare(Person p1, Person p2) { 
	String PersonName1 = p1.getName().toUpperCase(); 
	String PersonName2 = p2.getName().toUpperCase(); 
	 
        return PersonName1.compareTo(PersonName2); 
    }
}
