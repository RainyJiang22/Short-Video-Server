package com.rainy.video.table;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.io.Serializable;

@ApiModel(value = "帖子评论对象-ugc-like")
@Entity
@Table(name = "table_feeds_comment_like")
public class TableFeedsCommentLike implements Serializable {

    @Id
    @GeneratedValue
    public int id;

    @Column(name = "comment_id")
    public long commentId;

    @Column(name = "user_id")
    public long userId;

    @Column(name = "has_like")
    public int hasLike;
}
