package com.rainy.video.service.comment.ugc;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rainy.video.mapper.CommentUgcMapper;
import com.rainy.video.table.TableFeedsCommentUgc;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class CommentUgcServiceImpl extends ServiceImpl<CommentUgcMapper, TableFeedsCommentUgc> implements CommentUgcService {
}
