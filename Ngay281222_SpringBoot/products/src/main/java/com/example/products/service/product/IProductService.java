package com.example.products.service.product;

import com.example.products.model.Product;
import com.example.products.service.ICrud;

public interface IProductService extends ICrud<Product> {
    Iterable<Product> findAllByNameContaining (String name);
}
