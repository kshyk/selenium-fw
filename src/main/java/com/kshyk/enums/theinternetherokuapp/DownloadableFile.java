package com.kshyk.enums.theinternetherokuapp;

import com.kshyk.common.CommonUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DownloadableFile {
    NOT_EMPTY("not_empty.txt");

    private final String fileName;

    @Override
    public String toString() {
        return CommonUtil.capitalizeEnumName(this.name());
    }
}
