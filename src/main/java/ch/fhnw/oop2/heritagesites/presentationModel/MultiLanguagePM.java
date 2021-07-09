package ch.fhnw.oop2.heritagesites.presentationModel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import static ch.fhnw.oop2.heritagesites.presentationModel.MultiLanguagePM.Caption.*;

public class MultiLanguagePM {

    public enum Language {DE, EN}

    enum Caption {
        BUTTON_ADD("Add", "Hinzufügen"),
        BUTTON_DELETE("Delete", "Löschen"),
        BUTTON_SAVE("Save", "Speichern"),

        BUTTON_GERMAN("DE", "DE"),
        BUTTON_ENGLISH("EN", "EN"),

        LABEL_SITE("Site", "Ort"),
        LABEL_YEAR_INSCRIBED("Year Inscribed", "Beschriftungsjahr"),
        LABEL_CATEGORY("Category", "Kategorie"),
        LABEL_LOCATION("Location", "Standort"),
        LABEL_REGION("Region", "Region"),
        LABEL_STATE("State", "Land"),
        LABEL_SHORT_DESCRIPTION("Short Description", "Kurzbeschreibung"),
        LABEL_ISO_CODE("ISO Code", "ISO Code"),
        LABEL_IMAGE_URL("Image URL", "Bild URL"),
        CHECKBOX_VISITED("Visited", "Besucht"),

        COLUMN_ID("ID", "ID"),
        COLUMN_CATEGORY("Category", "Kategorie"),
        COLUMN_REGION("Region", "Region"),
        COLUMN_STATES("State", "Land"),
        COLUMN_SITE("Site", "Ort"),

        LABEL_VISITED_SITES("Visited Sites: ", "Besuchte Orte: "),
        LABEL_VISITED_COUNTRIES("Visited Countries: ", "Besuchte Länder: ");

        private final String english;
        private final String german;

        Caption(String english, String german) {
            this.english = english;
            this.german = german;
        }

        public String getEnglish() {
            return english;
        }

        public String getGerman() {
            return german;
        }

        public String getText(Language lang) {
            switch (lang) {
            case DE:
                return getGerman();
            default:
                return getEnglish();
            }
        }
    }

    private final StringProperty buttonAdd = new SimpleStringProperty();
    private final StringProperty buttonDelete = new SimpleStringProperty();
    private final StringProperty buttonSave = new SimpleStringProperty();

    private final StringProperty buttonGerman = new SimpleStringProperty();
    private final StringProperty buttonEnglish = new SimpleStringProperty();

    private final StringProperty labelSite = new SimpleStringProperty();
    private final StringProperty labelYearInscribed = new SimpleStringProperty();
    private final StringProperty labelCategory = new SimpleStringProperty();
    private final StringProperty labelLocation = new SimpleStringProperty();
    private final StringProperty labelRegion = new SimpleStringProperty();
    private final StringProperty labelState = new SimpleStringProperty();
    private final StringProperty labelShortDescription = new SimpleStringProperty();
    private final StringProperty labelISOCode = new SimpleStringProperty();
    private final StringProperty labelImageURL = new SimpleStringProperty();
    private final StringProperty checkboxVisited = new SimpleStringProperty();

    private final StringProperty columnID = new SimpleStringProperty();
    private final StringProperty columnCategory = new SimpleStringProperty();
    private final StringProperty columnRegion = new SimpleStringProperty();
    private final StringProperty columnStates = new SimpleStringProperty();
    private final StringProperty columnSite = new SimpleStringProperty();

    private final StringProperty labelVisitedSites = new SimpleStringProperty();
    private final StringProperty labelVisitedCountries = new SimpleStringProperty();

    public MultiLanguagePM() {
        setLanguage(Language.EN);
    }

    public void setLanguage(Language lang) {
        setButtonAdd(BUTTON_ADD.getText(lang));
        setButtonDelete(BUTTON_DELETE.getText(lang));
        setButtonSave(BUTTON_SAVE.getText(lang));

        setButtonGerman(BUTTON_GERMAN.getText(lang));
        setButtonEnglish(BUTTON_ENGLISH.getText(lang));

        setLabelSite(LABEL_SITE.getText(lang));
        setLabelYearInscribed(LABEL_YEAR_INSCRIBED.getText(lang));
        setLabelCategory(LABEL_CATEGORY.getText(lang));
        setLabelLocation(LABEL_LOCATION.getText(lang));
        setLabelRegion(LABEL_REGION.getText(lang));
        setLabelState(LABEL_STATE.getText(lang));
        setLabelShortDescription(LABEL_SHORT_DESCRIPTION.getText(lang));
        setLabelISOCode(LABEL_ISO_CODE.getText(lang));
        setLabelImageURL(LABEL_IMAGE_URL.getText(lang));
        setCheckboxVisited(CHECKBOX_VISITED.getText(lang));

        setColumnID(COLUMN_ID.getText(lang));
        setColumnCategory(COLUMN_CATEGORY.getText(lang));
        setColumnRegion(COLUMN_REGION.getText(lang));
        setColumnStates(COLUMN_STATES.getText(lang));
        setColumnSite(COLUMN_SITE.getText(lang));

        setLabelVisitedSites(LABEL_VISITED_SITES.getText(lang));
        setLabelVisitedCountries(LABEL_VISITED_COUNTRIES.getText(lang));
    }

    // Setters

    public StringProperty buttonAddProperty() {
        return buttonAdd;
    }

    public void setButtonAdd(String buttonAdd) {
        this.buttonAdd.set(buttonAdd);
    }

    public StringProperty buttonDeleteProperty() {
        return buttonDelete;
    }

    public void setButtonDelete(String buttonDelete) {
        this.buttonDelete.set(buttonDelete);
    }

    public StringProperty buttonSaveProperty() {
        return buttonSave;
    }

    public void setButtonSave(String buttonSave) {
        this.buttonSave.set(buttonSave);
    }

    public StringProperty labelVisitedSitesProperty() {
        return labelVisitedSites;
    }

    public void setLabelVisitedSites(String labelVisitedSites) {
        this.labelVisitedSites.set(labelVisitedSites);
    }

    public StringProperty labelVisitedCountriesProperty() {
        return labelVisitedCountries;
    }

    public void setLabelVisitedCountries(String labelVisitedCountries) {
        this.labelVisitedCountries.set(labelVisitedCountries);
    }

    public StringProperty buttonGermanProperty() {
        return buttonGerman;
    }

    public void setButtonGerman(String buttonGerman) {
        this.buttonGerman.set(buttonGerman);
    }

    public StringProperty buttonEnglishProperty() {
        return buttonEnglish;
    }

    public void setButtonEnglish(String buttonEnglish) {
        this.buttonEnglish.set(buttonEnglish);
    }

    public StringProperty labelSiteProperty() {
        return labelSite;
    }

    public void setLabelSite(String labelSite) {
        this.labelSite.set(labelSite);
    }

    public StringProperty labelYearInscribedProperty() {
        return labelYearInscribed;
    }

    public void setLabelYearInscribed(String labelYearInscribed) {
        this.labelYearInscribed.set(labelYearInscribed);
    }

    public StringProperty labelCategoryProperty() {
        return labelCategory;
    }

    public void setLabelCategory(String labelCategory) {
        this.labelCategory.set(labelCategory);
    }

    public StringProperty labelLocationProperty() {
        return labelLocation;
    }

    public void setLabelLocation(String labelLocation) {
        this.labelLocation.set(labelLocation);
    }

    public StringProperty labelRegionProperty() {
        return labelRegion;
    }

    public void setLabelRegion(String labelRegion) {
        this.labelRegion.set(labelRegion);
    }

    public StringProperty labelStateProperty() {
        return labelState;
    }

    public void setLabelState(String labelState) {
        this.labelState.set(labelState);
    }

    public StringProperty labelShortDescriptionProperty() {
        return labelShortDescription;
    }

    public void setLabelShortDescription(String labelShortDescription) {
        this.labelShortDescription.set(labelShortDescription);
    }

    public StringProperty labelISOCodeProperty() {
        return labelISOCode;
    }

    public void setLabelISOCode(String labelISOCode) {
        this.labelISOCode.set(labelISOCode);
    }

    public StringProperty labelImageURLProperty() {
        return labelImageURL;
    }

    public void setLabelImageURL(String labelImageURL) {
        this.labelImageURL.set(labelImageURL);
    }

    public StringProperty checkboxVisitedProperty() {
        return checkboxVisited;
    }

    public void setCheckboxVisited(String checkboxVisited) {
        this.checkboxVisited.set(checkboxVisited);
    }

    public StringProperty columnIDProperty() {
        return columnID;
    }

    public void setColumnID(String columnID) {
        this.columnID.set(columnID);
    }

    public StringProperty columnCategoryProperty() {
        return columnCategory;
    }

    public void setColumnCategory(String columnCategory) {
        this.columnCategory.set(columnCategory);
    }

    public StringProperty columnRegionProperty() {
        return columnRegion;
    }

    public void setColumnRegion(String columnRegion) {
        this.columnRegion.set(columnRegion);
    }

    public StringProperty columnStatesProperty() {
        return columnStates;
    }

    public void setColumnStates(String columnStates) {
        this.columnStates.set(columnStates);
    }

    public StringProperty columnSiteProperty() {
        return columnSite;
    }

    public void setColumnSite(String columnSite) {
        this.columnSite.set(columnSite);
    }
}
