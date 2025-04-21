package com.rainy.video.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.rainy.video.ApiResponse;
import com.rainy.video.service.feeds.FeedsService;
import com.rainy.video.service.user.UserService;
import com.rainy.video.table.TableHotFeeds;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Jacky
 * @date 2025/2/20
 **/

@RestController
@RequestMapping("/feeds")
@ApiOperation(value = "贴子相关")
public class FeedsController {

    @Autowired
    FeedsService feedsService;

    @Autowired
    UserService userService;



    @ApiOperation(value = "查询帖子列表数据")
    @RequestMapping(value = "queryHotFeedsList", method = RequestMethod.GET)
    @JsonView(value = TableHotFeeds.class)
    public String queryHotFeedsList(
            @RequestParam(value = "feedType", required = false, defaultValue = "all") String feedType,
            @RequestParam(value = "userId", required = false, defaultValue = "0") Long userId,
            @RequestParam(value = "feedId", required = false, defaultValue = "0") Integer feedId,
            @RequestParam(value = "pageCount", required = false, defaultValue = "10") Integer pageCount
    ) {
        List<TableHotFeeds> feeds = feedsService.queryHotFeedsList(feedType, feedId, pageCount);
        if (feeds != null && feeds.size() > 0) {
            fillFeedsList(userId, feeds);
        }

        ApiResponse<List<TableHotFeeds>> response = new ApiResponse<>();
        response.setResult(ApiResponse.STATUS_SUCCESS, null, feeds);
        return response.toString();
    }

    private void fillFeedsList(@RequestParam("userId") Long userId, List<TableHotFeeds> list) {
        for (TableHotFeeds feed: list) {
            if (feed == null) continue;
            //todo
        }
    }
}
