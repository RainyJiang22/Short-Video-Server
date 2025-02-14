package com.rainy.video.table;


import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.io.Serializable;

@ApiModel(value = "用户关注")
@Table(name = "table_user_follow")
@Entity
public class TableUserFollow implements Serializable {
    @Id
    @GeneratedValue
    public int id;

    @Column(name = "user_id")
    public long userId;

    @Column(name = "has_follow")
    public int hasFollow;

    @Column(name = "follow_user_id")
    public long followUserId;
}
