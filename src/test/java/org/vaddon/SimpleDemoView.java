package org.vaddon;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("simple")
public class SimpleDemoView extends VerticalLayout {

    private Span display1200 = new Span("Shown if width > 1200");
    private Span display800 = new Span("Shown if width > 800");
    private Span displayAlways = new Span("Always shown");

    public SimpleDemoView() {

        add(display800,display1200,displayAlways);


        CustomMediaQuery customMediaQuery1200 = new CustomMediaQuery(this::hide1200);
        CustomMediaQuery customMediaQuery800 = new CustomMediaQuery(this::hide800);

        add(customMediaQuery1200, customMediaQuery800);
        customMediaQuery1200.setQuery("(min-width: 1200px)");
        customMediaQuery800.setQuery("(min-width: 800px)");

    }

    private void hide1200(boolean visible)
    {
        display1200.setVisible(visible);
    }

    private void hide800(boolean visible)
    {
        display800.setVisible(visible);
    }

}
