package com.mmt.douban.controller.homeController;

import com.mmt.douban.model.Comment;
import com.mmt.douban.service.home.HomeCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home/comment")
public class HomeCommentController {
    @Autowired
    HomeCommentService homeCommentService;
    @GetMapping("/{mid}")
    public Comment getCommentByMid(@PathVariable Integer mid){
        return homeCommentService.getCommentByMid(mid);
    }
}
