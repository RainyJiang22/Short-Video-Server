package com.rainy.video.mock.comments;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FeedsComment {


    /**
     * statusCode
     */
    @SerializedName("status_code")
    public Integer statusCode;
    /**
     * message
     */
    @SerializedName("message")
    public String message;
    /**
     * prompt
     */
    @SerializedName("prompt")
    public String prompt;
    /**
     * time
     */
    @SerializedName("time")
    public Long time;
    /**
     * data
     */
    @SerializedName("data")
    public DataDTO data;

    public static class DataDTO {
        /**
         * cellComments
         */
        @SerializedName("cell_comments")
        public List<CellCommentsDTO> cellComments;

        public static class CellCommentsDTO {
            /**
             * cellType
             */
            @SerializedName("cell_type")
            public Integer cellType;
            /**
             * cellId
             */
            @SerializedName("cell_id")
            public Long cellId;
            /**
             * cellIdStr
             */
            @SerializedName("cell_id_str")
            public String cellIdStr;
            /**
             * displayTime
             */
            @SerializedName("display_time")
            public Integer displayTime;
            /**
             * commentInfo
             */
            @SerializedName("comment_info")
            public CommentInfoDTO commentInfo;
            /**
             * passThrough
             */
            @SerializedName("pass_through")
            public String passThrough;
            /**
             * stickup
             */
            @SerializedName("stickup")
            public Boolean stickup;
            /**
             * lastViewTime
             */
            @SerializedName("last_view_time")
            public Integer lastViewTime;
            /**
             * cityName
             */
            @SerializedName("city_name")
            public String cityName;

            public static class CommentInfoDTO {
                /**
                 * commentId
                 */
                @SerializedName("comment_id")
                public Long commentId;
                /**
                 * commentIdStr
                 */
                @SerializedName("comment_id_str")
                public String commentIdStr;
                /**
                 * createTime
                 */
                @SerializedName("create_time")
                public Integer createTime;
                /**
                 * text
                 */
                @SerializedName("text")
                public String text;
                /**
                 * status
                 */
                @SerializedName("status")
                public Integer status;
                /**
                 * type
                 */
                @SerializedName("type")
                public Integer type;
                /**
                 * item
                 */
                @SerializedName("item")
                public ItemDTO item;
                /**
                 * user
                 */
                @SerializedName("user")
                public UserDTO user;
                /**
                 * likeCount
                 */
                @SerializedName("like_count")
                public Integer likeCount;
                /**
                 * hasLiked
                 */
                @SerializedName("has_liked")
                public Boolean hasLiked;
                /**
                 * share
                 */
                @SerializedName("share")
                public ShareDTO share;
                /**
                 * replyCount
                 */
                @SerializedName("reply_count")
                public Integer replyCount;
                /**
                 * replies
                 */
                @SerializedName("replies")
                public List<?> replies;
                /**
                 * commentCount
                 */
                @SerializedName("comment_count")
                public Integer commentCount;
                /**
                 * itemId
                 */
                @SerializedName("item_id")
                public Long itemId;
                /**
                 * bdsOriginType
                 */
                @SerializedName("bds_origin_type")
                public Integer bdsOriginType;
                /**
                 * shareCount
                 */
                @SerializedName("share_count")
                public Integer shareCount;
                /**
                 * revealReplies
                 */
                @SerializedName("reveal_replies")
                public List<?> revealReplies;
                /**
                 * wardInfo
                 */
                @SerializedName("ward_info")
                public WardInfoDTO wardInfo;
                /**
                 * isWardComment
                 */
                @SerializedName("is_ward_comment")
                public Boolean isWardComment;
                /**
                 * frozenToast
                 */
                @SerializedName("frozen_toast")
                public String frozenToast;
                /**
                 * highlight
                 */
                @SerializedName("highlight")
                public Boolean highlight;
                /**
                 * lightspotTime
                 */
                @SerializedName("lightspot_time")
                public Integer lightspotTime;
                /**
                 * hasAuthorLike
                 */
                @SerializedName("has_author_like")
                public Boolean hasAuthorLike;
                /**
                 * interactEgg
                 */
                @SerializedName("interact_egg")
                public InteractEggDTO interactEgg;
                /**
                 * rootCellId
                 */
                @SerializedName("root_cell_id")
                public Long rootCellId;
                /**
                 * rootCellType
                 */
                @SerializedName("root_cell_type")
                public Integer rootCellType;
                /**
                 * sendGodStatus
                 */
                @SerializedName("send_god_status")
                public Integer sendGodStatus;
                /**
                 * wardContentType
                 */
                @SerializedName("ward_content_type")
                public Integer wardContentType;
                /**
                 * canDelete
                 */
                @SerializedName("can_delete")
                public Boolean canDelete;
                /**
                 * isJiegeng
                 */
                @SerializedName("is_jiegeng")
                public Boolean isJiegeng;
                /**
                 * canDownload
                 */
                @SerializedName("can_download")
                public Boolean canDownload;
                /**
                 * withRepost
                 */
                @SerializedName("with_repost")
                public Boolean withRepost;
                /**
                 * buryCount
                 */
                @SerializedName("bury_count")
                public Integer buryCount;
                /**
                 * hasBuried
                 */
                @SerializedName("has_buried")
                public Boolean hasBuried;
                /**
                 * supportLivePhoto
                 */
                @SerializedName("support_live_photo")
                public Boolean supportLivePhoto;
                /**
                 * tagInfo
                 */
                @SerializedName("tag_info")
                public TagInfoDTO tagInfo;
                /**
                 * rewardInfo
                 */
                @SerializedName("reward_info")
                public RewardInfoDTO rewardInfo;
                /**
                 * logCommentExtra
                 */
                @SerializedName("log_comment_extra")
                public String logCommentExtra;

                public static class ItemDTO {
                    /**
                     * itemId
                     */
                    @SerializedName("item_id")
                    public Long itemId;
                    /**
                     * itemIdStr
                     */
                    @SerializedName("item_id_str")
                    public String itemIdStr;
                    /**
                     * itemType
                     */
                    @SerializedName("item_type")
                    public Integer itemType;
                    /**
                     * content
                     */
                    @SerializedName("content")
                    public String content;
                    /**
                     * cover
                     */
                    @SerializedName("cover")
                    public CoverDTO cover;
                    /**
                     * status
                     */
                    @SerializedName("status")
                    public Integer status;
                    /**
                     * author
                     */
                    @SerializedName("author")
                    public AuthorDTO author;
                    /**
                     * createTime
                     */
                    @SerializedName("create_time")
                    public Integer createTime;
                    /**
                     * itemCellType
                     */
                    @SerializedName("item_cell_type")
                    public Integer itemCellType;
                    /**
                     * canDownload
                     */
                    @SerializedName("can_download")
                    public Boolean canDownload;
                    /**
                     * duration
                     */
                    @SerializedName("duration")
                    public Double duration;
                    /**
                     * video
                     */
                    @SerializedName("video")
                    public VideoDTO video;

                    public static class CoverDTO {
                        /**
                         * width
                         */
                        @SerializedName("width")
                        public Integer width;
                        /**
                         * height
                         */
                        @SerializedName("height")
                        public Integer height;
                        /**
                         * uri
                         */
                        @SerializedName("uri")
                        public String uri;
                        /**
                         * urlList
                         */
                        @SerializedName("url_list")
                        public List<UrlListDTO> urlList;
                        /**
                         * isGif
                         */
                        @SerializedName("is_gif")
                        public Boolean isGif;
                        /**
                         * downloadList
                         */
                        @SerializedName("download_list")
                        public List<UrlListDTO> downloadList;

                        public static class UrlListDTO {
                            /**
                             * url
                             */
                            @SerializedName("url")
                            public String url;
                        }
                    }

                    public static class AuthorDTO {
                        /**
                         * id
                         */
                        @SerializedName("id")
                        public Long id;
                        /**
                         * idStr
                         */
                        @SerializedName("id_str")
                        public String idStr;
                        /**
                         * name
                         */
                        @SerializedName("name")
                        public String name;
                        /**
                         * avatar
                         */
                        @SerializedName("avatar")
                        public AvatarDTO avatar;
                        /**
                         * followersCount
                         */
                        @SerializedName("followers_count")
                        public Integer followersCount;
                        /**
                         * followingsCount
                         */
                        @SerializedName("followings_count")
                        public Integer followingsCount;
                        /**
                         * likeCount
                         */
                        @SerializedName("like_count")
                        public Integer likeCount;
                        /**
                         * level
                         */
                        @SerializedName("level")
                        public Integer level;
                        /**
                         * description
                         */
                        @SerializedName("description")
                        public String description;
                        /**
                         * profileSchema
                         */
                        @SerializedName("profile_schema")
                        public String profileSchema;
                        /**
                         * godCommentCount
                         */
                        @SerializedName("god_comment_count")
                        public Integer godCommentCount;
                        /**
                         * voteCount
                         */
                        @SerializedName("vote_count")
                        public Integer voteCount;
                        /**
                         * achievements
                         */
                        @SerializedName("achievements")
                        public List<AchievementsDTO> achievements;
                        /**
                         * status
                         */
                        @SerializedName("status")
                        public Integer status;
                        /**
                         * liveAuth
                         */
                        @SerializedName("live_auth")
                        public Boolean liveAuth;
                        /**
                         * region
                         */
                        @SerializedName("region")
                        public String region;
                        /**
                         * language
                         */
                        @SerializedName("language")
                        public String language;
                        /**
                         * gender
                         */
                        @SerializedName("gender")
                        public Integer gender;
                        /**
                         * age
                         */
                        @SerializedName("age")
                        public String age;
                        /**
                         * horoscope
                         */
                        @SerializedName("horoscope")
                        public String horoscope;
                        /**
                         * medalInfo
                         */
                        @SerializedName("medal_info")
                        public MedalInfoDTO medalInfo;

                        public static class AvatarDTO {
                            /**
                             * width
                             */
                            @SerializedName("width")
                            public Integer width;
                            /**
                             * height
                             */
                            @SerializedName("height")
                            public Integer height;
                            /**
                             * uri
                             */
                            @SerializedName("uri")
                            public String uri;
                            /**
                             * urlList
                             */
                            @SerializedName("url_list")
                            public List<CoverDTO.UrlListDTO> urlList;
                            /**
                             * isGif
                             */
                            @SerializedName("is_gif")
                            public Boolean isGif;
                            /**
                             * downloadList
                             */
                            @SerializedName("download_list")
                            public List<CoverDTO.UrlListDTO> downloadList;
                        }

                        public static class MedalInfoDTO {
                            /**
                             * totalMedal
                             */
                            @SerializedName("total_medal")
                            public Integer totalMedal;
                            /**
                             * wallSchema
                             */
                            @SerializedName("wall_schema")
                            public String wallSchema;
                        }

                        public static class AchievementsDTO {
                            /**
                             * achieveType
                             */
                            @SerializedName("achieve_type")
                            public Integer achieveType;
                            /**
                             * description
                             */
                            @SerializedName("description")
                            public String description;
                            /**
                             * icon
                             */
                            @SerializedName("icon")
                            public String icon;
                            /**
                             * schema
                             */
                            @SerializedName("schema")
                            public String schema;
                            /**
                             * achieveId
                             */
                            @SerializedName("achieve_id")
                            public Integer achieveId;
                        }
                    }

                    public static class VideoDTO {
                        /**
                         * videoId
                         */
                        @SerializedName("video_id")
                        public String videoId;
                        /**
                         * text
                         */
                        @SerializedName("text")
                        public String text;
                        /**
                         * coverImage
                         */
                        @SerializedName("cover_image")
                        public CoverImageDTO coverImage;
                        /**
                         * duration
                         */
                        @SerializedName("duration")
                        public Double duration;
                        /**
                         * videoWidth
                         */
                        @SerializedName("video_width")
                        public Integer videoWidth;
                        /**
                         * videoHeight
                         */
                        @SerializedName("video_height")
                        public Integer videoHeight;
                        /**
                         * videoDownload
                         */
                        @SerializedName("video_download")
                        public VideoDownloadDTO videoDownload;
                        /**
                         * videoHigh
                         */
                        @SerializedName("video_high")
                        public VideoHighDTO videoHigh;
                        /**
                         * videoFallback
                         */
                        @SerializedName("video_fallback")
                        public VideoFallbackDTO videoFallback;
                        /**
                         * transport
                         */
                        @SerializedName("transport")
                        public Boolean transport;
                        /**
                         * transportText
                         */
                        @SerializedName("transport_text")
                        public String transportText;
                        /**
                         * supportLivePhoto
                         */
                        @SerializedName("support_live_photo")
                        public Boolean supportLivePhoto;
                        /**
                         * tailAdPassthrough
                         */
                        @SerializedName("tail_ad_passthrough")
                        public String tailAdPassthrough;

                        public static class CoverImageDTO {
                            /**
                             * width
                             */
                            @SerializedName("width")
                            public Integer width;
                            /**
                             * height
                             */
                            @SerializedName("height")
                            public Integer height;
                            /**
                             * uri
                             */
                            @SerializedName("uri")
                            public String uri;
                            /**
                             * urlList
                             */
                            @SerializedName("url_list")
                            public List<CoverDTO.UrlListDTO> urlList;
                            /**
                             * isGif
                             */
                            @SerializedName("is_gif")
                            public Boolean isGif;
                            /**
                             * downloadList
                             */
                            @SerializedName("download_list")
                            public List<CoverDTO.UrlListDTO> downloadList;
                        }

                        public static class VideoDownloadDTO {
                            /**
                             * uri
                             */
                            @SerializedName("uri")
                            public String uri;
                            /**
                             * width
                             */
                            @SerializedName("width")
                            public Integer width;
                            /**
                             * height
                             */
                            @SerializedName("height")
                            public Integer height;
                            /**
                             * urlList
                             */
                            @SerializedName("url_list")
                            public List<?> urlList;
                            /**
                             * coverImage
                             */
                            @SerializedName("cover_image")
                            public CoverImageDTO coverImage;
                            /**
                             * duration
                             */
                            @SerializedName("duration")
                            public Double duration;
                            /**
                             * videoModel
                             */
                            @SerializedName("video_model")
                            public String videoModel;

                            public static class CoverImageDTO {
                                /**
                                 * width
                                 */
                                @SerializedName("width")
                                public Integer width;
                                /**
                                 * height
                                 */
                                @SerializedName("height")
                                public Integer height;
                                /**
                                 * uri
                                 */
                                @SerializedName("uri")
                                public String uri;
                                /**
                                 * urlList
                                 */
                                @SerializedName("url_list")
                                public List<CoverDTO.UrlListDTO> urlList;
                                /**
                                 * isGif
                                 */
                                @SerializedName("is_gif")
                                public Boolean isGif;
                            }
                        }

                        public static class VideoHighDTO {
                            /**
                             * uri
                             */
                            @SerializedName("uri")
                            public String uri;
                            /**
                             * width
                             */
                            @SerializedName("width")
                            public Integer width;
                            /**
                             * height
                             */
                            @SerializedName("height")
                            public Integer height;
                            /**
                             * urlList
                             */
                            @SerializedName("url_list")
                            public List<UrlListDTO> urlList;
                            /**
                             * coverImage
                             */
                            @SerializedName("cover_image")
                            public CoverImageDTO coverImage;
                            /**
                             * duration
                             */
                            @SerializedName("duration")
                            public Double duration;
                            /**
                             * codecType
                             */
                            @SerializedName("codec_type")
                            public Integer codecType;
                            /**
                             * definition
                             */
                            @SerializedName("definition")
                            public Integer definition;
                            /**
                             * videoModel
                             */
                            @SerializedName("video_model")
                            public String videoModel;

                            public static class CoverImageDTO {
                                /**
                                 * width
                                 */
                                @SerializedName("width")
                                public Integer width;
                                /**
                                 * height
                                 */
                                @SerializedName("height")
                                public Integer height;
                                /**
                                 * uri
                                 */
                                @SerializedName("uri")
                                public String uri;
                                /**
                                 * urlList
                                 */
                                @SerializedName("url_list")
                                public List<CoverDTO.UrlListDTO> urlList;
                                /**
                                 * isGif
                                 */
                                @SerializedName("is_gif")
                                public Boolean isGif;
                                /**
                                 * downloadList
                                 */
                                @SerializedName("download_list")
                                public List<CoverDTO.UrlListDTO> downloadList;
                            }

                            public static class UrlListDTO {
                                /**
                                 * url
                                 */
                                @SerializedName("url")
                                public String url;
                                /**
                                 * expires
                                 */
                                @SerializedName("expires")
                                public Integer expires;
                            }
                        }

                        public static class VideoFallbackDTO {
                            /**
                             * uri
                             */
                            @SerializedName("uri")
                            public String uri;
                            /**
                             * width
                             */
                            @SerializedName("width")
                            public Integer width;
                            /**
                             * height
                             */
                            @SerializedName("height")
                            public Integer height;
                            /**
                             * urlList
                             */
                            @SerializedName("url_list")
                            public List<?> urlList;
                            /**
                             * coverImage
                             */
                            @SerializedName("cover_image")
                            public CoverImageDTO coverImage;
                            /**
                             * duration
                             */
                            @SerializedName("duration")
                            public Double duration;
                            /**
                             * videoModel
                             */
                            @SerializedName("video_model")
                            public String videoModel;

                            public static class CoverImageDTO {
                                /**
                                 * width
                                 */
                                @SerializedName("width")
                                public Integer width;
                                /**
                                 * height
                                 */
                                @SerializedName("height")
                                public Integer height;
                                /**
                                 * uri
                                 */
                                @SerializedName("uri")
                                public String uri;
                                /**
                                 * urlList
                                 */
                                @SerializedName("url_list")
                                public List<CoverDTO.UrlListDTO> urlList;
                                /**
                                 * isGif
                                 */
                                @SerializedName("is_gif")
                                public Boolean isGif;
                            }
                        }
                    }
                }

                public static class UserDTO {
                    /**
                     * id
                     */
                    @SerializedName("id")
                    public Long id;
                    /**
                     * idStr
                     */
                    @SerializedName("id_str")
                    public String idStr;
                    /**
                     * name
                     */
                    @SerializedName("name")
                    public String name;
                    /**
                     * avatar
                     */
                    @SerializedName("avatar")
                    public AvatarDTO avatar;
                    /**
                     * followersCount
                     */
                    @SerializedName("followers_count")
                    public Integer followersCount;
                    /**
                     * followingsCount
                     */
                    @SerializedName("followings_count")
                    public Integer followingsCount;
                    /**
                     * likeCount
                     */
                    @SerializedName("like_count")
                    public Integer likeCount;
                    /**
                     * level
                     */
                    @SerializedName("level")
                    public Integer level;
                    /**
                     * description
                     */
                    @SerializedName("description")
                    public String description;
                    /**
                     * profileSchema
                     */
                    @SerializedName("profile_schema")
                    public String profileSchema;
                    /**
                     * godCommentCount
                     */
                    @SerializedName("god_comment_count")
                    public Integer godCommentCount;
                    /**
                     * voteCount
                     */
                    @SerializedName("vote_count")
                    public Integer voteCount;
                    /**
                     * achievements
                     */
                    @SerializedName("achievements")
                    public List<ItemDTO.AuthorDTO.AchievementsDTO> achievements;
                    /**
                     * status
                     */
                    @SerializedName("status")
                    public Integer status;
                    /**
                     * liveAuth
                     */
                    @SerializedName("live_auth")
                    public Boolean liveAuth;
                    /**
                     * region
                     */
                    @SerializedName("region")
                    public String region;
                    /**
                     * language
                     */
                    @SerializedName("language")
                    public String language;
                    /**
                     * gender
                     */
                    @SerializedName("gender")
                    public Integer gender;
                    /**
                     * age
                     */
                    @SerializedName("age")
                    public String age;
                    /**
                     * horoscope
                     */
                    @SerializedName("horoscope")
                    public String horoscope;
                    /**
                     * medalInfo
                     */
                    @SerializedName("medal_info")
                    public ItemDTO.AuthorDTO.MedalInfoDTO medalInfo;

                    public static class AvatarDTO {
                        /**
                         * width
                         */
                        @SerializedName("width")
                        public Integer width;
                        /**
                         * height
                         */
                        @SerializedName("height")
                        public Integer height;
                        /**
                         * uri
                         */
                        @SerializedName("uri")
                        public String uri;
                        /**
                         * urlList
                         */
                        @SerializedName("url_list")
                        public List<ItemDTO.CoverDTO.UrlListDTO> urlList;
                        /**
                         * isGif
                         */
                        @SerializedName("is_gif")
                        public Boolean isGif;
                        /**
                         * downloadList
                         */
                        @SerializedName("download_list")
                        public List<ItemDTO.CoverDTO.UrlListDTO> downloadList;
                    }
                }

                public static class ShareDTO {
                    /**
                     * shareUrl
                     */
                    @SerializedName("share_url")
                    public String shareUrl;
                    /**
                     * title
                     */
                    @SerializedName("title")
                    public String title;
                    /**
                     * content
                     */
                    @SerializedName("content")
                    public String content;
                    /**
                     * imageUrl
                     */
                    @SerializedName("image_url")
                    public String imageUrl;
                    /**
                     * compoundPageUrl
                     */
                    @SerializedName("compound_page_url")
                    public String compoundPageUrl;
                    /**
                     * ios
                     */
                    @SerializedName("ios")
                    public IosDTO ios;
                    /**
                     * android
                     */
                    @SerializedName("android")
                    public IosDTO android;
                    /**
                     * linkText
                     */
                    @SerializedName("link_text")
                    public String linkText;
                    /**
                     * shareText
                     */
                    @SerializedName("share_text")
                    public String shareText;
                    /**
                     * weixinStrategy
                     */
                    @SerializedName("weixin_strategy")
                    public Integer weixinStrategy;
                    /**
                     * momentsStrategy
                     */
                    @SerializedName("moments_strategy")
                    public Integer momentsStrategy;
                    /**
                     * qqStrategy
                     */
                    @SerializedName("qq_strategy")
                    public Integer qqStrategy;
                    /**
                     * qzoneStrategy
                     */
                    @SerializedName("qzone_strategy")
                    public Integer qzoneStrategy;
                    /**
                     * wechatUrl
                     */
                    @SerializedName("wechat_url")
                    public String wechatUrl;
                    /**
                     * momentsUrl
                     */
                    @SerializedName("moments_url")
                    public String momentsUrl;
                    /**
                     * qqUrl
                     */
                    @SerializedName("qq_url")
                    public String qqUrl;
                    /**
                     * qzoneUrl
                     */
                    @SerializedName("qzone_url")
                    public String qzoneUrl;
                    /**
                     * douyinUrl
                     */
                    @SerializedName("douyin_url")
                    public String douyinUrl;
                    /**
                     * schema
                     */
                    @SerializedName("schema")
                    public String schema;
                    /**
                     * largeImageUrl
                     */
                    @SerializedName("large_image_url")
                    public String largeImageUrl;

                    public static class IosDTO {
                        /**
                         * channel
                         */
                        @SerializedName("channel")
                        public Integer channel;
                        /**
                         * weixinStrategy
                         */
                        @SerializedName("weixin_strategy")
                        public Integer weixinStrategy;
                        /**
                         * momentsStrategy
                         */
                        @SerializedName("moments_strategy")
                        public Integer momentsStrategy;
                        /**
                         * qqStrategy
                         */
                        @SerializedName("qq_strategy")
                        public Integer qqStrategy;
                        /**
                         * qzoneStrategy
                         */
                        @SerializedName("qzone_strategy")
                        public Integer qzoneStrategy;
                    }
                }

                public static class WardInfoDTO {
                    /**
                     * isWard
                     */
                    @SerializedName("is_ward")
                    public Boolean isWard;
                    /**
                     * wardCommentId
                     */
                    @SerializedName("ward_comment_id")
                    public Integer wardCommentId;
                    /**
                     * wardReplyId
                     */
                    @SerializedName("ward_reply_id")
                    public Integer wardReplyId;
                    /**
                     * wardUsers
                     */
                    @SerializedName("ward_users")
                    public List<?> wardUsers;
                    /**
                     * wardCount
                     */
                    @SerializedName("ward_count")
                    public Integer wardCount;
                    /**
                     * hasNew
                     */
                    @SerializedName("has_new")
                    public Boolean hasNew;
                    /**
                     * trendMessages
                     */
                    @SerializedName("trend_messages")
                    public List<?> trendMessages;
                    /**
                     * isVisible
                     */
                    @SerializedName("is_visible")
                    public Boolean isVisible;
                }

                public static class InteractEggDTO {
                    /**
                     * likeStyle
                     */
                    @SerializedName("like_style")
                    public String likeStyle;
                }

                public static class TagInfoDTO {
                    /**
                     * type
                     */
                    @SerializedName("type")
                    public Integer type;
                    /**
                     * content
                     */
                    @SerializedName("content")
                    public String content;
                    /**
                     * contentColor
                     */
                    @SerializedName("content_color")
                    public String contentColor;
                    /**
                     * borderColor
                     */
                    @SerializedName("border_color")
                    public String borderColor;
                    /**
                     * imageModel
                     */
                    @SerializedName("image_model")
                    public ImageModelDTO imageModel;

                    public static class ImageModelDTO {
                        /**
                         * width
                         */
                        @SerializedName("width")
                        public Integer width;
                        /**
                         * height
                         */
                        @SerializedName("height")
                        public Integer height;
                        /**
                         * uri
                         */
                        @SerializedName("uri")
                        public String uri;
                        /**
                         * urlList
                         */
                        @SerializedName("url_list")
                        public Object urlList;
                        /**
                         * isGif
                         */
                        @SerializedName("is_gif")
                        public Boolean isGif;
                    }
                }

                public static class RewardInfoDTO {
                    /**
                     * rewardCount
                     */
                    @SerializedName("reward_count")
                    public Integer rewardCount;
                }
            }
        }
    }
}
