# Short-Video-Server

Jetpack+Compose打造一款短视频APP服务端 SpringBoot

### 接口文档

#### UserController

- [GET] localhost:9996/video/user/insert (插入新的用户)
- [GET] localhost:9996/video/user/query (查询用户)
- [GET] localhost:9996/video/user/delete (删除用户)
- [GET] localhost:9996/video/user/queryFans(查询粉丝列表)
- [GET] localhost:9996/video/user/relation(查询两个用户的关系)
- [POST] localhost:9996/video/user/update (更新用户信息)
