/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.client.web.views.addusers.views;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.VerticalLayout;
import zm.hashcode.vault.client.web.VaultMain;

/**
 *
 * @author boniface
 */
public class GetUserAccountViewPage extends VerticalLayout implements
        ClickListener, ValueChangeListener {
      private final VaultMain main;

    public GetUserAccountViewPage(VaultMain app) {
        main=app;
    }

    @Override
    public void buttonClick(ClickEvent event) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void valueChange(ValueChangeEvent event) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
