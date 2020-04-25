package com.pg.bbs.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import com.pg.bbs.controller.FileController;
import com.pg.bbs.dao.*;
import com.pg.bbs.dto.CollectDto;
import com.pg.bbs.dto.RecommendDto;
import com.pg.bbs.entity.*;
import com.pg.bbs.handler.BusinessException;
import com.pg.bbs.service.RecommendService;
import com.pg.bbs.util.FileUtil;
import com.pg.bbs.util.JwtGetUserInterceptor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class RecommendServiceImpl implements RecommendService {

    private static Logger log = LoggerFactory.getLogger(FileController.class);

    @Value("${filePath}")
    private String filePath;

    @Value("${nginxPath}")
    private String nginxPath;

    @Resource
    private RecommendMapper recommendMapper;

    @Resource
    private LabelsMapper labelsMapper;

    @Resource
    private UsersMapper usersMapper;

    @Resource
    private RecommendVoteMapper recommendVoteMapper;

    @Resource
    private ChannelsMapper channelsMapper;

    @Override
    public int insert(Recommend recommend) {
        // 获取用户信息
        String userId = JwtGetUserInterceptor.getUserId();
        recommend.setUuid(UUID.randomUUID().toString().replace("-", ""));
        recommend.setUserId(userId);
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
        if (StringUtil.isEmpty(uuid)) {
            throw new BusinessException(500, "uuid必传");
        }
        Recommend recommend = recommendMapper.findById(uuid);
        List<Labels> labels = labelsMapper.findSplitData(recommend.getLabels());
        recommend.getLabelArr().addAll(labels);
        return recommend;
    }

    @Override
    public void collect(CollectDto collectDto) {
        String url;
        if (collectDto.getChannelsPath() == null && collectDto.getChannelsPath() == "") {
            url = "https://segmentfault.com/";
        } else {
            url = "https://segmentfault.com/" + collectDto.getChannelsPath();
        }
        String subUrl = "https://segmentfault.com/a/";
        String imgPath = "https://segmentfault.com";
        try {
            Document doc = Jsoup.connect(url).get();
            Elements divsBig = doc.getElementsByClass("news-item stream__item clearfix mt15");
            if (null != divsBig && divsBig.size() != 0) {
                for (int i = 0; i < divsBig.size(); i++) {
                    Recommend recommends = new Recommend();
                    // 获取title
                    Element title = divsBig.get(i).getElementsByClass("news__item-title mt0").get(0);
                    if (null != title) {
                        recommends.setTitle(title.ownText().trim());
                    }
                    int count = recommendMapper.findQueryTitle(recommends.getTitle());
                    if (count == 0) {
                        recommends.setUuid(UUID.randomUUID().toString().replace("-", ""));
                        recommends.setViewsWord(0);
                        recommends.setType(1);
                        recommends.setStatus(3);
                        recommends.setCreateTime(new Date());
                        recommends.setModifyTime(new Date());
                        recommends.setChannelsId(collectDto.getChannelsId());

                        // 随机取一个用户
                        Users users = usersMapper.randomData();
                        recommends.setUserId(users.getUuid());

                        // 获取列表展示字段
                        Element excerpt = divsBig.get(i).getElementsByClass("article-excerpt").get(0);
                        if (null != excerpt) {
                            recommends.setExcerpt(excerpt.ownText().trim());
                        }
                        // 获取封面图
                        Elements newsImg = divsBig.get(i).getElementsByClass("news-img");
                        if (null != newsImg && newsImg.size() != 0) {
                            // 获取的图片地址
                            String newsImgStyle = newsImg.attr("style");
                            String newsImgStyleSub = newsImgStyle.substring(21, newsImgStyle.length() - 1);
                            Calendar now = Calendar.getInstance();
                            String filePathNow = filePath + now.get(Calendar.YEAR) + "/" + (now.get(Calendar.MONTH) + 1) + "/" + now.get(Calendar.DATE) + "/";
                            String nginxPathNow = nginxPath + now.get(Calendar.YEAR) + "/" + (now.get(Calendar.MONTH) + 1) + "/" + now.get(Calendar.DATE) + "/";
                            String filePath = filePathNow;
                            String newFileName = UUID.randomUUID().toString().replace("-", "");
                            String fileName = newFileName + ".jpg";
                            try {
                                FileUtil.downloadImage(newsImgStyleSub, filePath, fileName);
                                recommends.setImageUrl(nginxPathNow + fileName);
                            } catch (Exception e) {
                                log.info("文件上传: file: {}", e);
                            }
                        }

                        // 详情页面数据
                        String dataId = divsBig.get(i).attr("data-id");
                        if (null != dataId) {
                            Document docOne = Jsoup.connect(subUrl + dataId).get();
                            // 富文本内容
                            Elements imgWrapList = docOne.getElementsByClass("img-wrap");
                            if (imgWrapList.size() > 0) {
                                for (int m = 0; m < imgWrapList.size(); m++) {
                                    String imgDataSrc = imgWrapList.get(m).select("img").attr("data-src");
                                    System.out.println(imgPath + imgDataSrc);
                                    Calendar now = Calendar.getInstance();
                                    String filePathNow = filePath + now.get(Calendar.YEAR) + "/" + (now.get(Calendar.MONTH) + 1) + "/" + now.get(Calendar.DATE) + "/";
                                    String nginxPathNow = nginxPath + now.get(Calendar.YEAR) + "/" + (now.get(Calendar.MONTH) + 1) + "/" + now.get(Calendar.DATE) + "/";
                                    String filePath = filePathNow;
                                    String newFileName = UUID.randomUUID().toString().replace("-", "");
                                    String fileName = newFileName + ".jpg";
                                    try {
                                        FileUtil.downloadImage(imgPath + imgDataSrc, filePath, fileName);
                                        imgWrapList.get(m).select("img").attr("src", nginxPathNow + fileName);
                                    } catch (Exception e) {
                                        log.info("文件上传: file: {}", e);
                                    }
                                }
                            }
                            String content = docOne.getElementsByClass("article fmt article-content").html();
                            recommends.setContent(content);

                            // 处理标签
                            // 首先把数据查找出来
                            Elements tagElementsList = docOne.getElementsByClass("m-n1").get(0).getElementsByClass("badge-tag");
                            // 创建StringBuffer对象
                            StringBuffer labelsList = new StringBuffer();
                            for (int t = 0; t < tagElementsList.size(); t++) {
                                // 循环数据拿到标签内容
                                String tagNameText = tagElementsList.get(t).attr("data-original-title");
                                // 把标签内容去数据库进行查询
                                Labels listNameDataData = labelsMapper.findListNameData(tagNameText);
                                if (listNameDataData == null) {
                                    // 如果没有查询到数据先创建一个labels的实体
                                    Labels labels = new Labels();
                                    labels.setUuid(UUID.randomUUID().toString().replace("-", ""));
                                    // 如果有传入对应的频道id就用传入的 没有则用频道“其它”
                                    if (collectDto.getChannelsId() == null && collectDto.getChannelsId() == "") {
                                        labels.setChannelsId("ee1accc0cfb444fa96d6811569830ecd");
                                    } else {
                                        labels.setChannelsId(collectDto.getChannelsId());
                                    }
                                    labels.setName(tagNameText);
                                    labels.setCreateTime(new Date());
                                    labels.setModifyTime(new Date());
                                    try {
                                        labelsMapper.insert(labels);
                                        labelsList.append(labels.getUuid() + ",");
                                    } catch (Exception e) {
                                        log.info("数据采集标签创建失败: label: {}", e);
                                    }
                                } else {
                                    // 如果查询到了就直接把标签的id添加到StringBuffer里面
                                    labelsList.append(listNameDataData.getUuid() + ",");
                                }
                            }
                            String labelToString = labelsList.deleteCharAt(labelsList.length() - 1).toString();
                            recommends.setLabels(labelToString);
                        }
                        try {
                            recommendMapper.insert(recommends);
                        } catch (Exception e) {
                            log.info("数据创建失败: recommendMapper: {}", e);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    @Override
    public int vote(String recommendId) {
        if (StringUtil.isEmpty(recommendId)) {
            throw new BusinessException(500, "文章或问题id必传");
        }
        // 获取用户信息
        String userId = JwtGetUserInterceptor.getUserId();
        // 判断该记录是否存在，如果不存在代表点赞，如果存在代表取消点赞
        int dataCount = 0;
        int count = recommendVoteMapper.queryFindList(recommendId, userId);
        if (count > 0) {
            recommendVoteMapper.delete(recommendId, userId);
            dataCount = count - 1;
        } else {
            RecommendVote recommendVote = new RecommendVote();
            recommendVote.setUuid(UUID.randomUUID().toString().replace("-", ""));
            recommendVote.setUserId(userId);
            recommendVote.setRecommendId(recommendId);
            recommendVoteMapper.insert(recommendVote);
            dataCount = count + 1;
        }
        return dataCount;
    }

    @Override
    public Page<Recommend> queryAll(RecommendDto recommendDto) {
        if (recommendDto.getPageSize() != null && recommendDto.getPageNum() != null) {
            PageHelper.startPage(recommendDto.getPageNum(), recommendDto.getPageSize());
        }
        Page<Recommend> pages = this.recommendMapper.queryAll(recommendDto);
        for (Recommend recommend : pages) {
            if (recommend.getLabels() != null && recommend.getLabels() != "") {
                // 循环结果集，把标签集合查询出来
                List<Labels> labelsList = labelsMapper.findSplitData(recommend.getLabels());
                recommend.getLabelArr().addAll(labelsList);
                // 巡检结果集，把点赞数量查询出来
                int voteCount = recommendVoteMapper.queryCount(recommend.getUuid());
                recommend.setVotes(voteCount);
            }
        }
        return pages;
    }

    @Override
    public void collectAll() {
        List<Channels> channels = channelsMapper.queryList();
        for (int i = 0; i < channels.size(); i++) {
            CollectDto collectDto = new CollectDto();
            if (channels.get(i).getName() == "其它") {
                collectDto.setChannelsPath("");
                collectDto.setChannelsId("");
            }
            collectDto.setChannelsId(channels.get(i).getUuid());
            collectDto.setChannelsPath("channel/" + channels.get(i).getUrl());
            this.collect(collectDto);
        }
    }
}
