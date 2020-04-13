package com.pg.bbs.service.impl;

import com.github.pagehelper.util.StringUtil;
import com.pg.bbs.dao.RecommendMapper;
import com.pg.bbs.entity.Recommend;
import com.pg.bbs.handler.BusinessException;
import com.pg.bbs.service.RecommendService;
import com.pg.bbs.util.JwtGetUserInterceptor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@Service
public class RecommendServiceImpl implements RecommendService {

    @Resource
    private RecommendMapper recommendMapper;

    @Override
    public int insert(Recommend recommend) {
        // 获取用户信息
        String userId = JwtGetUserInterceptor.getUserId();
        recommend.setUuid(UUID.randomUUID().toString().replace("-", ""));
        recommend.setUserId(userId);
        recommend.setVotes(0);
        recommend.setViewsWord(0);
        recommend.setCreateTime(new Date());
        recommend.setModifyTime(new Date());
        return recommendMapper.insert(recommend);
    }

    @Override
    public int update(Recommend recommend) {
        if (StringUtil.isEmpty(recommend.getUuid())) {
            throw new BusinessException(500, "uuid必传");
        }
        recommend.setModifyTime(new Date());
        return recommendMapper.update(recommend);
    }

    @Override
    public void collect() {
        String url = "https://segmentfault.com/";
        try {
            ArrayList<Recommend> arrayList = new ArrayList<>();
            Document doc = Jsoup.connect(url).get();
            Elements divsBig = doc.getElementsByClass("news-item stream__item clearfix mt15");
            for (int i = 0; i < divsBig.size(); i++) {
                Recommend recommends = new Recommend();
                // 获取title
                recommends.setTitle(divsBig.get(i).getElementsByClass("news__item-title mt0").get(0).ownText());
                // 获取列表展示字段
                recommends.setExcerpt(divsBig.get(i).getElementsByClass("article-excerpt").get(0).ownText());
                // 获取封面图
                Element newsImg = divsBig.get(i).getElementsByClass("news-img").get(0);
                if(newsImg!=null){
                    String newsImgStyle = newsImg.attr("style");
                    String newsImgStyleSub = newsImgStyle.substring(21, newsImgStyle.length() - 1);
                    recommends.setImageUrl(newsImgStyleSub);
                }





                System.out.println(recommends.toString()+"\n");
            }

        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
