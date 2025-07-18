package com.rainy.video.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.rainy.video.ApiResponse;
import com.rainy.video.service.user.UserService;
import com.rainy.video.table.TableUser;
import com.rainy.video.table.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Jacky
 * @date 2025/2/12
 **/

@RestController
@RequestMapping("/user")
@ApiOperation(value = "用户信息相关")
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping(value = "query", method = RequestMethod.GET)
    @ApiOperation(value = "查询用户", notes = "根据id来查询用户")
    @JsonView(value = TableUser.class)
    public String query(@RequestParam(value = "userId") long userId) {
        ApiResponse<TableUser> response = new ApiResponse<>();
        TableUser user = userService.queryUser(userId);
//        response.setData(user);
        if (user != null) {
            response.setSuccessResult(user);
        } else {
            response.setFailedResult("用户未找到");
        }
        return response.toString();
    }

    @GetMapping("/insert_test")
    public String insertUserTest() {

        //模拟下插入数据库
        TableUser user = new TableUser();
        user.setName("Test User");
        user.setAvatar("https://example.com/avatar.png");
        user.setDescription("This is a test user.");
        user.setLikeCount(0);
        user.setTopCount(0);
        user.setFollowCount(0);
        user.setFollowerCount(0);
        user.setQqOpenId("test_qq_open_id");
        user.setExpiresTime(System.currentTimeMillis());
        user.setScore(100);
        user.setHistoryCount(0);
        user.setCommentCount(0);
        user.setFavoriteCount(0);
        user.setFeedCount(0);

        int success = userService.insert(user);
        String result;
        if (success == 1) result = "用户插入成功";
        else result = "用户插入失败";
        return result;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    @ApiOperation(value = "插入新的用户", notes = "插入新的用户")
    @JsonView(User.class)
    @ResponseBody
    public String insert(@RequestParam(value = "qqOpenId", required = true) String qqOpenId,
                         @RequestParam(value = "name", required = true) String name,
                         @RequestParam(value = "avatar", required = true) String avatar,
                         @RequestParam(value = "description", required = false, defaultValue = "") String description,
                         @RequestParam(value = "likeCount", required = false, defaultValue = "0") Integer likeCount,
                         @RequestParam(value = "topCommentCount", required = false, defaultValue = "0") Integer topCommentCount,
                         @RequestParam(value = "followCount", required = false, defaultValue = "0") Integer followCount,
                         @RequestParam(value = "expires_time", required = true) long expires_time) {

        TableUser exitOne = userService.queryUserByQQOpenId(qqOpenId);
        if (exitOne == null) {
            exitOne = new TableUser();
            exitOne.userId = System.currentTimeMillis() / 1000;
        }
        exitOne.qqOpenId = qqOpenId;
        exitOne.name = name;
        exitOne.avatar = avatar;
        if (!StringUtils.isEmpty(description)) {
            exitOne.description = description;
        }

        if (topCommentCount > 0) {
            exitOne.description = description;
        }

        if (likeCount > 0) {
            exitOne.likeCount = likeCount;
        }

        if (followCount > 0) {
            exitOne.followerCount = followCount;

        }

        if (expires_time > 0) {
            exitOne.expiresTime = expires_time;
        }
        userService.insert(exitOne);
        TableUser tableUser = userService.queryUser(exitOne.userId);

        ApiResponse<TableUser> response = new ApiResponse<>();
        response.setData(tableUser);

        return response.toString();
    }


    @RequestMapping(value = "delete", method = RequestMethod.GET)
    @ApiOperation(value = "删除用户", notes = "根据id删除用户")
    @JsonView(value = Boolean.class)
    public ApiResponse<Boolean> deleteUser(@RequestParam(value = "userId") long userId) {
        ApiResponse<Boolean> response = new ApiResponse<>();
        int result = userService.delete(userId);
        if (result >= 1) {
            response.setData(true);
        } else {
            response.setData(false);
        }
        return response;
    }


    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ApiOperation(value="更新用户信息", notes = "根据id来更新用户信息")
    @JsonView(value = Boolean.class)
    public ApiResponse<Boolean> update(@RequestParam TableUser user, BindingResult binding) {
        ApiResponse<Boolean> response = new ApiResponse<>();
        int result = userService.update(user);
        if (result >= 1) {
            response.setData(true);
        } else {
            response.setData(false);
        }
        return response;

    }


    @RequestMapping(value = "queryFans", method = RequestMethod.GET)
    @ApiOperation(value = "查询粉丝列表", notes = "查询粉丝列表")
    @JsonView(User.class)
    public String queryFans(@RequestParam(value = "userId", defaultValue = "0") Long userId,
                            @RequestParam(value = "page", defaultValue = "0") Integer page,
                            @RequestParam(value = "pageCount", defaultValue = "10", required = false) Integer pageCount) {
        ApiResponse<List<TableUser>> response = new ApiResponse<>();
        if (userId == 0) {
            response.setData(null);
            return response.toString();
        }
        List<TableUser> users = userService.queryFans(userId, pageCount * page, pageCount);
        response.setData(users);
        return response.toString();
    }

    @RequestMapping(value = "queryFollows", method = RequestMethod.GET)
    @ApiOperation(value = "查询关注列表", notes = "查询关注列表")
    @JsonView(User.class)
    public String queryFollows(@RequestParam(value = "userId", defaultValue = "0") Long userId,
                               @RequestParam(value = "page", defaultValue = "0") Integer page,
                               @RequestParam(value = "pageCount", defaultValue = "10", required = false) Integer pageCount) {
        ApiResponse<List<TableUser>> response = new ApiResponse<>();
        if (userId == 0) {
            response.setData(null);
            return response.toString();
        }
        List<TableUser> users = userService.queryFollows(userId, pageCount * page, pageCount);
        response.setData(users);
        return response.toString();
    }

}
