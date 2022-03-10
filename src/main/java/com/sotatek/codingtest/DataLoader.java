package com.sotatek.codingtest;

import com.sotatek.codingtest.domain.entity.PostDetail;
import com.sotatek.codingtest.repository.PostDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private PostDetailRepository postDetailRepository;

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {
        if (postDetailRepository.findAll().size() <= 0) {
            postDetailRepository.save(new PostDetail("Ha Noi", 15000L));
            postDetailRepository.save(new PostDetail("Hai Phong", 16000L));
            postDetailRepository.save(new PostDetail("Ha Nam", 17000L));
            postDetailRepository.save(new PostDetail("Vinh Phuc", 18000L));
        }
    }
}
