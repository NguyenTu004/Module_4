package com.example.thuchanh1.repository;

import com.example.thuchanh1.model.Province;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProvinceRepository extends PagingAndSortingRepository<Province,Long>{
}
