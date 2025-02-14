package com.rainy.video.table;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;



@Data
@ApiModel(value = "用户对象")
@TableName(value = "table_user")
public class TableUser implements Serializable {
    @Id
    @TableId(value = "user_id", type = IdType.NONE)
    @Column(name = "user_id")
    public long userId;

    @Column(name = "name")
    public String name;

    @Column(name = "avatar", length = 1000)
    public String avatar;

    @Column(name = "description", length = 100)
    public String description;

    @Column(name = "like_count")
    public int likeCount;

    @Column(name = "top_count")
    public int topCount;

    @Column(name = "follow_count")
    public int followCount;

    @Column(name = "follower_count")
    public int followerCount;

    @Column(name = "qq_open_id")
    public String qqOpenId;

    @Column(name = "expires_time")
    public long expiresTime;

    @Column(name = "score")
    public long score;

    @Column(name = "history_count")
    public int historyCount;

    @Column(name = "comment_count")
    public int commentCount;

    @Column(name = "favorite_count")
    public int favoriteCount;

    @Column(name = "feed_count")
    public int feedCount;

     @TableField(exist = false)
    public boolean hasFollow;
}
