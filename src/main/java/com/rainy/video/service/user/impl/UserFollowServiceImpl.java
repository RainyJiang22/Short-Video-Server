package com.rainy.video.service.user.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rainy.video.mapper.UserFollowMapper;
import com.rainy.video.service.user.UserFollowService;
import com.rainy.video.table.TableUserFollow;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @author Jacky
 * @date 2025/8/12
 **/

@Primary
@Service
public class UserFollowServiceImpl extends ServiceImpl<UserFollowMapper, TableUserFollow> implements UserFollowService {
}
