package com.rainy.video.service.feeds;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rainy.video.table.TableHotFeeds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Jacky
 * @date 2025/2/20
 **/
public interface FeedsService extends IService<TableHotFeeds> {

    List<TableHotFeeds> queryHotFeedsList(@Param("feedType") String feedType,
                                          @Param("inId") long id,
                                          @Param("pageCount") int pageCount);

    List<TableHotFeeds> queryNotHotFeedsList(@Param("feedType") String feedType,
                                          @Param("inId") long id,
                                          @Param("pageCount") int pageCount);

    boolean addFeed(@Param("feed") TableHotFeeds feed);

    List<TableHotFeeds> queryProfileFeeds(@Param("userId") long userId,
                                          @Param("pageCount") int pageCount,
                                          @Param("profileType") String profileType,
                                          @Param("inId") int inId);

    int deleteFeed(@Param("itemId") long itemId);

    TableHotFeeds queryFeed(@Param("itemId") long itemId);

    List<TableHotFeeds> queryHistory(@Param("userId") Long userId, @Param("offset") int offset, @Param("pageCount") int pageCount);

    List<TableHotFeeds> queryFavorite(@Param("userId") Long userId, @Param("offset") int offset, @Param("pageCount") int pageCount);
}
