package com.rainy.video.mock.feeds;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HotFeeds {


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
         * item
         */
        @SerializedName("item")
        public ItemDTO item;

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
             * createTime
             */
            @SerializedName("create_time")
            public Integer createTime;
            /**
             * status
             */
            @SerializedName("status")
            public Integer status;
            /**
             * comments
             */
            @SerializedName("comments")
            public List<?> comments;
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
             * share
             */
            @SerializedName("share")
            public ShareDTO share;
            /**
             * author
             */
            @SerializedName("author")
            public AuthorDTO author;
            /**
             * stats
             */
            @SerializedName("stats")
            public StatsDTO stats;
            /**
             * itemRelation
             */
            @SerializedName("item_relation")
            public ItemRelationDTO itemRelation;
            /**
             * defaultSchema
             */
            @SerializedName("default_schema")
            public String defaultSchema;
            /**
             * vitalComments
             */
            @SerializedName("vital_comments")
            public Object vitalComments;
            /**
             * note
             */
            @SerializedName("note")
            public Object note;
            /**
             * video
             */
            @SerializedName("video")
            public VideoDTO video;
            /**
             * link
             */
            @SerializedName("link")
            public Object link;
            /**
             * textSchema
             */
            @SerializedName("text_schema")
            public List<?> textSchema;
            /**
             * level
             */
            @SerializedName("level")
            public Object level;
            /**
             * source
             */
            @SerializedName("source")
            public Object source;
            /**
             * debugInfo
             */
            @SerializedName("debug_info")
            public Object debugInfo;
            /**
             * stage
             */
            @SerializedName("stage")
            public Object stage;
            /**
             * userStatus
             */
            @SerializedName("user_status")
            public Object userStatus;
            /**
             * postSource
             */
            @SerializedName("post_source")
            public Integer postSource;
            /**
             * expireTime
             */
            @SerializedName("expire_time")
            public Object expireTime;
            /**
             * reviewStatus
             */
            @SerializedName("review_status")
            public Object reviewStatus;
            /**
             * frozenToast
             */
            @SerializedName("frozen_toast")
            public String frozenToast;
            /**
             * duration
             */
            @SerializedName("duration")
            public Double duration;
            /**
             * videoType
             */
            @SerializedName("video_type")
            public Integer videoType;
            /**
             * relatedId
             */
            @SerializedName("related_id")
            public Object relatedId;
            /**
             * ancestorId
             */
            @SerializedName("ancestor_id")
            public String ancestorId;
            /**
             * originVideoId
             */
            @SerializedName("origin_video_id")
            public String originVideoId;
            /**
             * relatedCommentId
             */
            @SerializedName("related_comment_id")
            public Integer relatedCommentId;
            /**
             * ancestorCommentId
             */
            @SerializedName("ancestor_comment_id")
            public Object ancestorCommentId;
            /**
             * originVideoDownload
             */
            @SerializedName("origin_video_download")
            public Object originVideoDownload;
            /**
             * commentPostItem
             */
            @SerializedName("comment_post_item")
            public Boolean commentPostItem;
            /**
             * hotInfo
             */
            @SerializedName("hot_info")
            public Object hotInfo;
            /**
             * authorDisplayTags
             */
            @SerializedName("author_display_tags")
            public Object authorDisplayTags;
            /**
             * rating
             */
            @SerializedName("rating")
            public Integer rating;
            /**
             * ancestorSchema
             */
            @SerializedName("ancestor_schema")
            public Object ancestorSchema;
            /**
             * jumpLink
             */
            @SerializedName("jump_link")
            public Object jumpLink;
            /**
             * microAppId
             */
            @SerializedName("micro_app_id")
            public Object microAppId;
            /**
             * recreateMetaInfoList
             */
            @SerializedName("recreate_meta_info_list")
            public List<?> recreateMetaInfoList;
            /**
             * neihanStyle
             */
            @SerializedName("neihan_style")
            public Integer neihanStyle;
            /**
             * mappingGids
             */
            @SerializedName("mapping_gids")
            public Object mappingGids;
            /**
             * humanTags
             */
            @SerializedName("human_tags")
            public Object humanTags;
            /**
             * adminDebug
             */
            @SerializedName("admin_debug")
            public Object adminDebug;
            /**
             * aiTag
             */
            @SerializedName("ai_tag")
            public Object aiTag;
            /**
             * wardInfo
             */
            @SerializedName("ward_info")
            public WardInfoDTO wardInfo;
            /**
             * relatedCommentIdStr
             */
            @SerializedName("related_comment_id_str")
            public String relatedCommentIdStr;
            /**
             * interactEgg
             */
            @SerializedName("interact_egg")
            public InteractEggDTO interactEgg;
            /**
             * clubInfo
             */
            @SerializedName("club_info")
            public Object clubInfo;
            /**
             * albumIntro
             */
            @SerializedName("album_intro")
            public Object albumIntro;
            /**
             * episodeInfo
             */
            @SerializedName("episode_info")
            public Object episodeInfo;
            /**
             * drainageInfo
             */
            @SerializedName("drainage_info")
            public Object drainageInfo;
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
             * clubRelation
             */
            @SerializedName("club_relation")
            public Object clubRelation;
            /**
             * gameCardInfo
             */
            @SerializedName("game_card_info")
            public Object gameCardInfo;
            /**
             * privilege
             */
            @SerializedName("privilege")
            public PrivilegeDTO privilege;
            /**
             * activity
             */
            @SerializedName("activity")
            public Object activity;
            /**
             * showFeatureDigg
             */
            @SerializedName("show_feature_digg")
            public Boolean showFeatureDigg;
            /**
             * showFeatureBury
             */
            @SerializedName("show_feature_bury")
            public Boolean showFeatureBury;
            /**
             * promotionInfo
             */
            @SerializedName("promotion_info")
            public Object promotionInfo;
            /**
             * ahaImage
             */
            @SerializedName("aha_image")
            public List<AhaImageDTO> ahaImage;
            /**
             * qualityLevel
             */
            @SerializedName("quality_level")
            public Object qualityLevel;
            /**
             * isOrigin
             */
            @SerializedName("is_origin")
            public Object isOrigin;
            /**
             * animations
             */
            @SerializedName("animations")
            public Object animations;
            /**
             * newAppVisible
             */
            @SerializedName("new_app_visible")
            public Object newAppVisible;
            /**
             * dupItemSchema
             */
            @SerializedName("dup_item_schema")
            public Object dupItemSchema;
            /**
             * position
             */
            @SerializedName("position")
            public Object position;
            /**
             * auditInfo
             */
            @SerializedName("audit_info")
            public Object auditInfo;
            /**
             * lastCommentTime
             */
            @SerializedName("last_comment_time")
            public Object lastCommentTime;
            /**
             * recommendTags
             */
            @SerializedName("recommend_tags")
            public Object recommendTags;
            /**
             * interactionStatus
             */
            @SerializedName("interaction_status")
            public Object interactionStatus;
            /**
             * isBest
             */
            @SerializedName("is_best")
            public Object isBest;
            /**
             * logItemExtra
             */
            @SerializedName("log_item_extra")
            public String logItemExtra;
            /**
             * authorTags
             */
            @SerializedName("author_tags")
            public String authorTags;
            /**
             * cellUiCtrl
             */
            @SerializedName("cell_ui_ctrl")
            public CellUiCtrlDTO cellUiCtrl;

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
                 * isFollowing
                 */
                @SerializedName("is_following")
                public Object isFollowing;
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
                 * isFollowed
                 */
                @SerializedName("is_followed")
                public Object isFollowed;
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
                 * certifyInfo
                 */
                @SerializedName("certify_info")
                public Object certifyInfo;
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
                 * authorInfo
                 */
                @SerializedName("author_info")
                public Object authorInfo;
                /**
                 * broadcastInfo
                 */
                @SerializedName("broadcast_info")
                public Object broadcastInfo;
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
                 * punishments
                 */
                @SerializedName("punishments")
                public Object punishments;
                /**
                 * recommendTag
                 */
                @SerializedName("recommend_tag")
                public Object recommendTag;
                /**
                 * recommendReason
                 */
                @SerializedName("recommend_reason")
                public Object recommendReason;
                /**
                 * commercePermissionList
                 */
                @SerializedName("commerce_permission_list")
                public Object commercePermissionList;
                /**
                 * decorationList
                 */
                @SerializedName("decoration_list")
                public Object decorationList;
                /**
                 * interactionLimitation
                 */
                @SerializedName("interaction_limitation")
                public Object interactionLimitation;
                /**
                 * creativeLevelInfo
                 */
                @SerializedName("creative_level_info")
                public Object creativeLevelInfo;
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
                 * hideAge
                 */
                @SerializedName("hide_age")
                public Object hideAge;

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

            public static class StatsDTO {
                /**
                 * goDetailCount
                 */
                @SerializedName("go_detail_count")
                public Integer goDetailCount;
                /**
                 * impressionCount
                 */
                @SerializedName("impression_count")
                public Integer impressionCount;
                /**
                 * commentCount
                 */
                @SerializedName("comment_count")
                public Integer commentCount;
                /**
                 * likeCount
                 */
                @SerializedName("like_count")
                public Integer likeCount;
                /**
                 * shareCount
                 */
                @SerializedName("share_count")
                public Integer shareCount;
                /**
                 * playCount
                 */
                @SerializedName("play_count")
                public Integer playCount;
                /**
                 * dubbingCount
                 */
                @SerializedName("dubbing_count")
                public Integer dubbingCount;
                /**
                 * buryCount
                 */
                @SerializedName("bury_count")
                public Integer buryCount;
                /**
                 * bulletCount
                 */
                @SerializedName("bullet_count")
                public Integer bulletCount;
                /**
                 * diggCounts
                 */
                @SerializedName("digg_counts")
                public List<DiggCountsDTO> diggCounts;
                /**
                 * buryCounts
                 */
                @SerializedName("bury_counts")
                public List<BuryCountsDTO> buryCounts;
                /**
                 * viewCount
                 */
                @SerializedName("view_count")
                public Integer viewCount;

                public static class DiggCountsDTO {
                    /**
                     * diggType
                     */
                    @SerializedName("digg_type")
                    public Integer diggType;
                    /**
                     * diggCount
                     */
                    @SerializedName("digg_count")
                    public Integer diggCount;
                }

                public static class BuryCountsDTO {
                    /**
                     * buryType
                     */
                    @SerializedName("bury_type")
                    public Integer buryType;
                    /**
                     * buryCount
                     */
                    @SerializedName("bury_count")
                    public Integer buryCount;
                }
            }

            public static class ItemRelationDTO {
                /**
                 * isLike
                 */
                @SerializedName("is_like")
                public Boolean isLike;
                /**
                 * isFavorite
                 */
                @SerializedName("is_favorite")
                public Boolean isFavorite;
                /**
                 * isBury
                 */
                @SerializedName("is_bury")
                public Boolean isBury;
                /**
                 * diggType
                 */
                @SerializedName("digg_type")
                public Integer diggType;
                /**
                 * buryType
                 */
                @SerializedName("bury_type")
                public Integer buryType;
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
                 * hashtagSchema
                 */
                @SerializedName("hashtag_schema")
                public List<HashtagSchemaDTO> hashtagSchema;
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
                 * title
                 */
                @SerializedName("title")
                public Object title;
                /**
                 * videoDownload
                 */
                @SerializedName("video_download")
                public VideoDownloadDTO videoDownload;
                /**
                 * videoLow
                 */
                @SerializedName("video_low")
                public Object videoLow;
                /**
                 * videoMid
                 */
                @SerializedName("video_mid")
                public Object videoMid;
                /**
                 * videoHigh
                 */
                @SerializedName("video_high")
                public Object videoHigh;
                /**
                 * videoFallback
                 */
                @SerializedName("video_fallback")
                public Object videoFallback;
                /**
                 * videoGodCommentUrls
                 */
                @SerializedName("video_god_comment_urls")
                public Object videoGodCommentUrls;
                /**
                 * animate
                 */
                @SerializedName("animate")
                public Object animate;
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
                     * alarmText
                     */
                    @SerializedName("alarm_text")
                    public Object alarmText;
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
                    /**
                     * p2pType
                     */
                    @SerializedName("p2p_type")
                    public Object p2pType;
                    /**
                     * fileHash
                     */
                    @SerializedName("file_hash")
                    public Object fileHash;
                    /**
                     * animatedCoverImage
                     */
                    @SerializedName("animated_cover_image")
                    public Object animatedCoverImage;

                    public static class CoverImageDTO {
                        /**
                         * width
                         */
                        @SerializedName("width")
                        public Long width;
                        /**
                         * height
                         */
                        @SerializedName("height")
                        public Long height;
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
                        public Long expires;
                    }
                }

                public static class HashtagSchemaDTO {
                    /**
                     * baseHashtag
                     */
                    @SerializedName("base_hashtag")
                    public BaseHashtagDTO baseHashtag;
                    /**
                     * schema
                     */
                    @SerializedName("schema")
                    public String schema;
                    /**
                     * isFollow
                     */
                    @SerializedName("is_follow")
                    public Boolean isFollow;
                    /**
                     * worksNum
                     */
                    @SerializedName("works_num")
                    public Long worksNum;
                    /**
                     * followersNum
                     */
                    @SerializedName("followers_num")
                    public Long followersNum;
                    /**
                     * status
                     */
                    @SerializedName("status")
                    public Object status;
                    /**
                     * intro
                     */
                    @SerializedName("intro")
                    public Object intro;
                    /**
                     * icon
                     */
                    @SerializedName("icon")
                    public Object icon;
                    /**
                     * backgroundImage
                     */
                    @SerializedName("background_image")
                    public Object backgroundImage;
                    /**
                     * tag
                     */
                    @SerializedName("tag")
                    public Object tag;
                    /**
                     * extra
                     */
                    @SerializedName("extra")
                    public Object extra;
                    /**
                     * enterNum
                     */
                    @SerializedName("enter_num")
                    public Long enterNum;
                    /**
                     * idStr
                     */
                    @SerializedName("id_str")
                    public String idStr;
                    /**
                     * showNum
                     */
                    @SerializedName("show_num")
                    public Long showNum;
                    /**
                     * displayTag
                     */
                    @SerializedName("display_tag")
                    public Object displayTag;
                    /**
                     * displayTagInfo
                     */
                    @SerializedName("display_tag_info")
                    public Object displayTagInfo;
                    /**
                     * isHost
                     */
                    @SerializedName("is_host")
                    public Boolean isHost;
                    /**
                     * hostAvatar
                     */
                    @SerializedName("host_avatar")
                    public List<?> hostAvatar;

                    public static class BaseHashtagDTO {
                        /**
                         * id
                         */
                        @SerializedName("id")
                        public Integer id;
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
                         * intro
                         */
                        @SerializedName("intro")
                        public String intro;
                        /**
                         * status
                         */
                        @SerializedName("status")
                        public Integer status;
                        /**
                         * icon
                         */
                        @SerializedName("icon")
                        public IconDTO icon;
                        /**
                         * backgroundImage
                         */
                        @SerializedName("background_image")
                        public BackgroundImageDTO backgroundImage;
                        /**
                         * activityIcon
                         */
                        @SerializedName("activity_icon")
                        public ActivityIconDTO activityIcon;
                        /**
                         * tag
                         */
                        @SerializedName("tag")
                        public Object tag;
                        /**
                         * extra
                         */
                        @SerializedName("extra")
                        public Object extra;
                        /**
                         * introSchema
                         */
                        @SerializedName("intro_schema")
                        public List<?> introSchema;
                        /**
                         * hashtagType
                         */
                        @SerializedName("hashtag_type")
                        public Integer hashtagType;
                        /**
                         * jumpLink
                         */
                        @SerializedName("jump_link")
                        public Object jumpLink;
                        /**
                         * topStatus
                         */
                        @SerializedName("top_status")
                        public Integer topStatus;
                        /**
                         * topItemIds
                         */
                        @SerializedName("top_item_ids")
                        public List<String> topItemIds;
                        /**
                         * guideWord
                         */
                        @SerializedName("guide_word")
                        public String guideWord;
                        /**
                         * guideText
                         */
                        @SerializedName("guide_text")
                        public String guideText;
                        /**
                         * guideLink
                         */
                        @SerializedName("guide_link")
                        public String guideLink;
                        /**
                         * atmosphere
                         */
                        @SerializedName("atmosphere")
                        public Object atmosphere;
                        /**
                         * avatars
                         */
                        @SerializedName("avatars")
                        public Object avatars;
                        /**
                         * hashtagTopType
                         */
                        @SerializedName("hashtag_top_type")
                        public Integer hashtagTopType;
                        /**
                         * topGif
                         */
                        @SerializedName("top_gif")
                        public Object topGif;
                        /**
                         * topText
                         */
                        @SerializedName("top_text")
                        public String topText;
                        /**
                         * targetTcsId
                         */
                        @SerializedName("target_tcs_id")
                        public Object targetTcsId;
                        /**
                         * targetTcsIdStr
                         */
                        @SerializedName("target_tcs_id_str")
                        public Object targetTcsIdStr;
                        /**
                         * forbiddenPostItem
                         */
                        @SerializedName("forbidden_post_item")
                        public Object forbiddenPostItem;
                        /**
                         * categoryList
                         */
                        @SerializedName("category_list")
                        public List<CategoryListDTO> categoryList;
                        /**
                         * actionStartTime
                         */
                        @SerializedName("action_start_time")
                        public Integer actionStartTime;
                        /**
                         * actionEndTime
                         */
                        @SerializedName("action_end_time")
                        public Integer actionEndTime;
                        /**
                         * boostInfo
                         */
                        @SerializedName("boost_info")
                        public Object boostInfo;
                        /**
                         * sponsorAvatar
                         */
                        @SerializedName("sponsor_avatar")
                        public Object sponsorAvatar;
                        /**
                         * sponsorRankSchema
                         */
                        @SerializedName("sponsor_rank_schema")
                        public Object sponsorRankSchema;
                        /**
                         * createTime
                         */
                        @SerializedName("create_time")
                        public Integer createTime;
                        /**
                         * modifyTime
                         */
                        @SerializedName("modify_time")
                        public Integer modifyTime;

                        public static class IconDTO {
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
                            public List<VideoDownloadDTO.UrlListDTO> urlList;
                            /**
                             * isGif
                             */
                            @SerializedName("is_gif")
                            public Boolean isGif;
                            /**
                             * downloadList
                             */
                            @SerializedName("download_list")
                            public List<VideoDownloadDTO.UrlListDTO> downloadList;
                        }

                        public static class BackgroundImageDTO {
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
                            public List<VideoDownloadDTO.UrlListDTO> urlList;
                            /**
                             * isGif
                             */
                            @SerializedName("is_gif")
                            public Boolean isGif;
                            /**
                             * downloadList
                             */
                            @SerializedName("download_list")
                            public List<VideoDownloadDTO.UrlListDTO> downloadList;
                        }

                        public static class ActivityIconDTO {
                            /**
                             * name
                             */
                            @SerializedName("name")
                            public String name;
                            /**
                             * color
                             */
                            @SerializedName("color")
                            public String color;
                            /**
                             * iconImage
                             */
                            @SerializedName("icon_image")
                            public IconImageDTO iconImage;

                            public static class IconImageDTO {
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
                                public List<VideoDownloadDTO.UrlListDTO> urlList;
                                /**
                                 * isGif
                                 */
                                @SerializedName("is_gif")
                                public Boolean isGif;
                                /**
                                 * downloadList
                                 */
                                @SerializedName("download_list")
                                public List<VideoDownloadDTO.UrlListDTO> downloadList;
                            }
                        }

                        public static class CategoryListDTO {
                            /**
                             * id
                             */
                            @SerializedName("id")
                            public Integer id;
                            /**
                             * name
                             */
                            @SerializedName("name")
                            public String name;
                            /**
                             * displayOrder
                             */
                            @SerializedName("display_order")
                            public Integer displayOrder;
                        }
                    }
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
                public List<WardUsersDTO> wardUsers;
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

                public static class WardUsersDTO {
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
                     * isFollowing
                     */
                    @SerializedName("is_following")
                    public Object isFollowing;
                    /**
                     * followersCount
                     */
                    @SerializedName("followers_count")
                    public Object followersCount;
                    /**
                     * followingsCount
                     */
                    @SerializedName("followings_count")
                    public Object followingsCount;
                    /**
                     * likeCount
                     */
                    @SerializedName("like_count")
                    public Object likeCount;
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
                     * isFollowed
                     */
                    @SerializedName("is_followed")
                    public Object isFollowed;
                    /**
                     * godCommentCount
                     */
                    @SerializedName("god_comment_count")
                    public Object godCommentCount;
                    /**
                     * voteCount
                     */
                    @SerializedName("vote_count")
                    public Integer voteCount;
                    /**
                     * certifyInfo
                     */
                    @SerializedName("certify_info")
                    public Object certifyInfo;
                    /**
                     * achievements
                     */
                    @SerializedName("achievements")
                    public Object achievements;
                    /**
                     * status
                     */
                    @SerializedName("status")
                    public Object status;
                    /**
                     * authorInfo
                     */
                    @SerializedName("author_info")
                    public Object authorInfo;
                    /**
                     * broadcastInfo
                     */
                    @SerializedName("broadcast_info")
                    public Object broadcastInfo;
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
                     * punishments
                     */
                    @SerializedName("punishments")
                    public Object punishments;
                    /**
                     * recommendTag
                     */
                    @SerializedName("recommend_tag")
                    public Object recommendTag;
                    /**
                     * recommendReason
                     */
                    @SerializedName("recommend_reason")
                    public Object recommendReason;
                    /**
                     * commercePermissionList
                     */
                    @SerializedName("commerce_permission_list")
                    public Object commercePermissionList;
                    /**
                     * decorationList
                     */
                    @SerializedName("decoration_list")
                    public Object decorationList;
                    /**
                     * interactionLimitation
                     */
                    @SerializedName("interaction_limitation")
                    public Object interactionLimitation;
                    /**
                     * creativeLevelInfo
                     */
                    @SerializedName("creative_level_info")
                    public Object creativeLevelInfo;
                    /**
                     * gender
                     */
                    @SerializedName("gender")
                    public Object gender;
                    /**
                     * age
                     */
                    @SerializedName("age")
                    public Object age;
                    /**
                     * horoscope
                     */
                    @SerializedName("horoscope")
                    public Object horoscope;
                    /**
                     * hideAge
                     */
                    @SerializedName("hide_age")
                    public Object hideAge;

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
                        public List<VideoDTO.VideoDownloadDTO.UrlListDTO> urlList;
                        /**
                         * isGif
                         */
                        @SerializedName("is_gif")
                        public Boolean isGif;
                        /**
                         * downloadList
                         */
                        @SerializedName("download_list")
                        public List<VideoDTO.VideoDownloadDTO.UrlListDTO> downloadList;
                    }
                }
            }

            public static class InteractEggDTO {
                /**
                 * likeStyle
                 */
                @SerializedName("like_style")
                public String likeStyle;
            }

            public static class PrivilegeDTO {
                /**
                 * bulletPlay
                 */
                @SerializedName("bullet_play")
                public Boolean bulletPlay;
                /**
                 * bulletPost
                 */
                @SerializedName("bullet_post")
                public Boolean bulletPost;
            }

            public static class CellUiCtrlDTO {
                /**
                 * showAuthorTags
                 */
                @SerializedName("show_author_tags")
                public Boolean showAuthorTags;
                /**
                 * imageStyle
                 */
                @SerializedName("image_style")
                public Object imageStyle;
                /**
                 * displayStyle
                 */
                @SerializedName("display_style")
                public Object displayStyle;
            }

            public static class AhaImageDTO {
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
        }
    }
}
