/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.client.web.template;

import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import zm.hashcode.vault.client.web.VaultMain;

/**
 *
 * @author boniface
 */
public class LandingPage extends VerticalLayout {

    private VaultMain main;
    private Form form;
    private HorizontalLayout footer;

    public LandingPage(VaultMain app) {
        


        final Embedded rtcpic = new Embedded("", new ThemeResource("rtcimages/ingImage.jpg"));


        Panel p = new Panel("Welcome To GIG VAULT BANK");


        p.setHeight("400px");
        p.addComponent(rtcpic);



        main = app;
        setSizeFull();
        setMargin(true);
        form = new Form();
        form.setImmediate(true);
        footer = new HorizontalLayout();
        footer.setSpacing(true);
        footer.setVisible(true);
        footer.setMargin(true);

        addComponent(p);
        setComponentAlignment(p, Alignment.MIDDLE_CENTER);


        addComponent(footer);
    }
}
