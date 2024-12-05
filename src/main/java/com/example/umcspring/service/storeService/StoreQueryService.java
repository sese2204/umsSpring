package com.example.umcspring.service.storeService;

import com.example.umcspring.domain.Review;
import com.example.umcspring.domain.Store;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;

public interface StoreQueryService {
    Optional<Store> findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, Float score);
    Page<Review> getReviewList(Long StoreId, Integer page);
}

