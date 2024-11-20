package com.example.umcspring.repository;

import com.example.umcspring.domain.Store;
import java.util.List;

public interface StoreRepositoryCustom {
    List<Store> dynamicQueryWithBooleanBuilder(String name, Float score);
}


