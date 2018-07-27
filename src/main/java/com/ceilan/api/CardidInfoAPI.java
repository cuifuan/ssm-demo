package com.ceilan.api;

import com.ceilan.entity.Card;
import com.ceilan.service.CardidService;
import com.ceilan.vo.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 查询身份证API
 *
 * @Param
 * @return
 * @Author cfa  2018-07-26
 **/
@RestController
public class CardidInfoAPI {

    private final CardidService cardidService;

    @Autowired
    public CardidInfoAPI(CardidService cardidService) {
        this.cardidService = cardidService;
    }

    @PostMapping("/getCardInfo")
    public ResultBean<Card> getCardInfo(@RequestBody Map map) {
//        JSONArray map= JSON.parseArray(cardid);
        System.out.println(map.toString());
        return new ResultBean<>(cardidService.queryCardidInfo(String.valueOf(map.get("cardid"))));
    }

    /**
     * 新增数据, 返回新对象的id
     *
     * @param Card
     * @return
     */
   /* @PostMapping("/add")
    public ResultBean<Long> add(Card Card) {
        return new ResultBean<Long>(CardService.add(Card));
    }*/

    /**
     * 根据id删除对象
     *
     * @param id
     * @return
     */
 /*   @PostMapping("/delete")
    public ResultBean<Boolean> delete(long id) {
        return new ResultBean<Boolean>(CardService.delete(id));
    }*/

   /* @PostMapping("/update")
    public ResultBean<Boolean> update(Card Card) {
        CardService.update(Card);
        return new ResultBean<Boolean>(true);
    }*/
}