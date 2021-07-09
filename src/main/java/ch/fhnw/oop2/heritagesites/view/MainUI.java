package ch.fhnw.oop2.heritagesites.view;

import ch.fhnw.oop2.heritagesites.presentationModel.HeritageSiteResultsPM;
import javafx.scene.control.SplitPane;

import java.util.Objects;

public class MainUI extends SplitPane {

    private TableViewUI tableViewUI;
    private DetailsUI detailsUI;

    HeritageSiteResultsPM heritageSiteResultsPM;

    public MainUI(HeritageSiteResultsPM heritageSiteResultsPM) {
        this.getStyleClass().add("mainView");
        this.heritageSiteResultsPM = heritageSiteResultsPM;
        initializeSelf();
        initializeControls();
        layoutControls();
        setupListeners();
    }

    private void initializeSelf() {
        this.getStyleClass().add("main");
        String stylesheet = Objects.requireNonNull(getClass().getResource("/styles/style.css")).toExternalForm();
        getStylesheets().add(stylesheet);
    }

    private void initializeControls() {
        tableViewUI = new TableViewUI(heritageSiteResultsPM);
        detailsUI = new DetailsUI(heritageSiteResultsPM);
    }

    private void layoutControls() {
        this.getItems().addAll(tableViewUI);
    }

    private void setupListeners() {
        heritageSiteResultsPM.selectedHeritageSiteIdProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.intValue() > 0) {
                if (!getItems().contains(detailsUI)) {
                    getItems().add(detailsUI);
                }
            }
        });
    }
}
