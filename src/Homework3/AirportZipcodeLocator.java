package Homework3;

import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.gjt.mm.mysql.Driver;
import Homework3.AirportBean;


@WebServlet(value={"/Homework3/AirportZipcodeLocator"})
public class AirportZipcodeLocator extends HttpServlet
{
    public AirportZipcodeLocator()
    {
    }
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        request.getRequestDispatcher("/WEB-INF/jsp/AirZipLocator.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        String host = "cs3.calstatela.edu";
        String port = "3306";
        String dbName = "cs320stu16";
        String username = "cs320stu16";
        String pass = "tUaRH*T*";
        String url = (new StringBuilder("jdbc:mysql://")).append(host).append(":").append(port).append("/").append(dbName).toString();
        try
        {
            Class.forName("org.gjt.mm.mysql.Driver").newInstance();
            java.sql.Driver driver = new Driver();
            Connection connection = DriverManager.getConnection(url, username, pass);
            Statement statement = connection.createStatement();
            ArrayList airportlocators = new ArrayList();
            ArrayList ziplocators = new ArrayList();
            String query = "SELECT * FROM zipcodes";
            String city;
            int zip;
            String state;
            Double latitude;
            Double longitude;
            for(ResultSet resultSet = statement.executeQuery(query); resultSet.next(); ziplocators.add(new AirportBean(zip, city, state, latitude, longitude)))
            {
                city = resultSet.getString("city");
                zip = resultSet.getInt("zip");
                state = resultSet.getString("state");
                latitude = Double.valueOf(resultSet.getDouble("latitude"));
                longitude = Double.valueOf(resultSet.getDouble("longitude"));
            }

            System.out.println("zipcode added to bean");
            query = "SELECT * FROM Airports";
            String airport;
            Double latitude1;
            Double longitude1;
            for(ResultSet resultSet = statement.executeQuery(query); resultSet.next(); airportlocators.add(new AirportBean(airport, latitude1, longitude1)))
            {
                airport = resultSet.getString("airport");
                latitude1 = Double.valueOf(resultSet.getDouble("latitude"));
                longitude1 = Double.valueOf(-resultSet.getDouble("longitude"));
            }

            System.out.println("Airports added.");
            if(request.getParameter("zipname") != null && request.getParameter("zipradius") != null)
            {
                System.out.println("Valid zipname and zipradius");
                int zipname = Integer.parseInt(request.getParameter("zipname"));
                int zipradius = Integer.parseInt(request.getParameter("zipradius"));
                System.out.println((new StringBuilder("zipname ---")).append(zipname).toString());
                System.out.println((new StringBuilder("zipradius ---")).append(zipradius).toString());
                ArrayList zipairports = new ArrayList();
                for(int i = 0; i < ziplocators.size(); i++)
                {
                    if(zipname != ((AirportBean)ziplocators.get(i)).getZip())
                        continue;
                    Double latitude11 = ((AirportBean)ziplocators.get(i)).getLatitude();
                    Double longitude11 = ((AirportBean)ziplocators.get(i)).getLongitude();
                    System.out.println((new StringBuilder("Latitude obtained: ")).append(latitude11).toString());
                    System.out.println((new StringBuilder("Longitude obtained: ")).append(longitude11).toString());
                    for(int j = 0; j < airportlocators.size(); j++)
                    {
                        Double dist = Double.valueOf(dist_calc(latitude11, longitude11, ((AirportBean)airportlocators.get(j)).getLatitude(), ((AirportBean)airportlocators.get(j)).getLongitude()));
                        if(dist.doubleValue() <= (double)zipradius)
                            zipairports.add(new AirportBean(((AirportBean)airportlocators.get(j)).getAirport(), ((AirportBean)airportlocators.get(j)).getLatitude(), ((AirportBean)airportlocators.get(j)).getLongitude()));
                    }

                    AirportBean a;
                    for(Iterator iterator = zipairports.iterator(); iterator.hasNext(); System.out.println((new StringBuilder(" -- ")).append(a.getAirport()).toString()))
                        a = (AirportBean)iterator.next();

                    break;
                }

                request.setAttribute("zipairports", zipairports);
            }
            ArrayList city_result = new ArrayList();
            if(request.getParameter("cityname") != null)
            {
                query = (new StringBuilder("SELECT * FROM `zipcodes` WHERE `city`='")).append(request.getParameter("cityname")).append("'").toString();
                int zip1;
                String city1;
                String state1;
                Double latitude11;
                Double longitude11;
                for(ResultSet resultSet = statement.executeQuery(query); resultSet.next(); city_result.add(new AirportBean(zip1, city1, state1, latitude11, longitude11)))
                {
                    zip1 = resultSet.getInt("zip");
                    city1 = resultSet.getString("city");
                    state1 = resultSet.getString("state");
                    latitude11 = Double.valueOf(resultSet.getDouble("latitude"));
                    longitude11 = Double.valueOf(resultSet.getDouble("longitude"));
                }

                request.setAttribute("city_result", city_result);
            }
            connection.close();
        }
        catch(Exception e)
        {
            request.setAttribute("error_airport", "Invalid City");
        }
        doGet(request, response);
    }

    public double dist_calc(Double lat1, Double long1, Double lat2, Double long2)
    {
        Double r = Double.valueOf(6372.8000000000002D);
        Double Lat1 = Double.valueOf(Math.toRadians(lat1.doubleValue()));
        Double Lat2 = Double.valueOf(Math.toRadians(lat2.doubleValue()));
        Double Lat21 = Double.valueOf(Math.toRadians(lat2.doubleValue() - lat1.doubleValue()));
        Double Long21 = Double.valueOf(Math.toRadians(long2.doubleValue() - long1.doubleValue()));
        Double a = Double.valueOf(Math.sin(Lat21.doubleValue() / 2D) * Math.sin(Lat21.doubleValue() / 2D) + Math.cos(Lat1.doubleValue()) * Math.cos(Lat2.doubleValue()) * Math.sin(Long21.doubleValue() / 2D) * Math.sin(Long21.doubleValue() / 2D));
        Double c = Double.valueOf(Math.atan2(Math.sqrt(a.doubleValue()), Math.sqrt(1.0D - a.doubleValue())));
        Double dist = Double.valueOf(r.doubleValue() * c.doubleValue());
        return dist.doubleValue();
    }
}