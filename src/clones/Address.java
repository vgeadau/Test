package clones;

/**
 * Address object for used for clone testing.
 * @author Valentin
 */
public class Address implements Cloneable {
    private String city;
    private String zipCode;

    public Address(String city, String zipCode) {
        this.city = city;
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    @SuppressWarnings("unused")
    public String getZipCode() {
        return zipCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @SuppressWarnings("unused")
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}