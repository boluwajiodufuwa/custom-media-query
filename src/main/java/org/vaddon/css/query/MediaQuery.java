package org.vaddon.css.query;

import java.util.Arrays;

public class MediaQuery implements HasCssValue {

    private MediaQueryUnit[] queries;

    public MediaQuery(MediaQueryUnit... queries) {
        this.queries = queries;
    }

    @Override
    public String getValue() {
        return Arrays.stream(queries)
                .map(HasCssValue::getCssValue)
                .map(s -> "(" + s + ")")
                .reduce((unit, unit2) -> unit + " and " + unit2)
                .orElse("");
    }
}
