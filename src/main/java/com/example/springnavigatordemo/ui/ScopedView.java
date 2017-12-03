package com.example.springnavigatordemo.ui;

import com.example.springnavigatordemo.model.Person;
import com.example.springnavigatordemo.repository.PersonRepository;
import com.example.springnavigatordemo.service.PersonService;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringView
@UIScope
public class ScopedView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "scoped";

    @Autowired
    PersonService service;

    public ScopedView() {
    }

    @PostConstruct
    private void init(){
        addComponent(new Label("Scoped View"));

        List<Person> list = service.getAllPersons();
        Grid<Person> grid = new Grid<>(Person.class);
        grid.setItems(list);
        grid.setColumnOrder("id", "firstName", "lastName");

        addComponent(grid);

    }
}
