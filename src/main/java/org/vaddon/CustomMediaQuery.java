package org.vaddon;


import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.templatemodel.TemplateModel;

import java.util.function.Consumer;

@Tag("custom-media-query")
@HtmlImport("org/vaadon/custom-media-query.html")
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
        getModel().setQuerymatches(true);
        getElement().addPropertyChangeListener("querymatches", e->
        {
            action.accept(getModel().getQuerymatches());
        });
    }

    public CustomMediaQuery(Consumer<Boolean> action, String query) {
        this(action);
        setQuery(query);
    }


    public void setQuery(String query) {
        getModel().setQuery(query);
        action.accept(getModel().getQuerymatches());
    }

    public String getQuery() {
        return getModel().getQuery();
    }
}
