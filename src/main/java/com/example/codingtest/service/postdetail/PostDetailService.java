package com.example.codingtest.service.postdetail;

import com.example.codingtest.CodingTestApplication;
import com.example.codingtest.domain.dto.PostDetailDTO;
import com.example.codingtest.domain.entity.PostDetail;
import com.example.codingtest.repository.PostDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostDetailService implements IPostDetailService {
    @Autowired
    private PostDetailRepository postDetailRepository;


    @EventListener()
    public void seedData(){
        if (this.findAll().size() <= 0) {
            postDetailRepository.save(new PostDetail("Ha Noi", 15000L));
            postDetailRepository.save(new PostDetail("Hai Phong", 16000L));
            postDetailRepository.save(new PostDetail("Ha Nam", 17000L));
            postDetailRepository.save(new PostDetail("Vinh Phuc", 18000L));

        }
    }

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
