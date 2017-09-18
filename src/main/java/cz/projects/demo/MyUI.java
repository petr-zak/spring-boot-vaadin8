package cz.projects.demo;

import javax.servlet.annotation.WebServlet;

import com.github.appreciated.builder.DrawerVariant;
import com.github.appreciated.builder.NavigationDrawerBuilder;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.themes.ValoTheme;
import cz.projects.demo.view.*;

import java.awt.*;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
@SpringUI
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setContent(NavigationDrawerBuilder.get()
                .withVariant(DrawerVariant.LEFT_OVERLAY)
                .withTitle("Basic App Layout Demo")
                .withAppBarElement(getBorderlessButtonWithIcon(VaadinIcons.ELLIPSIS_DOTS_V))
                .withDefaultNavigationView(HomeView.class)
                .withNavigationElement("Home", VaadinIcons.HOME, HomeView.class)
                .withNavigationElement("Charts", VaadinIcons.SPLINE_CHART, new ChartsView())
                .withNavigationElement("Contact", VaadinIcons.CONNECT, ContactView.class)
                .withSection("More")
                .withNavigationElement("More", VaadinIcons.PLUS, MoreView.class)
                .withNavigationElement("Menu", VaadinIcons.MENU, MenuView.class)
                .withNavigationElement("Elements", VaadinIcons.LIST, ElementsView.class)
                .withSection("Settings")
                .withNavigationElement("Preferences", VaadinIcons.COG, PreferencesView.class)
                .build());
    }

    private Button getBorderlessButtonWithIcon(VaadinIcons icon) {
        Button button = new Button(icon);
        button.addStyleNames(ValoTheme.BUTTON_BORDERLESS);
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                Notification.show("Settings clicked.");
            }
        });
        return button;
    }
    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
