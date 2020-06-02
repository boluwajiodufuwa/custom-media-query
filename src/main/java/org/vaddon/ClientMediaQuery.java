package org.vaddon;


import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
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
@HtmlImport("org/vaadon/client-media-query.html")
@JsModule("./client-media-query.js")
public class ClientMediaQuery extends PolymerTemplate<ClientMediaQuery.CustomMediaQueryModel> {

    public interface CustomMediaQueryModel extends TemplateModel {
        String getQuery();

        void setQuery(String propertyValue);

        String getQueryCss();

        void setQueryCss(String style);

        boolean getQuerymatches();

        void setQuerymatches(boolean queryMatches);
    }

    private CustomElementStylePropertyMap queryStyle;

    public ClientMediaQuery(Component component) {
        getModel().setQuerymatches(true);
        setElement(component);
        StateNode stateNode = new StateNode();
        queryStyle = new CustomElementStylePropertyMap(stateNode);
        queryStyle.addChangeListener(style -> {
            getModel().setQueryCss(new JSONStyleParser(style).getJSON());
        });
    }

    public void setElement(Component component) {
        getElement().callJsFunction("setElement", component.getElement());
    }

    public Style getQueryStyle() {
        return queryStyle.getStyle();
    }

    public String getQuery() {
        return getModel().getQuery();
    }

    public void setQuery(String query) {
        getModel().setQuery(query);
    }

    public void setQuery(MediaQuery query) {
        setQuery(query.getCssValue());
    }

}
