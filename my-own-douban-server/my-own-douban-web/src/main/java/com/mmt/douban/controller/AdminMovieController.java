package com.mmt.douban.controller;

import com.mmt.douban.model.Movie;
import com.mmt.douban.model.RespBean;
import com.mmt.douban.service.AdminMovieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "电影管理相关接口")
@RequestMapping("/admin/movie")
public class AdminMovieController {
    @Autowired
    AdminMovieService adminMovieService;

    @PostMapping("/")
    @ApiOperation("录入电影的接口")
    @ApiImplicitParam(name = "movie", value = "电影信息", required = true)
    public RespBean addMovieInf(@RequestBody Movie movie) {
        if (adminMovieService.addMovieInf(movie)) {
            return RespBean.ok("录入成功");
        } else {
            return RespBean.error("录入失败，请确认电影信息");
        }
    }

    @GetMapping("/")
    @ApiOperation("获取所有电影信息的接口")
    public List<Movie> getAllMovie() {
        return adminMovieService.getAllMovie();
    }

    @GetMapping("/{id}")
    @ApiOperation("根据电影id获取电影信息的接口")
    @ApiImplicitParam(name = "id", value = "电影的id", required = true)
    public Movie getMovieById(@PathVariable Integer id) {
        return adminMovieService.getMovieById(id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("根据电影id删除电影的接口")
    @ApiImplicitParam(name = "id", value = "电影的id", required = true)
    public RespBean deleteMovie(@PathVariable Integer id) {
        if (adminMovieService.deleteMovie(id)) {
            return RespBean.ok("删除成功");
        } else {
            return RespBean.error("删除失败");
        }
    }
}
