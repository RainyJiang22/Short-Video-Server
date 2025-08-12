package com.rainy.video.service.comment.like;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rainy.video.mapper.CommentLikeMapper;
import com.rainy.video.table.TableFeedsCommentLike;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class CommenLiketServiceImpl extends ServiceImpl<CommentLikeMapper, TableFeedsCommentLike> implements CommenLiketService {
}
