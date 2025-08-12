package com.rainy.video.mock.taglist;

import java.util.List;

public class TagList {

    public BaseHashtagBean base_hashtag;
    public boolean is_follow;
    public int works_num;
    public int followers_num;
    public int enter_num;
    public String id_str;
    public int show_num;

    public static class BaseHashtagBean {
        public int id;
        public String id_str;
        public String name;
        public String intro;
        public IconBean icon;
        public BackgroundImageBean background_image;
        public ActivityIconBean activity_icon;

        public static class IconBean {
            public int width;
            public int height;
            public String uri;
            public List<UrlListBean> url_list;

            public static class UrlListBean {
                public String url;
            }
        }

        public static class BackgroundImageBean {
            public int width;
            public int height;
            public String uri;
            public List<UrlListBeanX> url_list;

            public static class UrlListBeanX {
                public String url;
            }
        }

        public static class ActivityIconBean {
            public String name;
            public String color;
            public IconImageBean icon_image;

            public static class IconImageBean {
                public int width;
                public int height;
                public String uri;
                public List<UrlListBeanXX> url_list;

                public static class UrlListBeanXX {
                    public String url;
                }
            }
        }
    }
}
