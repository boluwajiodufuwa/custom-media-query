package org.vaddon;


import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.internal.StateNode;
import org.vaddon.css.query.CustomElementStylePropertyMap;
import org.vaddon.css.query.MediaQuery;
import org.vaddon.json.JSONStyleParser;

/**
 * Allows to bind media queries directly to an element on the client side without a server round trip
 */
@Tag("client-media-query")
@JsModule("./client-media-query.ts")
public class ClientMediaQuery extends Component {
    private CustomElementStylePropertyMap queryStyle;

    public ClientMediaQuery(Component component) {
        setElement(component);
        StateNode stateNode = new StateNode();
        queryStyle = new CustomElementStylePropertyMap(stateNode);
        queryStyle.addChangeListener(style -> {
            getElement().setProperty("queryCss", new JSONStyleParser(style).getJSON());
        });
    }

    public void setElement(Component component) {
        getElement().callJsFunction("setElement", component.getElement());
    }

    public Style getQueryStyle() {
        return queryStyle.getStyle();
    }

    public void setQuery(String query) {
        getElement().setProperty("query", query);
    }

    public void setQuery(MediaQuery query){
        setQuery(query.getCssValue());
    }

    public String getQuery() {
        return getElement().getProperty("query");
    }

}
