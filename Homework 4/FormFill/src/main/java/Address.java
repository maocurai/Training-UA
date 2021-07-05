/**
 * Address class for storing user's location information.
 * @author student
 */
public class Address {

    /** city index field*/
    private String index;

    /** current city name field*/
    private String city;

    /** current street name field*/
    private String street;

    /** house number field*/
    private String houseNumber;

    /** apartment number field*/
    private String apartmentNumber;

    /**
     *
     * @param index user's city index
     * @param city user's current city name
     * @param street user's current street name
     * @param houseNumber user's house number
     * @param apartmentNumber user's apartment number
     */
    public Address(String index, String city, String street, String houseNumber, String apartmentNumber) {
        this.index = index;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.apartmentNumber = apartmentNumber;
    }

    /**
     * Method for getting a string with the fields of the object
     * @return String
     */
    @Override
    public String toString() {
        return "Address{" +
                "index='" + index + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", apartmentNumber='" + apartmentNumber + '\'' +
                '}';
    }

    /**
     * Method for getting field value {@link Address#index}
     * @return index of the city
     */
    public String getIndex() {
        return index;
    }

    /**
     * Method for initializing the field {@link Address#index}
     * @param index of the city
     */
    public void setIndex(String index) {
        this.index = index;
    }

    /**
     * Method for getting field value {@link Address#city}
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * Method for initializing the field {@link Address#city}
     * @param city - user's city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Method for getting field value {@link Address#street}
     * @return street
     */
    public String getStreet() {
        return street;
    }

    /**
     * Method for initializing the field {@link Address#street}
     * @param street - user's street name
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Method for getting field value {@link Address#houseNumber}
     * @return houseNumber
     */
    public String getHouseNumber() {
        return houseNumber;
    }

    /**
     * Method for initializing the field {@link Address#houseNumber}
     * @param houseNumber - user's house number as a String
     */
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    /**
     * Method for getting field value {@link Address#apartmentNumber}
     * @return apartmentNumber
     */
    public String getApartmentNumber() {
        return apartmentNumber;
    }

    /**
     * Method for initializing the field {@link Address#apartmentNumber}
     * @param apartmentNumber - user's apartment number as a String
     */
    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }
}