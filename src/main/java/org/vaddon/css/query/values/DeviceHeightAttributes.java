package org.vaddon.css.query.values;

import org.vaddon.css.query.MediaQueryUnit;

public interface DeviceHeightAttributes {
    class DeviceHeight implements MediaQueryUnit {
        private String deviceHeight;

        public DeviceHeight(String deviceHeight) {
            this.deviceHeight = deviceHeight;
        }

        @Override
        public String getValue() {
            return deviceHeight;
        }

        @Override
        public boolean hasPrefix() {
            return true;
        }

        @Override
        public String getPrefixValue() {
            return "device-height: ";
        }
    }

    class MinDeviceHeight extends DeviceHeightAttributes.DeviceHeight {
        public MinDeviceHeight(String deviceHeight) {
            super(deviceHeight);
        }

        @Override
        public String getPrefixValue() {
            return "min-" + super.getPrefixValue();
        }
    }

    class MaxDeviceHeight extends DeviceHeightAttributes.DeviceHeight {
        public MaxDeviceHeight(String deviceHeight) {
            super(deviceHeight);
        }

        @Override
        public String getPrefixValue() {
            return "max-" + super.getPrefixValue();
        }
    }
}
