/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.client.web.template;

import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.service.ApplicationContext;
import com.vaadin.terminal.ExternalResource;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.Reindeer;
import java.io.Serializable;
import zm.hashcode.vault.app.data.ClientDataService;
import zm.hashcode.vault.client.web.VaultMain;
import zm.hashcode.vault.infrastructure.util.authentication.GetUserCredentials;
import zm.hashcode.vault.model.people.Users;


/**
 *
 * @author boniface
 */
public class Header implements Serializable {

    private static ClientDataService data = new ClientDataService();
    private VaultMain main;
    private final String username = new GetUserCredentials().username();
    private ApplicationContext ctx;

    public Header(VaultMain app) {
        this.main = app;

    }

    public Layout getHeader() {
        HorizontalLayout header = new HorizontalLayout();
        header.setWidth("100%");
        header.setMargin(true);
        header.setSpacing(true);


        CssLayout titleLayout = new CssLayout();
        final Embedded rtcLogo = new Embedded("", new ThemeResource("images/go.png"));
        rtcLogo.setHeight("100px");
        titleLayout.addComponent(rtcLogo);
        header.addComponent(titleLayout);

        HorizontalLayout toggles = new HorizontalLayout();
        toggles.setSpacing(true);
       //
        Users u = data.getUsersService().getByPropertyName("username", username);

        titleLayout = new CssLayout();
        Label user = null;
        if (u != null) {
            user = new Label("Welcome " + u.getName().getFirstname() + " " + u.getName().getLastname() + " ");
            user.setSizeUndefined();
            titleLayout.addComponent(user);
        }
        
      //  System.out.println(" THE USER NAME IS "+new GetUserCredentials().username());



        HorizontalLayout buttons = new HorizontalLayout();
        buttons.setSpacing(true);

        final Button helpButton = new Button("Help", new Button.ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                openHelpWindow();
            }
        });
        helpButton.setStyleName(Reindeer.BUTTON_SMALL);
        buttons.addComponent(helpButton);
        buttons.setComponentAlignment(helpButton, Alignment.MIDDLE_CENTER);


        final Button logout = new Button("Logout", new Button.ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                openLogoutWindow();
            }
        });
        logout.setStyleName(Reindeer.BUTTON_SMALL);
        buttons.addComponent(logout);
        titleLayout.addComponent(buttons);

        header.addComponent(titleLayout);
        header.setComponentAlignment(titleLayout, Alignment.MIDDLE_CENTER);

        final Embedded wsuLogo = new Embedded("", new ThemeResource("images/giga.png"));
        header.addComponent(wsuLogo);
        header.setComponentAlignment(wsuLogo, Alignment.MIDDLE_RIGHT);
        header.setStyleName(Reindeer.LAYOUT_BLUE);
        header.setExpandRatio(wsuLogo, 1);

        return header;
    }
    Window help = new Window("Help");

    void openHelpWindow() {
        if (!"initialized".equals(help.getData())) {
            help.setData("initialized");
            help.setCloseShortcut(KeyCode.ESCAPE, null);

            help.center();
            // help.setStyleName(Reindeer.WINDOW_LIGHT);
            help.setWidth("400px");
            help.setResizable(false);

            Label helpText = new Label(
                    "<strong>How To Use This Application</strong><p>Click around, explore. The purpose of this app is to show you what is possible to achieve with the Reindeer theme and its different styles.</p><p>Most of the UI controls that are visible in this application don't actually do anything. They are purely for show, like the menu items and the components that demostrate the different style names assosiated with the components.</p><strong>So, What Then?</strong><p>Go and use the styles you see here in your own application and make them beautiful!",
                    Label.CONTENT_XHTML);
            help.addComponent(helpText);

        }
        if (!main.getMainWindow().getChildWindows().contains(help)) {
            main.getMainWindow().addWindow(help);
        }
    }

    void openLogoutWindow() {
        Window logout = new Window("Logout");
        logout.setModal(true);
        logout.setStyleName(Reindeer.LAYOUT_BLUE);
        logout.setWidth("260px");
        logout.setResizable(false);
        logout.setClosable(false);
        logout.setDraggable(false);
        logout.setCloseShortcut(KeyCode.ESCAPE, null);

        Label helpText = new Label(
                "Are you sure you want to log out?",
                Label.CONTENT_XHTML);
        logout.addComponent(helpText);

        HorizontalLayout buttons = new HorizontalLayout();
        buttons.setSpacing(true);
        Button yes = new Button("Logout", new Button.ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                String context = main.getURL().getPath();
                context = context.substring(0, context.lastIndexOf("/app"));
                main.getMainWindow().open(new ExternalResource(context + "/j_spring_security_logout"));
            }
        });
        yes.setStyleName(Reindeer.BUTTON_DEFAULT);
        yes.focus();
        buttons.addComponent(yes);
        Button no = new Button("Cancel", new Button.ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                main.getMainWindow().removeWindow(event.getButton().getWindow());
            }
        });
        buttons.addComponent(no);

        logout.addComponent(buttons);
        ((VerticalLayout) logout.getContent()).setComponentAlignment(buttons,
                "center");
        ((VerticalLayout) logout.getContent()).setSpacing(true);

        main.getMainWindow().addWindow(logout);
    }

    class H1 extends Label {

        public H1(String caption) {
            super(caption);
            setSizeUndefined();
            setStyleName(Reindeer.LABEL_H1);
        }
    }

    class H2 extends Label {

        public H2(String caption) {
            super(caption);
            setSizeUndefined();
            setStyleName(Reindeer.LABEL_H2);
        }
    }

    class SmallText extends Label {

        public SmallText(String caption) {
            super(caption);
            setStyleName(Reindeer.LABEL_SMALL);
        }
    }
}
