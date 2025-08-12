package com.rainy.video.mock.comments;

import com.alibaba.fastjson.JSON;
import com.rainy.video.mock.feeds.HotJsonParse;
import com.rainy.video.table.TableFeedsComment;
import com.rainy.video.table.TableFeedsCommentUgc;
import com.rainy.video.table.TableUser;

import java.util.ArrayList;
import java.util.List;

public class CommentJsonParse {
    private static long commentId = System.currentTimeMillis();
    private static long authorId = System.currentTimeMillis();

    public static List<TableFeedsComment> parseCommentJson(Long itemId) {
        String json = HotJsonParse.readFile("src/main/java/com/rainy/video/mock/comments/comment.json");
        FeedsComment feedsComment = JSON.parseObject(json, FeedsComment.class);
        List<FeedsComment.DataDTO.CellCommentsDTO> cellComments = feedsComment.data.cellComments;

        List<TableFeedsComment> tableFeedsComments = new ArrayList<>();
        for (FeedsComment.DataDTO.CellCommentsDTO cellCommentsDTO : cellComments) {
            FeedsComment.DataDTO.CellCommentsDTO.CommentInfoDTO commentInfo = cellCommentsDTO.commentInfo;
            if (commentInfo == null) {
                continue;
            }
            commentId = commentId + 1;
            TableFeedsComment comment = new TableFeedsComment();
            comment.itemId = itemId;
            comment.commentId = commentId;
            comment.commentType = commentInfo.type;
            comment.createTime = System.currentTimeMillis();
            //comment.commentCount = commentInfo.commentCount;
            // comment.likeCount = commentInfo.likeCount;
            comment.commentText = commentInfo.text;
            comment.commentType = 1;

            TableFeedsCommentUgc commentUgc = new TableFeedsCommentUgc();
            commentUgc.commentId = comment.commentId;
            commentUgc.likeCount = commentInfo.likeCount;
            comment.commentUgc = commentUgc;


//            if (commentInfo.type == 2) {
//                if (commentInfo.cover != null && commentInfo.cover > 0) {
//                    comment.imageUrl = comment_info.images.get(0).url_list.get(0).url;
//                    comment.width = comment_info.images.get(0).width;
//                    comment.height = comment_info.images.get(0).height;
//                }
//            } else if (commentInfo.type == 3) {
//                if (commentInfo. != null && comment_info.video_download.url_list.size() > 0) {
//                    comment.imageUrl = comment_info.video_download.cover_image.download_list.get(0).url;
//                    comment.videoUrl = comment_info.video_download.url_list.get(0).url;
//                    comment.width = comment_info.video_download.cover_image.width;
//                    comment.height = comment_info.video_download.cover_image.height;
//                }
//            }


            // author
            if (commentInfo.user != null) {
                authorId = authorId + 1;
                TableUser user = new TableUser();
                user.userId = authorId;
                user.avatar = commentInfo.user.avatar.downloadList.get(0).url;
                user.name = commentInfo.user.name;
                user.description = commentInfo.user.description;
                user.qqOpenId = commentInfo.user.idStr;
                comment.author = user;
                comment.userId = user.userId;

            }
            if (comment.author == null) {
                continue;
            }
            tableFeedsComments.add(comment);
        }
        return tableFeedsComments;
    }
}
