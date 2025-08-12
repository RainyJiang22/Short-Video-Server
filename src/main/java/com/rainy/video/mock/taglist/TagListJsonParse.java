package com.rainy.video.mock.taglist;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.rainy.video.mock.feeds.HotJsonParse;
import com.rainy.video.table.TableTagList;

import java.util.ArrayList;
import java.util.List;

public class TagListJsonParse {
    public static List<TableTagList> parseTagListJson() {
        String json = HotJsonParse.readFile("src/main/java/com/rainy/video/mock/taglist/mock.json");
        JSONObject object = JSON.parseObject(json);
        JSONArray jsonArray = object.getJSONObject("data").getJSONArray("hashtags");

        List<TableTagList> lists = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            TagList tagList = JSON.parseObject(jsonObject.toString(), TagList.class);
            if (tagList == null)
                continue;
            TagList.BaseHashtagBean base_hashtag = tagList.base_hashtag;
            if (base_hashtag == null)
                continue;
            List<TagList.BaseHashtagBean.BackgroundImageBean.UrlListBeanX> url_list = base_hashtag.background_image.url_list;
            TableTagList tag = new TableTagList();
            tag.tagId = base_hashtag.id;
            tag.icon = base_hashtag.icon.url_list.get(0).url;
            tag.background = url_list != null && url_list.size() > 0 ? url_list.get(0).url : null;
            tag.activityIcon = base_hashtag.activity_icon.icon_image.url_list.get(0).url;
            tag.title = base_hashtag.name;
            tag.intro = base_hashtag.intro;
            tag.enterNum = tagList.enter_num;
            tag.feedNum = tagList.works_num;
            tag.followNum = tagList.followers_num;

            lists.add(tag);
        }
        return lists;
    }
}
