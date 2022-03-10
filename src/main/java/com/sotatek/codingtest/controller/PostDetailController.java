package com.sotatek.codingtest.controller;

import com.sotatek.codingtest.domain.dto.PostDetailDTO;
import com.sotatek.codingtest.helper.ResultResp;
import com.sotatek.codingtest.service.postdetail.PostDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class PostDetailController {
    @Autowired
    private PostDetailService postDetailService;

    @PostMapping("post")
    public ResultResp<?> getAll(@RequestBody(required = false) List<String> postcodes) {
        ResultResp<?> resultResp;
        try {
            if (postcodes != null) {
                resultResp = new ResultResp<>(HttpStatus.OK, postDetailService.findAllByPostcode(postcodes));
            } else {
                resultResp= new ResultResp<>(HttpStatus.OK, postDetailService.findAll());
            }
        } catch (Exception e) {
            resultResp = new ResultResp<>(HttpStatus.BAD_REQUEST);
        }
        return resultResp;
    }

    @PostMapping("post/create")
    public ResultResp<?> create(@RequestBody PostDetailDTO postDetailDTO) {
        ResultResp<?> resultResp;
        try {
            if (postDetailDTO.getSuburbNames() == null || postDetailDTO.getPostcodes() == null) {
                resultResp= new ResultResp<>(HttpStatus.BAD_REQUEST);
            } else {
                resultResp = new ResultResp<>(HttpStatus.OK, postDetailService.save(postDetailDTO));
            }
        } catch (Exception e) {
            resultResp= new ResultResp<>(HttpStatus.BAD_REQUEST);
        }
        return resultResp;
    }
}
