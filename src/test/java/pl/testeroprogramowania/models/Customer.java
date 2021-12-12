package pl.testeroprogramowania.models;

public class Customer {

    private String firstName = "Rafal";
    private String lastName = "Kowal";
    private String houseAndStreet = "Kowalowa 12/12";
    private String postCode = "99-999";
    private String city = "Kowalice";
    private String country = "Poland";
    private String phoneNumber = "123456789";
    private String email = "kowal@wp.pl";
    private String companyName = "Kowalex";

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHouseAndStreet() {
        return houseAndStreet;
    }

    public void setHouseAndStreet(String houseAndStreet) {
        this.houseAndStreet = houseAndStreet;
    }


    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
