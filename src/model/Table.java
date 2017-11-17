package model;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by husama on 02.11.2017.
 */
public class Table {

    private final SimpleStringProperty rName;
    private final SimpleStringProperty rSurname;
    private final SimpleStringProperty rCity;


    public Table (String sName, String sSurname, String sCity) {
        this.rName = new SimpleStringProperty(sName);
        this.rSurname = new SimpleStringProperty(sSurname);
        this.rCity = new SimpleStringProperty(sCity);
    }



    // getters and setters



    public String getRName() {
        return rName.get();
    }

    public void setRName(String v) {
        rName.set(v);
    }

    public String getRSurname() {
        return rSurname.get();
    }

    public void setRSurname(String v) {
        rSurname.set(v);
    }

    public String getRCity() {
        return rCity.get();
    }

    public void setRCity(String v) { rCity.set(v); }
}
