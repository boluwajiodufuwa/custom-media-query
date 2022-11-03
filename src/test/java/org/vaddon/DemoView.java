package org.vaddon;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.vaddon.css.query.MediaQuery;
import org.vaddon.css.query.values.WidthAttributes;

import java.util.ArrayList;
import java.util.List;

import static org.vaddon.css.query.values.WidthAttributes.*;

@Route("")
public class DemoView extends VerticalLayout {

    private final Grid<Person> grid;
    public DemoView() {

        List<Person> persons = new ArrayList<>();

        for (int i = 0; i<20; i++) {
            persons.add(new Person("name"+i, "surname"+i, "ES"));
        }

        grid = new Grid<>(Person.class);

        grid.setItems(persons);
        expand(grid);
        CustomMediaQuery customMediaQuery1200 = new CustomMediaQuery(this::toggleColumnCountry);
        CustomMediaQuery customMediaQuery800 = new CustomMediaQuery(this::toggleColumnSurname);
        add(new H1("Grid"));
        add(customMediaQuery1200, customMediaQuery800, grid);
        customMediaQuery1200.setQuery("(min-width: 1200px)");
        customMediaQuery800.setQuery("(min-width: 800px)");

        Div div = new Div();
        div.setWidth("200px");
        div.setHeight("200px");
        ClientMediaQuery clientMediaQuery1200 = new ClientMediaQuery(div);
        ClientMediaQuery clientMediaQuery800 = new ClientMediaQuery(div);
        ClientMediaQuery clientMediaQuery0 = new ClientMediaQuery(div);
        clientMediaQuery1200.setQuery(new MediaQuery(new MinWidth("1200px")));
        clientMediaQuery800.setQuery(new MediaQuery(new MinWidth("800px"),new MaxWidth("1200px")));
        clientMediaQuery0.setQuery(new MediaQuery(new MaxWidth("800px")));
        clientMediaQuery1200.getQueryStyle().set("background","green");
        clientMediaQuery800.getQueryStyle().set("background","blue");
        clientMediaQuery0.getQueryStyle().set("background","red");
        add(new H1("Client-Side-Query"));
        add(div,clientMediaQuery0,clientMediaQuery800, clientMediaQuery1200);

        Div coloredDiv = new Div();
        coloredDiv.setWidth("50%");
        coloredDiv.setHeight("200px");
        ElementMediaQuery elementMediaQuery = new ElementMediaQuery(ok -> changeColor(coloredDiv, ok));
        elementMediaQuery.setElement(coloredDiv);
        elementMediaQuery.setQuery("(min-width: 600px)");
        add(elementMediaQuery,coloredDiv);

    }

    private void changeColor(Div coloredDiv, Boolean ok) {
        if (ok) {
            coloredDiv.getStyle().set("background-color", "green");
        } else {
            coloredDiv.getStyle().set("background-color", "red");
        }
    }

    private void toggleColumnCountry(boolean visible){
        grid.getColumnByKey("country").setVisible(visible);
    }

    private void toggleColumnSurname(boolean visible){
        grid.getColumnByKey("surname").setVisible(visible);
    }


    public class Person {

        private String name;
        private String surname;
        private String country;

        public Person(String name, String surname, String country) {
            this.name = name;
            this.surname = surname;
            this.country = country;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", country='" + country + '\'' +
                    '}';
        }
    }
}
