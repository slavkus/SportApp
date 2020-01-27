package hr.foi.mtlab.sportify.Main;

import android.text.Editable;

import com.google.android.gms.maps.model.LatLng;

import java.util.Date;

/**
 * Created by Slavkus Maximus on 10/21/2016.
 */
public class NewEventItem {

    private static NewEventItem instance = null;
    private NewEventItem(){}

    public static NewEventItem getInstance()
    {
        if (instance == null)
        {
            instance = new NewEventItem();
        }
        return instance;
    }
    private String name,sport,description, location;
    private int sportNumber, numberOfRepeats;
    private Date date;
    private Date time;
    private double price;
    private LatLng latitudeLongitude;

    public String getDescription() {
        return description;
    }

    public void setDescription (String description) {
        this.description=description;
    }

    public int getSportNumber() {
        return sportNumber;
    }

    public void setSportNumber(int sportNumber) {
        this.sportNumber = sportNumber;
    }

    public double getPrice() {return price;}

    public void setPrice (double price) {this.price = price;}

    public int getNumberOfRepeats() {
        return numberOfRepeats;
    }

    public void setNumberOfRepeats(int numberOfRepeats) {
        this.numberOfRepeats = numberOfRepeats;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setName(String name)
        {this.name=name;}

    public String getName () {return name;}

    public void setSport(String sport)
    {this.sport=sport;}

    public String getSport () {return sport;}

    public void setLocation (String location){this.location=location;}

    public String getLocation () {return location;}

    public LatLng getLatitudeLongitude() {
        return latitudeLongitude;
    }

    public void setLatitudeLongitude(LatLng latitudeLongitude) {
        this.latitudeLongitude = latitudeLongitude;
    }


}
