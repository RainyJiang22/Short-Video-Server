package com.rainy.video.table;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.io.Serializable;

@ApiModel(value = "帖子对象")
@Entity
@Table(name = "table_hot_feeds")
public class TableHotFeeds implements Serializable {
    @Id
    @GeneratedValue
    public int id;

    @Column(name = "item_id")
    public long itemId;

    @Column(name = "item_type")
    public int itemType = 0;

    @Column(name = "create_time")
    public long createTime;

    @Column(name = "duration", length = 10)
    public double duration;

    @Column(name = "feeds_text",length = 2000)
    public String feedsText;

    @Column(name = "author_id")
    public long authorId;

    @Column(name = "activity_icon")
    public String activityIcon;

    @Column(name = "activity_text")
    public String activityText;

    @Column(name = "width")
    public int width;

    @Column(name = "height")
    public int height;

    @Column(name = "url", length = 1000)
    public String url;

    @Column(name = "cover", length = 1000)
    public String cover;

    @TableField(exist = false)
    public TableUser author;

    @TableField(exist = false)
    public TableFeedsComment topComment;

    @TableField(exist = false)
    public TableFeedUgc ugc;
}
