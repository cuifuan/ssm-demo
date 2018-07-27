package com.ceilan.service.impl;

import com.ceilan.dao.AreaMapper;
import com.ceilan.entity.Card;
import com.ceilan.service.CardidService;
import com.ceilan.vo.ResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardidServiceImpl implements CardidService {
    private static final Logger logger = LoggerFactory.getLogger(CardidServiceImpl.class);

    private final AreaMapper areaMapper;

    @Autowired
    public CardidServiceImpl(AreaMapper areaMapper) {
        this.areaMapper = areaMapper;
    }

    /**
     * 查询身份证信息
     *
     * @return com.ceilan.vo.ResultBean
     * @Param []
     * @Author cfa  2018-07-26
     **/
    @Override
    public Card queryCardidInfo(String cardid) {
        Card card = new Card();
        try {
            String address = areaMapper.queryAreaByPostalCode(Integer.valueOf(cardid.substring(0, 6)));
            if (address == null) {
                address = areaMapper.queryAreaByPostalCode(Integer.valueOf(cardid.substring(0, 4)));
                if (address == null) {
                    address = areaMapper.queryAreaByPostalCode(Integer.valueOf(cardid.substring(0, 2)));
                }
            }
            String isSex = Integer.valueOf(cardid.substring(14, 17)) % 2 != 0 ? "男" : "女";
            card.setSex(isSex);
            card.setAddress(address);
            String birthday = cardid.substring(6, 10) + "-" + cardid.substring(10, 12) + "-" + cardid.substring(12, 14);
            card.setBirthday(birthday);
            card.setCode(ResultBean.SUCCESS);
            card.setAge(2018-Integer.valueOf(cardid.substring(6, 10)));
        } catch (Exception e) {
            logger.error("查询身份证API出错 error:" + e.getMessage());
            card.setCode(ResultBean.FAIL);
            return card;
        }
        return card;
    }

    /**
     * 查询身份证地址
     *
     * @return java.lang.String
     * @Param [postalcode]
     * @Author cfa  2018-07-26
     **/
    @Override
    public String queryAreaByPostalCode(Integer postalcode) {
        return areaMapper.queryAreaByPostalCode(postalcode);
    }
}
