package com.example.springnavigatordemo.ui;

import com.example.springnavigatordemo.SpringnavigatordemoApplication;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.DefaultErrorHandler;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Theme("valo")
@SpringUI
@SpringViewDisplay
public class AppUI extends UI implements ViewDisplay {

    private Panel springViewPanel;
    private Logger log = LoggerFactory.getLogger(AppUI.class);

    @Override
    protected void init(VaadinRequest request) {
        VerticalLayout root = new VerticalLayout();
        setContent(root);

        CssLayout menuBar = new CssLayout();
        menuBar.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
        menuBar.addComponent(createNavigationButton("Default", Default.VIEW_NAME));
        menuBar.addComponent(createNavigationButton("ScopedView", ScopedView.VIEW_NAME));
        springViewPanel = new Panel();
        springViewPanel.setSizeFull();

        root.addComponents(menuBar, springViewPanel);
        root.setExpandRatio(springViewPanel, 1);

        setErrorHandler(event -> {
            Throwable t = DefaultErrorHandler.findRelevantThrowable(event.getThrowable());
            log.error("Error during request", t);
        });

        getUI().getNavigator().navigateTo("default");

    }

    private Button createNavigationButton(String caption, final String viewName) {
        return new Button(caption,
                event -> getUI().getNavigator().navigateTo(viewName));
    }

    @Override
    public void showView(View view) {
        springViewPanel.setContent((Component) view);

    }
}
