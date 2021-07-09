package ch.fhnw.oop2.heritagesites.presentationModel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ApplicationPM {
    private final StringProperty applicationTitle = new SimpleStringProperty("HeritageSitesFX");

    public String getApplicationTitle() {
        return applicationTitle.get();
    }

    public StringProperty applicationTitleProperty() {
        return applicationTitle;
    }

}
