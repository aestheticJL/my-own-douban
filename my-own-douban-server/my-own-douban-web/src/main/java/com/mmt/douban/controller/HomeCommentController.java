package com.mmt.douban.controller;

import com.mmt.douban.model.Comment;
import com.mmt.douban.service.HomeCommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "展示页评论信息相关接口")
@RequestMapping("/home/comment")
public class HomeCommentController {
    @Autowired
    HomeCommentService homeCommentService;

    @GetMapping("/{mid}")
    @ApiOperation("根据电影id获取评论的接口")
    @ApiImplicitParam(name = "mid", value = "电影的id", required = true)
    public Comment getCommentByMid(@PathVariable Integer mid) {
        return homeCommentService.getCommentByMid(mid);
    }
}
