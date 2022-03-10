package com.sotatek.codingtest.controller;

import com.sotatek.codingtest.domain.dto.PostDetailDTO;
import com.sotatek.codingtest.service.postdetail.PostDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class PostDetailController {
    @Autowired
    private PostDetailService postDetailService;

    @GetMapping("get-all")
    public ResponseEntity<List<PostDetailDTO>> getAll() {
        return new ResponseEntity<>(postDetailService.findAll(), HttpStatus.OK);
    }

    @GetMapping("get-by-postcodes")
    public ResponseEntity<List<PostDetailDTO>> getAllByPostcodes(@RequestBody List<Long> postcodes) {
        return new ResponseEntity<>(postDetailService.findAllByPostcode(postcodes), HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<PostDetailDTO> create(@RequestBody PostDetailDTO postDetailDTO) {
        return new ResponseEntity<>(postDetailService.save(postDetailDTO), HttpStatus.CREATED);
    }
}
