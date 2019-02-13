package org.vaddon.css.query.values;

import org.vaddon.css.query.MediaQueryUnit;

public interface MonochromeAttributes {
    class Monochrome implements MediaQueryUnit {
        private int monochrome;

        public Monochrome(int monochrome) {
            this.monochrome = monochrome;
        }

        @Override
        public String getValue() {
            return String.valueOf(monochrome);
        }

        @Override
        public boolean hasPrefix() {
            return true;
        }

        @Override
        public String getPrefixValue() {
            return "monochrome: ";
        }
    }

    class MinMonochrome extends org.vaddon.css.query.values.MonochromeAttributes.Monochrome {
        public MinMonochrome(int monochrome) {
            super(monochrome);
        }

        @Override
        public String getPrefixValue() {
            return "min-" + super.getPrefixValue();
        }
    }

    class MaxMonochrome extends org.vaddon.css.query.values.MonochromeAttributes.Monochrome {
        public MaxMonochrome(int monochrome) {
            super(monochrome);
        }

        @Override
        public String getPrefixValue() {
            return "max-" + super.getPrefixValue();
        }
    }
}

