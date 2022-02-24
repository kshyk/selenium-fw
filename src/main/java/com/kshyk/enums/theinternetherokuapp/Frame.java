package com.kshyk.enums.theinternetherokuapp;

import com.kshyk.common.CommonUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Frame {
    TOP("frame-top"),
    BOTTOM("frame-bottom"),
    LEFT("frame-left"),
    RIGHT("frame-right"),
    MIDDLE("frame-middle");

    @Getter
    private final String position;

    @Override
    public String toString() {
        return CommonUtil.capitalizeEnumName(this.name());
    }
}
