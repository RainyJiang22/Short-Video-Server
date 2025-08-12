package com.rainy.video.service.ugc.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rainy.video.mapper.UgcLikeMapper;
import com.rainy.video.service.ugc.UgcLikeService;
import com.rainy.video.table.TableFeedUgcLike;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class UgcLikeServiceImpl extends ServiceImpl<UgcLikeMapper, TableFeedUgcLike> implements UgcLikeService {
}
