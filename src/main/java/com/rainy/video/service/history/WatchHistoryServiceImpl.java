package com.rainy.video.service.history;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rainy.video.mapper.WatchHistoryMapper;
import com.rainy.video.table.TableWatchHistory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class WatchHistoryServiceImpl extends ServiceImpl<WatchHistoryMapper, TableWatchHistory> implements WatchHistoryService {
}
