package com.rainy.video.table;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.io.Serializable;

@ApiModel(value = "帖子评论对象-ugc")
@Entity
@Table(name = "table_feeds_comment_ugc")
public class TableFeedsCommentUgc implements Serializable {

    @Id
    @GeneratedValue
    public int id;

    @Column(name = "comment_id")
    public long commentId;

    @Column(name = "like_count")
    public long likeCount;

//    @Column(name = "share_count")
//    public int shareCount;
//
//    @Column(name = "comment_count")
//    public long commentCount;

    @TableField(exist = false)
    public boolean hasLiked;

}
