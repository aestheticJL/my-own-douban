package com.mmt.douban.controller.homeController;

import com.mmt.douban.model.Movie;
import com.mmt.douban.service.home.HomeMovieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "展示页电影信息相关接口")
@RequestMapping("/home/movie")
public class HomeMovieController {
    @Autowired
    HomeMovieService homeMovieService;

    @GetMapping("/{type}")
    @ApiOperation("根据类型获取十佳电影的接口")
    @ApiImplicitParam(name = "type", value = "电影类型", required = true)
    public List<Movie> getTopTenMovieByType(@PathVariable String type) {
        return homeMovieService.getTopTenMovieByType(type);
    }

    @GetMapping("/new")
    @ApiOperation("获取最新评论电影的接口")
    public List<Movie> getNewCommentMovie() {
        return homeMovieService.getNewCommentMovie();
    }

    @GetMapping("/highScore")
    @ApiOperation("获取豆瓣高分电影的接口")
    public List<Movie> getHighScoreMovie() {
        return homeMovieService.getHighScoreMovie();
    }

    @GetMapping("/myHighScore")
    @ApiOperation("获取我给出高分电影的接口")
    public List<Movie> getMyHighScoreMovie() {
        return homeMovieService.getMyHighScoreMovie();
    }


    @GetMapping("/id/{id}")
    @ApiOperation("获取电影详细信息的接口")
    @ApiImplicitParam(name = "id", value = "电影的id", required = true)
    public Movie getMovieAllInfById(@PathVariable Integer id) {
        return homeMovieService.getMovieAllInfById(id);
    }
}
