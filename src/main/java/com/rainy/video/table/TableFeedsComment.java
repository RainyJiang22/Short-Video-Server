package com.rainy.video.table;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@ApiModel(value = "帖子评论对象")
@Table(name = "table_feeds_comment")
@JsonIgnoreProperties({"TEXT", "IMAGE", "VIDEO"})
public class TableFeedsComment implements Serializable {

    public static final int TEXT = 1;
    public static final int IMAGE = 2;
    public static final int VIDEO = 3;

    @Id
    @GeneratedValue
    public int id;

    @Column(name = "item_id")
    public long itemId;

    @Column(name = "comment_id")
    public long commentId;

    @Column(name = "user_id")
    public long userId;

    //1 文字 2图片 3视频
    @Column(name = "comment_type")
    public int commentType;

    @Column(name = "create_time")
    public long createTime;

//    @Column(name = "comment_count")
//    public int commentCount;
//
//    @Column(name = "like_count")
//    public int likeCount;

    @Column(name = "comment_text", length = 200)
    public String commentText;

    @Column(name = "image_url", length = 1000)
    public String imageUrl;

    @Column(name = "video_url", length = 1000)
    public String videoUrl;

    @Column(name = "width")
    public int width;

    @Column(name = "height")
    public int height;

//    @TableField(exist = false)
//    public boolean hasLiked;

    @TableField(exist = false)
    public TableUser author;

    @TableField(exist = false)
    public TableFeedsCommentUgc commentUgc;
}
