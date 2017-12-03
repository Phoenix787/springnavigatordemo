package com.example.springnavigatordemo.ui;

import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;

@SpringView
public class Default extends VerticalLayout implements View {

    public static final String VIEW_NAME = "default";

    public Default() {
    }

    @PostConstruct
    private void init(){
        addComponent(new Label("Default"));
    }
}
