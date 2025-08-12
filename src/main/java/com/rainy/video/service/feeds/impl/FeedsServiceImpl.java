package com.rainy.video.service.feeds.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rainy.video.mapper.FeedsMapper;
import com.rainy.video.service.feeds.FeedsService;
import com.rainy.video.table.TableHotFeeds;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author Jacky
 * @date 2025/2/20
 **/

@Service
public class FeedsServiceImpl extends ServiceImpl<FeedsMapper, TableHotFeeds> implements FeedsService {
    @Override
    public List<TableHotFeeds> queryHotFeedsList(String feedType, int id, int pageCount) {
        int itemType = -1;
        if (Objects.equals(feedType, "text")) {
            itemType = 0;
        } else if (Objects.equals(feedType, "pics")) {
            itemType = 1;
        } else if (Objects.equals(feedType, "video")) {
            itemType = 2;
        }
        if (id == 0) id = Integer.MAX_VALUE;
        return getBaseMapper().queryHotFeeds(itemType, id, pageCount);
    }

    @Override
    public List<TableHotFeeds> queryNotHotFeedsList(String feedType, int id, int pageCount) {
        int itemType = -1;
        if (Objects.equals(feedType, "text")) {
            itemType = 0;
        } else if (Objects.equals(feedType, "pics")) {
            itemType = 1;
        } else if (Objects.equals(feedType, "video")) {
            itemType = 2;
        }
        if (id == 0) id = Integer.MAX_VALUE;
        return getBaseMapper().queryNotHotFeeds(itemType, id, pageCount);
    }
}
