package com.rainy.video.controller;

import com.alibaba.fastjson.JSONObject;
import com.rainy.video.ApiResponse;
import com.rainy.video.service.comment.CommentService;
import com.rainy.video.service.feeds.FeedsService;
import com.rainy.video.service.label.TagListService;
import com.rainy.video.service.ugc.UgcService;
import com.rainy.video.service.user.UserService;
import com.rainy.video.table.TableFeedUgc;
import com.rainy.video.table.TableFeedsComment;
import com.rainy.video.table.TableHotFeeds;
import com.rainy.video.table.TableUser;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jacky
 * @date 2025/8/12
 **/

@RestController
@RequestMapping(value = "/ugc")
@ApiOperation(value = "ugc帖子互动相关")
public class UgcController {

    @Autowired
    UgcService ugcService;

    @Autowired
    CommentService commentService;

    @Autowired
    FeedsService feedsService;

    @Autowired
    UserService userService;

    @Autowired
    TagListService tagListService;


    @RequestMapping(value = "/queryUgcByItemId", method = RequestMethod.GET)
    @ApiOperation(value = "根据itemId查询段子的ugc属性")
    public ApiResponse<Object> queryUgcByItemId(Long itemId) {
        ApiResponse<Object> response = new ApiResponse<>();
        if (itemId == null) {
            response.setResult(ApiResponse.STATUS_FAILED, "itemId 不能为空");
            return response;
        }
        TableFeedUgc feedUgc = ugcService.queryUgcByItemId(itemId);
        response.setResult(ApiResponse.STATUS_SUCCESS, null, feedUgc);
        return response;
    }

    @RequestMapping(value = "/increaseCommentCount", method = RequestMethod.GET)
    @ApiOperation(value = "增加段子评论的数量")
    public ApiResponse<Object> increaseCommentCount(Long itemId) {
        ApiResponse<Object> response = new ApiResponse<>();
        if (itemId == null) {
            response.setResult(ApiResponse.STATUS_FAILED, "itemId  不能为空");
            return response;
        }
        ugcService.increaseCommentCount(itemId, 1);
        int commentCount = ugcService.queryCommentCount(itemId);
        response.setData("count", commentCount);
        return response;
    }


    @RequestMapping(value = "toggleFavorite", method = RequestMethod.GET)
    @ApiOperation(value = "收藏一个帖子", notes = "根据itemId来收藏一个帖子")
    public ApiResponse<Object> toggleFavorite(@RequestParam(value = "itemId", defaultValue = "0") Long itemId,
                                              @RequestParam(value = "userId", defaultValue = "0") Long userId) {
        ApiResponse<Object> response = new ApiResponse<>();
        if (itemId == 0 || userId == 0) {
            response.setData("result", "itemId|userId 不能为空");
            return response;
        }
        TableUser user = userService.queryUser(userId);
        ugcService.toggleFavorite(itemId, userId);
        boolean hasFavorite = ugcService.hasFavorite(itemId, userId);
        if (hasFavorite) {
            user.favoriteCount = user.favoriteCount + 1;
            response.setData("hasFavorite", true);
        } else {
            user.favoriteCount = user.favoriteCount - 1;
            response.setData("hasFavorite", false);
        }
        userService.update(user);
        return response;

    }

    @RequestMapping(value = "/increaseShareCount", method = RequestMethod.GET)
    @ApiOperation(value = "增加一条段子分享的数量")
    public ApiResponse<Object> increaseShareCount(Long itemId) {
        ApiResponse<Object> response = new ApiResponse<>();
        if (itemId == null) {
            response.setResult(ApiResponse.STATUS_FAILED, "itemId 不能为空");
            return response;
        }
        ugcService.increaseShareCount(itemId);
        int shareCount = ugcService.queryShareCount(itemId);
        response.setData("count", shareCount);
        return response;
    }

    @RequestMapping(value = "/toggleFeedLike", method = RequestMethod.GET)
    @ApiOperation(value = "变换用户对该条段子的喜欢结果")
    public ApiResponse<JSONObject> toggleLike(Long itemId, Long userId) {
        ApiResponse<JSONObject> apiResponse = new ApiResponse<>();
        if (itemId == null || userId == null) {
            apiResponse.setResult(ApiResponse.STATUS_FAILED, "itemId或者userId不能为空");
            return apiResponse;
        }

        TableHotFeeds feed = feedsService.queryFeed(itemId);
        if (feed != null) {
            TableUser user = userService.queryUser(userId);
            if (user != null) {
                boolean hasLiked = ugcService.isLiked(itemId, userId);
                ugcService.toggleLike(itemId, userId);
                ugcService.increaseLikeCount(userId, itemId, hasLiked ? -1 : 1);
                user.likeCount = !hasLiked ? user.likeCount + 1 : user.likeCount - 1;
                userService.saveOrUpdate(user);
                JSONObject data = new JSONObject();
                data.put("hasLiked", ugcService.isLiked(itemId, userId));
                data.put("likeCount", ugcService.queryLikeCount(itemId));
                data.put("hasdiss", ugcService.hasDissFeed(itemId, userId));
                System.out.println("toggleFeedLike:" + data.toString());
                apiResponse.setData(data);
            } else {
                apiResponse.setResult(ApiResponse.STATUS_FAILED, String.format("不存在userId=%s 的用户", userId));
            }
        } else {
            apiResponse.setResult(ApiResponse.STATUS_FAILED, String.format("不存在itemId=%s的帖子", itemId));
        }

        return apiResponse;
    }

    @RequestMapping(value = "/isLiked", method = RequestMethod.GET)
    @ApiOperation(value = "查询用户对该条段子的喜欢结果")
    public ApiResponse<Object> isLiked(Long itemId, Long userId) {
        ApiResponse<Object> apiResponse = new ApiResponse<>();
        if (itemId == null || userId == null) {
            apiResponse.setResult(ApiResponse.STATUS_FAILED, "itemId或者userId不能为空");
            return apiResponse;
        }
        boolean hasLiked = ugcService.isLiked(itemId, userId);
        apiResponse.setData("hasLiked", hasLiked);
        return apiResponse;
    }


    @RequestMapping(value = "/toggleTagListFollow", method = RequestMethod.GET)
    @ApiOperation(value = "变换用户对该标签类型的喜欢结果")
    public ApiResponse<Object> toggleTagListFollow(Long tagId, Long userId) {
        ApiResponse<Object> apiResponse = new ApiResponse<>();
        if (tagId == null || userId == null) {
            apiResponse.setResult(ApiResponse.STATUS_FAILED, "tagId或者userId不能为空");
            return apiResponse;
        }

        tagListService.toggleTagListFollow(tagId, userId);
        boolean liked = tagListService.hasFollowTag(tagId, userId);
        apiResponse.setData("hasLiked", liked);
        return apiResponse;
    }


    @RequestMapping(value = "/hasFollowTag", method = RequestMethod.GET)
    @ApiOperation(value = "查询用户对该标签类型的喜欢结果")
    public ApiResponse<Object> hasFollowTag(Long tagId, Long userId) {
        ApiResponse<Object> apiResponse = new ApiResponse<>();
        if (tagId == null || userId == null) {
            apiResponse.setResult(ApiResponse.STATUS_FAILED, "tagId或者userId不能为空");
            return apiResponse;
        }

        boolean liked = tagListService.hasFollowTag(tagId, userId);
        apiResponse.setData("hasLiked", liked);
        return apiResponse;
    }


    @RequestMapping(value = "/toggleCommentLike", method = RequestMethod.GET)
    @ApiOperation(value = "变更用户对一条评论的喜欢状态")
    public ApiResponse<JSONObject> toggleCommentLike(Long commentId, Long itemId, Long userId) {
        ApiResponse<JSONObject> apiResponse = new ApiResponse<>();
        if (commentId == null || userId == null) {
            apiResponse.setResult(ApiResponse.STATUS_FAILED, "commentId或者userId不能为空");
            return apiResponse;
        }

        ugcService.toggleCommentLike(commentId, userId);
        boolean hasLiked = ugcService.isCommentLike(commentId, userId);
        long likeCount = ugcService.queryCommentLikeCount(commentId);

        TableFeedsComment comment = commentService.queryComment(commentId);
        if (comment != null && comment.author != null) {
            TableUser user = userService.queryUser(comment.userId);
            if (user != null) {
                if (hasLiked) {
                    user.likeCount = user.likeCount + 1;
                } else {
                    user.likeCount = user.likeCount - 1;
                }
                userService.update(user);
            }
        }

        JSONObject data = new JSONObject();
        data.put("hasLiked", hasLiked);
        data.put("likeCount", likeCount);
        apiResponse.setData(data);
        return apiResponse;
    }

    @RequestMapping(value = "/isCommentLike", method = RequestMethod.GET)
    @ApiOperation(value = "查询用户对一条评论的喜欢状态")
    public ApiResponse<Boolean> isCommentLike(Long commentId, Long userId) {
        ApiResponse<Boolean> apiResponse = new ApiResponse<>();
        if (commentId == null || userId == null) {
            apiResponse.setResult(ApiResponse.STATUS_FAILED, "commentId或者userId不能为空");
            return apiResponse;
        }

        boolean hasLike = ugcService.isCommentLike(commentId, userId);
        apiResponse.setData("hasLiked", hasLike);
        return apiResponse;
    }


    @RequestMapping(value = "/toggleUserFollow", method = RequestMethod.GET)
    @ApiOperation(value = "变更用户对另一个用户的喜欢状态")
    public ApiResponse<Object> toggleUserFollow(@RequestParam(value = "followUserId") Long followUserId, @RequestParam(value = "userId") Long userId) {
        ApiResponse<Object> apiResponse = new ApiResponse<>();
        if (followUserId == null || userId == null) {
            apiResponse.setResult(ApiResponse.STATUS_FAILED, "followUserId或者userId不能为空");
            return apiResponse;
        }

        ugcService.toggleUserFollow(followUserId, userId);
        boolean hasFollow = ugcService.isUserFollow(followUserId, userId);
        TableUser followUser = userService.queryUser(followUserId);
        if (followUser != null) {
            if (hasFollow) {
                followUser.followCount = followUser.followCount + 1;
            } else {
                followUser.followCount = followUser.followCount - 1;
            }
        }

        TableUser user = userService.queryUser(userId);
        if (user != null) {
            if (hasFollow) {
                user.followerCount = user.followerCount + 1;
            } else {
                user.followerCount = user.followerCount - 1;
            }
        }

        //更新关注的用户
        userService.update(followUser);
        //更新当前的用户
        userService.update(user);
        apiResponse.setData("hasLiked", hasFollow);
        return apiResponse;
    }

    @RequestMapping(value = "/isUserFollow", method = RequestMethod.GET)
    @ApiOperation(value = "查询用户对另一个用户的喜欢状态")
    public ApiResponse<Boolean> isUserFollow(@RequestParam(value = "followUserId") Long followUserId, @RequestParam(value = "userId") Long userId) {
        ApiResponse<Boolean> apiResponse = new ApiResponse<>();
        if (followUserId == null || userId == null) {
            apiResponse.setResult(ApiResponse.STATUS_FAILED, "commentId或者userId不能为空");
            return apiResponse;
        }

        boolean hasLiked = ugcService.isUserFollow(followUserId, userId);
        apiResponse.setData("hasLiked", hasLiked);
        return apiResponse;
    }


    @RequestMapping(value = "/dissFeed", method = RequestMethod.GET)
    @ApiOperation(value = "变更用户对一个帖子的diss状态")
    public ApiResponse<Object> dissFeed(Long itemId, Long userId) {
        ApiResponse<Object> apiResponse = new ApiResponse<>();
        if (itemId == null || userId == null) {
            apiResponse.setResult(ApiResponse.STATUS_FAILED, "itemId或者userId不能为空");
            return apiResponse;
        }

        boolean isLiked = ugcService.isLiked(itemId, userId);
        TableHotFeeds feed = feedsService.queryFeed(itemId);
        if (feed != null) {
            TableUser user = userService.queryUser(userId);
            if (user != null && isLiked) {
                user.likeCount = user.likeCount - 1;
                userService.update(user);
            }
        }
        if (isLiked) {
            ugcService.increaseLikeCount(userId, itemId, -1);
        }
        ugcService.dissFeed(itemId, userId);

        JSONObject data = new JSONObject();
        data.put("hasLiked", ugcService.isLiked(itemId, userId));
        data.put("likeCount", ugcService.queryLikeCount(itemId));
        data.put("hasdiss", ugcService.hasDissFeed(itemId, userId));
        apiResponse.setData(data);
        return apiResponse;
    }

    @RequestMapping(value = "/hasDissFeed", method = RequestMethod.GET)
    @ApiOperation(value = "查询用户对一个帖子的diss状态")
    public ApiResponse<Object> hasDissFeed(Long itemId, Long userId) {
        ApiResponse<Object> apiResponse = new ApiResponse<>();
        if (itemId == null || userId == null) {
            apiResponse.setResult(ApiResponse.STATUS_FAILED, "itemId或者userId不能为空");
            return apiResponse;
        }
        boolean hasLiked = ugcService.hasDissFeed(itemId, userId);
        apiResponse.setData("hasLiked", hasLiked);
        return apiResponse;
    }

}
