package Homework3;

public class AirportBean
{
    public AirportBean(int zip, String city, String state, Double latitude, Double longitude)
    {
        this.zip = zip;
        this.city = city;
        this.state = state;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public AirportBean(String airport, Double latitude, Double longitude)
    {
        this.airport = airport;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getAirport()
    {
        return airport;
    }

    public int getZip()
    {
        return zip;
    }

    public String getCity()
    {
        return city;
    }

    public String getState()
    {
        return state;
    }

    public Double getLatitude()
    {
        return latitude;
    }

    public Double getLongitude()
    {
        return longitude;
    }

    int zip;
    String city;
    String state;
    Double latitude;
    Double longitude;
    String airport;
}