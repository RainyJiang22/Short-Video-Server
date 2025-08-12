package com.rainy.video.service.label.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rainy.video.mapper.TagListMapper;
import com.rainy.video.service.label.TagListLikeService;
import com.rainy.video.service.label.TagListService;
import com.rainy.video.table.TableTagList;
import com.rainy.video.table.TableTagListLike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * s
 *
 * @author Jacky
 * @date 2025/8/12
 **/

@Primary
@Service
public class TagListServiceImpl extends ServiceImpl<TagListMapper, TableTagList> implements TagListService {

    @Autowired
    TagListLikeService tagListLikeService;

    @Override
    public List<TableTagList> queryTagList(long tagId, long userId, boolean onlyFollow) {
        if (onlyFollow) {
            return getBaseMapper().queryLikedTagList(tagId, userId);
        }
        return getBaseMapper().queryAllTagList(tagId, userId);
    }

    @Override
    public void toggleTagListFollow(long tagId, long userId) {
        QueryWrapper<TableTagListLike> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("tag_id",tagId);
        queryWrapper.eq("user_id",userId);
        List<TableTagListLike> tagListLikes = tagListLikeService.getBaseMapper().selectList(queryWrapper);
        if (tagListLikes != null) {
            for (TableTagListLike like : tagListLikes) {
                like.hasLike = like.hasLike == 0 ? 1 : 0;
                tagListLikeService.saveOrUpdate(like);
            }
        }
    }

    @Override
    public boolean hasFollowTag(long tagId, long userId) {
        QueryWrapper<TableTagListLike> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("tag_id", tagId);
        queryWrapper.eq("user_id", userId);
        queryWrapper.last("limit 1");
        TableTagListLike like = tagListLikeService.getBaseMapper().selectOne(queryWrapper);
        return like != null && like.hasLike == 1;
    }
}
