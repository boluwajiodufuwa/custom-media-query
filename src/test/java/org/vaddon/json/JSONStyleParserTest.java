package org.vaddon.json;

import com.vaadin.flow.component.html.Div;
import org.junit.Assert;
import org.junit.Test;

public class JSONStyleParserTest {
    @Test
    public void testJsonStyleParser() {
        Div d1 = new Div();
        d1.getStyle().set("background", "green");
        Assert.assertEquals("{\"background\":\"green\"}", new JSONStyleParser(d1.getStyle()).getJSON());

        Div d2 = new Div();
        d2.getStyle().set("background", "green");
        d2.getStyle().set("display", "none");
        Assert.assertEquals("{\"background\":\"green\",\"display\":\"none\"}", new JSONStyleParser(d2.getStyle()).getJSON());
    }
}