package org.vaddon;


import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.templatemodel.TemplateModel;
import org.vaddon.css.query.MediaQuery;

import java.util.function.Consumer;

@Tag("custom-media-query")
@NpmPackage(value = "@polymer/iron-media-query",version = "3.0.1")
@HtmlImport("org/vaadon/custom-media-query.html")
@JsModule("custom-media-query.js")
public class CustomMediaQuery extends PolymerTemplate<CustomMediaQuery.CustomMediaQueryModel> {

    public interface CustomMediaQueryModel extends TemplateModel {
        void setQuery(String propertyValue);
        String getQuery();

        void setQuerymatches(boolean queryMatches);
        boolean getQuerymatches();
    }

    private Consumer<Boolean> action;

    public CustomMediaQuery(Consumer<Boolean> action) {
        this.action = action;
        getElement().addSynchronizedProperty("querymatches");
        getElement().addSynchronizedPropertyEvent("querymatches");
        getElement().addPropertyChangeListener("querymatches", e->
        {
            action.accept(getModel().getQuerymatches());
        });
    }

    public void setQuery(String query) {
        getModel().setQuery(query);
    }

    public void setQuery(MediaQuery query){
        setQuery(query.getCssValue());
    }

    public String getQuery() {
        return getModel().getQuery();
    }
}
