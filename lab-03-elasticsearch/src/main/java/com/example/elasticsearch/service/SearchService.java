package com.example.elasticsearch.service;

import java.util.List;

import com.example.elasticsearch.repository.ProductRepository;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

import com.example.elasticsearch.bean.Product;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Pratik Das
 *
 */
@Service
@Slf4j
public class SearchService {

    private ProductRepository productRepository;

    private  ElasticsearchOperations elasticsearchOperations;

    @Autowired
    public SearchService(ProductRepository productRepository, ElasticsearchOperations elasticsearchOperations) {
        super();
        this.productRepository = productRepository;
        this.elasticsearchOperations = elasticsearchOperations;
    }



    public List<Product> findByManufacturerAndCategory(final String name, final String category){
        return productRepository.findByManufacturerAndCategory(name, category);
    }

    public List<Product> fetchProductNamesContaining(final String name){



        return productRepository.findByNameContaining(name);
    }

}

