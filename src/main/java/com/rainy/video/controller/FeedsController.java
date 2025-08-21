package com.rainy.video.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.rainy.video.ApiResponse;
import com.rainy.video.service.comment.CommentService;
import com.rainy.video.service.feeds.FeedsService;
import com.rainy.video.service.ugc.UgcService;
import com.rainy.video.service.user.UserService;
import com.rainy.video.table.TableFeedsComment;
import com.rainy.video.table.TableHotFeeds;
import com.rainy.video.table.TableUser;
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

    @Autowired
    CommentService commentService;

    @Autowired
    UgcService ugcService;


    @ApiOperation(value = "查询帖子列表数据")
    @RequestMapping(value = "queryHotFeedsList", method = RequestMethod.GET)
    @JsonView(value = TableHotFeeds.class)
    public ApiResponse<List<TableHotFeeds>> queryHotFeedsList(
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
        return response;
    }

    @RequestMapping(value = "/queryProfileFeeds", method = RequestMethod.GET)
    @ApiOperation(value = "查询用户的动态帖子", notes = "根据id来查询")
    @JsonView(value = TableHotFeeds.class)
    public ApiResponse<List<TableHotFeeds>> queryProfileFeeds(@RequestParam(value = "userId", required = true) long userId,
                                                              @RequestParam(value = "pageCount", required = false, defaultValue = "10") int pageCount,
                                                              @RequestParam(value = "profileType", required = true) String profileType,
                                                              @RequestParam(value = "inId", required = true, defaultValue = "0") int inId) {

        ApiResponse<List<TableHotFeeds>> response = new ApiResponse<>();
        List<TableHotFeeds> tableHotFeeds = feedsService.queryProfileFeeds(userId, 10, profileType, inId <= 0 ? -1 : inId);
        if (tableHotFeeds != null) {
            fillFeedsList(userId, tableHotFeeds);
        }
        response.setResult(ApiResponse.STATUS_SUCCESS, null, tableHotFeeds);
        return response;
    }


    @ApiOperation(value = "发布一条新的帖子")
    @RequestMapping(value = "publish", method = RequestMethod.POST)
    @JsonView(value = TableHotFeeds.class)
    public ApiResponse<Object> publishFeed(@RequestParam(value = "feedType", required = false, defaultValue = "1") int feedType,
                                           @RequestParam(value = "userId", required = false, defaultValue = "0") Long userId,
                                           @RequestParam(value = "coverUrl", required = false, defaultValue = "") String coverUrl,
                                           @RequestParam(value = "fileUrl", required = false, defaultValue = "") String fileUrl,
                                           @RequestParam(value = "fileWidth", required = false, defaultValue = "0") int fileWidth,
                                           @RequestParam(value = "fileHeight", required = false, defaultValue = "0") int fileHeight,
                                           @RequestParam(value = "tagId", required = false, defaultValue = "0") long tagId,
                                           @RequestParam(value = "tagTitle", required = false, defaultValue = "0") String tagTitle,
                                           @RequestParam(value = "feedText", required = false, defaultValue = "0") String feedText) {

        TableHotFeeds feed = new TableHotFeeds();
        feed.itemId = System.currentTimeMillis();
        feed.itemType = coverUrl != null && fileUrl != null ? 2 : (fileUrl != null ? 1 : 0);
        feed.authorId = userId;
        if (fileUrl != null) {
            if (fileUrl.endsWith(".mp4")) {
                feed.cover = coverUrl;
                feed.url = fileUrl;
            } else {
                feed.cover = fileUrl;
            }
        }

        feed.width = fileWidth;
        feed.height = fileHeight;
        feed.activityIcon = null;
        feed.activityText = tagTitle;
        feed.feedsText = feedText;
        feed.createTime = System.currentTimeMillis();

        ApiResponse<Object> response = new ApiResponse<>();
        boolean success = feedsService.addFeed(feed);
        response.setData("result", success);
        return response;
    }

    @RequestMapping(value = "deleteFeed", method = RequestMethod.GET)
    @ApiOperation(value = "删除一条帖子")
    public ApiResponse<Object> deleteFeed(@RequestParam("itemId") Long itemId,
                                          @RequestParam("userId") Long userId) {

        ApiResponse<Object> response = new ApiResponse<>();
        if (itemId == null) {
            response.setData("result", "itemId不能为空");
            return response;
        }
        int result1 = feedsService.deleteFeed(itemId);
        int result2 = commentService.deleteAllComments(itemId);

        TableUser tableUser = userService.queryUser(userId);
        if (tableUser != null) {
            tableUser.feedCount = tableUser.feedCount - 1;
            userService.saveOrUpdate(tableUser);
        }
        response.setData("result", result1 >= 0 && result2 >= 0);
        return response;
    }

    @RequestMapping(value = "queryHistory", method = RequestMethod.GET)
    @ApiOperation(value = "查询历史观看记录")
    public ApiResponse<List<TableHotFeeds>> queryHistory(@RequestParam("userId") Long userId,
                                                         @RequestParam(value = "pageCount", defaultValue = "10", required = false) int pageCount,
                                                         @RequestParam("page") int page) {
        ApiResponse<List<TableHotFeeds>> response = new ApiResponse<>();
        if (userId == null) {
            response.setResult(ApiResponse.STATUS_FAILED, "userId不能为空", null);
            return response;
        }
        List<TableHotFeeds> history = feedsService.queryHistory(userId, page * pageCount, pageCount);
        if (history != null) {
            fillFeedsList(userId, history);
        }
        response.setResult(ApiResponse.STATUS_SUCCESS, null, history);
        return response;
    }


    @RequestMapping(value = "queryFavorite", method = RequestMethod.GET)
    @ApiOperation(value = "查询收藏记录")
    public ApiResponse<List<TableHotFeeds>> queryFavorite(@RequestParam("userId") Long userId, @RequestParam(value = "pageCount", defaultValue = "10", required = false) int pageCount, @RequestParam("page") int page) {
        ApiResponse<List<TableHotFeeds>> response = new ApiResponse<>();
        if (userId == null) {
            response.setResult(ApiResponse.STATUS_FAILED, "userId不能为空", null);
            return response;
        }
        List<TableHotFeeds> favorite = feedsService.queryFavorite(userId, page * pageCount, pageCount);
        if (favorite != null) {
            fillFeedsList(userId, favorite);
        }
        response.setResult(ApiResponse.STATUS_FAILED, null, favorite);
        return response;
    }


    private void fillFeedsList(@RequestParam("userId") Long userId, List<TableHotFeeds> list) {
        for (TableHotFeeds feed : list) {
            if (feed == null) continue;
            feed.author = userService.queryUser(feed.authorId);
            feed.ugc = ugcService.queryUgcByItemId(feed.itemId);
            if (feed.author != null) {
                feed.author.hasFollow = ugcService.isUserFollow(userId, feed.authorId);
            }
            if (feed.ugc != null && userId > 0) {
                feed.ugc.hasLiked = ugcService.isLiked(feed.itemId, userId);
                feed.ugc.hasFavorite = ugcService.hasFavorite(feed.itemId, userId);
                feed.ugc.hasdiss = ugcService.hasDissFeed(feed.itemId, userId);
            }
            TableFeedsComment topComment = commentService.queryTopComment(feed.itemId);
            if (topComment != null) {
                topComment.commentUgc = commentService.queryUgcByCommentId(topComment.commentId);
                if (topComment.commentUgc != null) {
                    topComment.commentUgc.hasLiked = ugcService.isCommentLike(topComment.commentId, userId);
                }
                topComment.author = userService.queryUser(topComment.userId);
                feed.topComment = topComment;
            }
        }
    }
}
