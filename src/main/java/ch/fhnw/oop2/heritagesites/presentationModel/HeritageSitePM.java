package ch.fhnw.oop2.heritagesites.presentationModel;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class HeritageSitePM {
    private final StringProperty category = new SimpleStringProperty();
    private final StringProperty dateInscribed = new SimpleStringProperty();
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty imageURL = new SimpleStringProperty();
    private final StringProperty codeISO = new SimpleStringProperty();
    private final StringProperty location = new SimpleStringProperty();
    private final StringProperty region = new SimpleStringProperty();
    private final StringProperty shortDescription = new SimpleStringProperty();
    private final StringProperty site = new SimpleStringProperty();
    private final StringProperty states = new SimpleStringProperty();
    private final BooleanProperty visited = new SimpleBooleanProperty();

    public HeritageSitePM(String[] line) {
        setCategory(line[0]);
        setDateInscribed((line[1]));
        setId(Integer.parseInt(line[2]));
        setImageURL(line[3]);
        setCodeISO(line[4]);
        setLocation(line[5]);
        setRegion(line[6]);
        setShortDescription(line[7]);
        setSite(line[8]);
        setStates(line[9]);
        setVisited(false);
    }
    public HeritageSitePM() {
    }

    public String infoAsLine(String delimiter) {
        return String.join(delimiter,
            getCategory(),
            getDateInscribed(),
            Integer.toString(getId()),
            getImageURL(),
            getCodeISO(),
            getLocation(),
            getRegion(),
            getShortDescription(),
            getSite(),
            getStates());
    }

    // all getter & setter

    public String getCategory() {
        return category.get();
    }

    public StringProperty categoryProperty() {
        return category;
    }

    public void setCategory(String category) {
        this.category.set(category);
    }

    public String getDateInscribed() {
        return dateInscribed.get();
    }

    public StringProperty dateInscribedProperty() {
        return dateInscribed;
    }

    public void setDateInscribed(String dateInscribed) {
        this.dateInscribed.set(dateInscribed);
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getImageURL() {
        return imageURL.get();
    }

    public StringProperty imageURLProperty() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL.set(imageURL);
    }

    public String getCodeISO() {
        return codeISO.get();
    }

    public StringProperty codeISOProperty() {
        return codeISO;
    }

    public void setCodeISO(String codeISO) {
        this.codeISO.set(codeISO);
    }

    public String getLocation() {
        return location.get();
    }

    public StringProperty locationProperty() {
        return location;
    }

    public void setLocation(String location) {
        this.location.set(location);
    }

    public String getRegion() {
        return region.get();
    }

    public StringProperty regionProperty() {
        return region;
    }

    public void setRegion(String region) {
        this.region.set(region);
    }

    public String getShortDescription() {
        return shortDescription.get();
    }

    public StringProperty shortDescriptionProperty() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription.set(shortDescription);
    }

    public String getSite() {
        return site.get();
    }

    public StringProperty siteProperty() {
        return site;
    }

    public void setSite(String site) {
        this.site.set(site);
    }

    public String getStates() {
        return states.get();
    }

    public StringProperty statesProperty() {
        return states;
    }

    public void setStates(String states) {
        this.states.set(states);
    }

    public boolean isVisited() {
        return visited.get();
    }

    public BooleanProperty visitedProperty() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited.set(visited);
    }
}
