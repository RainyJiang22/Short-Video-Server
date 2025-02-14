package com.rainy.video.table;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.io.Serializable;

@ApiModel(value = "帖子标签对象-已喜欢")
@Table(name = "table_tag_list_like")
@Entity
public class TableTagListLike implements Serializable {
    @Id
    @GeneratedValue
    public int id;

    @Column(name = "user_id")
    public long userId;

    @Column(name = "tag_id")
    public int tagId;

    @Column(name = "has_like")
    public int hasLike;
}
