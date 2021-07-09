package ch.fhnw.oop2.heritagesites.view;

import ch.fhnw.oop2.heritagesites.presentationModel.HeritageSiteResultsPM;
import ch.fhnw.oop2.heritagesites.presentationModel.MultiLanguagePM;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

import java.util.Objects;

public class HeaderUI extends HBox {

    private Button add;
    private Button delete;
    private Button save;
    private Button german;
    private Button english;
    private HBox languageBox;

    HeritageSiteResultsPM heritageSiteResultsPM;

    public HeaderUI(HeritageSiteResultsPM heritageSiteResultsPM) {
        this.heritageSiteResultsPM = heritageSiteResultsPM;
        initializeSelf();
        initializeControls();
        layoutControls();
        setupEventHandlers();
        setupValueChangedListeners();
        setupBindings();
    }

    private void initializeSelf() {
        this.getStyleClass().add("header");
        String stylesheet = Objects.requireNonNull(getClass().getResource("/styles/style.css")).toExternalForm();
        getStylesheets().add(stylesheet);
    }

    private void initializeControls() {
        add = new Button("Add");
        delete = new Button("Delete");
        save = new Button("Save");

        german = new Button("DE");
        english = new Button("EN");
        languageBox = new HBox(german, english);

        delete.setDisable(true);
        save.setDisable(true);

        add.getStyleClass().add("secondary-button");
        delete.getStyleClass().add("secondary-button");
        save.getStyleClass().add("primary-button");

        german.setId("german-selector");
        english.setId("english-selector");
        delete.setId("delete");
        save.setId("save");
    }

    private void layoutControls() {
        Node spacer = new Region();
        setHgrow(spacer, Priority.ALWAYS);
        setPadding(new Insets(10));
        setSpacing(10);
        getChildren().addAll(add, delete, save, spacer, languageBox);
    }

    private void setupEventHandlers() {
        add.setOnAction(event -> heritageSiteResultsPM.addNewElement());
        delete.setOnAction(event -> heritageSiteResultsPM.deleteSelectedElement());
        save.setOnAction(event -> heritageSiteResultsPM.save());

        german.setOnAction(event -> setLanguage(MultiLanguagePM.Language.DE));
        english.setOnAction(event -> setLanguage(MultiLanguagePM.Language.EN));
    }

    private void setupValueChangedListeners() {
        heritageSiteResultsPM.selectedHeritageSiteIdProperty().addListener((observable, oldValue, newValue) -> {
            delete.setDisable(false);
            save.setDisable(false);
        });
    }

    private void setupBindings() {
        add.textProperty().bind(heritageSiteResultsPM.languagePM.buttonAddProperty());
        delete.textProperty().bind(heritageSiteResultsPM.languagePM.buttonDeleteProperty());
        save.textProperty().bind(heritageSiteResultsPM.languagePM.buttonSaveProperty());
        german.textProperty().bind(heritageSiteResultsPM.languagePM.buttonGermanProperty());
        english.textProperty().bind(heritageSiteResultsPM.languagePM.buttonEnglishProperty());
    }

    private void setLanguage(MultiLanguagePM.Language lang) {
        heritageSiteResultsPM.setLanguage(lang);
    }

}
