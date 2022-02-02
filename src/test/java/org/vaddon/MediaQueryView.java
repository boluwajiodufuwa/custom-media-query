package org.vaddon;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.vaddon.css.query.MediaQuery;
import org.vaddon.css.query.values.WidthAttributes;

/**
 * @author jcgueriaud
 */
/**Change the color of a div is the window size < 1024px and div width < 300px **/
@Route("mediaquery")
public class MediaQueryView extends VerticalLayout {

    private boolean div300pxOrLess = false;
    private boolean window1024OrLess = false;
    private Div div;
    private Span textWindow;
    private Span textDiv;

    public MediaQueryView() {
        setSizeFull();
        div = new Div();
        div.setWidth("50%");
        div.setHeight("100px");
        textWindow = new Span("window1024OrLess");
        textDiv = new Span("div300pxOrLess");
        add(div, textWindow, textDiv);
        CustomMediaQuery customMediaQuery1024 = new CustomMediaQuery(this::updateWindows1024OrLess);
        add(customMediaQuery1024);
        customMediaQuery1024.setQuery(new MediaQuery(new WidthAttributes.MaxWidth("1024px")));
        ElementMediaQuery elementMediaQuery300 = new ElementMediaQuery(this::updateDiv300OrLess);
        elementMediaQuery300.setElement(div);
        elementMediaQuery300.setQuery(new MediaQuery(new WidthAttributes.MaxWidth("300px")));
        add(elementMediaQuery300);
    }

    private void updateWindows1024OrLess(Boolean window1024OrLess) {
        this.window1024OrLess = window1024OrLess;
        textWindow.setVisible(window1024OrLess);
        updateCondition();
    }

    private void updateDiv300OrLess(Boolean div300pxOrLess) {
        this.div300pxOrLess = div300pxOrLess;
        textDiv.setVisible(div300pxOrLess);
        updateCondition();
    }
    private void updateCondition() {
        if (window1024OrLess && div300pxOrLess) {
            div.getStyle().set("background-color", "green");
        } else {
            div.getStyle().set("background-color", "red");
        }
    }

}
