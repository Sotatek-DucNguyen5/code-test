package com.sotatek.codingtest.service.postdetail;

import com.sotatek.codingtest.domain.dto.PostDetailDTO;
import com.sotatek.codingtest.domain.entity.PostDetail;
import com.sotatek.codingtest.repository.PostDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostDetailService implements IPostDetailService {
    @Autowired
    private PostDetailRepository postDetailRepository;


    @Override
    public List<PostDetailDTO> findAll() {
        List<PostDetailDTO> postDetailDTOList = new ArrayList<>();
        postDetailRepository.findAll().stream().forEach(postDetail -> {
            postDetailDTOList.add(new PostDetailDTO(postDetail));
        });
        return postDetailDTOList;
    }

    @Override
    public PostDetailDTO save(PostDetailDTO postDetailDTO) {
        PostDetail postDetail = new PostDetail(postDetailDTO);
        postDetailDTO = new PostDetailDTO(postDetailRepository.save(postDetail));
        return postDetailDTO;
    }

    @Override
    public List<PostDetailDTO> findAllByPostcode(List<Long> postcodes) {
        if (postcodes.size() > 0) {
            List<PostDetail> postDetailList = postDetailRepository.findByPostcodesInOrderBySuburbNames(postcodes);
            List<PostDetailDTO> postDetailDTOList = new ArrayList<>();
            postDetailList.stream().forEach(postDetail -> {
                postDetailDTOList.add(new PostDetailDTO(postDetail));
            });
            return postDetailDTOList;
        } else {
            return this.findAll();
        }
    }
}
