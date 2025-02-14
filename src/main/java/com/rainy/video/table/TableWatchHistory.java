package com.rainy.video.table;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.io.Serializable;

@ApiModel(value = "用户关注")
@Table(name = "table_watch_history")
@Entity
public class TableWatchHistory implements Serializable {
    @Id
    @GeneratedValue
    public int id;

    @Column(name = "user_id")
    public long userId;

    @Column(name = "item_id")
    public long itemId;

    @Column(name = "time")
    public long time;
}
