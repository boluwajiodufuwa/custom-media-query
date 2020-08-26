package org.vaddon;

import com.vaadin.flow.component.ClientCallable;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import org.vaddon.css.query.MediaQuery;

import java.util.function.Consumer;

/**
 * Observe an element add if the media query condition is changing
 *
 * @author jcgueriaud
 */
@Tag("element-media-query")
@JsModule("./element-media-query.js")
@NpmPackage(value = "element-match-media",version = "0.0.3")
public class ElementMediaQuery extends Component {

    private Consumer<Boolean> action;

    public ElementMediaQuery(Consumer<Boolean> action) {
        this.action = action;
    }
    public void setElement(Component component) {
        getElement().callJsFunction("setElement", component.getElement());
    }

    public void setQuery(String query) {
        getElement().callJsFunction("setQuery", query);
    }

    public void setQuery(MediaQuery query) {
        setQuery(query.getCssValue());
    }

    @ClientCallable
    private void querymatchesChanged(Boolean querymatches) {
        action.accept(querymatches);
    }
}
