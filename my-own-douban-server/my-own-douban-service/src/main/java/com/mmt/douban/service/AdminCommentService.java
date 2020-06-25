package com.mmt.douban.service;

import com.mmt.douban.mapper.CommentMapper;
import com.mmt.douban.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@CacheConfig(cacheNames = "home")
public class AdminCommentService {
    @Autowired
    CommentMapper commentMapper;

    @Caching(evict = {
            @CacheEvict(key = "'NewCommentMovie'"),
            @CacheEvict(key = "'MyHighScoreMovie'"),
            @CacheEvict(cacheNames = "movie",key = "#comment.mid")
    })
    public Integer addComment(Comment comment) {
        comment.setCreateTime(new Date());
        return commentMapper.insertSelective(comment);
    }
}
