package clones;

/**
 * Shallow cloning of {@link ShallowPerson} object.
 * @author Valentin
 */
public class ShallowPersonTest {

    /**
     * main method.
     * @param args string array
     * @throws CloneNotSupportedException in case the cloned object doesn't implement {@link Cloneable}
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        Address originalAddress = new Address("City", "12345");
        ShallowPerson originalPerson = new ShallowPerson("John", 25, originalAddress);

        // Perform a deep clone
        ShallowPerson clonedPerson = (ShallowPerson) originalPerson.clone();

        // Modify the clonedPerson's address
        clonedPerson.getAddress().setCity("New City");

        // Both should display New City, as only a shallow clone was made in ShallowPerson
        System.out.println("Original Person's Address: " + originalPerson.getAddress().getCity());
        System.out.println("Cloned Person's Address: " + clonedPerson.getAddress().getCity());
    }
}
