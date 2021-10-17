package com.vodafone.iotdevices.enums;

public enum SimCardStatusEnum {

    ACTIVE("Active"),
    WAITING_FOR_ACTIVATION("Waiting for activation"),
    BLOCKED("Blocked"),
    DEACTIVATED("Deactivated"),
    READY("Ready");

    private final String value;

    SimCardStatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static boolean isValid(String value) {
        return getSimCardStatusEnum(value) != null;
    }

    public static SimCardStatusEnum getSimCardStatusEnum(String value) {
        for (SimCardStatusEnum statusEnum : SimCardStatusEnum.values()) {
            if (statusEnum.getValue().equals(value)) {
                return statusEnum;
            }
        }
        return null;
    }
}
