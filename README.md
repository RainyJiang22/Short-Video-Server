# Short-Video-Server

Jetpack+Compose打造一款短视频APP服务端 SpringBoot

### 接口文档


#### MockUserController

- [GET] localhost:9991/video/mock/insertHotFeeds(模拟插入热门帖子相关数据)

#### UserController

- [GET] localhost:9991/video/user/insert (插入新的用户)
- [GET] localhost:9991/video/user/query (查询用户)
- [GET] localhost:9991/video/user/delete (删除用户)
- [GET] localhost:9991/video/user/queryFans(查询粉丝列表)
- [GET] localhost:9991/video/user/relation(查询两个用户的关系)
- [POST] localhost:9991/video/user/update (更新用户信息)

#### FeedsController
- [GET] localhost:9996/video/feeds/queryHotFeedsList (查询贴子列表数据)