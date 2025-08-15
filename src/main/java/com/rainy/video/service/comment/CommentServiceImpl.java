package com.rainy.video.service.comment;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rainy.video.mapper.CommentMapper;
import com.rainy.video.service.comment.ugc.CommentUgcService;
import com.rainy.video.service.history.WatchHistoryService;
import com.rainy.video.table.TableFeedsComment;
import com.rainy.video.table.TableFeedsCommentUgc;
import com.rainy.video.table.TableWatchHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Primary
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, TableFeedsComment> implements CommentService {
    @Autowired
    WatchHistoryService watchHistoryService;
    @Autowired
    CommentUgcService commentUgcService;
    @Override
    public TableFeedsComment queryTopComment(long itemId) {
        //  select * from table_feeds_comment  where item_id = if((select count(*) from table_feeds_comment WHERE item_id=${itemId})>0,${itemId},6725417009447704840)
        //  and like_count >= 100 limit 1;
        QueryWrapper<TableFeedsComment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("item_id", itemId);
        queryWrapper.gt("like_count", 100);
        queryWrapper.last("limit 1");
        return getBaseMapper().selectOne(queryWrapper);
    }

    @Override
    public TableFeedsComment queryComment(long itemId) {
        //  select * from table_feeds_comment  where item_id = #{itemId} limit 1;
        QueryWrapper<TableFeedsComment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("item_id", itemId);
        return getBaseMapper().selectOne(queryWrapper);
    }

    @Override
    public List<TableFeedsComment> queryCommentList(long itemId, int commentId, int pageCount) {
        // SELECT * FROM table_feeds_comment where item_id = if((select count(*) from table_feeds_comment WHERE item_id=${itemId})>0,${itemId},6700133439221274893) and id <![CDATA[ < ]]> ${id}
        //    order by create_time desc limit ${pageCount};
        QueryWrapper<TableFeedsComment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("item_id", itemId);
        queryWrapper.gt("comment_id", commentId);
        queryWrapper.last("order by comment_id desc limit " + pageCount);
        return getBaseMapper().selectList(queryWrapper);
    }

    @Override
    public boolean addComment(TableFeedsComment comment) {
        return saveOrUpdate(comment);
    }
    @Override
    public TableFeedsComment queryCommentByUserId(long itemId, long userId, int offset) {
        // select * from table_feeds_comment  where item_id = #{itemId} and user_id=#{userId} order by create_time desc limit 1 offset #{offset};
        QueryWrapper<TableFeedsComment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("item_id", itemId);
        queryWrapper.eq("user_id", userId);
        queryWrapper.last("order by create_time desc limit 1 offset " + offset);
        return getBaseMapper().selectOne(queryWrapper);
    }

    @Override
    public void addWatchHistory(long userId, long itemId, long time) {
        /**
         *        <when test="id &lt;= 0">
         *                 insert into table_watch_history (user_id,item_id,time) values (#{userId},#{itemId},#{time})
         *             </when>
         *             <otherwise>
         *                 select id from table_watch_history where user_id= #{userId} and item_id= #{itemId}
         */
        QueryWrapper<TableWatchHistory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("item_id", itemId);
        queryWrapper.eq("user_id", userId);
        TableWatchHistory watchHistory = watchHistoryService.getBaseMapper().selectOne(queryWrapper);
        if (watchHistory == null) {
            watchHistory = new TableWatchHistory();
            watchHistory.itemId = itemId;
            watchHistory.userId = userId;
        }
        watchHistory.time = time;
        watchHistoryService.saveOrUpdate(watchHistory);
    }

    @Override
    public int deleteComment(long itemId, long commentId, long userId) {
        QueryWrapper<TableFeedsComment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("item_id", itemId);
        queryWrapper.eq("comment_id", commentId);
        queryWrapper.eq("user_id", userId);
        return getBaseMapper().delete(queryWrapper);
    }

    @Override
    public int deleteAllComments(long itemId) {
        QueryWrapper<TableFeedsComment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("item_id", itemId);
        return getBaseMapper().delete(queryWrapper);
    }

    @Override
    public TableFeedsCommentUgc queryUgcByCommentId(long commentId) {
        //  select * from table_feed_comment_ugc  where comment_id = ${commentId} limit 1
        QueryWrapper<TableFeedsCommentUgc> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("comment_id", commentId);
        return commentUgcService.getBaseMapper().selectOne(queryWrapper);
    }

    @Override
    public void setCommentUgc(TableFeedsCommentUgc ugc) {
        commentUgcService.saveOrUpdate(ugc);
    }
}
