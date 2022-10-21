package org.vaddon;


import com.vaadin.flow.component.*;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.shared.Registration;
import org.vaddon.css.query.MediaQuery;

import java.util.function.Consumer;

@Tag("lit-media-query")
@JsModule("./lit-media-query.ts")
public class CustomMediaQuery extends Component {
    private Consumer<Boolean> action;

    public CustomMediaQuery(Consumer<Boolean> action) {
        this.action = action;
        addChangedListener(e ->
                action.accept(e.isChanged()));
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


    public Registration addChangedListener(ComponentEventListener<ChangedEvent> listener) {
        return addListener(ChangedEvent.class, listener);
    }


    @DomEvent("changed")
    public static class ChangedEvent
            extends ComponentEvent<CustomMediaQuery> {

        private boolean changed;
        public ChangedEvent(CustomMediaQuery source,
                            boolean fromClient, @EventData("event.detail.value") boolean changed) {
            super(source, fromClient);
            this.changed = changed;
        }

        public boolean isChanged() {
            return changed;
        }
    }
}
