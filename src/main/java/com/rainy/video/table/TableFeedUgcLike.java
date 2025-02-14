package com.rainy.video.table;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.io.Serializable;

@ApiModel(value = "帖子对象-已喜欢")
@Table(name = "table_feed_ugc_like")
@Entity
public class TableFeedUgcLike implements Serializable {
    @Id
    @GeneratedValue
    public int id;

    @Column(name = "user_id")
    public long userId;

    @Column(name = "item_id")
    public long itemId;

    @Column(name = "has_like")
    public int hasLike;

    @Column(name = "has_diss")
    public int hasDiss;

    @Column(name = "has_favorite")
    public int hasFavorite;
}
