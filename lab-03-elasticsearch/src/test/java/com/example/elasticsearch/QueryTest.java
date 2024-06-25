package com.example.elasticsearch;

import com.example.elasticsearch.bean.Product;
import com.example.elasticsearch.service.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class QueryTest {

    @Autowired
    private ProductSearchService productSearchService;

    @Autowired
    private ProductSearchServiceWithRepo productSearchServiceWithRepo;

    @Test
    void queryAllTest(){
        String conditions = "{\"size\": 1000, \"query\":{ \"match_all\": {} }}";
        List<Product> products = productSearchService.searchAll();
        int a = 1;

    }


    @Test
    void findByProductNameTest() {
        List<Product> products = productSearchServiceWithRepo.findByProductName("Train");
        log.info("products {}",products);
    }

    @Test
    void findByManufacturerAndCategoryTest(){

//        productSearchServiceWithRepo.findByManufacturerAndCategory("Train", )
    }

}
