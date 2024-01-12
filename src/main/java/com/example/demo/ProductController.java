package com.example.demo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Product;
import com.example.demo.repo.ProductRepo;

@RestController
@CrossOrigin(origins = "*")//for all external networks we can use hitting this requests 

public class ProductController {

    @Autowired
    ProductRepo productRepo;
    Logger log=Logger.getAnonymousLogger();
    // create a product
    @PostMapping("/insert")
    public String createProduct(@RequestBody Product product) {
        productRepo.save(product);
        return "Hi "+product.getPname()+" is registered sucessfully...!";
    }

    // get all products
    @GetMapping("/getall")
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    // get a product by id
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        return productRepo.findById(id).orElse(null);
    }


    // delete a product by id
    @DeleteMapping("/cancel/{id}")
    public List<Product> deleteProductById(@PathVariable int id) {
        productRepo.deleteById(id);
        return productRepo.findAll();
    }

    // update a product by id
    @PutMapping("/update")
    public String updateProductById(@RequestBody Product product) {
    	log.info("request hit"+product.pid);
        Product existingProduct = productRepo.findById(product.pid).orElse(null);
        if (existingProduct != null) {
            existingProduct.setPname(product.getPname());
            existingProduct.setOrderdate(product.getOrderdate());
            existingProduct.setCost(product.getCost());
            productRepo.save(product);

            return "Hi " + product.getPname() + " is updated successfully...!";
  	  } else {
  	    //return an error message
  	    return "Product not found with id " + product.pid;
  	  }

    }
}
