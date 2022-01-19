package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



public interface ProductRepository extends CrudRepository<Product, Integer> {
    
    List<Product> findAll();

    @Query("SELECT pt FROM ProductType pt") //Consulta que permita obtener todos los tipos de preguntas existentes.
    List<ProductType> findAllProductTypes();

    Optional<Product> findById(int id);

    Product findByName(String name);

    //Crear una query para una consulta personalizada
    @Query("SELECT pt FROM ProductType pt WHERE pt.name =:typeName")
    ProductType findProductByName(String typeName);

    Product save(Product p);

    @Query("SELECT p FROM Product p WHERE p.price < :price")
    List<Product> findByPriceLessThan(double price);

   
    
}
