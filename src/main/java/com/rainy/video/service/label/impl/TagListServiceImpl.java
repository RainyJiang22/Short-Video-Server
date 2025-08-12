package com.rainy.video.service.label.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rainy.video.mapper.TagListMapper;
import com.rainy.video.service.label.TagListService;
import com.rainy.video.table.TableTagList;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**s
 * @author Jacky
 * @date 2025/8/12
 **/

@Primary
@Service
public class TagListServiceImpl extends ServiceImpl<TagListMapper, TableTagList> implements TagListService {

}
