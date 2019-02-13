package org.vaddon.json;

import com.vaadin.flow.dom.Style;
import org.json.JSONObject;

public class JSONStyleParser {
    private final JSONObject object;

    public JSONStyleParser(Style style) {
        object = new JSONObject();
        style.getNames().forEach(styleName -> object.put(styleName, style.get(styleName)));
    }

    public String getJSON() {
        return object.toString();
    }
}
