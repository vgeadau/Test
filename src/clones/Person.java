package clones;

/**
 * Objects that is properly cloned (deep cloning).
 * As this object is more complex each custom object also needs to be cloned in this case the Address.
 * @author Valentin
 */
public class Person implements Cloneable {
    private String name;
    private int age;
    private Address address;

    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @SuppressWarnings("unused")
    public String getName() {
        return name;
    }

    @SuppressWarnings("unused")
    public void setName(String name) {
        this.name = name;
    }

    @SuppressWarnings("unused")
    public int getAge() {
        return age;
    }

    @SuppressWarnings("unused")
    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    @SuppressWarnings("unused")
    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // Perform a shallow copy
        Person clonedPerson = (Person) super.clone();

        // Perform a deep copy for the Address object
        clonedPerson.address = (Address) address.clone();

        return clonedPerson;
    }
}