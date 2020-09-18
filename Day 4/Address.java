public class Address{

    private String state,city,pincode;

    Address(String state, String city, String pincode)
    {
        this.state = state;
        this.city = city;
        this.pincode = pincode;
    }

    public String getState()
    {
        return this.state;
    }
    public String getCity()
    {
        return this.city;
    }
    public String getPincode()
    {
        return this.pincode;
    }

    public void setState(String state)
    {
        this.state = state;
    }
    public void setCity(String city)
    {
        this.city = city;
    }
    public void setPincode(String pincode)
    {
        this.pincode = pincode;
    }

}