package com.kshyk.enums.theinternetherokuapp;

import com.kshyk.common.CommonUtil;

public enum Frame {
    TOP("frame-top"),
    BOTTOM("frame-bottom"),
    LEFT("frame-left"),
    RIGHT("frame-right"),
    MIDDLE("frame-middle");

    private final String position;

    Frame(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return CommonUtil.capitalizeEnumName(this.name());
    }
}
