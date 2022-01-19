package org.springframework.samples.petclinic.product;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.samples.petclinic.model.NamedEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "products")//Lo que pone en Table debe coincir con el que ponemos en la base de datos
public class Product extends NamedEntity{
    //Borramos los dos atributos que venían aquí porque lo estamos cogiendo de NamedEntity que a su vez
    //extiende de NamedEntity
    
    @NotNull
    @Min(0)
    double price;

    @ManyToOne//N a 1 de product a product_type
    @JoinColumn(name = "product_type")//para que cada producto quede asociado al tipo de producto correspondiente
    ProductType productType;
}
