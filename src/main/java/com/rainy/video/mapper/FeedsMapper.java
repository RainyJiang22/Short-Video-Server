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
            "FROM table_hot_feeds,table_ugc " +
            "WHERE table_hot_feeds.item_id = table_ugc.item_id " +
            "and table_ugc.like_count>1000 and table_ugc.comment_count>500 " +
            "order by table_hot_feeds.id asc limit #{pageCount}")
    List<TableHotFeeds> queryHotFeeds(@Param("feedType") int feedType,
                                      @Param("id") int id,
                                      @Param("pageCount") int pageCount);


    @Select("SELECT table_hot_feeds.* " +
            "FROM table_hot_feeds " +
            "LEFT JOIN table_ugc ON table_hot_feeds.item_id = table_ugc.item_id " +
            "WHERE table_hot_feeds.item_type =#{feedType} " +
            "and table_ugc.item_id IS NULL OR table_ugc.like_count < 1000 " +
            "order by table_hot_feeds.id desc limit #{pageCount}")
    List<TableHotFeeds> queryNotHotFeeds(@Param("feedType") int feedType,
                                         @Param("id") int id,
                                         @Param("pageCount") int pageCount);
}
