package clones;

/**
 * Deep cloning of {@link Person} object.
 * @author Valentin
 */
public class PersonTest {

    /**
     * main method.
     * @param args string array
     * @throws CloneNotSupportedException in case of object doesn't implement {@link Cloneable}
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        Address originalAddress = new Address("City", "12345");
        Person originalPerson = new Person("John", 25, originalAddress);

        // Perform a deep clone
        Person clonedPerson = (Person) originalPerson.clone();

        // Modify the clonedPerson's address
        clonedPerson.getAddress().setCity("New City");

        // Display originalPerson's address to confirm it's not modified
        System.out.println("Original Person's Address: " + originalPerson.getAddress().getCity());
        // Display clonedPerson's address to confirm it's modified
        System.out.println("Cloned Person's Address: " + clonedPerson.getAddress().getCity());

    }
}
