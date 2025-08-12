package com.rainy.video.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rainy.video.table.TableWatchHistory;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WatchHistoryMapper extends BaseMapper<TableWatchHistory> {
}
