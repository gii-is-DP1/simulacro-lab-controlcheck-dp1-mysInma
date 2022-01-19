package org.springframework.samples.petclinic.product;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class ProductService {
    
    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    
    public List<Product> getProductsCheaperThan(double price) {
        return productRepository.findByPriceLessThan(price);
    }


    //Ejercicio 6
    public ProductType getProductType(String typeName) {
        return productRepository.findProductByName(typeName);
    }

    public Product save(Product p){
        return productRepository.save(p);       
    }

    public Collection<ProductType> findAllProductTypes(){
        return productRepository.findAllProductTypes();
    }
    
    

    
}
