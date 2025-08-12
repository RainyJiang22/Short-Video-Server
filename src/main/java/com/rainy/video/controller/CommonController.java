package com.rainy.video.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.rainy.video.ApiResponse;
import com.rainy.video.service.comment.CommentService;
import com.rainy.video.service.ugc.UgcService;
import com.rainy.video.service.user.UserService;
import com.rainy.video.table.TableFeedsComment;
import com.rainy.video.table.TableFeedsCommentUgc;
import com.rainy.video.table.TableUser;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Jacky
 * @date 2024/12/4
 **/
@RestController
@RequestMapping("/commend")
@ApiOperation("帖子评论相关")
public class CommonController {

    @Autowired
    CommentService commentService;

    @Autowired
    UserService userService;

    @Autowired
    UgcService ugcService;

    @ApiOperation(value = "用于查询帖子的评论列表 支持分页")
    @RequestMapping(value = "queryFeedComments", method = RequestMethod.GET)
    @JsonView(value = TableFeedsComment.class)
    public ApiResponse<List<TableFeedsComment>> queryFeedComments(@RequestParam(value = "userId", required = false, defaultValue = "0") Long userId,
                                                                  @RequestParam(value = "pageCount", required = false, defaultValue = "10") Integer pageCount,
                                                                  @RequestParam(value = "itemId", required = true) Long itemId,
                                                                  @RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {

        ApiResponse<List<TableFeedsComment>> response = new ApiResponse<>();
        if (itemId == null) {
            response.setResult(ApiResponse.STATUS_FAILED, "itemId不能为空");
            return response;
        }

        List<TableFeedsComment> comments = commentService.queryCommentList(itemId, id <= 0 ? -1 : id, pageCount);
        if (comments != null && comments.size() > 0) {
            for (TableFeedsComment comment : comments) {
                comment.author = userService.queryUser(comment.userId);
                comment.commentUgc = commentService.queryUgcByCommentId(comment.commentId);
                if (comment.commentUgc == null) {
                    comment.commentUgc = new TableFeedsCommentUgc();
                }
                comment.commentUgc.hasLiked = ugcService.isCommentLike(comment.commentId, userId);
            }
        }
        response.setResult(ApiResponse.STATUS_SUCCESS, null, comments);

        if (userId != 0) {
            TableUser user = userService.queryUser(userId);
            if (user != null) {
                user.historyCount = user.historyCount + 1;
                userService.update(user);
            }
        }

        if (userId != 0) {
            commentService.addWatchHistory(userId, itemId, System.currentTimeMillis());
        }
        return response;
    }


    @ApiOperation(value = "用于帖子增加一条评论")
    @PostMapping(value = "addComment")
    @JsonView(value = TableFeedsComment.class)
    public ApiResponse<TableFeedsComment> addComment(@RequestParam(value = "userId", required = false, defaultValue = "0") Long userId,
                                                     @RequestParam(value = "itemId", required = true) Long itemId,
                                                     @RequestParam(value = "commentText", required = false, defaultValue = "") String commentText,
                                                     @RequestParam(value = "image_url", required = false, defaultValue = "") String image_url,
                                                     @RequestParam(value = "video_url", required = false, defaultValue = "") String video_url,
                                                     @RequestParam(value = "width", required = false, defaultValue = "") int width,
                                                     @RequestParam(value = "height", required = false, defaultValue = "") int height) {

        ApiResponse<TableFeedsComment> response = new ApiResponse<>();
        if (itemId == null || userId == null || StringUtils.isEmpty(commentText)) {
            response.setResult(ApiResponse.STATUS_FAILED, "itemId|userId|commentText不能为空");
            return response;
        }
        int commentType = TableFeedsComment.TEXT;
        if (!StringUtils.isEmpty(video_url)) {
            commentType = TableFeedsComment.VIDEO;
        } else if (!StringUtils.isEmpty(image_url)) {
            commentType = TableFeedsComment.IMAGE;
        }

        TableFeedsComment comment = new TableFeedsComment();
        comment.userId = userId;
        comment.itemId = itemId;
        comment.commentText = commentText;
        comment.commentType = commentType;
        comment.commentId = System.currentTimeMillis();
        comment.createTime = System.currentTimeMillis();
        if (video_url != null) {
            if (video_url.endsWith(".mp4")) {
                comment.imageUrl = image_url;
                comment.videoUrl = video_url;
            } else {
                comment.imageUrl = video_url;
            }
        }
        comment.width = width;
        comment.height = height;

        commentService.addComment(comment);
        ugcService.increaseCommentCount(itemId, 1);

        comment.author = userService.queryUser(userId);
        comment.commentUgc = new TableFeedsCommentUgc();
        response.setResult(ApiResponse.STATUS_SUCCESS, null, comment);


        TableUser user = userService.queryUser(userId);
        if (user != null) {
            user.commentCount = user.commentCount + 1;
            userService.update(user);
        }

        return response;
    }


    @ApiOperation(value = "删除帖子的一条评论")
    @RequestMapping(value = "deleteComment", method = RequestMethod.GET)
    public ApiResponse<Boolean> deleteComment(@RequestParam(value = "itemId", defaultValue = "0") Long itemId,
                                              @RequestParam(value = "userId", defaultValue = "0") Long userId,
                                              @RequestParam(value = "commentId", defaultValue = "0") Long commentId) {

        ApiResponse<Boolean> response = new ApiResponse<>();
        if (itemId == null || commentId == null) {
            response.setResult(ApiResponse.STATUS_FAILED, "commentId|itemId不能为空");
            return response;
        }

        int result = commentService.deleteComment(itemId, commentId, userId);
        ugcService.increaseCommentCount(itemId, -1);

        TableUser user = userService.queryUser(userId);
        if (user != null) {
            user.commentCount = user.commentCount - 1;
            userService.update(user);
        }

        if (result > 0) {
            response.setData("result", true);
        } else {
            response.setData("result", false);
        }
        return response;
    }

}
