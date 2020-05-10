package com.mmt.douban.controller.adminController;

import com.mmt.douban.model.Comment;
import com.mmt.douban.model.RespBean;
import com.mmt.douban.service.admin.AdminCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/comment")
public class AdminCommentController {
    @Autowired
    AdminCommentService adminCommentService;
    @PostMapping("/")
    public RespBean addComment(@RequestBody Comment comment) {
        if (adminCommentService.addComment(comment) == 1){
            return RespBean.ok("评论成功");
        }else {
            return RespBean.error("评论失败");
        }
    }
}
