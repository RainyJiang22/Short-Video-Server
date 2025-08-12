package com.rainy.video.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.rainy.video.mock.comments.CommentJsonParse;
import com.rainy.video.mock.feeds.HotJsonParse;
import com.rainy.video.okhttp.OkhttpUtil;
import com.rainy.video.service.comment.CommentService;
import com.rainy.video.service.feeds.FeedsService;
import com.rainy.video.service.user.UserService;
import com.rainy.video.table.TableFeedsComment;
import com.rainy.video.table.TableHotFeeds;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.net.URI;
import java.util.Calendar;
import java.util.List;

/**
 * @author Jacky
 * @date 2025/8/12
 **/

@RestController
@RequestMapping(value = "/mock")
@Api(value = "数据库各个表的数据mock控制器")
public class MockFeedsController {
    @Autowired
    private FeedsService feedsService;

    @Autowired
    CommentService commentService;

    @Autowired
    UserService userService;

    @Autowired
    OkhttpUtil okHttpUtil;

    @RequestMapping(value = "/insertHotFeeds", method = RequestMethod.GET)
    @ApiOperation(value = "table_hot_feeds表插入数据")
    @JsonView(value = {TableHotFeeds.class})
    public int insertHotFeeds() {
        TableHotFeeds hotFeeds = HotJsonParse.parseFeedsJson();
        if (hotFeeds == null) {
            return 0;
        }
//        hotFeeds.cover = downloadFile(hotFeeds.cover, 1);
//        hotFeeds.url = downloadFile(hotFeeds.url, 2);
        feedsService.saveOrUpdate(hotFeeds);

        if (hotFeeds.author != null) {
            //hotFeeds.author.avatar = downloadFile(hotFeeds.author.avatar, 1);
            userService.saveOrUpdate(hotFeeds.author);
        }
        if (hotFeeds.topComment != null) {
            commentService.saveOrUpdate(hotFeeds.topComment);
            if (hotFeeds.topComment.author != null) {
                //hotFeeds.topComment.author.avatar = downloadFile(hotFeeds.topComment.author.avatar, 1);
                userService.saveOrUpdate(hotFeeds.topComment.author);
            }
        }

        List<TableFeedsComment> comments = CommentJsonParse.parseCommentJson(hotFeeds.itemId);
        for (TableFeedsComment comment : comments) {
            commentService.saveOrUpdate(comment);

            //comment.author.avatar = downloadFile(comment.author.avatar, 1);
            userService.saveOrUpdate(comment.author);
        }
        return 1;

    }


    private String downloadFile(String url, int type) {
        if (url == null) {
            return null;
        }
        if (url.contains("\\u0026")) {
            url = url.replace("\\u0026", "&");
        }
        System.out.println("downLoadFile:" + url);
        int start = url.lastIndexOf("/") + 1;
        int end = url.indexOf("~");
        String fileName = null;
        if (end > start) {
            fileName = url.substring(start, end);
        } else {
            String[] split = URI.create(url).getPath().split("/");
            fileName = split[split.length - 1];
        }

        int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        File parent = new File("/Users/rainy/Documents/jetpack2023/素材" + month + "_" + day);
        if (!parent.exists()) {
            parent.mkdirs();
        }
        File file = new File(parent, fileName + (type == 1 ? ".png" : ".mp4"));
        String loadFile = okHttpUtil.downloadFile(url, file.getAbsolutePath());
        return "https://jetpack2023.oss-cn-shanghai.aliyuncs.com/" + file.getName();
    }

}
