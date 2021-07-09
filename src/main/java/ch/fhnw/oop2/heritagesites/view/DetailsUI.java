package ch.fhnw.oop2.heritagesites.view;

import ch.fhnw.oop2.heritagesites.presentationModel.HeritageSitePM;
import ch.fhnw.oop2.heritagesites.presentationModel.HeritageSiteResultsPM;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

import java.util.Objects;
import java.util.stream.Collectors;

public class DetailsUI extends GridPane {
    private Label siteTitle;
    private Label siteLabel;
    private Label yearInscribedLabel;
    private Label categoryLabel;
    private Label locationLabel;
    private Label regionLabel;
    private Label stateLabel;
    private Label shortDescriptionLabel;
    private Label isoCodeLabel;
    private Label imageUrlLabel;
    private Label visitedLabel;

    private TextField siteTextField;
    private TextField yearInscribedTextField;
    private TextField categoryTextField;
    private TextField locationTextField;
    private TextField regionTextField;
    private TextField statesTextField;
    private TextArea shortDescriptionTextArea;
    private TextField isoCodeTextField;
    private TextField imageUrlTextField;
    private CheckBox visitedCheckBox;

    HeritageSiteResultsPM heritageSiteResultsPM;

    public DetailsUI(HeritageSiteResultsPM heritageSiteResultsPM) {
        this.heritageSiteResultsPM = heritageSiteResultsPM;
        initializeSelf();
        initializeControls();
        layoutControls();
        setupValueChangedListeners();
        setupBindings();
    }

    private void initializeSelf() {
        this.getStyleClass().add("detailsView");
        String stylesheet = Objects.requireNonNull(getClass().getResource("/styles/style.css")).toExternalForm();
        getStylesheets().add(stylesheet);
    }

    private void initializeControls() {
        siteTitle = new Label();
        siteLabel = new Label("Site");
        yearInscribedLabel = new Label("Year Inscribed");
        categoryLabel = new Label("Category");
        locationLabel = new Label("Location");
        regionLabel = new Label("Region");
        stateLabel = new Label("State");
        shortDescriptionLabel = new Label("Short Description");
        isoCodeLabel = new Label("ISO Code");
        imageUrlLabel = new Label("Image URL");
        visitedLabel = new Label("Visited");

        siteTextField = new TextField();
        yearInscribedTextField = new TextField();
        categoryTextField = new TextField();
        locationTextField = new TextField();
        regionTextField = new TextField();
        statesTextField = new TextField();
        shortDescriptionTextArea = new TextArea();
        isoCodeTextField = new TextField();
        imageUrlTextField = new TextField();
        visitedCheckBox = new CheckBox();

        siteTitle.setId("siteTitle");

        shortDescriptionTextArea.getStyleClass().add("shortDesc");
    }

    private void layoutControls() {
        ColumnConstraints cc = new ColumnConstraints();
        cc.setHgrow(Priority.ALWAYS);
        getColumnConstraints().addAll(cc, cc);
        cc.setMinWidth(120);

        RowConstraints rc = new RowConstraints();
        rc.setVgrow(Priority.NEVER);
        getRowConstraints().addAll(rc, rc, rc, rc, rc, rc, rc, rc, rc, rc, rc);

        setPadding(new Insets(10));
        setVgap(10);

        this.setMinWidth(500);
        this.setMaxWidth(500);

        add(siteLabel, 0, 1);
        add(yearInscribedLabel, 0, 2);
        add(categoryLabel, 0, 3);
        add(locationLabel, 0, 4);
        add(regionLabel, 0, 5);
        add(stateLabel, 0, 6);
        add(shortDescriptionLabel, 0, 7);
        add(isoCodeLabel, 0, 8);
        add(imageUrlLabel, 0, 9);
        add(visitedLabel, 0, 10);

        add(siteTitle, 0, 0, 2, 1);
        add(siteTextField, 1, 1);
        add(yearInscribedTextField, 1, 2);
        add(categoryTextField, 1, 3);
        add(locationTextField, 1, 4);
        add(regionTextField, 1, 5);
        add(statesTextField, 1, 6);
        add(shortDescriptionTextArea, 1, 7);
        add(isoCodeTextField, 1, 8);
        add(imageUrlTextField, 1, 9);
        add(visitedCheckBox, 1, 10);

        getChildren().addAll();
    }

    private void setupValueChangedListeners() {
        visitedCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            Platform.runLater(() -> heritageSiteResultsPM
                .setNumberOfVisitedHeritageSites(heritageSiteResultsPM.visitedHeritageSites().size()));
            Platform.runLater(() -> heritageSiteResultsPM
                .setNumberOfVisitedCountries(heritageSiteResultsPM.visitedCountries().size()));

            heritageSiteResultsPM.setListOfVisitedCountries(heritageSiteResultsPM.visitedCountries());

            heritageSiteResultsPM.setListOfVisitedHeritageSites(heritageSiteResultsPM.visitedHeritageSites()
                .stream()
                .map(HeritageSitePM::getSite)
                .collect(Collectors.toList()));
        });

        siteTextField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                validateString(siteTextField);
                validateBlank(siteTextField);
            } else {
                siteTextField.setStyle("-fx-text-fill: black");
            }
        });

        yearInscribedTextField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                validateNumber(yearInscribedTextField);
                validateBlank(yearInscribedTextField);
            } else {
                yearInscribedTextField.setStyle("-fx-text-fill: black");
            }
        });

        categoryTextField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                validateString(categoryTextField);
                validateBlank(categoryTextField);
            } else {
                categoryTextField.setStyle("-fx-text-fill: black");
            }
        });

        locationTextField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                validateString(locationTextField);
                validateBlank(locationTextField);
            } else {
                locationTextField.setStyle("-fx-text-fill: black");
            }
        });

        regionTextField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                validateString(regionTextField);
                validateBlank(regionTextField);
            } else {
                regionTextField.setStyle("-fx-text-fill: black");
            }
        });

        statesTextField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                validateString(statesTextField);
                validateBlank(statesTextField);
            } else {
                statesTextField.setStyle("-fx-text-fill: black");
            }
        });

        shortDescriptionTextArea.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                validateBlank(shortDescriptionTextArea);
            } else {
                shortDescriptionTextArea.setStyle("-fx-text-fill: black");
            }
        });

        isoCodeTextField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                validateString(isoCodeTextField);
                validateBlank(isoCodeTextField);
            } else {
                isoCodeTextField.setStyle("-fx-text-fill: black");
            }
        });

        imageUrlTextField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                validateBlank(imageUrlTextField);
            } else {
                imageUrlTextField.setStyle("-fx-text-fill: black");
            }
        });
    }

    private void validateString(TextInputControl textField) {
        if (!textField.getText().matches("^[a-zA-Z\\s]*$")) {
            textField.setText("No numbers allowed");
            textField.setStyle("-fx-text-fill: red");
        }
    }

    private void validateBlank(TextInputControl textField) {
        if (textField.getText().isBlank()) {
            textField.setText("Field must not be blank");
            textField.setStyle("-fx-text-fill: red");
        }
    }

    private void validateNumber(TextInputControl textField) {
        if (!textField.getText().matches("[0-9]{4}")) {
            textField.setText("Not a four digit number");
            textField.setStyle("-fx-text-fill: red");
        }
    }

    private void setupBindings() {
        HeritageSitePM proxy = heritageSiteResultsPM.getHeritageSiteProxy();

        siteTitle.textProperty().bind(Bindings.concat(proxy.siteProperty(), " - ", proxy.dateInscribedProperty()));
        siteTextField.textProperty().bindBidirectional(proxy.siteProperty());
        yearInscribedTextField.textProperty().bindBidirectional(proxy.dateInscribedProperty());
        categoryTextField.textProperty().bindBidirectional(proxy.categoryProperty());
        locationTextField.textProperty().bindBidirectional(proxy.locationProperty());
        regionTextField.textProperty().bindBidirectional(proxy.regionProperty());
        statesTextField.textProperty().bindBidirectional(proxy.statesProperty());
        shortDescriptionTextArea.textProperty().bindBidirectional(proxy.shortDescriptionProperty());
        isoCodeTextField.textProperty().bindBidirectional(proxy.codeISOProperty());
        imageUrlTextField.textProperty().bindBidirectional(proxy.imageURLProperty());
        visitedCheckBox.selectedProperty().bindBidirectional(proxy.visitedProperty());

        siteLabel.textProperty().bind(heritageSiteResultsPM.languagePM.labelSiteProperty());
        yearInscribedLabel.textProperty().bind(heritageSiteResultsPM.languagePM.labelYearInscribedProperty());
        categoryLabel.textProperty().bind(heritageSiteResultsPM.languagePM.labelCategoryProperty());
        locationLabel.textProperty().bind(heritageSiteResultsPM.languagePM.labelLocationProperty());
        regionLabel.textProperty().bind(heritageSiteResultsPM.languagePM.labelRegionProperty());
        stateLabel.textProperty().bind(heritageSiteResultsPM.languagePM.labelStateProperty());
        shortDescriptionLabel.textProperty().bind(heritageSiteResultsPM.languagePM.labelShortDescriptionProperty());
        isoCodeLabel.textProperty().bind(heritageSiteResultsPM.languagePM.labelISOCodeProperty());
        imageUrlLabel.textProperty().bind(heritageSiteResultsPM.languagePM.labelImageURLProperty());
        visitedLabel.textProperty().bind(heritageSiteResultsPM.languagePM.checkboxVisitedProperty());
    }
}
