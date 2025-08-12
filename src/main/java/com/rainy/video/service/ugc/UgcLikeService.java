package com.rainy.video.service.ugc;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rainy.video.table.TableFeedUgcLike;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @author Jacky
 * @date 2025/8/12
 **/

@Primary
@Service
public interface UgcLikeService extends IService<TableFeedUgcLike> {
}
