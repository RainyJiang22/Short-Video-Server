package com.rainy.video.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rainy.video.table.TableHotFeeds;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Jacky
 * @date 2025/2/20
 **/

@Mapper
public interface FeedsMapper  extends BaseMapper<TableHotFeeds> {

    @Select("SELECT table_hot_feeds.* " +
            "FROM table_hot_feeds,table_feed_ugc " +
            "WHERE table_hot_feeds.item_id = table_feed_ugc.item_id " +
            "and table_feed_ugc.like_count>1000 and table_feed_ugc.comment_count>500 " +
            "order by table_hot_feeds.id asc limit #{pageCount}")
    List<TableHotFeeds> queryHotFeeds(@Param("feedType") String feedType,
                                      @Param("id") int id,
                                      @Param("pageCount") int pageCount);


    @Select("SELECT table_hot_feeds.* " +
            "FROM table_hot_feeds " +
            "order by table_hot_feeds.id desc limit #{pageCount}")
    List<TableHotFeeds> queryAllFeeds(@Param("feedType") int feedType,
                                      @Param("id") int id,
                                      @Param("pageCount") int pageCount);


    @Select("SELECT table_hot_feeds.* " +
            "FROM table_hot_feeds " +
            "LEFT JOIN table_feed_ugc ON table_hot_feeds.item_id = table_feed_ugc.item_id " +
            "WHERE table_hot_feeds.item_type =#{feedType} " +
            "and (table_feed_ugc.item_id IS NULL OR table_feed_ugc.like_count < 1000) " +
            "order by table_hot_feeds.id desc limit #{pageCount}")
    List<TableHotFeeds> queryNotHotFeeds(@Param("feedType") int feedType,
                                         @Param("id") int id,
                                         @Param("pageCount") int pageCount);

    @Select("select * from table_hot_feeds,table_watch_history " +
            "where table_watch_history.user_id =#{userId} " +
            "and table_watch_history.item_id =table_hot_feeds.item_id " +
            "order by table_watch_history.id desc limit #{pageCount} offset #{offset}")
    List<TableHotFeeds> queryHistory(@Param("userId") Long userId,
                                     @Param("offset") int offset,
                                     @Param("pageCount") int pageCount);


    @Select("select * from table_hot_feeds,table_feed_ugc_like " +
            "where table_feed_ugc_like.user_id =#{userId} " +
            "and table_feed_ugc_like.has_favorite=1 " +
            "AND table_hot_feeds.item_id = table_feed_ugc_like.item_id " +
            "order by table_feed_ugc_like.id desc limit #{pageCount} offset #{offset}")
    List<TableHotFeeds> queryFavorite(@Param("userId") Long userId,
                                      @Param("offset") int offset,
                                      @Param("pageCount") int pageCount);

    @Select("SELECT * FROM table_hot_feeds,table_feeds_comment" +
            "where table_feeds_comment.user_id=#{userId} " +
            "and table_hot_feeds.author_id != #{userId} " +
            "and table_hot_feeds.id > #{inId} " +
            "order by table_hot_feeds.id desc limit #{pageCount}")
    void queryCommentFeeds(@Param("userId") Long userId,
                           @Param("pageCount") int pageCount,
                           @Param("inId") int inId);

    @Select(" SELECT * FROM table_hot_feeds where table_hot_feeds.author_id =#{userId} " +
            "and table_hot_feeds.id > #{inId} " +
            "order by table_hot_feeds.id desc limit #{pageCount}")
    void queryUserFeeds(@Param("userId") Long userId,
                        @Param("pageCount") int pageCount,
                        @Param("inId") int inId);


    @Select("SELECT distinct " +
            "table_hot_feeds.id," +
            "table_hot_feeds.item_id," +
            "table_hot_feeds.item_type," +
            "table_hot_feeds.create_time," +
            "table_hot_feeds.duration," +
            "table_hot_feeds.feeds_text," +
            "table_hot_feeds.author_id," +
            "table_hot_feeds.activity_text," +
            "table_hot_feeds.activity_icon," +
            "table_hot_feeds.video_width," +
            "table_hot_feeds.video_height," +
            "table_hot_feeds.video_url," +
            "table_hot_feeds.video_cover " +
            "FROM table_hot_feeds,table_feeds_comment " +
            "where table_feeds_comment.user_id=#{userId} or table_hot_feeds.author_id =#{userId} " +
            "and (table_hot_feeds.id > #{inId} or table_feeds_comment.id>${inId}) " +
            "order by table_hot_feeds.id desc limit #{pageCount}")
    List<TableHotFeeds> queryUserFeedsAndComments(@Param("userId") Long userId,
                                                  @Param("pageCount") int pageCount,
                                                  @Param("inId") int inId);
}
