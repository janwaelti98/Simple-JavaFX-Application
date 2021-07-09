package ch.fhnw.oop2.heritagesites.view;

import ch.fhnw.oop2.heritagesites.presentationModel.*;
import javafx.collections.ListChangeListener;
import javafx.scene.control.*;

import java.util.Objects;

public class TableViewUI extends TableView<HeritageSitePM> {

    HeritageSiteResultsPM heritageSiteResultsPM;

    public TableViewUI(HeritageSiteResultsPM heritageSiteResultsPM) {
        super(heritageSiteResultsPM.getAllHeritageSites());
        this.heritageSiteResultsPM = heritageSiteResultsPM;
        initializeSelf();
        initializeControls();
        layoutControls();
        setupValueChangedListeners();
    }

    private void initializeSelf() {
        this.getStyleClass().add("tableView");
        String stylesheet = Objects.requireNonNull(getClass().getResource("/styles/style.css")).toExternalForm();
        getStylesheets().add(stylesheet);
    }

    private void initializeControls() {
        initializeTableView();
    }

    private void initializeTableView() {

        TableColumn<HeritageSitePM, Number> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(cell -> cell.getValue().idProperty());

        TableColumn<HeritageSitePM, String> categoryCol = new TableColumn<>("Category");
        categoryCol.setCellValueFactory(cell -> cell.getValue().categoryProperty());

        TableColumn<HeritageSitePM, String> regionCol = new TableColumn<>("Region");
        regionCol.setCellValueFactory(cell -> cell.getValue().regionProperty());

        TableColumn<HeritageSitePM, String> statesCol = new TableColumn<>("States");
        statesCol.setCellValueFactory(cell -> cell.getValue().statesProperty());

        TableColumn<HeritageSitePM, String> siteCol = new TableColumn<>("Site");
        siteCol.setCellValueFactory(cell -> cell.getValue().siteProperty());

        this.getColumns()
            .addAll(idCol, categoryCol, regionCol, statesCol, siteCol);

        //Tableview bindings
        idCol.textProperty().bind(heritageSiteResultsPM.languagePM.columnIDProperty());
        categoryCol.textProperty().bind(heritageSiteResultsPM.languagePM.columnCategoryProperty());
        regionCol.textProperty().bind(heritageSiteResultsPM.languagePM.columnRegionProperty());
        statesCol.textProperty().bind(heritageSiteResultsPM.languagePM.columnStatesProperty());
        siteCol.textProperty().bind(heritageSiteResultsPM.languagePM.columnSiteProperty());

    }

    private void layoutControls() {
        this.setMinWidth(450);
        getChildren().addAll();
    }

    private void setupValueChangedListeners() {
        this.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> {
                if (newValue != null) {
                    heritageSiteResultsPM.setSelectedHeritageSiteId(newValue.getId());
                }
            });

        heritageSiteResultsPM.getAllHeritageSites().addListener((ListChangeListener<HeritageSitePM>) change -> {
            while (change.next()) {
                this.scrollTo(change.getFrom());
                this.getSelectionModel().select(change.getFrom());
            }
        });
    }
}
