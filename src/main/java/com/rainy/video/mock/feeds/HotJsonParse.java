package com.rainy.video.mock.feeds;

import com.alibaba.fastjson.JSON;
import com.google.gson.reflect.TypeToken;
import com.rainy.video.table.TableHotFeeds;
import com.rainy.video.table.TableTagList;
import com.rainy.video.table.TableUser;

import java.io.*;
import java.util.List;
import java.util.Random;

public class HotJsonParse {
    public static TableHotFeeds parseFeedsJson() {
        String hotJson = readFile("src/main/java/com/rainy/video/mock/feeds/feed.json");
        HotFeeds hotFeed = JSON.parseObject(hotJson, HotFeeds.class);
        HotFeeds.DataDTO.ItemDTO itemDTO = hotFeed.data.item;
        if (itemDTO.author == null) {
            return null;
        }
        TableHotFeeds tableHotFeed = new TableHotFeeds();

        tableHotFeed.itemId = System.currentTimeMillis();
        tableHotFeed.createTime = System.currentTimeMillis();
        tableHotFeed.feedsText = itemDTO.content;

        // image
        if (itemDTO.cover != null) {
            tableHotFeed.width = itemDTO.cover.width;
            tableHotFeed.height = itemDTO.cover.height;
            if (itemDTO.cover.downloadList != null && itemDTO.cover.downloadList.size() > 0) {
                tableHotFeed.cover = itemDTO.cover.downloadList.get(0).url;
            }
            tableHotFeed.itemType = 1;
        }

        // video
        if (itemDTO.video != null && itemDTO.video.videoDownload != null && itemDTO.video.videoDownload.urlList != null) {
            tableHotFeed.url = itemDTO.video.videoDownload.urlList.get(0).url;
            tableHotFeed.duration = itemDTO.video.duration;
            tableHotFeed.width = itemDTO.video.videoWidth;
            tableHotFeed.height = itemDTO.video.videoHeight;
            if (itemDTO.video.coverImage != null) {
                if (itemDTO.video.coverImage.downloadList != null && itemDTO.video.coverImage.downloadList.size() > 0) {
                    tableHotFeed.cover = itemDTO.video.coverImage.downloadList.get(0).url;
                }
            }
            tableHotFeed.feedsText = itemDTO.video.text;
            tableHotFeed.itemType = 2;
        }

        // author
        TableUser tableUser = new TableUser();
        tableUser.userId = System.currentTimeMillis();
        tableUser.avatar = itemDTO.author.avatar.downloadList.get(0).url;
        tableUser.name = itemDTO.author.name;
        tableUser.description = itemDTO.author.description;
        tableUser.followerCount = itemDTO.author.followersCount;
        tableUser.likeCount = itemDTO.author.likeCount;
        tableUser.qqOpenId = itemDTO.author.idStr;
        tableHotFeed.authorId = tableUser.userId;
        tableHotFeed.author = tableUser;

        // activity
        List<TableTagList> tagLists = getTableTagList();
        int size = tagLists.size();
        TableTagList tagList = tagLists.get(new Random().nextInt(size));
        tableHotFeed.activityIcon =tagList.activityIcon;
        tableHotFeed.activityText =tagList.title;

        return tableHotFeed;
    }

    public static String readFile(String fileName) {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        StringBuilder builder = new StringBuilder();
        try {
            File file = new File(fileName);
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null) {
                builder.append(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {

                }
            }

            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return builder.toString();
    }

    static List<TableTagList> tableTagLists = null;

    public static List<TableTagList> getTableTagList() {
        if (tableTagLists != null) {
            return tableTagLists;
        }
        String tagListResponse = "[\n" +
                "      {\n" +
                "        \"id\": 62,\n" +
                "        \"icon\": \"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/21434249C0E2090713793722702E4487.jpg\",\n" +
                "        \"background\": \"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/2222.png\",\n" +
                "        \"activityIcon\": \"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/51f076f662ef40c99f056a41b130c516.png\",\n" +
                "        \"title\": \"2020新年快乐\",\n" +
                "        \"intro\": \"2020年展望未来，许下美好的愿望\",\n" +
                "        \"feedNum\": 101,\n" +
                "        \"tagId\": 2,\n" +
                "        \"enterNum\": 1001,\n" +
                "        \"followNum\": 101,\n" +
                "        \"hasFollow\": false\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 61,\n" +
                "        \"icon\": \"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/icon_etpack.png\",\n" +
                "        \"background\": \"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/1111.png\",\n" +
                "        \"activityIcon\": \"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/51f076f662ef40c99f056a41b130c516.png\",\n" +
                "        \"title\": \"2019高光时刻\",\n" +
                "        \"intro\": \"2019年那些事,有哪些最让你怀念呢？\",\n" +
                "        \"feedNum\": 100,\n" +
                "        \"tagId\": 1,\n" +
                "        \"enterNum\": 1000,\n" +
                "        \"followNum\": 100,\n" +
                "        \"hasFollow\": false\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 63,\n" +
                "        \"icon\": \"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/%E5%A4%9A%E5%BD%A9%E5%85%AC%E9%B8%A1.jpg\",\n" +
                "        \"background\": \"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/%E5%A4%9A%E5%BD%A9%E5%85%AC%E9%B8%A1.jpg\",\n" +
                "        \"activityIcon\": \"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/51f076f662ef40c99f056a41b130c516.png\",\n" +
                "        \"title\": \"多彩生活\",\n" +
                "        \"intro\": \"多彩生活，由于这只多彩公鸡\",\n" +
                "        \"feedNum\": 100,\n" +
                "        \"tagId\": 3,\n" +
                "        \"enterNum\": 1000,\n" +
                "        \"followNum\": 100,\n" +
                "        \"hasFollow\": false\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 64,\n" +
                "        \"icon\": \"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/%E8%80%83%E6%8B%89.jpg\",\n" +
                "        \"background\": \"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/%E8%80%83%E6%8B%89.jpg\",\n" +
                "        \"activityIcon\": \"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/51f076f662ef40c99f056a41b130c516.png\",\n" +
                "        \"title\": \"Aukoala\",\n" +
                "        \"intro\": \"考拉 作为澳大利亚本土品牌，澳考拉雪地靴由麦克森（Bill.Decksen）于上世纪70年代初创立Decksen公司所有，是澳大利亚人最喜欢的雪地靴品牌之一。\",\n" +
                "        \"feedNum\": 100,\n" +
                "        \"tagId\": 4,\n" +
                "        \"enterNum\": 1000,\n" +
                "        \"followNum\": 100,\n" +
                "        \"hasFollow\": false\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 65,\n" +
                "        \"icon\": \"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/relaxing-1979674_640.jpg\",\n" +
                "        \"background\": \"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/relaxing-1979674_640.jpg\",\n" +
                "        \"activityIcon\": \"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/51f076f662ef40c99f056a41b130c516.png\",\n" +
                "        \"title\": \"放松时刻\",\n" +
                "        \"intro\": \"放松时刻,放松下自己\",\n" +
                "        \"feedNum\": 100,\n" +
                "        \"tagId\": 5,\n" +
                "        \"enterNum\": 1000,\n" +
                "        \"followNum\": 100,\n" +
                "        \"hasFollow\": false\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 67,\n" +
                "        \"icon\": \"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/lol.jpg\",\n" +
                "        \"background\": \"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/lol.jpg\",\n" +
                "        \"activityIcon\": \"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/51f076f662ef40c99f056a41b130c516.png\",\n" +
                "        \"title\": \"王者峡谷\",\n" +
                "        \"intro\": \"高能时刻，峡谷精彩瞬间\",\n" +
                "        \"feedNum\": 100,\n" +
                "        \"tagId\": 7,\n" +
                "        \"enterNum\": 1000,\n" +
                "        \"followNum\": 100,\n" +
                "        \"hasFollow\": false\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 68,\n" +
                "        \"icon\": \"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/geometry-1044090_640.jpg\",\n" +
                "        \"background\": \"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/geometry-1044090_640.jpg\",\n" +
                "        \"activityIcon\": \"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/51f076f662ef40c99f056a41b130c516.png\",\n" +
                "        \"title\": \"百年教育\",\n" +
                "        \"intro\": \"百年大计，教育大业\",\n" +
                "        \"feedNum\": 100,\n" +
                "        \"tagId\": 8,\n" +
                "        \"enterNum\": 1000,\n" +
                "        \"followNum\": 100,\n" +
                "        \"hasFollow\": false\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 69,\n" +
                "        \"icon\": \"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/food-984441_640.jpg\",\n" +
                "        \"background\": \"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/food-984441_640.jpg\",\n" +
                "        \"activityIcon\": \"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/51f076f662ef40c99f056a41b130c516.png\",\n" +
                "        \"title\": \"舌尖上的美食\",\n" +
                "        \"intro\": \"舌尖上的美食，纵览让人垂涎三尺的美食\",\n" +
                "        \"feedNum\": 100,\n" +
                "        \"tagId\": 9,\n" +
                "        \"enterNum\": 1000,\n" +
                "        \"followNum\": 100,\n" +
                "        \"hasFollow\": false\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 70,\n" +
                "        \"icon\": \"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/emotion-2167582_640.jpg\",\n" +
                "        \"background\": \"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/emotion-2167582_640.jpg\",\n" +
                "        \"activityIcon\": \"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/51f076f662ef40c99f056a41b130c516.png\",\n" +
                "        \"title\": \"国宝熊猫\",\n" +
                "        \"intro\": \"看起来憨厚，据说当年蚩尤骑着这货打天下\",\n" +
                "        \"feedNum\": 100,\n" +
                "        \"tagId\": 10,\n" +
                "        \"enterNum\": 1000,\n" +
                "        \"followNum\": 100,\n" +
                "        \"hasFollow\": false\n" +
                "      }\n" +
                "    ]";
        tableTagLists = JSON.parseObject(tagListResponse, new TypeToken<List<TableTagList>>() {
        }.getType());
        return tableTagLists;
    }
}
