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

    @Override
    public boolean addFeed(TableHotFeeds feed) {
        return saveOrUpdate(feed);
    }

    @Override
    public List<TableHotFeeds> queryProfileFeeds(long userId, int pageCount, String profileType, int inId) {
        if (Objects.equals(profileType, "tab_feed")) {
            getBaseMapper().queryUserFeeds(userId, pageCount, inId);
        } else if (Objects.equals(profileType, "tab_comment")) {
            getBaseMapper().queryCommentFeeds(userId, pageCount, inId);
        } else {
            return getBaseMapper().queryUserFeedsAndComments(userId, pageCount, inId);
        }
        return null;
    }

    @Override
    public int deleteFeed(long itemId) {
        QueryWrapper<TableHotFeeds> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("item_id", itemId);
        return getBaseMapper().delete(queryWrapper);
    }

    @Override
    public TableHotFeeds queryFeed(long itemId) {
        QueryWrapper<TableHotFeeds> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("item_id", itemId);
        return getBaseMapper().selectOne(queryWrapper);
    }

    @Override
    public List<TableHotFeeds> queryHistory(Long userId, int offset, int pageCount) {
        return getBaseMapper().queryHistory(userId, offset, pageCount);
    }

    @Override
    public List<TableHotFeeds> queryFavorite(Long userId, int offset, int pageCount) {
        return getBaseMapper().queryFavorite(userId, offset, pageCount);
    }
}
