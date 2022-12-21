package com.example.demo.service.inpl;
import com.example.demo.model.Category;
import com.example.demo.repository.ICategoryRepository;
import com.example.demo.service.interface_service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryService  extends ICategoryService {
    @Autowired
    ICategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public Category findById(long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public void save(Category category) {
    }

    @Override
    public void delete(Category category) {

    }
    public Map<Long,Category> findAllMap() {
        Map<Long,Category> categoryMap = new HashMap<Long,Category>();
        for (Category category : categoryRepository.findAll()){
            categoryMap.put(category.getId(), category);
        }
        return categoryMap;
    }
}
