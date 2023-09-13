package com.rhabad.tutorial.services;

import com.rhabad.tutorial.models.Producto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IOrderService {

    public void saveOrder(List<Producto> products);

}
