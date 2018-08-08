package org.chinaos.model;

import lombok.Data;

import java.io.Serializable;
/**
 * 
 *
 * @Param 
 * @return 
 * @Author cfa  2018-07-31 
 **/
@Data
public class Role implements Serializable {

    private Integer id;

    private String type;

    private String description;
}