package com.example.codingtest.service.postdetail;

import com.example.codingtest.domain.dto.PostDetailDTO;
import com.example.codingtest.domain.entity.PostDetail;
import com.example.codingtest.exception.ApplicationException;
import com.example.codingtest.repository.PostDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostDetailService implements IPostDetailService {
    @Autowired
    private PostDetailRepository postDetailRepository;

    @Override
    public List<PostDetailDTO> findAll() {
        List<PostDetailDTO> postDetailDTOList = new ArrayList<>();
        postDetailRepository.findAll().stream().forEach(postDetail -> {
            PostDetailDTO postDetailDTO = new PostDetailDTO();
            postDetailDTO.build(postDetail);
            postDetailDTOList.add(postDetailDTO);
        });
        return postDetailDTOList;
    }

    @Override
    public PostDetailDTO save(PostDetailDTO postDetailDTO) {
        PostDetail postDetail = new PostDetail();
        postDetail = postDetail.build(postDetailDTO);
        postDetailDTO = postDetailDTO.build(postDetailRepository.save(postDetail));
        return postDetailDTO;
    }


    @Override
    public void remove(PostDetailDTO postDetailDTO) {
        postDetailDTO = findById(postDetailDTO.getId());
        postDetailRepository.deleteById(postDetailDTO.getId());
    }

    @Override
    public PostDetailDTO findById(Long id) {
        PostDetail postDetail = postDetailRepository.findById(id).orElseThrow(() -> new ApplicationException("Not found post detail"));
        PostDetailDTO postDetailDTO = new PostDetailDTO();
        return postDetailDTO.build(postDetail);
    }

    @Override
    public List<PostDetailDTO> findAllByPostcode(String firstPostcodes, String secondPostcodes) {
        if (firstPostcodes != null || secondPostcodes != null) {
            if (firstPostcodes == null) {
                firstPostcodes = secondPostcodes;
            }
            if (secondPostcodes == null) {
                secondPostcodes = firstPostcodes;
            }
            if (Long.valueOf(firstPostcodes) > Long.valueOf(secondPostcodes)) {
                String temp = firstPostcodes;
                firstPostcodes = secondPostcodes;
                secondPostcodes = temp;
            }
            List<PostDetailDTO> postDetailDTOList = new ArrayList<>();
            postDetailRepository.findAllByPostcode(firstPostcodes, secondPostcodes).stream().forEach(postDetail -> {
                PostDetailDTO postDetailDTO = new PostDetailDTO();
                postDetailDTO.build(postDetail);
                postDetailDTOList.add(postDetailDTO);
            });
            return postDetailDTOList;
        } else {
            return this.findAll();
        }
    }
}
