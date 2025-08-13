package com.rainy.video.table;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.io.Serializable;


@ApiModel(value = "帖子互动对象")
@Table(name = "table_feed_ugc")
@Entity
@JsonIgnoreProperties({"id"})
public class TableFeedUgc implements Serializable {
    @Id
    @GeneratedValue
    public int id;

    @Column(name = "item_id")
    public long itemId;

    @Column(name = "like_count")
    public int likeCount;

    @Column(name = "share_count")
    public int shareCount;

    @Column(name = "comment_count")
    public int commentCount;

     @TableField(exist = false)
    public boolean hasFavorite;

     @TableField(exist = false)
    public boolean hasLiked;

     @TableField(exist = false)
    public boolean hasdiss;
}
