package ch.fhnw.oop2.heritagesites.presentationModel;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class HeritageSiteResultsPM {
    private static final String FILE_NAME = "/data/heritage_sites.csv";
    private static final String DELIMITER = ";";

    public final MultiLanguagePM languagePM;
    private final IntegerProperty selectedHeritageSiteId = new SimpleIntegerProperty(-1);
    private final LongProperty numberOfVisitedHeritageSites = new SimpleLongProperty(0);
    private final LongProperty numberOfVisitedCountries = new SimpleLongProperty(0);
    private final ObservableList<HeritageSitePM> allHeritageSites = FXCollections.observableArrayList();

    private List<String> listOfVisitedCountries = new ArrayList<>();
    private List<String> listOfVisitedHeritageSites = new ArrayList<>();

    private final HeritageSitePM heritageSiteProxy = new HeritageSitePM();


    public HeritageSiteResultsPM() {
        languagePM = new MultiLanguagePM();
        allHeritageSites.addAll(readFromFile());
        setNumberOfVisitedHeritageSites(visitedHeritageSites().size());
        setNumberOfVisitedCountries(visitedCountries().size());
        selectedHeritageSiteIdProperty().addListener(((observable, oldValue, newValue) -> {
            HeritageSitePM oldSelection = getHeritageSite(oldValue.intValue());
            HeritageSitePM newSelection = getHeritageSite(newValue.intValue());

            if (oldSelection != null) {
                unbindFromProxy(oldSelection);
            }

            if (newSelection != null) {
                bindToProxy(newSelection);
            }
        }));
    }

    public HeritageSitePM getHeritageSiteProxy() {
        return heritageSiteProxy;
    }

    private void bindToProxy(HeritageSitePM heritageSitePM) {
        heritageSiteProxy.categoryProperty().bindBidirectional(heritageSitePM.categoryProperty());
        heritageSiteProxy.dateInscribedProperty().bindBidirectional(heritageSitePM.dateInscribedProperty());
        heritageSiteProxy.idProperty().bindBidirectional(heritageSitePM.idProperty());
        heritageSiteProxy.imageURLProperty().bindBidirectional(heritageSitePM.imageURLProperty());
        heritageSiteProxy.codeISOProperty().bindBidirectional(heritageSitePM.codeISOProperty());
        heritageSiteProxy.locationProperty().bindBidirectional(heritageSitePM.locationProperty());
        heritageSiteProxy.regionProperty().bindBidirectional(heritageSitePM.regionProperty());
        heritageSiteProxy.shortDescriptionProperty().bindBidirectional(heritageSitePM.shortDescriptionProperty());
        heritageSiteProxy.siteProperty().bindBidirectional(heritageSitePM.siteProperty());
        heritageSiteProxy.statesProperty().bindBidirectional(heritageSitePM.statesProperty());
        heritageSiteProxy.visitedProperty().bindBidirectional(heritageSitePM.visitedProperty());
    }

    private void unbindFromProxy(HeritageSitePM heritageSitePM) {
        heritageSiteProxy.categoryProperty().unbindBidirectional(heritageSitePM.categoryProperty());
        heritageSiteProxy.dateInscribedProperty().unbindBidirectional(heritageSitePM.dateInscribedProperty());
        heritageSiteProxy.idProperty().unbindBidirectional(heritageSitePM.idProperty());
        heritageSiteProxy.imageURLProperty().unbindBidirectional(heritageSitePM.imageURLProperty());
        heritageSiteProxy.codeISOProperty().unbindBidirectional(heritageSitePM.codeISOProperty());
        heritageSiteProxy.locationProperty().unbindBidirectional(heritageSitePM.locationProperty());
        heritageSiteProxy.regionProperty().unbindBidirectional(heritageSitePM.regionProperty());
        heritageSiteProxy.shortDescriptionProperty().unbindBidirectional(heritageSitePM.shortDescriptionProperty());
        heritageSiteProxy.siteProperty().unbindBidirectional(heritageSitePM.siteProperty());
        heritageSiteProxy.statesProperty().unbindBidirectional(heritageSitePM.statesProperty());
        heritageSiteProxy.visitedProperty().unbindBidirectional(heritageSitePM.visitedProperty());
    }

    private HeritageSitePM getHeritageSite(int id) {
        return allHeritageSites.stream()
            .filter(heritageSitePM -> heritageSitePM.getId() == id)
            .findAny()
            .orElse(null);
    }

    private List<HeritageSitePM> readFromFile() {
        try (BufferedReader reader = getReader(FILE_NAME)) {
            return reader.lines()
                .skip(1)
                .map(line -> new HeritageSitePM(line.split(DELIMITER, 20)))
                .collect(Collectors.toList());
        } catch (IOException e) {
            throw new IllegalArgumentException("Reading from file " + getReader(FILE_NAME) + " failed");
        }
    }

    private BufferedReader getReader(String fileName) {
        InputStream inputStream = getClass().getResourceAsStream(fileName);
        assert inputStream != null;
        InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        return new BufferedReader(reader);
    }

    public void addNewElement() {
        HeritageSitePM newElement = new HeritageSitePM();
        newElement.setId(getHighestId() + 1);
        allHeritageSites.add(newElement);
    }

    public void deleteSelectedElement() {
        allHeritageSites.remove(getHeritageSite(selectedHeritageSiteId.get()));
    }

    public void save() {
        try (BufferedWriter writer = getWriter(FILE_NAME)) {
            writer.write(
                "Category;Date inscribed;ID;Image URL;Code ISO;Location;Region;Short Description;Site;States;;;;");
            writer.newLine();
            allHeritageSites.stream()
                .map(result -> result.infoAsLine(DELIMITER))
                .forEach(line -> {
                    try {
                        writer.write(line);
                        writer.newLine();
                    } catch (IOException e) {
                        throw new IllegalStateException(e);
                    }
                });
        } catch (IOException e) {
            throw new IllegalStateException("save failed");
        }
    }

    public List<HeritageSitePM> visitedHeritageSites() {
        return allHeritageSites.stream()
            .filter(HeritageSitePM::isVisited)
            .collect(Collectors.toList());
    }

    public List<String> visitedCountries() {
        return visitedHeritageSites().stream()
            .map(HeritageSitePM::getStates)
            .distinct()
            .collect(Collectors.toList());
    }


    private BufferedWriter getWriter(String fileName) {
        try {
            String file = Objects.requireNonNull(getClass().getResource(fileName)).getFile();
            return new BufferedWriter(new FileWriter(file, StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new IllegalStateException("File " + fileName + " is wrong");
        }
    }

    public int getHighestId() {
        return allHeritageSites.stream()
            .map(HeritageSitePM::getId)
            .max(Integer::compare)
            .get();
    }

    public void setLanguage(MultiLanguagePM.Language lang) {
        languagePM.setLanguage(lang);
    }

    public ObservableList<HeritageSitePM> getAllHeritageSites() {
        return allHeritageSites;
    }

    public long getNumberOfVisitedHeritageSites() {
        return numberOfVisitedHeritageSites.get();
    }

    public LongProperty numberOfVisitedHeritageSitesProperty() {
        return numberOfVisitedHeritageSites;
    }

    public void setNumberOfVisitedHeritageSites(long numberOfVisitedHeritageSites) {
        this.numberOfVisitedHeritageSites.set(numberOfVisitedHeritageSites);
    }

    public long getNumberOfVisitedCountries() {
        return numberOfVisitedCountries.get();
    }

    public LongProperty numberOfVisitedCountriesProperty() {
        return numberOfVisitedCountries;
    }

    public void setNumberOfVisitedCountries(long numberOfVisitedCountries) {
        this.numberOfVisitedCountries.set(numberOfVisitedCountries);
    }

    public int getSelectedHeritageSiteId() {
        return selectedHeritageSiteId.get();
    }

    public IntegerProperty selectedHeritageSiteIdProperty() {
        return selectedHeritageSiteId;
    }

    public void setSelectedHeritageSiteId(int selectedHeritageSiteId) {
        this.selectedHeritageSiteId.set(selectedHeritageSiteId);
    }

    public List<String> getListOfVisitedCountries() {
        return listOfVisitedCountries;
    }

    public void setListOfVisitedCountries(List<String> listOfVisitedCountries) {
        this.listOfVisitedCountries = listOfVisitedCountries;
    }

    public List<String> getListOfVisitedHeritageSites() {
        return listOfVisitedHeritageSites;
    }

    public void setListOfVisitedHeritageSites(List<String> listOfVisitedHeritageSites) {
        this.listOfVisitedHeritageSites = listOfVisitedHeritageSites;
    }
}
