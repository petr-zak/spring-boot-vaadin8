package cz.projects.demo.view;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class PreferencesView extends BaseView {
    public PreferencesView() {
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setWidth(100,Unit.PERCENTAGE);
        addComponent(verticalLayout);

        for (int i = 1; i < 50; i++) {
            verticalLayout.addComponent(new Label(String.valueOf(i)));
        }
    }
}
