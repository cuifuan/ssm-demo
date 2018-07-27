package com.ceilan.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class Zone {
    private String code;
    private String text;
    private String parentid;

    public Zone(String code, String text) {
        this.code = code;
        this.text = text;
    }
}
