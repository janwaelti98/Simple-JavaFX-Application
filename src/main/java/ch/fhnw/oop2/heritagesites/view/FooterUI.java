package ch.fhnw.oop2.heritagesites.view;

import ch.fhnw.oop2.heritagesites.presentationModel.HeritageSiteResultsPM;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.control.*;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.util.converter.NumberStringConverter;

import java.util.Objects;

public class FooterUI extends HBox {

    private Label numberOfVisitedSitesTextLabel;
    private Label numberOfVisitedSitesLabel;
    private Label numberOfVisitedCountriesTextLabel;
    private Label numberOfVisitedCountriesLabel;

    HeritageSiteResultsPM heritageSiteResultsPM;

    public FooterUI(HeritageSiteResultsPM heritageSiteResultsPM) {
        this.heritageSiteResultsPM = heritageSiteResultsPM;
        initializeSelf();
        initializeControls();
        layoutControls();
        setupBindings();
    }

    private void initializeSelf() {
        this.getStyleClass().add("footer");
        String stylesheet = Objects.requireNonNull(getClass().getResource("/styles/style.css")).toExternalForm();
        getStylesheets().add(stylesheet);
    }

    private void initializeControls() {
        numberOfVisitedSitesTextLabel = new Label("Visited Sites: ");
        numberOfVisitedSitesLabel = new Label();
        numberOfVisitedCountriesTextLabel = new Label("Visited Countries: ");
        numberOfVisitedCountriesLabel = new Label();
    }

    private void layoutControls() {
        Node spacer = new Region();
        setHgrow(spacer, Priority.ALWAYS);
        setPadding(new Insets(5, 10, 5, 10));

        getChildren()
            .addAll(numberOfVisitedSitesTextLabel, numberOfVisitedSitesLabel, spacer, numberOfVisitedCountriesTextLabel,
                numberOfVisitedCountriesLabel);
    }

    private void setupBindings() {
        numberOfVisitedSitesLabel.textProperty()
            .bindBidirectional(heritageSiteResultsPM.numberOfVisitedHeritageSitesProperty(),
                new NumberStringConverter());

        numberOfVisitedCountriesLabel.textProperty()
            .bindBidirectional(heritageSiteResultsPM.numberOfVisitedCountriesProperty(), new NumberStringConverter());

        numberOfVisitedSitesTextLabel.textProperty().bind(heritageSiteResultsPM.languagePM.labelVisitedSitesProperty());
        numberOfVisitedCountriesTextLabel.textProperty()
            .bind(heritageSiteResultsPM.languagePM.labelVisitedCountriesProperty());
    }
}
