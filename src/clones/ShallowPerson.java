package clones;

/**
 * Object that is shallow cloned.
 * @author Valentin
 */
public class ShallowPerson implements Cloneable {
    private String name;
    private int age;
    private Address address;

    public ShallowPerson(String name, int age, Address address) {
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
        return super.clone();
    }
}
