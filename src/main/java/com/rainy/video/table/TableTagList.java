package com.rainy.video.table;


import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.io.Serializable;

@ApiModel(value = "帖子标签对象")
@Table(name = "table_tag_list")
@Entity
public class TableTagList implements Serializable {
    @Id
    @GeneratedValue
    public int id;

    @Column(name = "icon", length = 1000)
    public String icon;

    @Column(name = "background", length = 1000)
    public String background;

    @Column(name = "activity_icon", length = 1000)
    public String activityIcon;

    @Column(name = "title")
    public String title;

    @Column(name = "intro")
    public String intro;

    @Column(name = "feed_num")
    public int feedNum;

    @Column(name = "tag_id")
    public long tagId;

    @Column(name = "enter_num")
    public int enterNum;

    @Column(name = "follow_num")
    public int followNum;

     @TableField(exist = false)
    public boolean hasFollow;
}
