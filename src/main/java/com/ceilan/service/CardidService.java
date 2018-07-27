package com.ceilan.service;

import com.ceilan.entity.Card;

public interface CardidService {
    /**
     * 查询身份证信息
     *
     * @Param [cardid]
     * @return Card
     * @Author cfa  2018-07-26
     **/
    Card queryCardidInfo(String cardid);

    /**
     * 查询地址
     *
     * @Param [postalcode]
     * @return java.lang.String
     * @Author cfa  2018-07-26
     **/
    String queryAreaByPostalCode(Integer postalcode);
}
