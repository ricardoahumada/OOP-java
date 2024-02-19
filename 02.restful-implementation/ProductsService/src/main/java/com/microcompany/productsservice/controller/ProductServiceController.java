package com.microcompany.productsservice.controller;

import com.microcompany.productsservice.exception.ProductNotfoundException;
import com.microcompany.productsservice.model.Product;
import com.microcompany.productsservice.model.StatusMessage;
import com.microcompany.productsservice.persistence.ProductsRepository;
import com.microcompany.productsservice.service.ProductsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


//    @RequestMapping(value = "", method = RequestMethod.GET)
    /*@GetMapping("")
    public List<Product> getAll() {
        return repo.findAll();
    }*/

    @GetMapping("")
    public ResponseEntity<List<Product>> getAll() {
        List<Product> products = repo.findAll();
        if (products != null && products.size() > 0) return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
//        else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        else throw new ProductNotfoundException("La lista de productos está vacía");
    }

    /*@RequestMapping(value = "", method = RequestMethod.POST)
    public Product save(@RequestBody Product newProduct) {
        logger.info("newProduct:" + newProduct);
        return repo.save(newProduct);
    }*/

//    @RequestMapping(value = "", method = RequestMethod.POST)
    @PostMapping("")
    public ResponseEntity<Product> save(@RequestBody Product newProduct) {
        logger.info("newProduct:" + newProduct);
        newProduct.setId(null);
        return new ResponseEntity<>(repo.save(newProduct), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{pid}", method = RequestMethod.GET)
    public Product getOne(@PathVariable("pid") Long id) {
        return repo.findById(id).get();
    }

    @RequestMapping(value = "/{pid}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("pid") Long id) {
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //    @RequestMapping(value = "/{pid}", method = RequestMethod.PUT)
    @PutMapping("/{pid}")
    public ResponseEntity<Object> update(@PathVariable("pid") Long id, @RequestBody Product product) {
        if (id == product.getId()) {
            return new ResponseEntity<>(repo.save(product), HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(new StatusMessage(HttpStatus.PRECONDITION_FAILED.value(), "Id y produt.id deben cohincidir"), HttpStatus.PRECONDITION_FAILED);
        }
    }

    @PostMapping(value = "/duplicarProducto/{pid}")
    public ResponseEntity<Product> duplicate(@PathVariable Long pid) {
        return new ResponseEntity<>(service.duplicate(pid), HttpStatus.CREATED);
    }

}