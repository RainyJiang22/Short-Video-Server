package com.rainy.video.service.mock.feeds;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rainy.video.table.TableFeedsComment;
import com.rainy.video.table.TableHotFeeds;
import com.rainy.video.table.TableTagList;
import com.rainy.video.table.TableUser;

/**
 * @author Jacky
 * @date 2025/7/18
 **/
public interface MockFeedsService extends IService<Object> {
    int insertHotFeeds(TableHotFeeds feeds);


    int insertTag(TableTagList tagList);


    int insertComments(TableFeedsComment comment);


    int insertUser(TableUser user);

}
