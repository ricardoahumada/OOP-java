package com.microcompany.productsservice.controller;

import com.microcompany.productsservice.exception.ProductExceptionController;
import com.microcompany.productsservice.model.Product;
import com.microcompany.productsservice.persistence.ProductsRepository;
import com.microcompany.productsservice.service.ProductsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductServiceController {
    private static final Logger logger = LoggerFactory.getLogger(ProductServiceController.class);

    @Autowired
    private ProductsService service;

    @Autowired
    private ProductsRepository repo;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Product> getAll() {
        return repo.findAll();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Product save(@RequestBody Product newProduct) {
        logger.info("newProduct:" + newProduct);
        return repo.save(newProduct);
    }

    @RequestMapping(value = "/{pid}", method = RequestMethod.GET)
    public Product getOne(@PathVariable("pid") Long id) {
        return repo.findById(id).get();
    }

    @RequestMapping(value = "/{pid}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("pid") Long id) {
        repo.deleteById(id);
    }

    @RequestMapping(value = "/{pid}", method = RequestMethod.PUT)
    public Product update(@PathVariable("pid") Long id, @RequestBody Product product) {
        if (id == product.getId()) return repo.save(product);
        else throw new RuntimeException();
    }

}