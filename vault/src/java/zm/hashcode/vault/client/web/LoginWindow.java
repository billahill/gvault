/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.client.web;

import com.vaadin.terminal.ExternalResource;
import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.Reindeer;

/**
 *
 * @author boniface
 */
class LoginWindow extends Window {

    private Button btnLogin = new Button("Login");
    private TextField login = new TextField("E-Mail Address");
    private PasswordField password = new PasswordField("Password");
    private final VerticalLayout rootPanel = new VerticalLayout();
    private final HorizontalLayout sponsors = new HorizontalLayout();
    private final HorizontalLayout header = new HorizontalLayout();
    private final Panel panel = new Panel("Please login to use the System");
    private final FormLayout form = new FormLayout();
   

    public LoginWindow() {
        super("Authentication Required !");
        setName("login");
        initUI();
    }

    private void initUI() {

        rootPanel.setSizeFull();
        rootPanel.setMargin(true);

        panel.addStyleName(Reindeer.WINDOW_LIGHT);
        panel.setWidth(Sizeable.SIZE_UNDEFINED, 0);
        form.setMargin(true);
        form.addStyleName(Reindeer.LAYOUT_BLUE);

        form.addComponent(login);
        form.addComponent(password);
        panel.setContent(form);
        panel.addComponent(btnLogin);

        rootPanel.addComponent(header);
        rootPanel.setComponentAlignment(header, Alignment.MIDDLE_CENTER);

        rootPanel.addComponent(panel);
        rootPanel.setComponentAlignment(panel, Alignment.MIDDLE_CENTER);
       
        rootPanel.addComponent(sponsors);
        rootPanel.setComponentAlignment(sponsors, Alignment.MIDDLE_CENTER);

        btnLogin.addListener(new Button.ClickListener() {

            @Override
            public void buttonClick(Button.ClickEvent event) {
                try {
                    VaultMain.getInstance().authenticate((String) login.getValue(), (String) password.getValue());
                    open(new ExternalResource(VaultMain.getInstance().getURL()));
                } catch (Exception e) {
                    showNotification("Login failed", "Bad Username or Password", Notification.TYPE_ERROR_MESSAGE);
                }
            }
        });

        addComponent(rootPanel);

    }
}