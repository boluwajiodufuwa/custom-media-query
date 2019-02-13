package org.vaddon.css.query.values;

import org.vaddon.css.query.MediaQueryUnit;

public interface DeviceAspectRatioAttributes {
    class DeviceAspectRatio implements MediaQueryUnit {

        private final int width;
        private final int height;

        public DeviceAspectRatio(int width, int height) {
            this.width = width;
            this.height = height;
        }

        @Override
        public String getValue() {
            return width + "/" + height;
        }

        @Override
        public boolean hasPrefix() {
            return true;
        }

        @Override
        public String getPrefixValue() {
            return "device-aspect-ratio: ";
        }
    }

    class MinDeviceAspectRatio extends org.vaddon.css.query.values.DeviceAspectRatioAttributes.DeviceAspectRatio {
        public MinDeviceAspectRatio(int width, int height) {
            super(width, height);
        }

        @Override
        public String getPrefixValue() {
            return "min-" + super.getPrefixValue();
        }
    }

    class MaxDeviceAspectRatio extends org.vaddon.css.query.values.DeviceAspectRatioAttributes.DeviceAspectRatio {
        public MaxDeviceAspectRatio(int width, int height) {
            super(width, height);
        }

        @Override
        public String getPrefixValue() {
            return "max-" + super.getPrefixValue();
        }
    }
}
