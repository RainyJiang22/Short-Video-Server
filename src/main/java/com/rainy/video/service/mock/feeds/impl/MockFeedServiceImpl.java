package com.rainy.video.service.mock.feeds.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rainy.video.mapper.mock.MockFeedsMapper;
import com.rainy.video.service.mock.feeds.MockFeedsService;
import com.rainy.video.table.TableFeedsComment;
import com.rainy.video.table.TableHotFeeds;
import com.rainy.video.table.TableTagList;
import com.rainy.video.table.TableUser;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @author Jacky
 * @date 2025/7/18
 **/

@Primary
@Service
public class MockFeedServiceImpl extends ServiceImpl<MockFeedsMapper, Object> implements MockFeedsService {
    @Override
    public int insertHotFeeds(TableHotFeeds feeds) {
        return 0;
    }

    @Override
    public int insertTag(TableTagList tagList) {
        return 0;
    }

    @Override
    public int insertComments(TableFeedsComment comment) {
        return 0;
    }

    @Override
    public int insertUser(TableUser user) {
        return 0;
    }
}
