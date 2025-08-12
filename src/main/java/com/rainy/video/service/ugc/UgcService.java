package com.rainy.video.service.ugc;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rainy.video.table.TableFeedUgc;
import com.rainy.video.table.TableFeedsCommentUgc;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @author Jacky
 * @date 2025/8/12
 **/

@Primary
@Service
public interface UgcService extends IService<TableFeedUgc> {

    TableFeedUgc queryUgcByItemId(@Param("itemId") long itemId);

    TableFeedsCommentUgc queryUgcByCommentId(@Param("commentId") long commentId);

    long increaseCommentCount(@Param("itemId") long itemId, @Param("increaseCount") int increaseCount);

    long queryCommentLikeCount(Long commentId);

    int queryCommentCount(@Param("itemId") long itemId);

    int increaseLikeCount(@Param("userId") long userId,@Param("itemId") Long itemId, @Param("increaseCount") int increaseCount);

    int queryLikeCount(@Param("itemId") long itemId);

    int increaseShareCount(@Param("itemId") long itemId);

    int queryShareCount(@Param("itemId") long itemId);

    int toggleLike(@Param("itemId") long itemId, @Param("userId") long userId);

    boolean isLiked(@Param("itemId") long itemId, @Param("userId") long userId);

    void setUgc(TableFeedUgc ugc);

    void toggleCommentLike(@Param("commentId") long commentId, @Param("userId") long userId);

    boolean isCommentLike(@Param("commentId") long commentId, @Param("userId") long userId);

    boolean toggleUserFollow(@Param("followUserId") long followUserId, @Param("userId") long userId);

    boolean isUserFollow(@Param("followUserId") long followUserId, @Param("userId") long userId);

    int dissFeed(@Param("itemId") long itemId, @Param("userId") long userId);

    boolean hasDissFeed(@Param("itemId") long itemId, @Param("userId") long userId);

    int toggleFavorite(@Param("itemId") Long itemId, @Param("userId") Long userId);

    boolean hasFavorite(@Param("itemId") Long itemId, @Param("userId") Long userId);
}
