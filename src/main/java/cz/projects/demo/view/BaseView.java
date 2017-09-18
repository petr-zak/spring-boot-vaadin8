package cz.projects.demo.view;

import com.vaadin.navigator.View;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

public class BaseView extends CssLayout implements View {
    public BaseView() {
        this.setWidth(100,Unit.PERCENTAGE);

        Label label = new Label("This is " + getName() + ".");
        label.setSizeUndefined();

        HorizontalLayout horizontalLayout = new HorizontalLayout(label);
        horizontalLayout.setComponentAlignment(label, Alignment.MIDDLE_CENTER);
        horizontalLayout.setWidth(100,Unit.PERCENTAGE);

        addComponent(horizontalLayout);
    }

    public String getName() {
        return getClass().getSimpleName();
    }
}
