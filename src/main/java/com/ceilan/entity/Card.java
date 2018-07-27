package com.ceilan.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Card {
    private String cardid;

    private Integer code;

    private String address;

    private String ip;

    private Integer age;

    private String birthday;

    private String sex;

    private String message;
}
