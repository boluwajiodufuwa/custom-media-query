package org.vaddon;


import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.internal.StateNode;
import com.vaadin.flow.templatemodel.TemplateModel;
import org.vaddon.css.query.CustomElementStylePropertyMap;
import org.vaddon.css.query.MediaQuery;
import org.vaddon.json.JSONStyleParser;

/**
 * Allows to bind media queries directly to an element on the client side without a server round trip
 */
@Tag("client-media-query")
@NpmPackage(value = "@polymer/iron-media-query",version = "3.0.1")
@JsModule("./client-media-query.js")
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
