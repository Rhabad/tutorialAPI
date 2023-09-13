package com.rhabad.tutorial.mybeans;

import com.rhabad.tutorial.models.Producto;
import com.rhabad.tutorial.services.IOrderService;
import com.rhabad.tutorial.services.OrdenService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MiPrimerosBean {

    @Bean
    public MiBean crearMIBean(){
        return new MiBean();
    }

    @Bean
    public IOrderService instanciarOrderService() {
        boolean esProduccion = true;

        if (esProduccion) {
            return new OrdenService();
        } else {
            return new IOrderService() {
                @Override
                public void saveOrder(List<Producto> products) {
                    System.out.println("guardando en base de datos dummy(local)");
                }
            };
        }

    }

}
