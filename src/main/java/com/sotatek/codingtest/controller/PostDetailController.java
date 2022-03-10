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

    @GetMapping("get-all")
    public ResultResp<List<PostDetailDTO>> getAll() {
        List<PostDetailDTO> postDetailDTOList = postDetailService.findAll();
        if (postDetailDTOList.size() <= 0) {
            return new ResultResp<>(HttpStatus.OK);
        }
        return new ResultResp<>(HttpStatus.OK, postDetailDTOList);
    }

    @GetMapping("get-by-postcodes")
    public ResultResp<List<PostDetailDTO>> getAllByPostcodes(@RequestBody List<Long> postcodes) {
        List<PostDetailDTO> postDetailDTOList = postDetailService.findAllByPostcode(postcodes);
        if (postDetailDTOList.size() <= 0) {
            return new ResultResp<>(HttpStatus.OK);
        }
        return new ResultResp<>(HttpStatus.OK, postDetailDTOList);
    }

    @PostMapping("create")
    public ResultResp<PostDetailDTO> create(@RequestBody PostDetailDTO postDetailDTO) {
        if (postDetailDTO.getSuburbNames() == null || postDetailDTO.getPostcodes() == null) {
            return new ResultResp<>(HttpStatus.BAD_REQUEST);
        }
        return new ResultResp<>(HttpStatus.CREATED, postDetailService.save(postDetailDTO));
    }
}
