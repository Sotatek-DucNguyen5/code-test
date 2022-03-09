package com.example.codingtest.controller;

import com.example.codingtest.domain.dto.PostDetailDTO;
import com.example.codingtest.service.postdetail.PostDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class PostDetailController {
    @Autowired
    private PostDetailService postDetailService;

    @GetMapping("get-all")
    public List<PostDetailDTO> getAll() {
        return postDetailService.findAll();
    }

    @GetMapping("get-by-postcodes")
    public List<PostDetailDTO> getAllByPostcodes(@RequestParam(required = false, name = "first") String firstPostcodes,
                                                 @RequestParam(required = false, name = "second") String secondPostcodes) {
        return postDetailService.findAllByPostcode(firstPostcodes, secondPostcodes);
    }

    @PostMapping("create")
    public PostDetailDTO create(@RequestBody PostDetailDTO postDetailDTO) {
        return postDetailService.save(postDetailDTO);
    }

    @PutMapping("update/{id}")
    public PostDetailDTO create(@PathVariable Long id, @RequestBody PostDetailDTO postDetailDTO) {
        PostDetailDTO oldPostDetailDTO = postDetailService.findById(id);
        postDetailDTO.setId(oldPostDetailDTO.getId());
        return postDetailService.save(postDetailDTO);
    }
}
