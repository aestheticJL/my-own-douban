package com.mmt.douban.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Api(tags = "豆瓣api接口")
public class SpringRestTemplateController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/admin/getMovie/{id}")
    @ApiOperation("利用豆瓣api来获取电影信息的接口")
    @ApiImplicitParam(name = "id", value = "豆瓣某部电影的id", required = true)
    public String getJson(@PathVariable String id) {
        String url = "http://api.douban.com/v2/movie/subject/" + id + "?apikey=0df993c66c0c636e29ecbb5344252a4a";
        //String json =restTemplate.getForObject(url,Object.class);
        ResponseEntity<String> results = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        String json = results.getBody();
        return json;
    }
}