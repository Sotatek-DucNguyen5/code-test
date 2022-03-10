package com.sotatek.codingtest.controller;

import com.sotatek.codingtest.domain.dto.PostDetailDTO;
import com.sotatek.codingtest.helper.ResultResp;
import com.sotatek.codingtest.service.postdetail.PostDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class PostDetailController {
    @Autowired
    private PostDetailService postDetailService;

    @GetMapping("post")
    public ResultResp<List<PostDetailDTO>> getAll(@RequestBody(required = false) List<String> postcodes) {
        List<PostDetailDTO> postDetailDTOList = new ArrayList<>();
        try {
            if (postcodes != null) {
                postDetailDTOList = postDetailService.findAllByPostcode(postcodes);
            } else {
                postDetailDTOList = postDetailService.findAll();
            }
        } catch (Exception e) {
            return new ResultResp<>(HttpStatus.BAD_REQUEST);
        }
        return new ResultResp<>(HttpStatus.OK, postDetailDTOList);
    }

    @PostMapping("post/create")
    public ResultResp<PostDetailDTO> create(@RequestBody PostDetailDTO postDetailDTO) {
        try {
            if (postDetailDTO.getSuburbNames() == null || postDetailDTO.getPostcodes() == null) {
                return new ResultResp<>(HttpStatus.BAD_REQUEST);
            }
            return new ResultResp<>(HttpStatus.CREATED, postDetailService.save(postDetailDTO));
        } catch (Exception e) {
            return new ResultResp<>(HttpStatus.BAD_REQUEST);
        }
    }
}
