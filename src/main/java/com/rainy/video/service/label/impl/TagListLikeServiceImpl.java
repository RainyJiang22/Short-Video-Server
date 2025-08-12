package com.rainy.video.service.label.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rainy.video.mapper.TagListLikeMapper;
import com.rainy.video.service.label.TagListLikeService;
import com.rainy.video.table.TableTagListLike;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @author Jacky
 * @date 2025/8/12
 **/

@Primary
@Service
public class TagListLikeServiceImpl extends ServiceImpl<TagListLikeMapper, TableTagListLike> implements TagListLikeService {
}
