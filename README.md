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
``