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
                                          @Param("inId") int id,
                                          @Param("pageCount") int pageCount);
}
