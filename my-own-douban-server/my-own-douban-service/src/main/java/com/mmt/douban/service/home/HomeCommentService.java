package com.mmt.douban.service.home;

import com.mmt.douban.mapper.CommentMapper;
import com.mmt.douban.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeCommentService {
    @Autowired
    CommentMapper commentMapper;
    public Comment getCommentByMid(Integer mid) {
        return commentMapper.getCommentByMid(mid);
    }

}
