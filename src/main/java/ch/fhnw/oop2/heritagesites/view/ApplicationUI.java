package ch.fhnw.oop2.heritagesites.view;

import ch.fhnw.oop2.heritagesites.presentationModel.HeritageSiteResultsPM;
import javafx.scene.layout.BorderPane;

public class ApplicationUI extends BorderPane {

    private HeaderUI headerUI;
    private MainUI mainUI;
    private FooterUI footerUI;

    public ApplicationUI() {
        initializeControls();
        layoutControls();
    }

    private void initializeControls() {
        HeritageSiteResultsPM heritageSiteResultsPM = new HeritageSiteResultsPM();

        headerUI = new HeaderUI(heritageSiteResultsPM);
        mainUI = new MainUI(heritageSiteResultsPM);
        footerUI = new FooterUI(heritageSiteResultsPM);

    }

    private void layoutControls() {
        setTop(headerUI);
        setCenter(mainUI);
        setBottom(footerUI);
    }
}
