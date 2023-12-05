package clones;

/**
 * Base cloned object {@link Address} doesn't contains any custom object so shallow cloning is enough.
 * @author Valentin
 */
public class AddressTest {

    /**
     * main method.
     * @param args string array
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        Address address = new Address("city", "zipCode");
        Address address1 = (Address) address.clone();
        Address address2 = (Address) address.clone();

        if (address1 == address2) {
            throw new IllegalStateException("Clones have same reference");
        } else {
            System.out.println("Clones have different references as they suppose to.");
        }

        address.setCity("newCity");

        if (address1.getCity().equals(address.getCity()) || address2.getCity().equals(address.getCity())) {
            System.out.println("Cloned objected affected!");
        }
    }
}
