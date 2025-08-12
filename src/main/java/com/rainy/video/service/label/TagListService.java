package com.rainy.video.service.label;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rainy.video.table.TableTagList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Jacky
 * @date 2025/8/12
 **/


public interface TagListService extends IService<TableTagList> {
    List<TableTagList> queryTagList(@Param("tagId") long tagId, @Param("userId") long userId, @Param("onlyFollow") boolean onlyFollow);

    void toggleTagListFollow(@Param("tagId") long tagId, @Param("userId") long userId);

    boolean hasFollowTag(@Param("tagId") long tagId, @Param("userId") long userId);

}
