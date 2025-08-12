package com.rainy.video.service.comment;


import com.baomidou.mybatisplus.extension.service.IService;
import com.rainy.video.table.TableFeedsComment;
import com.rainy.video.table.TableFeedsCommentUgc;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentService extends IService<TableFeedsComment> {
    TableFeedsComment queryTopComment(@Param("itemId") long itemId);

    TableFeedsComment queryComment(@Param("itemId") long itemId);

    List<TableFeedsComment> queryCommentList(@Param("itemId") long itemId,
                                             @Param("id") int id,
                                             @Param("pageCount") int pageCount);

    boolean addComment(@Param("comment") TableFeedsComment comment);


    TableFeedsComment queryCommentByUserId(@Param("itemId") long itemId, @Param("userId") long userId, @Param("offset") int offset);

    void addWatchHistory(@Param("userId") long userId, @Param("itemId") long itemId, @Param("time") long time);

    int deleteComment(long itemId, long commentId, long userId);

    int deleteAllComments(long itemId);

    TableFeedsCommentUgc queryUgcByCommentId(long commentId);

    void setCommentUgc(TableFeedsCommentUgc ugc);
}
