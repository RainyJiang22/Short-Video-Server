# Short-Video-Server

Jetpack+Compose打造一款短视频帖子APP服务端 SpringBoot

### 接口相关

#### MockUserController

- [GET] video/mock/insertHotFeeds(模拟插入热门帖子相关数据)

#### UserController

- [GET] video/user/insert (插入新的用户)
- [GET] video/user/query (查询用户)
- [GET] video/user/delete (删除用户)
- [GET] video/user/queryFans(查询粉丝列表)
- [GET] video/user/relation(查询两个用户的关系)
- [POST] video/user/update (更新用户信息)

#### FeedsController

- [GET] video/feeds/queryHotFeedsList (查询贴子列表数据)
- [GET] video/feeds/queryProfileFeeds (查询用户动态帖子)
- [POST] video/feeds/publish(发布一条新的帖子)
- [GET] video/feeds/deleteFeed(删除一条帖子)
- [GET] video/feeds/queryHistory(查询用户帖子历史观看记录)
- [GET] video/feeds/queryFavorite(查询用户帖子收藏记录)

#### CommonController

- [GET] video/commend/queryFeedComments (查询帖子评论列表 可分页)
- [POST] video/commend/addComment(增加一条帖子评论)
- [GET] video/commend/deleteComment(删除一条帖子评论)

#### TagListController

- [GET] video/tag/queryTagList (查询标签列表数据)
- [GET] video/tag/toggleTagFollow (变更对某个标签的喜欢)


#### UgcController

- [GET] video//ugc/queryUgcByItemId (根据itemId查询段子的ugc属性)
- [GET] video/ugc/increaseCommentCount (增加段子评论的数量)
- [GET] video/ugc/toggleFavorite (收藏一个帖子)
- [GET] video/ugc/increaseShareCount (增加一条段子分享的数量)
- [GET] video/ugc/toggleFeedLike (变换用户对该条段子的喜欢结果)
- [GET] video/ugc/isLiked (查询用户对该条段子的喜欢结果)
- [GET] video/ugc/toggleTagListFollow (变换用户对该标签类型的喜欢结果)
- [GET] video/ugc/hasFollowTag (查询用户对该标签类型的喜欢结果)
- [GET] video/ugc/toggleCommentLike (变更用户对一条评论的喜欢状态)
- [GET] video/ugc/isCommentLike (查询用户对一条评论的喜欢状态)
- [GET] video/ugc/toggleUserFollow (变更用户对另一个用户的喜欢状态)
- [GET] video/ugc/isUserFollow (查询用户对另一个用户的喜欢状态)
- [GET] video/ugc/dissFeed (变更用户对一个帖子的diss状态)
- [GET] video/ugc/hasDissFeed (查询用户对一个帖子的diss状态)