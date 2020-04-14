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
    public Recommend findById(String uuid) {
        return recommendMapper.findById(uuid);
    }

    @Override
    public void collect() {
        String url = "https://segmentfault.com/";
        String subUrl = "https://segmentfault.com/a/";
        try {
            ArrayList<Recommend> arrayList = new ArrayList<>();
            Document doc = Jsoup.connect(url).get();
            Elements divsBig = doc.getElementsByClass("news-item stream__item clearfix mt15");
            if (null != divsBig && divsBig.size() != 0) {
                for (int i = 0; i < divsBig.size(); i++) {
                    Recommend recommends = new Recommend();

                    recommends.setUuid(UUID.randomUUID().toString().replace("-", ""));
                    recommends.setVotes(0);
                    recommends.setViewsWord(0);
                    recommends.setType(1);
                    recommends.setCreateTime(new Date());
                    recommends.setModifyTime(new Date());

                    // 获取title
                    Element title = divsBig.get(i).getElementsByClass("news__item-title mt0").get(0);
                    if (null != title) {
                        recommends.setTitle(title.ownText().trim());
                    }
                    // 获取列表展示字段
                    Element excerpt = divsBig.get(i).getElementsByClass("article-excerpt").get(0);
                    if (null != excerpt) {
                        recommends.setExcerpt(excerpt.ownText().trim());
                    }
                    // 获取封面图
                    Elements newsImg = divsBig.get(i).getElementsByClass("news-img");
                    if (null != newsImg && newsImg.size() != 0) {
                        String newsImgStyle = newsImg.attr("style");
                        String newsImgStyleSub = newsImgStyle.substring(21, newsImgStyle.length() - 1);
                        recommends.setImageUrl(newsImgStyleSub);
                    }

                    // 富文本内容
                    String dataId = divsBig.get(i).attr("data-id");
                    if(null != dataId) {
                        Document docOne = Jsoup.connect(subUrl+dataId).get();
                        String content = docOne.getElementsByClass("article fmt article-content").html();
                        // recommends.setContent(content);
                    }

                    int count = recommendMapper.findQueryTitle(recommends.getTitle());
                    if (count == 0) {
                        recommendMapper.insert(recommends);
                    }

                    System.out.println(recommends.toString() + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
