package com.mmt.douban.controller;

import com.mmt.douban.model.Comment;
import com.mmt.douban.model.RespBean;
import com.mmt.douban.service.AdminCommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "电影评论管理相关接口")
@RequestMapping("/admin/comment")
public class AdminCommentController {
    @Autowired
    AdminCommentService adminCommentService;

    @PostMapping("/")
    @ApiOperation("添加电影评论的接口")
    @ApiImplicitParam(name = "comment", value = "电影评论信息", required = true)
    public RespBean addComment(@RequestBody Comment comment) {
        if (adminCommentService.addComment(comment) == 1) {
            return RespBean.ok("评论成功");
        } else {
            return RespBean.error("评论失败");
        }
    }
}
