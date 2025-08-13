package com.rainy.video.service.ugc.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rainy.video.mapper.UgcMapper;
import com.rainy.video.service.comment.like.CommenLiketService;
import com.rainy.video.service.comment.ugc.CommentUgcService;
import com.rainy.video.service.ugc.UgcLikeService;
import com.rainy.video.service.ugc.UgcService;
import com.rainy.video.service.user.UserFollowService;
import com.rainy.video.table.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class UgcServiceImpl extends ServiceImpl<UgcMapper, TableFeedUgc> implements UgcService {

    @Autowired
    UgcLikeService ugcLikeService;
    @Autowired
    CommentUgcService commentUgcService;
    @Autowired
    CommenLiketService commentLikeService;
    @Autowired
    UserFollowService userFollowService;

    @Override
    public long increaseCommentCount(long itemId, int increaseCount) {
        TableFeedsCommentUgc commentUgc = getTableCommentUgc(itemId);
        commentUgc.likeCount += increaseCount;
        commentUgcService.saveOrUpdate(commentUgc);
        return commentUgc.likeCount;
    }

    @Override
    public long queryCommentLikeCount(Long commentId) {
        TableFeedsCommentUgc commentUgc = getTableCommentUgc(commentId);
        return commentUgc.likeCount;
    }

    @Override
    public int queryCommentCount(long itemId) {
        TableFeedUgc tableFeedUgc = getTableFeedUgc(itemId);
        return tableFeedUgc.commentCount;
    }


    @Override
    public int increaseLikeCount(long userId, Long itemId, int increaseCount) {
        TableFeedUgc feedUgc = getTableFeedUgc(itemId);
        feedUgc.likeCount += increaseCount;
        saveOrUpdate(feedUgc);
        return 0;
    }

    @Override
    public int queryLikeCount(long itemId) {
        TableFeedUgc tableFeedUgc = getTableFeedUgc(itemId);
        return tableFeedUgc.likeCount;
    }

    @Override
    public int increaseShareCount(long itemId) {
        TableFeedUgc tableFeedUgc = getTableFeedUgc(itemId);
        tableFeedUgc.shareCount += 1;
        saveOrUpdate(tableFeedUgc);
        return tableFeedUgc.shareCount;
    }

    @Override
    public int queryShareCount(long itemId) {
        TableFeedUgc tableFeedUgc = getTableFeedUgc(itemId);
        return tableFeedUgc.shareCount;
    }

    @Override
    public int toggleLike(long itemId, long userId) {
        TableFeedUgcLike ugcLike = getTableFeedUgcLike(itemId, userId);
        ugcLike.hasLike = ugcLike.hasLike == 1 ? 0 : 1;
        ugcLike.hasDiss = ugcLike.hasLike == 1 ? 0 : ugcLike.hasDiss;
        ugcLikeService.saveOrUpdate(ugcLike);
        return ugcLike.hasLike;
    }

    @Override
    public boolean isLiked(long itemId, long userId) {
        TableFeedUgcLike ugcLike = getTableFeedUgcLike(itemId, userId);
        return ugcLike.hasLike == 1;
    }

    @Override
    public void setUgc(TableFeedUgc ugc) {
        saveOrUpdate(ugc);
    }

    @Override
    public void toggleCommentLike(long commentId, long userId) {
        // 查询当前用户是否对该条评论喜欢
        TableFeedsCommentLike commentUgcLike = getTableCommentUgcLike(commentId, userId);
        commentUgcLike.hasLike = commentUgcLike.hasLike == 1 ? 0 : 1;
        commentLikeService.saveOrUpdate(commentUgcLike);

        // 更新该条评论的 likeCount
        TableFeedsCommentUgc tableFeedsCommentUgc = getTableCommentUgc(commentId);
        tableFeedsCommentUgc.likeCount = tableFeedsCommentUgc.likeCount + (commentUgcLike.hasLike == 1 ? 1 : -1);
        commentUgcService.saveOrUpdate(tableFeedsCommentUgc);
    }

    @Override
    public boolean isCommentLike(long commentId, long userId) {
        TableFeedsCommentLike commentUgcLike = getTableCommentUgcLike(commentId, userId);
        return commentUgcLike.hasLike == 1;
    }

    @Override
    public boolean toggleUserFollow(long followUserId, long userId) {
        TableUserFollow userFollow = getUserFollow(userId, followUserId);
        userFollow.hasFollow = userFollow.hasFollow == 1 ? 0 : 1;
        return userFollowService.saveOrUpdate(userFollow);
    }

    @Override
    public boolean isUserFollow(long followUserId, long userId) {
        TableUserFollow userFollow = getUserFollow(userId, followUserId);
        userFollow.hasFollow = userFollow.hasFollow == 1 ? 0 : 1;
        return userFollow.hasFollow == 1;
    }

    @Override
    public int dissFeed(long itemId, long userId) {
        TableFeedUgcLike feedUgLike = getTableFeedUgcLike(itemId, userId);
        feedUgLike.hasLike = 0;
        feedUgLike.hasDiss = 1;
        ugcLikeService.saveOrUpdate(feedUgLike);
        return feedUgLike.hasDiss;
    }

    @Override
    public boolean hasDissFeed(long itemId, long userId) {
        TableFeedUgcLike feedUgLike = getTableFeedUgcLike(itemId, userId);
        return feedUgLike.hasDiss == 1;
    }

    @Override
    public int toggleFavorite(Long itemId, Long userId) {
        TableFeedUgcLike feedUgLike = getTableFeedUgcLike(itemId, userId);
        feedUgLike.hasFavorite = feedUgLike.hasFavorite == 1 ? 0 : 1;
        ugcLikeService.saveOrUpdate(feedUgLike);
        return feedUgLike.hasFavorite;
    }

    @Override
    public boolean hasFavorite(Long itemId, Long userId) {
        TableFeedUgcLike feedUgLike = getTableFeedUgcLike(itemId, userId);
        return feedUgLike.hasFavorite == 1;
    }


    @Override
    public TableFeedUgc queryUgcByItemId(long itemId) {
        QueryWrapper<TableFeedUgc> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("item_id",itemId);
        queryWrapper.last("limit 1");
        return getBaseMapper().selectOne(queryWrapper);
    }

    @Override
    public TableFeedsCommentUgc queryUgcByCommentId(long commentId) {
        return getTableCommentUgc(commentId);
    }

    private TableFeedUgc getTableFeedUgc(long itemId) {
        QueryWrapper<TableFeedUgc> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("item_id", itemId);
        queryWrapper.last("limit 1");
        TableFeedUgc tableFeedUgc = getBaseMapper().selectOne(queryWrapper);
        if (tableFeedUgc == null) {
            tableFeedUgc = new TableFeedUgc();
            tableFeedUgc.itemId = itemId;
        }
        return tableFeedUgc;
    }

    private TableFeedUgcLike getTableFeedUgcLike(long itemId, long userId) {
        QueryWrapper<TableFeedUgcLike> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("item_id", itemId);
        queryWrapper.eq("user_id", userId);
        queryWrapper.last("limit 1");
        TableFeedUgcLike tableFeedUgcLike = ugcLikeService.getBaseMapper().selectOne(queryWrapper);
        if (tableFeedUgcLike == null) {
            tableFeedUgcLike = new TableFeedUgcLike();
            tableFeedUgcLike.itemId = itemId;
            tableFeedUgcLike.userId = userId;
        }
        return tableFeedUgcLike;
    }
    private TableFeedsCommentLike getTableCommentUgcLike(long commentId, long userId) {
        QueryWrapper<TableFeedsCommentLike> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("comment_id", commentId);
        queryWrapper.eq("user_id", userId);
        TableFeedsCommentLike commentUgcLike = commentLikeService.getOne(queryWrapper);
        if (commentUgcLike == null) {
            commentUgcLike = new TableFeedsCommentLike();
            commentUgcLike.commentId = commentId;
            commentUgcLike.userId = userId;
        }
        return commentUgcLike;
    }

    private TableFeedsCommentUgc getTableCommentUgc(long commentId) {
        QueryWrapper<TableFeedsCommentUgc> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("comment_id", commentId);
        TableFeedsCommentUgc commentUgc = commentUgcService.getOne(queryWrapper);
        if (commentUgc == null) {
            commentUgc = new TableFeedsCommentUgc();
            commentUgc.commentId = commentId;
        }
        return commentUgc;
    }

    private TableUserFollow getUserFollow(long userId, long followUserId) {
        QueryWrapper<TableUserFollow> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        queryWrapper.eq("follow_user_id", followUserId);
        TableUserFollow userFollow = userFollowService.getBaseMapper().selectOne(queryWrapper);
        if (userFollow == null) {
            userFollow = new TableUserFollow();
            userFollow.userId = userId;
            userFollow.followUserId = followUserId;
        }
        return userFollow;
    }
}
