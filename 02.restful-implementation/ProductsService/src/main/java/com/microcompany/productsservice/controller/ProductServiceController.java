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
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/products")
@Validated
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

    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<Product>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    /*@RequestMapping(value = "", method = RequestMethod.POST)
    public Product save(@RequestBody Product newProduct) {
        logger.info("newProduct:" + newProduct);
        return repo.save(newProduct);
    }*/

    //    @RequestMapping(value = "", method = RequestMethod.POST)
    @PostMapping(value = "", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Product> save(@RequestBody @Valid Product newProduct) {
        logger.info("newProduct:" + newProduct);
        newProduct.setId(null);
        return new ResponseEntity<>(repo.save(newProduct), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{pid}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Product getOne(@PathVariable("pid") @Min(1) Long id) {
        return repo.findById(id).get();
    }

    @RequestMapping(value = "/{pid}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("pid") @Min(1) Long id) {
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //    @RequestMapping(value = "/{pid}", method = RequestMethod.PUT)
    @PutMapping("/{pid}")
    public ResponseEntity<Object> update(@PathVariable("pid") @Min(1) Long id, @RequestBody Product product) {
        if (id == product.getId()) {
            return new ResponseEntity<>(repo.save(product), HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(new StatusMessage(HttpStatus.PRECONDITION_FAILED.value(), "Id y produt.id deben cohincidir"), HttpStatus.PRECONDITION_FAILED);
        }
    }

    @PostMapping(value = "/duplicarProducto/{pid}")
    public ResponseEntity<Product> duplicate(@PathVariable @Min(1) Long pid) {
        return new ResponseEntity<>(service.duplicate(pid), HttpStatus.CREATED);
    }

}