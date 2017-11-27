package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by husama on 02.11.2017.
 */
public class Table {

    private final SimpleIntegerProperty rLP;
    private final SimpleStringProperty rName;
    private final SimpleStringProperty rSurname;
    private final SimpleStringProperty rCity;


    public Table (int sLP, String sName, String sSurname, String sCity) {
        this.rLP = new SimpleIntegerProperty(sLP);
        this.rName = new SimpleStringProperty(sName);
        this.rSurname = new SimpleStringProperty(sSurname);
        this.rCity = new SimpleStringProperty(sCity);
    }

    public String toString(String separator) {
        return getRName() + getRName() + separator + getRSurname() + separator + getRCity();
    }

    // getters and setters


    public int getRLP() {
        return rLP.get();
    }

    public SimpleIntegerProperty rLPProperty() {
        return rLP;
    }

    public void setRLP(int rLP) {
        this.rLP.set(rLP);
    }

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
