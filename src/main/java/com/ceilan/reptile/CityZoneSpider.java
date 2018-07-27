package com.ceilan.reptile;

import com.ceilan.entity.Zone;
import org.apache.log4j.Logger;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.ArrayList;
import java.util.List;

public class CityZoneSpider implements PageProcessor {

    private final transient Logger logger = Logger.getLogger(CityZoneSpider.class);

    // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    @Override
    public Site getSite() {
        return site;
    }

    @Override
    public void process(Page page) {

        if (page.getUrl().toString()
                .matches("http://www.stats.gov.cn/tjsj/tjbz/xzqhdm/")) {

			/*System.out.println(page.getHtml()
					.xpath("//ul[@class='center_list_contlist']").links().all().toString());*/


            String newUrl = page.getHtml()
                    .xpath("//ul[@class='center_list_contlist']").links()
                    .all().get(0);


            page.addTargetRequest(newUrl);
            return;
        }


        List<Selectable> contentList = page.getHtml()
                .xpath("//div[@class='TRS_PreAppend']/p/b/span").nodes();
        contentList.addAll(page.getHtml()
                .xpath("//div[@class='TRS_PreAppend']/p/span").nodes());

        List<Zone> list = new ArrayList<>();
        for (int i = 0; i < contentList.size(); i++) {
            Selectable node = contentList.get(i);
            String innerHtml = node.toString();
            //判断code开始
            if(!innerHtml.contains("lang=\"EN-US\"")){
                continue;
            }
            String code = node.xpath("//span[@lang='EN-US']/text()").get().replace(" ", "");
            String text = contentList.get(i+1).xpath("//span/text()").get();

            list.add(new Zone(code,text));
            //System.out.println(code +":"+text);
            //跳过已处理的文本
            i++;
        }

        page.putField("data", list);
        logger.info("==>  zone list size is :"+ list.size());

    }

    public static void main(String[] args) {

        Spider.create(new CityZoneSpider())
                // 从"https://github.com/code4craft"开始抓
                .addUrl("http://www.stats.gov.cn/tjsj/tjbz/xzqhdm/")
                //.addPipeline(new ZonePipeline())
                // 开启1个线程抓取
                .thread(1)
                // 启动爬虫
                .run();
    }

}
