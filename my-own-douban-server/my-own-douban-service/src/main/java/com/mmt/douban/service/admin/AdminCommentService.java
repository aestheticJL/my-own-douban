package com.mmt.douban.service.admin;

import com.mmt.douban.mapper.CommentMapper;
import com.mmt.douban.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AdminCommentService {
    @Autowired
    CommentMapper commentMapper;

    public Integer addComment(Comment comment) {
        comment.setCreateTime(new Date());
        return commentMapper.insertSelective(comment);
    }
}
