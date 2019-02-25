package org.vaddon.css.query;

public interface HasCssValue {

    default String getCssValue() {
        return (hasPrefix() ? getPrefixValue() : "") + getValue() + (hasSuffix() ? getSuffixValue() : "");
    }

    default boolean hasPrefix() {
        return false;
    }

    default String getPrefixValue() {
        return null;
    }

    default String getValue() {
        return null;
    }

    default boolean hasSuffix() {
        return false;
    }

    default String getSuffixValue() {
        return null;
    }
}
