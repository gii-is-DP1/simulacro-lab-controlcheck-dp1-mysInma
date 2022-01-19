package org.springframework.samples.petclinic.product;

import java.util.Collection;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    //Ejercicio 9
    @ModelAttribute("types")
    public Collection<ProductType> populateProductTypes(){
        return productService.findAllProductTypes();
    }

    @GetMapping(value = "/product/create") //Esto para que vaya a la url que nos dan
    public String initCreationForm(Map<String, Object> model){
        Product product = new Product();
        model.put("product", product);
        return "products/createOrUpdateProductForm";
    }

    //Ejercicio 10
    @PostMapping("/product/create")
    public String processCreationForm(@Valid Product product, BindingResult result) {
	    if(result.hasErrors()) {
	        return "products/createOrUpdateProductForm";
	    } else {
	        productService.save(product);
	        return "welcome";
	}


}



}
