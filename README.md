# 📌 短视频帖子 APP 服务端接口清单 (SpringBoot)

---

## 🎭 MockUserController
- [x] [GET] `/video/mock/insertHotFeeds` — 模拟插入热门帖子相关数据

---

## 👤 UserController
- [x] [GET] `/video/user/insert` — 插入新的用户
- [x] [GET] `/video/user/query` — 查询用户
- [x] [GET] `/video/user/delete` — 删除用户
- [x] [GET] `/video/user/queryFans` — 查询粉丝列表
- [x] [GET] `/video/user/relation` — 查询两个用户的关系
- [x] [POST] `/video/user/update` — 更新用户信息

---

## 📰 FeedsController
- [x] [GET] `/video/feeds/queryHotFeedsList` — 查询帖子列表数据
- [x] [GET] `/video/feeds/queryProfileFeeds` — 查询用户动态帖子
- [x] [POST] `/video/feeds/publish` — 发布一条新的帖子
- [x] [GET] `/video/feeds/deleteFeed` — 删除一条帖子
- [x] [GET] `/video/feeds/queryHistory` — 查询用户帖子历史观看记录
- [x] [GET] `/video/feeds/queryFavorite` — 查询用户帖子收藏记录

---

## 💬 CommonController
- [x] [GET] `/video/commend/queryFeedComments` — 查询帖子评论列表（可分页）
- [x] [POST] `/video/commend/addComment` — 增加一条帖子评论
- [x] [GET] `/video/commend/deleteComment` — 删除一条帖子评论

---

## 🏷 TagListController
- [x] [GET] `/video/tag/queryTagList` — 查询标签列表数据
- [x] [GET] `/video/tag/toggleTagFollow` — 变更对某个标签的喜欢状态

---

## 🎬 UgcController
- [x] [GET] `/video/ugc/queryUgcByItemId` — 根据 itemId 查询段子的 ugc 属性
- [x] [GET] `/video/ugc/increaseCommentCount` — 增加段子评论数量
- [x] [GET] `/video/ugc/toggleFavorite` — 收藏一个帖子
- [x] [GET] `/video/ugc/increaseShareCount` — 增加一条段子分享数量
- [x] [GET] `/video/ugc/toggleFeedLike` — 变换用户对该条段子的喜欢结果
- [x] [GET] `/video/ugc/isLiked` — 查询用户对该条段子的喜欢结果
- [x] [GET] `/video/ugc/toggleTagListFollow` — 变换用户对该标签类型的喜欢结果
- [x] [GET] `/video/ugc/hasFollowTag` — 查询用户对该标签类型的喜欢结果
- [x] [GET] `/video/ugc/toggleCommentLike` — 变更用户对一条评论的喜欢状态
- [x] [GET] `/video/ugc/isCommentLike` — 查询用户对一条评论的喜欢状态
- [x] [GET] `/video/ugc/toggleUserFollow` — 变更用户对另一个用户的喜欢状态
- [x] [GET] `/video/ugc/isUserFollow` — 查询用户对另一个用户的喜欢状态
- [x] [GET] `/video/ugc/dissFeed` — 变更用户对一个帖子的 diss 状态
- [x] [GET] `/video/ugc/hasDissFeed` — 查询用户对一个帖子的 diss 状态
