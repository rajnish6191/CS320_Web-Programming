package Homework2;

public class CS320User
{
    public CS320User(String first, String last, String email, String password)
    {
        this.first = first;
        this.last = last;
        this.email = email;
        this.password = password;
    }

    public String getFirst()
    {
        return first;
    }

    public String getLast()
    {
        return last;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPassword()
    {
        return password;
    }

    private String first;
    private String last;
    private String email;
    private String password;
}