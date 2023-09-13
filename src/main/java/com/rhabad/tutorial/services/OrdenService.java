package com.rhabad.tutorial.services;

import com.rhabad.tutorial.Rutas;
import com.rhabad.tutorial.models.Producto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;


public class OrdenService implements IOrderService{

    @Value("${miURL.database}")
    private String database;

    private final Logger logger = LoggerFactory.getLogger(OrdenService.class);


    public void saveOrder(List<Producto> products){
        System.out.println("Guardando en la base de datos. En la URL: "+database);

        products.forEach(producto-> logger.debug("el nombre del productoo: {}", producto.nombre));

    }

}
