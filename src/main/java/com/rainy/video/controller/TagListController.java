package com.rainy.video.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.rainy.video.ApiResponse;
import com.rainy.video.service.label.TagListService;
import com.rainy.video.table.TableTagList;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Jacky
 * @date 2025/8/12
 **/

@RestController
@RequestMapping(value = "/tag")
@ApiOperation(value = "帖子标签相关")
public class TagListController {

    @Autowired
    TagListService tagListService;

    @ApiOperation(value = "查询tagList数据")
    @RequestMapping(value = "queryTagList", method = RequestMethod.GET)
    @JsonView(value = TableTagList.class)
    public ApiResponse<List<TableTagList>> queryTagList(@RequestParam(value = "tagId", required = false, defaultValue = "0") long tagId,
                                                        @RequestParam(value = "userId", required = false, defaultValue = "0") long userId,
                                                        @RequestParam(value = "tagType", required = false, defaultValue = "all") String tagType) {

        List<TableTagList> lists = tagListService.queryTagList(tagId, userId, tagType.equals("follow"));
        if (userId > 0) {
            for (TableTagList tag : lists) {
                tag.hasFollow = tagListService.hasFollowTag(tag.tagId, userId);
            }
        }

        ApiResponse<List<TableTagList>> response = new ApiResponse<>();
        response.setResult(ApiResponse.STATUS_SUCCESS, null, lists);
        return response;
    }


    @ApiOperation(value = "变更对某个标签的喜欢")
    @RequestMapping(value = "toggleTagFollow", method = RequestMethod.GET)
    @JsonView(value = Boolean.class)
    public ApiResponse<Boolean> toggleTagFollow(@RequestParam(value = "tagId", required = false, defaultValue = "0") long tagId,
                                                @RequestParam(value = "userId", required = false, defaultValue = "0") long userId) {

        ApiResponse<Boolean> response = new ApiResponse<>();
        if (tagId == 0 || userId == 0) {
            response.setResult(ApiResponse.STATUS_FAILED, "tagId 或 userId 不能为空");
            return response;
        }

        tagListService.toggleTagListFollow(tagId, userId);
        boolean followTag = tagListService.hasFollowTag(tagId, userId);
        response.setData("hasFollow", followTag);
        return response;
    }



}
