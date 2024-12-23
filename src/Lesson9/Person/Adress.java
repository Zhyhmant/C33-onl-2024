package Lesson9.Person;

public class Adress implements Cloneable{
    private String city;
    private String street;

    public Adress(String city, String street) {
        this.city = city;
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }


    @Override
    protected Adress clone() throws CloneNotSupportedException {
        return (Adress)super.clone(); // клонируем обьект Address
    }

    @Override
    public String toString() {
        return "Address: " + '\n' +
                "City: " + city + '\n' +
                "Street: " + street + '\n';
    }
}
